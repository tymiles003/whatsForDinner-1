package org.home.whatsfordinner.helper.dish;

import org.apache.commons.lang3.StringUtils;
import org.home.whatsfordinner.domain.dish.Dish;
import org.home.whatsfordinner.domain.dish.DishIngredient;
import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.helper.GlobalHelper;

import java.util.LinkedList;
import java.util.List;

public final class DishHelper {

    private DishHelper() {}

    /**
     * Method that will update the data from the dish with the data from the newDish
     *
     * @param dish       the dish of which the data has to be updated
     * @param newDish    the dish containing the new data
     * @return updated dish
     */
    public static Dish updateDish(final Dish dish, final Dish newDish) {
        if (StringUtils.isNotEmpty(newDish.getName())) {
            dish.setName(newDish.getName());
        }
        //Set the correct dishIngredients by removing the old ones and adding the new ones
        final List<DishIngredient> toRemoveDishIngredients = GlobalHelper.getRelativeComplement(dish.getDishIngredients(), newDish.getDishIngredients());
        final List<DishIngredient> newDishIngredients = GlobalHelper.getRelativeComplement(newDish.getDishIngredients(), dish.getDishIngredients());
        dish.getDishIngredients().removeAll(toRemoveDishIngredients);
        //Ensure the new DishIngredients have the correct dish reference
        newDishIngredients.forEach(dishIngredient -> dishIngredient.setDish(dish));
        dish.getDishIngredients().addAll(newDishIngredients);
        return dish;
    }

    /**
     * Replace the null values from the first list with values from the second list.
     * If there are more null values in the first list then there are values in the second list, the null values will
     * be kept as is.
     *
     * @param dishesWithNullValues  list of dishes containing null values that should be replaced
     * @param dishes                list of dishes used to replace the null values in the other list
     * @return merged dishes list
     */
    public static List<Dish> replaceNullValueDishes(final List<Dish> dishesWithNullValues, final List<Dish> dishes) {
        final List<Dish> newDishes = new LinkedList<>();
        for (int dishesIndex = 0, newDishesIndex = 0; dishesIndex < dishesWithNullValues.size(); dishesIndex++) {
            final Dish dish = dishesWithNullValues.get(dishesIndex);
            if (dish == null && newDishesIndex < dishes.size()) {
                newDishes.add(dishes.get(newDishesIndex));
                newDishesIndex++;
            } else {
                newDishes.add(dish);
            }
        }
        return newDishes;
    }

    /**
     * Create a new dishIngredient
     *
     * @param ingredient    the ingredient for the dishIngredient
     * @return the created dishIngredient
     */
    public static DishIngredient createDishIngredient(Ingredient ingredient) {
        final DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setIngredient(ingredient);
        return dishIngredient;
    }
}
