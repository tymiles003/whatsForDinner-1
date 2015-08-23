'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientUnitController', ['$scope', '$state', 'ingredientUnitResourceFactory', 'paginationService', 'Flash', function ($scope, $state, ingredientUnitResourceFactory, paginationService, Flash) {
        $scope.getAllIngredientUnits = function() {
            ingredientUnitResourceFactory.getAllIngredientUnits({}, function(result) {
                $scope.totalIngredientUnits = result.length;
                $scope.currentPage = paginationService.beginPage;
                $scope.numPerPage = paginationService.numPerPage;
                $scope.maxSize = paginationService.maxSize;

                $scope.$watch('currentPage + numPerPage', function() {
                    var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                    var end = begin + $scope.numPerPage;
                    $scope.ingredientUnits = result.slice(begin, end);
                });
            });
        };

        $scope.addIngredientUnit  = function() {
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