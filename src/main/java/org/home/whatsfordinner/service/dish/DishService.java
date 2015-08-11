package org.home.whatsfordinner.service.dish;

import org.home.whatsfordinner.domain.dish.Dish;
import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.helper.dish.DishHelper;
import org.home.whatsfordinner.repository.dish.DishIngredientRepository;
import org.home.whatsfordinner.repository.dish.DishRepository;
import org.home.whatsfordinner.service.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private DishIngredientRepository dishIngredientRepository;
    @Autowired
    private IngredientService ingredientService;

    /**
     * Return the dish with the given id or {@literal null} if none found
     *
     * @param id
     * @return the dish with the given id or {@literal null} if none found
     */
    public Dish getDish(final Long id) {
        return dishRepository.findOne(id);
    }

    /**
     * Get all the dishes
     *
     * @return list of all the dishes
     */
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    /**
     * Get a list of dishes in the form of a page
     *
     * @param page    the page number starting from 1
     * @param size    the number of elements per page
     * @return a page of dishes
     */
    public Page<Dish> getPaginatedDishes(final Integer page, final Integer size) {
        return dishRepository.findAll(new PageRequest(page - 1, size, Sort.Direction.DESC, Dish.DEFAULT_SORT_FIELD));
    }

    /**
     * Save the dish and flushes changes instantly.
     *
     * @param dish
     * @return the saved dish
     */
    public Dish saveDish(final Dish dish) {
        return dishRepository.saveAndFlush(dish);
    }

    /**
     * Update the dish with id with the data from the newDish
     *
     * @param id         the id of the dish that needs to be updated
     * @param newDish    the dish containing the new data
     * @return the updated dish
     * @throws EntityNotFoundException when the dish with id is not found
     */
    public Dish updateDish(final Long id, final Dish newDish) {
        final Dish dish = getDish(id);
        if (dish == null) {
            throw new EntityNotFoundException("Entity with id " + id + " was not found.");
        }
        final Dish updatedDish = DishHelper.updateDish(dish, newDish);
        return dishRepository.saveAndFlush(updatedDish);
    }

    /**
     * Add a new dishIngredientRow to the dish object
     * The added dishIngredientRow will have the ingredient with ingredientId attached to it
     *
     * @param dish
     * @param ingredientId
     * @return dish with a new dishIngredientRow with ingredient ingredientId
     */
    public Dish addDishIngredientRow(final Dish dish, final Long ingredientId) {
        final Ingredient ingredient = ingredientService.getIngredient(ingredientId);
        dish.getDishIngredients().add(DishHelper.createDishIngredient(ingredient));
        return dish;
    }

    /**
     * Remove the dishIngredientRow at the given index from the passed dish
     *
     * @param dish
     * @param dishIngredientRowIndex
     * @return dish with removed dishIngredientRow
     */
    public Dish removeDishIngredientRow(final Dish dish, final int dishIngredientRowIndex) {
        if (dishIngredientRowIndex < dish.getDishIngredients().size()) {
            dish.getDishIngredients().remove(dishIngredientRowIndex);
        }
        return dish;
    }

    /**
     * Get random nrOfDishes dishes back of which the ids are not in dishIdsToIgnore
     *
     * @param nrOfDishes
     * @param dishIdsToIgnore
     * @return random nrOfDishes dishes not in dishIds
     */
    public List<Dish> getRandomDishes(final int nrOfDishes, final List<Long> dishIdsToIgnore) {
        return dishRepository.getRandomDishes(dishIdsToIgnore, new PageRequest(0, nrOfDishes));
    }
}

