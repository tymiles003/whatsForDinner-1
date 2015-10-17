'use strict';

angular.module('whatsForDinnerApp.dish')
    .controller('dishEditController', ['$scope', '$state', 'dishResourceFactory', '$stateParams', 'Flash', function ($scope, $state, dishResourceFactory, $stateParams, Flash) {
        $scope.loadDish = function() {
            if (typeof $stateParams !== 'undefined' && $stateParams.id !== null) {
                $scope.dishPromise = dishResourceFactory.getDish({id: $stateParams.id}).$promise.then(function(data) {
                    $scope.dish = data;
                });
            }
        }
        $scope.editDish = function() {
            dishResourceFactory.editDish({id: $stateParams.id}, $scope.dish, function(result) {
                var message = "<strong>Success!</strong> The dish was successfully edited.";
                Flash.create('success', message, 'customAlert success');
                $state.go('dishes');
            }, function(error) {
                var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                Flash.create('danger', message, 'customAlert danger');
            });
        };
    }]);