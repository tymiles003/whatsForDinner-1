'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientUnitController', ['$scope', '$state', 'ingredientUnitResourceFactory', 'paginationService', 'Flash', 'modalFactory', function ($scope, $state, ingredientUnitResourceFactory, paginationService, Flash, modalFactory) {
        $scope.getAllIngredientUnits = function() {
            getAllIngredientUnits();
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

        $scope.deleteIngredientUnitModal = function(id) {
            modalFactory.createModal('js/ingredient/views/deleteIngredientUnitModal.html', {
                id: 'deleteIngredientModal',
                title: 'Delete ingredient unit',
                backdrop: true,
                controller: 'ingredientUnitController',
                success: {label: 'Delete', fn: function() {
                    ingredientUnitResourceFactory.deleteIngredientUnit({id: id}, function(result) {
                        getAllIngredientUnits();
                        var message = "<strong>Success!</strong> The ingredient unit was successfully added.";
                        Flash.create('success', message, 'customAlert success');
                    }, function(error) {
                        if (error.data) {
                            var errorMessage = error.data.message;
                        } else {
                            var errorMessage = error;
                        }
                        var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  + errorMessage;
                        Flash.create('danger', message, 'customAlert danger');
                    });
                }},
                scope: $scope
            });
        };

        var getAllIngredientUnits = function() {
            ingredientUnitResourceFactory.getAllIngredientUnits({}, function(result) {
                $scope.totalIngredientUnits = result.length;
                $scope.currentPage = paginationService.beginPage;
                $scope.numPerPage = paginationService.numPerPage;
                $scope.maxSize = paginationService.maxSize;
                $scope.allIngredientUnits = result;
                $scope.$watch('currentPage + numPerPage', function() {
                    var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                    var end = begin + $scope.numPerPage;
                    $scope.ingredientUnits = result.slice(begin, end);
                });
            });
        };
    }]);