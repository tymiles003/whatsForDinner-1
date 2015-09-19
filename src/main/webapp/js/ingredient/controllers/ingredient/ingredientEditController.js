'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientEditController', ['$scope', '$state', 'ingredientResourceFactory', '$stateParams', 'Flash', function ($scope, $state, ingredientResourceFactory, $stateParams, Flash) {
        $scope.loadIngredient = function() {
            if (typeof $stateParams !== 'undefined' && $stateParams.id !== null) {
                $scope.ingredientPromise = ingredientResourceFactory.getIngredient({id: $stateParams.id}).$promise.then(function(data) {
                    $scope.ingredient = data;
                });
            }
        }
        $scope.editIngredient = function() {
            ingredientResourceFactory.editIngredient({id: $stateParams.id}, $scope.ingredient, function(result) {
                var message = "<strong>Success!</strong> The ingredient unit was successfully edited.";
                Flash.create('success', message, 'customAlert success');
                $state.go('ingredients');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        };
    }]);