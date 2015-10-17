'use strict';

angular.module('whatsForDinnerApp.dish')
    .controller('dishCreateController', ['$scope', '$state', 'dishResourceFactory', 'Flash',
        function ($scope, $state, dishResourceFactory, Flash) {
            $scope.dish = {};
            
            $scope.addDish = function() {
                dishResourceFactory.addDish($scope.dish, function(result) {
                    var message = "<strong>Success!</strong> The dish was successfully added.";
                    Flash.create('success', message, 'customAlert success');
                    $state.go('dishes');
                }, function(error) {
                    var message = "<strong>Something went wrong!</strong> Status: " + error.status + "<br/> Message: "  +error.data.message;
                    Flash.create('danger', message, 'customAlert danger');
                });
            }
        }]);