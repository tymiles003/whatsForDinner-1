package org.home.whatsfordinner.domain.dish;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.home.whatsfordinner.domain.BaseEntity;
import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.domain.ingredient.IngredientUnit;

import javax.persistence.*;

@Entity
@Table(name = "dish_ingredient")
public class DishIngredient extends BaseEntity {

    private Dish dish;
    private Ingredient ingredient;
    private Double quantity;
    private IngredientUnit ingredientUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", nullable = false)
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Column(name = "quantity", nullable = false)
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_unit_id", nullable = false)
    public IngredientUnit getIngredientUnit() {
        return ingredientUnit;
    }

    public void setIngredientUnit(final IngredientUnit ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final DishIngredient dishIngredient = (DishIngredient) obj;
        //Check on id
        if ((this.getId() != null && dishIngredient.getId() == null) || (this.getId() == null && dishIngredient.getId() != null) || (this.getId() != null && !this.getId().equals(dishIngredient.getId()))) {
            return false;
        }
        //Check on the dish
        if ((this.dish == null && dishIngredient.getDish() != null) || (this.dish != null && !this.dish.equals(dishIngredient.getDish()))) {
            return false;
        }
        //Check on the ingredient
        if ((this.ingredient == null && dishIngredient.getIngredient() != null) || (this.ingredient != null && !this.ingredient.equals(dishIngredient.getIngredient()))) {
            return false;
        }
        //Check on the ingredientUnit
        if ((this.ingredientUnit == null && dishIngredient.getIngredientUnit() != null) || this.ingredientUnit != null && !this.ingredientUnit.equals(dishIngredient.getIngredientUnit())) {
            return false;
        }
        //Check on the quantity
        if ((this.quantity == null && dishIngredient.getQuantity() != null) || this.quantity != null && !this.quantity.equals(dishIngredient.getQuantity())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(7, 37).
                append(getId()).
                append(dish).
                append(ingredient).
                append(ingredientUnit).
                append(quantity).toHashCode();
    }
}
