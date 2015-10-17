'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientCreateController', ['$scope', '$state', 'ingredientResourceFactory', 'Flash', function ($scope, $state, ingredientResourceFactory, Flash) {
        $scope.ingredient = {};

        $scope.addIngredient = function() {
            ingredientResourceFactory.addIngredient($scope.ingredient, function(result) {
                var message = "<strong>Success!</strong> The ingredient was successfully added.";
                Flash.create('success', message, 'customAlert success');
                $state.go('ingredients');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        };
    }]);