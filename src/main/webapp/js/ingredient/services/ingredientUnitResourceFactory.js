'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .factory('ingredientUnitResourceFactory', ['$resource', function($resource) {
        return $resource('api/ingredients/units/:id', {id: '@id'}, {
            getAllIngredientUnits: {
                method: 'GET',
                isArray: true
            },
            addIngredientUnit: {
                dataType: 'json',
                method: 'POST'
            },
            getIngredientUnit: {
                method: 'GET',
                params: { id: "@id"}
            },
            deleteIngredientUnit: {
                method: 'DELETE',
                params: { id: "@id"}
            }
        });
    }]);