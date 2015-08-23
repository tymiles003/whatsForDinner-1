'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .factory('ingredientUnitResourceFactory', ['$resource', function($resource) {
        return $resource('api/ingredients/units', {}, {
            getAllIngredientUnits: {
                method: 'GET',
                isArray: true
            },
            addIngredientUnit: {
                method: 'POST'
            }
        });
    }]);