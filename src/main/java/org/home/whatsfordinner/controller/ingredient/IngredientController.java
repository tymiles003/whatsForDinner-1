package org.home.whatsfordinner.controller.ingredient;

import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.service.ingredient.IngredientService;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ingredient saveIngredient(@RequestBody final Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

}
