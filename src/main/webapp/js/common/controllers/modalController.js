'use strict';

angular.module('whatsForDinnerApp.common')
    .controller('modalController', ['$scope', '$modalInstance', function($scope, $modalInstance) {
        $scope.ok = function() {
            alert('ok ok ok ok');
        };

        $scope.closeModal = function() {
            $modalInstance.dismiss('cancel');
        };
    }]);