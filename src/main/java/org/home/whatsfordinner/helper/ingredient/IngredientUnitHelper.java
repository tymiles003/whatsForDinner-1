package org.home.whatsfordinner.helper.ingredient;

import org.apache.commons.lang3.StringUtils;
import org.home.whatsfordinner.domain.ingredient.IngredientUnit;

public class IngredientUnitHelper {

    /**
     * Method the will update the data from the ingredientUnit with the data from the newIngredientUnit
     *
     * @param ingredientUnit       the ingredientUnit of which the data has to be updated
     * @param newIngredientUnit    the ingredientUnit containing the new data
     * @return updated ingredientUnit
     */
    public static IngredientUnit updateIngredientUnit(final IngredientUnit ingredientUnit, final IngredientUnit newIngredientUnit) {
        if (StringUtils.isNotEmpty(newIngredientUnit.getName())) {
            ingredientUnit.setName(newIngredientUnit.getName());
        }
        return ingredientUnit;
    }

}
