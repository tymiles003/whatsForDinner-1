'use strict';

angular.module('whatsForDinnerApp.dish')
    .controller('dishController', ['$scope', '$state', 'dishResourceFactory', 'paginationService', 'Flash', function ($scope, $state, dishResourceFactory, paginationService, Flash) {
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

        $scope.addDish = function() {
            dishResourceFactory.addDish($scope.dish, function(result) {
                var message = "<strong>Success!</strong> The dish was successfully added.";
                Flash.create('success', message, 'customAlert success');
                $state.go('dishes');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        }
    }]);