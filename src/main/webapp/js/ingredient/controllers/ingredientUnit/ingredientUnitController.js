'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientUnitController', ['$scope', '$state', 'ingredientUnitResourceFactory', 'paginationService', 'Flash', 'modalFactory', 'dateTimeFormat',
        function ($scope, $state, ingredientUnitResourceFactory, paginationService, Flash, modalFactory, dateTimeFormat) {
            $scope.dateTimeFormat = dateTimeFormat;

            $scope.getAllIngredientUnits = function() {
                getAllIngredientUnits();
            };

            $scope.deleteIngredientUnitModal = function(id) {
                modalFactory.createModal({
                    id: 'deleteIngredientUnitModal',
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
                    if ($scope.totalIngredientUnits > $scope.numPerPage) {
                        $scope.showPagination = true;
                    } else {
                        $scope.showPagination = false;
                    }

                    $scope.$watch('currentPage + numPerPage', function() {
                        var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                        var end = begin + $scope.numPerPage;
                        $scope.ingredientUnits = result.slice(begin, end);
                    });
                });
            };

            $scope.getAllIngredientUnits();
        }
    ]);