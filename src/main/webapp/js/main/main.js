'use strict';

angular.module('whatsfordinnerApp.index').config(function($stateProvider) {
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