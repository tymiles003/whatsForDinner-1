'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientUnitCreateController', ['$scope', '$state', 'ingredientUnitResourceFactory', 'Flash', function ($scope, $state, ingredientUnitResourceFactory, Flash) {
        $scope.addIngredientUnit = function() {
            ingredientUnitResourceFactory.addIngredientUnit($scope.ingredientUnit, function(result) {
                var message = "<strong>Success!</strong> The ingredient unit was successfully added.";
                Flash.create('success', message, 'customAlert success');
                $state.go('ingredientUnits');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        };
    }]);