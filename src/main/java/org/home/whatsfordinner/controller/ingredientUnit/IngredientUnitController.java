package org.home.whatsfordinner.controller.ingredientUnit;

import org.home.whatsfordinner.domain.ingredientUnit.IngredientUnit;
import org.home.whatsfordinner.service.ingredientUnit.IngredientUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ingredients/units")
public class IngredientUnitController {

    @Autowired
    private IngredientUnitService ingredientUnitService;

    @RequestMapping(method = RequestMethod.GET)
    public List<IngredientUnit> getAllIngredientUnits() {
        return ingredientUnitService.getAllIngredientUnits();
    }

    @RequestMapping(method = RequestMethod.POST)
    public IngredientUnit addIngredientUnit(@RequestBody final IngredientUnit ingredientUnit) {
        return ingredientUnitService.saveIngredientUnit(ingredientUnit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IngredientUnit getIngredientUnit(@PathVariable(value = "id") final Long id) {
        return ingredientUnitService.getIngredientUnit(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void editIngredientUnit(@RequestBody final IngredientUnit ingredientUnit, @PathVariable(value = "id") final Long id) {
        ingredientUnitService.updateIngredientUnit(id, ingredientUnit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteIngredientUnit(@PathVariable(value = "id") final Long id) {
        ingredientUnitService.deleteIngredientUnit(id);
    }

}
