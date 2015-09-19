'use strict';

angular.module('whatsForDinnerApp.ingredient')
    .controller('ingredientController', ['$scope', '$state', 'ingredientResourceFactory', 'paginationService', 'Flash', 'modalFactory', 'dateTimeFormat',
        function ($scope, $state, ingredientResourceFactory, paginationService, Flash, modalFactory, dateTimeFormat) {
            $scope.dateTimeFormat = dateTimeFormat;

            $scope.getAllIngredients = function() {
                getAllIngredients();
            };

            $scope.deleteIngredientModal = function(id) {
                modalFactory.createModal({
                    id: 'deleteIngredientModal',
                    title: 'Delete ingredient',
                    backdrop: true,
                    controller: 'ingredientController',
                    success: {label: 'Delete', fn: function() {
                        ingredientResourceFactory.deleteIngredient({id: id}, function(result) {
                            getAllIngredients();
                            var message = "<strong>Success!</strong> The ingredient was successfully added.";
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

            var getAllIngredients = function() {
                ingredientResourceFactory.getAllIngredients({}, function(result) {
                    $scope.totalIngredients = result.length;
                    $scope.currentPage = paginationService.beginPage;
                    $scope.numPerPage = paginationService.numPerPage;
                    $scope.maxSize = paginationService.maxSize;
                    if ($scope.totalIngredients > $scope.numPerPage) {
                        $scope.showPagination = true;
                    } else {
                        $scope.showPagination = false;
                    }

                    $scope.$watch('currentPage + numPerPage', function() {
                        var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                        var end = begin + $scope.numPerPage;
                        $scope.ingredients = result.slice(begin, end);
                    });
                });
            };

            $scope.getAllIngredients();
        }
    ]);