package org.home.whatsfordinner.controller.ingredient;

import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.service.ingredient.IngredientService;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ingredient addIngredient(@RequestBody final Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ingredient getIngredientUnit(@PathVariable(value = "id") final Long id) {
        return ingredientService.getIngredient(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void editIngredientUnit(@RequestBody final Ingredient ingredient, @PathVariable(value = "id") final Long id) {
        ingredientService.updateIngredient(id, ingredient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteIngredientUnit(@PathVariable(value = "id") final Long id) {
        ingredientService.deleteIngredient(id);
    }
}
