package org.home.whatsfordinner.domain.ingredientUnit;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.home.whatsfordinner.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ingredient_unit")
public class IngredientUnit extends BaseEntity {

    private String name;

    @NotNull
    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final IngredientUnit ingredientUnit = (IngredientUnit) obj;
        return this.getId() != null && this.getId().equals(ingredientUnit.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(5, 37).
                append(getId()).
                toHashCode();
    }
}
