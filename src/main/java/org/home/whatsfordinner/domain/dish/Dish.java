package org.home.whatsfordinner.domain.dish;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.home.whatsfordinner.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish extends BaseEntity {

    public static final String DEFAULT_SORT_FIELD = "lastModifiedDate";
    private String name;
    private List<DishIngredient> dishIngredients = new LinkedList<>();

    @NotNull
    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<DishIngredient> getDishIngredients() {
        return this.dishIngredients;
    }

    public void setDishIngredients(final List<DishIngredient> dishIngredients) {
        dishIngredients.forEach(dishIngredient -> dishIngredient.setDish(this));
        this.dishIngredients = dishIngredients;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final Dish dish = (Dish) obj;
        return this.getId() != null && this.getId().equals(dish.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(1, 37).
                append(getId()).
                toHashCode();
    }
}
