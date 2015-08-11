package org.home.whatsfordinner.service.ingredient;

import org.home.whatsfordinner.domain.ingredient.Ingredient;
import org.home.whatsfordinner.helper.ingredient.IngredientHelper;
import org.home.whatsfordinner.repository.ingredient.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    /**
     * Return the ingredient with the given id or {@literal null} if none found
     *
     * @param id
     * @return the ingredient with the given id or {@literal null} if none found
     */
    public Ingredient getIngredient(final Long id) {
        return ingredientRepository.findOne(id);
    }

    /**
     * Get all the ingredients
     *
     * @return list of all the ingredients
     */
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    /**
     * Get a list of ingredients in the form of a page
     *
     * @param page    the page number starting from 1
     * @param size    the number of elements per page
     * @return a page of ingredients
     */
    public Page<Ingredient> getPaginatedIngredients(final Integer page, final Integer size) {
        return ingredientRepository.findAll(new PageRequest(page - 1, size, Sort.Direction.DESC, "lastModifiedDate"));
    }

    /**
     * Save the ingredient and flushes changes instantly.
     *
     * @param ingredient
     * @return the saved ingredient
     */
    public Ingredient saveIngredient(final Ingredient ingredient) {
        return ingredientRepository.saveAndFlush(ingredient);
    }

    /**
     * Update the ingredient with id with the data from the newIngredient
     *
     * @param id               the id of the ingredient that needs to be updated
     * @param newIngredient    the ingredient containing the new data
     * @return the updated ingredient
     * @throws EntityNotFoundException when the ingredient with id is not found
     */
    public Ingredient updateIngredient(final Long id, final Ingredient newIngredient) {
        final Ingredient ingredient = getIngredient(id);
        if (ingredient == null) {
            throw new EntityNotFoundException("Entity with id " + id + " was not found.");
        }
        final Ingredient updatedIngredient = IngredientHelper.updateIngredient(ingredient, newIngredient);
        return ingredientRepository.saveAndFlush(updatedIngredient);
    }

    /**
     * Search for an ingredient of which the name contains searchValue
     *
     * @param searchValue    the partial or complete name of the ingredient
     * @return a list of ingredients that have a name that contains the searchValue
     */
    public List<Ingredient> searchIngredient(final String searchValue) {
        return ingredientRepository.searchByValue(searchValue);
    }
}
