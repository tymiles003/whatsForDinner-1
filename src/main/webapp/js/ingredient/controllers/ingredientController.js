'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientController', ['$scope', '$state', 'ingredientResourceFactory', 'paginationService', 'Flash', function ($scope, $state, ingredientResourceFactory, paginationService, Flash) {
        $scope.getAllIngredients = function() {
            ingredientResourceFactory.getAllIngredients({}, function(result) {
                $scope.totalIngredients = result.length;
                $scope.currentPage = paginationService.beginPage;
                $scope.numPerPage = paginationService.numPerPage;
                $scope.maxSize = paginationService.maxSize;

                $scope.$watch('currentPage + numPerPage', function() {
                    var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                    var end = begin + $scope.numPerPage;
                    $scope.ingredients = result.slice(begin, end);
                });
            });
        };

        $scope.addIngredient = function() {
            ingredientResourceFactory.addIngredient($scope.ingredient, function(result) {
                var message = "<strong>Success!</strong> The ingredient was successfully added.";
                Flash.create('success', message, 'customAlert success');
                $state.go('ingredients');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        }
    }]);