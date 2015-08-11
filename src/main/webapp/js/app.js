'use strict';

angular.module('whatsfordinnerApp.index', ['ngResource']);

var whatsfordinnerApp = angular.module('whatsfordinnerApp', ['ui.bootstrap', 'ngResource', 'ui.router', 'whatsfordinnerApp.index']);

whatsfordinnerApp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider.state('site', {
        'abstract': true,
        views: {
            'navbar@': {
                templateUrl: 'js/navbar/views/navbar.html',
                controller: 'navbarController'
            }
        }
    });
})