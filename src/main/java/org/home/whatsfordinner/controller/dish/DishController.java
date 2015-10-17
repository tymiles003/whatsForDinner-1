package org.home.whatsfordinner.controller.dish;

import org.home.whatsfordinner.domain.dish.Dish;
import org.home.whatsfordinner.service.dish.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Dish addDish(@RequestBody final Dish dish) {
        return dishService.saveDish(dish);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Dish getDish(@PathVariable(value = "id") final Long id) {
        return dishService.getDish(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void editDish(@RequestBody final Dish dish, @PathVariable(value = "id") final Long id) {
        dishService.updateDish(id, dish);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDish(@PathVariable(value = "id") final Long id) {
        dishService.deleteDish(id);
    }

}
