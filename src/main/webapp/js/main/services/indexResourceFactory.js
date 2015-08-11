'use strict';

var index = angular.module('whatsForDinnerApp.index');

index.factory('indexResourceFactory', function($resource) {
    return $resource('api/dishes', {}, {
        getAllDishes: {
            method: 'GET',
            isArray: true
        }
    });
});