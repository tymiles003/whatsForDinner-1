'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientUnitEditController', ['$scope', '$state', 'ingredientUnitResourceFactory', '$stateParams', 'Flash', function ($scope, $state, ingredientUnitResourceFactory, $stateParams, Flash) {
        $scope.loadIngredientUnit = function() {
            if (typeof $stateParams !== 'undefined' && $stateParams.id !== null) {
                $scope.ingredientUnitPromise = ingredientUnitResourceFactory.getIngredientUnit({id: $stateParams.id}).$promise.then(function(data) {
                    $scope.ingredientUnit = data;
                });
            }
        }
        $scope.editIngredientUnit = function() {
            ingredientUnitResourceFactory.editIngredientUnit({id: $stateParams.id}, $scope.ingredientUnit, function(result) {
                var message = "<strong>Success!</strong> The ingredient unit was successfully edited.";
                Flash.create('success', message, 'customAlert success');
                $state.go('ingredientUnits');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        };
    }]);