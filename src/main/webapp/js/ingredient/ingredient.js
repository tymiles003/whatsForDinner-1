'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .config(function($stateProvider) {
        $stateProvider.state('ingredients', {
            parent: 'site',
            url: '/ingredients',
            views: {
                'content@': {
                    templateUrl: 'js/ingredient/views/ingredient.html',
                    controller: 'ingredientController'
                }
            }
        });
        $stateProvider.state('addIngredient', {
            parent: 'ingredients',
            url: '/add',
            views: {
                'content@': {
                    templateUrl: 'js/ingredient/views/newIngredientForm.html',
                    controller: 'ingredientController'
                }
            }
        });
        $stateProvider.state('ingredientUnits', {
            parent: 'ingredients',
            url: '/units',
            views: {
                'content@': {
                    templateUrl: 'js/ingredient/views/ingredientUnit.html',
                    controller: 'ingredientUnitController'
                }
            }
        });
        $stateProvider.state('addIngredientUnit', {
            parent: 'ingredientUnits',
            url: '/add',
            views: {
                'content@': {
                    templateUrl: 'js/ingredient/views/newIngredientUnitForm.html',
                    controller: 'ingredientUnitController'
                }
            }
        });
});