'use strict';

angular.module('whatsForDinnerApp.common', ['ngResource', 'ngAnimate', 'flash'])
angular.module('whatsForDinnerApp.index', ['whatsForDinnerApp.common']);
angular.module('whatsForDinnerApp.dish', ['whatsForDinnerApp.common']);
angular.module('whatsForDinnerApp.ingredient', ['whatsForDinnerApp.common']);

var whatsForDinnerApp = angular.module('whatsForDinnerApp', ['ui.bootstrap', 'ngResource', 'ui.router', 'whatsForDinnerApp.index', 'whatsForDinnerApp.dish', 'whatsForDinnerApp.ingredient']);

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

whatsForDinnerApp.value('dateTimeFormat', 'dd-MM-yyyy HH:mm:ss')