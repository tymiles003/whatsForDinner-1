'use strict';

angular.module('whatsForDinnerApp.dish')
    .factory('dishResourceFactory', function($resource) {
        return $resource('api/dishes', {}, {
            getAllDishes: {
                method: 'GET',
                isArray: true
            }
        });
    });