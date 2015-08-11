package org.home.whatsfordinner.repository.ingredient;

import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    /**
     * Search for an ingredient of which the name contains searchValue
     *
     * @param searchValue
     * @return a list of ingredients that have a name that contains the searchValue
     */
    @Query("SELECT ingredient FROM Ingredient ingredient WHERE LOWER(name) LIKE %:searchValue% ORDER BY id ASC")
    public List<Ingredient> searchByValue(@Param("searchValue") final String searchValue);

}