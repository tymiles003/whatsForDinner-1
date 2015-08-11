'use strict';

var index = angular.module('whatsfordinnerApp.index');

index.controller('indexController', ['$scope', 'indexResourceFactory', function ($scope, mainResourceFactory) {
    mainResourceFactory.getAllDishes({}, function(result) {
        console.log(result);
        $scope.dishes = result;
    });
}]);