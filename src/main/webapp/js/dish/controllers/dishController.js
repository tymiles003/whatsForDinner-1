'use strict';

angular.module('whatsForDinnerApp.dish')
    .controller('dishController', ['$scope', 'dishResourceFactory', function ($scope, dishResourceFactory) {
        dishResourceFactory.getAllDishes({}, function(result) {
            $scope.totalDishes = 20;
            $scope.currentPage = 1;
            $scope.numPerPage = 10;
            $scope.maxSize = 5;

            $scope.$watch('currentPage + numPerPage', function() {
                var begin = (($scope.currentPage - 1) * $scope.numPerPage);
                var end = begin + $scope.numPerPage;
                $scope.dishes = result.slice(begin, end);
            });
        });
    }]);