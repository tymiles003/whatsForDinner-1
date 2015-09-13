'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientUnitEditController', ['$scope', '$state', 'ingredientUnitResourceFactory', '$stateParams', function ($scope, $state, ingredientUnitResourceFactory, $stateParams) {
        $scope.loadIngredientUnit = function() {
            if (typeof $stateParams !== 'undefined' && $stateParams.id !== null) {
                $scope.ingredientUnitPromise = ingredientUnitResourceFactory.getIngredientUnit({id: $stateParams.id}).$promise.then(function(data) {
                    $scope.ingredientUnit = data;
                });
            }
        }
    }]);