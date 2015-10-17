'use strict';

angular.module('whatsForDinnerApp.dish')
    .factory('dishResourceFactory', ['$resource', function($resource) {
        return $resource('api/dishes/:id', {id: '@id'}, {
            getAllDishes: {
                method: 'GET',
                isArray: true
            },
            addDish: {
                method: 'POST'
            },
            getDish: {
                method: 'GET',
                params: { id: "@id"}
            },
            editDish: {
                method: 'PUT',
                params: { id: "@id"}
            },
            deleteDish: {
                method: 'DELETE',
                params: { id: "@id"}
            }
        });
    }]);