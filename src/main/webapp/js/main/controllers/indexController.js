'use strict';

var index = angular.module('whatsForDinnerApp.index');

index.controller('indexController', ['$scope', 'dishResourceFactory', function ($scope, dishResourceFactory) {
    dishResourceFactory.getAllDishes({}, function(result) {
        $scope.dishes = result;
    });
}]);