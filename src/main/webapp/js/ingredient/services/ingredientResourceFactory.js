'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .factory('ingredientResourceFactory', ['$resource', function($resource) {
        return $resource('api/ingredients/:id', {id: '@id'}, {
            getAllIngredients: {
                method: 'GET',
                isArray: true
            },
            addIngredient: {
                method: 'POST'
            },
             getIngredient: {
                 method: 'GET',
                 params: { id: "@id"}
             },
             editIngredient: {
                 method: 'PUT',
                 params: { id: "@id"}
             },
             deleteIngredient: {
                 method: 'DELETE',
                 params: { id: "@id"}
             }
        });
    }]);