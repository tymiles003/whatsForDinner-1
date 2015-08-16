'use strict';

angular.module('whatsForDinnerApp.common')
    .factory('paginationService', function() {
        return {
            numPerPage: 10,
            beginPage: 1,
            maxSize: 5
        }
    });