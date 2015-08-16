'use strict';

angular.module('whatsForDinnerApp.dish')
    .factory('dishResourceFactory', ['$resource', function($resource) {
        return $resource('api/dishes', {}, {
            getAllDishes: {
                method: 'GET',
                isArray: true
            }
        });
    }]);