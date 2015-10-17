'use strict';

angular.module('whatsForDinnerApp.dish')
    .controller('dishController', ['$scope', '$state', 'dishResourceFactory', 'paginationService', 'dateTimeFormat',
        function ($scope, $state, dishResourceFactory, paginationService, dateTimeFormat) {
            $scope.dateTimeFormat = dateTimeFormat;

            dishResourceFactory.getAllDishes({}, function(result) {
                $scope.totalDishes = result.length;
                $scope.currentPage = paginationService.beginPage;
                $scope.numPerPage = paginationService.numPerPage;
                $scope.maxSize = paginationService.maxSize;

                $scope.$watch('currentPage + numPerPage', function() {
                    var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                    var end = begin + $scope.numPerPage;
                    $scope.dishes = result.slice(begin, end);
                });
            });
        }]);