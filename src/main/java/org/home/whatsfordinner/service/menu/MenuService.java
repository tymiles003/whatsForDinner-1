package org.home.whatsfordinner.service.menu;

import org.home.whatsfordinner.domain.dish.Dish;
import org.home.whatsfordinner.domain.menu.Menu;
import org.home.whatsfordinner.domain.menu.MenuDTO;
import org.home.whatsfordinner.helper.dish.DishHelper;
import org.home.whatsfordinner.helper.menu.MenuHelper;
import org.home.whatsfordinner.repository.menu.MenuDishRepository;
import org.home.whatsfordinner.repository.menu.MenuRepository;
import org.home.whatsfordinner.service.dish.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuDishRepository menuDishRepository;
    @Autowired
    private DishService dishService;
    public static final int NR_OF_DISHES = 7;

    /**
     * Get the menu with id
     *
     * @param id
     * @return menu with id
     */
    public Menu getMenu(final Long id) {
        return menuRepository.getOne(id);
    }

    /**
     * Get a list of menus in the form of a page
     *
     * @param page
     * @param size
     * @return a page of menus
     */
    public Page<Menu> getPaginatedMenus(final Integer page, final Integer size) {
        return menuRepository.findAll(new PageRequest(page - 1, size, Sort.Direction.DESC, Dish.DEFAULT_SORT_FIELD));
    }

    /**
     * Generate a new menu with nrOfDishes dishes
     *
     * @param nrOfDishes
     * @return a new menu
     */
    public MenuDTO generateMenu(final int nrOfDishes) {
        return generateMenu(nrOfDishes, new LinkedList<>());
    }

    /**
     * Generate a new menu with nrOfDishes dishes in and ignore dishes whose id is in dishIdsToIgnore
     * @param nrOfDishes
     * @param dishIdsToIgnore
     * @return a new menu
     */
    public MenuDTO generateMenu(final int nrOfDishes, final List<Long> dishIdsToIgnore) {
        final MenuDTO menu = new MenuDTO();
        menu.setWeekNr(MenuHelper.getWeekNumber());
        menu.setStartDate(MenuHelper.getWeekStartDate());
        menu.setEndDate(MenuHelper.getWeekEndDate());
        menu.setDishes(dishService.getRandomDishes(nrOfDishes, dishIdsToIgnore));
        return menu;
    }

    /**
     * Regenerate the menu with new dishes. The current dishes in the menu, which are not null, will be kept
     *
     * @param menu
     * @return regenerated menu
     */
    public MenuDTO regenerateMenu(final MenuDTO menu) {
        final List<Long> dishIdsToIgnore = new LinkedList<>(menu.getDishIdsToIgnore());
        menu.getDishes().forEach(dish -> {
            if (dish != null) {
                dishIdsToIgnore.add(dish.getId());
            }
        });
        final int nullValuesInDishes = (int) menu.getDishes().stream().filter(dish -> dish == null).count();
        final List<Dish> newRandomDishes = dishService.getRandomDishes(menu.getDishes().size() - nullValuesInDishes, dishIdsToIgnore);
        final List<Dish> newDishes = DishHelper.replaceNullValueDishes(menu.getDishes(), newRandomDishes);
        menu.setDishes(newDishes);
        return menu;
    }

    /**
     * Save the menu in the database
     *
     * @param menuDTO
     */
    public void saveMenu(final MenuDTO menuDTO) {
        final Menu menu = new Menu();
        menu.setWeekNr(menuDTO.getWeekNr());
        menu.setStartDate(menuDTO.getStartDate());
        menu.setEndDate(menuDTO.getEndDate());
        menu.setMenuDishes(MenuHelper.createMenuDishes(menuDTO.getDishes(), menu));
        menuRepository.save(menu);
    }
}
