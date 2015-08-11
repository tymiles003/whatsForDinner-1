'use strict';

angular.module('whatsForDinnerApp.index').config(function($stateProvider) {
    $stateProvider.state('index', {
        parent: 'site',
        url: '/',
        views: {
            'content@': {
                templateUrl: 'js/main/views/main.html',
                controller: 'indexController'
            }
        }
    });
});