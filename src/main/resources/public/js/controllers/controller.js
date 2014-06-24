'use strict';

var sparkappControllers = angular.module('sparkappControllers', []);

sparkappControllers.controller('homeController', ['$scope',
    function($scope) {
        $scope.besked = "HOME";
    }]);

sparkappControllers.controller('projectController', ['$scope','$http',
    function($scope,$http) {

        $scope.besked = "PROJECT";
        $http({method: 'GET', url: '/hello'}).
            success(function(data, status, headers, config) {
                // this callback will be called asynchronously
                // when the response is available
                $scope.response = data;
            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });

    }]);