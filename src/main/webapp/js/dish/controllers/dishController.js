'use strict';

angular.module('whatsForDinnerApp.dish')
    .controller('dishController', ['$scope', '$state', 'dishResourceFactory', 'paginationService', 'Flash', 'modalFactory', 'dateTimeFormat',
        function ($scope, $state, dishResourceFactory, paginationService, Flash, modalFactory, dateTimeFormat) {
            $scope.dateTimeFormat = dateTimeFormat;

            $scope.getAllDishes = function() {
                getAllDishes();
            };
            
            $scope.deleteDishModal = function(id) {
                modalFactory.createModal({
                    id: 'deleteDishModal',
                    title: 'Delete dish',
                    backdrop: true,
                    controller: 'dishController',
                    success: {label: 'Delete', fn: function() {
                        dishResourceFactory.deleteDish({id: id}, function(result) {
                            getAllDishes();
                            var message = "<strong>Success!</strong> The dish was successfully added.";
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

            var getAllDishes = function() {
                dishResourceFactory.getAllDishes({}, function(result) {
                    $scope.totalDishes = result.length;
                    $scope.currentPage = paginationService.beginPage;
                    $scope.numPerPage = paginationService.numPerPage;
                    $scope.maxSize = paginationService.maxSize;
                    if ($scope.totalDishes > $scope.numPerPage) {
                        $scope.showPagination = true;
                    } else {
                        $scope.showPagination = false;
                    }

                    $scope.$watch('currentPage + numPerPage', function() {
                        var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                        var end = begin + $scope.numPerPage;
                        $scope.dishes = result.slice(begin, end);
                    });
                });
            };

            $scope.getAllDishes();
        }]);