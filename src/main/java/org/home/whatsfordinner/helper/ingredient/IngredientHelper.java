package org.home.whatsfordinner.helper.ingredient;

import org.apache.commons.lang3.StringUtils;
import org.home.whatsfordinner.domain.ingredient.Ingredient;

public class IngredientHelper {

    /**
     * Method the will update the data from the ingredient with the data from the newIngredient
     *
     * @param ingredient       the ingredient of which the data has to be updated
     * @param newIngredient    the ingredient containing the new data
     * @return updated ingredient
     */
    public static Ingredient updateIngredient(final Ingredient ingredient, final Ingredient newIngredient) {
        if (StringUtils.isNotEmpty(newIngredient.getName())) {
            ingredient.setName(newIngredient.getName());
        }
        return ingredient;
    }

}
