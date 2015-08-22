'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .factory('ingredientResourceFactory', ['$resource', function($resource) {
        return $resource('api/ingredients', {}, {
            getAllIngredients: {
                method: 'GET',
                isArray: true
            },
            addIngredient: {
                method: 'POST'
            }
        });
    }]);