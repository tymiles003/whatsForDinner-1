package org.home.whatsfordinner.controller.ingredient;

import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.domain.ingredient.IngredientUnit;
import org.home.whatsfordinner.service.ingredient.IngredientService;
import org.home.whatsfordinner.service.ingredient.IngredientUnitService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ingredientUnitService.saveIngredientUnit(ingredientUnit);
    }

}
