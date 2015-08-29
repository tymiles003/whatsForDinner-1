'use strict';

angular.module('whatsForDinnerApp.common')
    .factory('modalFactory', ['$rootScope', '$modal', function($rootScope, $modal) {
        /*var createModal = function(templateUrl, controller, options) {
            if (options && options.size) {
                var size = options.size;
            } else {
                var size = 'm';
            }
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: templateUrl,
                controller: controller,
                size: size
            });
        };

        return {
            'createModal': createModal
        };*/

        var defaults = {
            templateUrl: null,
            title: 'Default Modal Title',
            backdrop: true,
            success: {label: 'Ok', fn: null},
            cancel: {label: 'Cancel', fn: null},
            controller: null,
            size: 'm'
        };

        var createModal = function(templateUrl, options) {
            options = angular.extend({}, defaults, options);
            var scope = options.scope || $rootScope.$new();
            scope.modalCancelLabel = options.cancel.label;
            scope.modalCancel = function () {
                var callFn = options.cancel.fn;
                if (callFn != null) {
                    callFn.call(this);
                }
                modalInstance.dismiss('cancel');
            };
            scope.modalSuccessLabel = options.success.label;
            scope.modalSuccess = function () {
                var callFn = options.success.fn;
                if (callFn != null) {
                    callFn.call(this);
                }
                modalInstance.dismiss('cancel');
            };
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: templateUrl,
                controller: options.controller,
                scope: scope,
                size: 'm'
            });
        };

        return {
            'createModal': createModal
        };
    }]);