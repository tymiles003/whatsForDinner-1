package org.home.whatsfordinner.controller.ingredient;

import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.domain.ingredient.IngredientUnit;
import org.home.whatsfordinner.service.ingredient.IngredientService;
import org.home.whatsfordinner.service.ingredient.IngredientUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private IngredientUnitService ingredientUnitService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ingredient addIngredient(@RequestBody final Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

    @RequestMapping(value = "/units", method = RequestMethod.GET)
    public List<IngredientUnit> getAllIngredientUnits() {
        return ingredientUnitService.getAllIngredientUnits();
    }

    @RequestMapping(value = "/units", method = RequestMethod.POST)
    public IngredientUnit addIngredientUnit(@RequestBody final IngredientUnit ingredientUnit) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(ingredientUnit);
        return ingredientUnitService.saveIngredientUnit(ingredientUnit);
    }

    @RequestMapping(value = "/units/{id}", method = RequestMethod.DELETE)
    public void deleteIngredientUnit(@PathVariable(value = "id") final Long id) {
        ingredientUnitService.deleteIngredientUnit(id);
    }

    @RequestMapping(value = "/units/{id}", method = RequestMethod.GET)
    public IngredientUnit getIngredientUnit(@PathVariable(value = "id") final Long id) {
        return ingredientUnitService.getIngredientUnit(id);
    }

}
