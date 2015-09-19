package org.home.whatsfordinner.service.ingredientUnit;

import org.home.whatsfordinner.domain.ingredientUnit.IngredientUnit;
import org.home.whatsfordinner.helper.ingredient.IngredientUnitHelper;
import org.home.whatsfordinner.repository.ingredientUnit.IngredientUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class IngredientUnitService {

    @Autowired
    private IngredientUnitRepository ingredientUnitRepository;

    /**
     * Return the ingredientUnit with the given id or {@literal null} if none found
     *
     * @param id
     * @return the ingredientUnit with the given id or {@literal null} if none found
     * @throws EntityNotFoundException when the ingredientUnit with id is not found
     */
    public IngredientUnit getIngredientUnit(final Long id) {
        final IngredientUnit ingredientUnit = ingredientUnitRepository.findOne(id);
        if (ingredientUnit == null) {
            throw new EntityNotFoundException("Entity with id " + id + " was not found.");
        }
        return ingredientUnit;
    }

    /**
     * Get all the ingredientsUnits
     *
     * @return list of all the ingredientsUnits
     */
    public List<IngredientUnit> getAllIngredientUnits() {
        return ingredientUnitRepository.findAll();
    }

    /**
     * Save the ingredientUnit and flushes changes instantly.
     *
     * @param ingredientUnit
     * @return the saved ingredientUnit
     */
    public IngredientUnit saveIngredientUnit(final IngredientUnit ingredientUnit) {
        return ingredientUnitRepository.saveAndFlush(ingredientUnit);
    }

    /**
     * Update the ingredientUnit with id with the data from the newIngredientUnit
     *
     * @param id                   the id of the ingredientUnit that needs to be updated
     * @param newIngredientUnit    the ingredientUnit containing the new data
     * @return the updated ingredientUnit
     * @throws EntityNotFoundException when the ingredientUnit with id is not found
     */
    public IngredientUnit updateIngredientUnit(final Long id, final IngredientUnit newIngredientUnit) {
        final IngredientUnit ingredientUnit = getIngredientUnit(id);
        final IngredientUnit updatedIngredientUnit = IngredientUnitHelper.updateIngredientUnit(ingredientUnit, newIngredientUnit);
        return ingredientUnitRepository.saveAndFlush(updatedIngredientUnit);
    }

    /**
     * Delete the ingredientUnit with id id
     *
     * @param id
     * @throws EntityNotFoundException when the ingredientUnit with id is not found
     */
    public void deleteIngredientUnit(final Long id) {
        final IngredientUnit ingredientUnit = getIngredientUnit(id);
        ingredientUnitRepository.delete(ingredientUnit);
    }
}
