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
});