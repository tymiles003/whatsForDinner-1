'use strict';

var index = angular.module('whatsfordinnerApp.index');

index.factory('indexResourceFactory', function($resource) {
    return $resource('api/dishes', {}, {
        getAllDishes: {
            method: 'GET',
            isArray: true
        }
    });
});