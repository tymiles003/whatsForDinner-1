'use strict';

angular.module('whatsForDinnerApp.dish')
    .config(function($stateProvider) {
        $stateProvider.state('dishes', {
            parent: 'site',
            url: '/dishes',
            views: {
                'content@': {
                    templateUrl: 'js/dish/views/dish.html',
                    controller: 'dishController'
                }
            }
        });
        $stateProvider.state('addDish', {
            parent: 'dishes',
            url: '/add',
            views: {
                'content@': {
                    templateUrl: 'js/dish/views/newDishForm.html',
                    controller: 'dishController'
                }
            }
        });
});