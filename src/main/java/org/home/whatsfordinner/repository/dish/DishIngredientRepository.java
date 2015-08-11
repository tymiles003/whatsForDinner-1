package org.home.whatsfordinner.repository.dish;

import org.home.whatsfordinner.domain.dish.DishIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishIngredientRepository extends JpaRepository<DishIngredient, Long> {
}
