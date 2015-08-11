package org.home.whatsfordinner.repository.dish;

import org.home.whatsfordinner.domain.dish.Dish;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    String FIND_RANDOM_DISHES = "SELECT d FROM Dish d WHERE d.id NOT IN (:dishIdsToIgnore) ORDER BY RAND()";

    /**
     * Get random nrOfDishes dishes back of which the ids are not in dishIdsToIgnore
     *
     * @return random nrOfDishes dishes not in dishIdsToIgnore
     */
    @Query(FIND_RANDOM_DISHES)
    List<Dish> getRandomDishes(@Param("dishIdsToIgnore") final List<Long> dishIdsToIgnore, final Pageable pageable);

}
