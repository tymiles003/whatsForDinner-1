'use strict';

angular.module('whatsForDinnerApp.index', ['ngResource']);
angular.module('whatsForDinnerApp.dish', ['ngResource']);

var whatsForDinnerApp = angular.module('whatsForDinnerApp', ['ui.bootstrap', 'ngResource', 'ui.router', 'whatsForDinnerApp.index', 'whatsForDinnerApp.dish']);

whatsForDinnerApp.config(function($stateProvider, $urlRouterProvider) {
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