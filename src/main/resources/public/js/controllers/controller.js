'use strict';

var sparkappControllers = angular.module('sparkappControllers', []);

sparkappControllers.controller('homeController', ['$scope',
    function($scope) {
        $scope.besked = "HOME";
    }]);

sparkappControllers.controller('projectController', ['$scope',
    function($scope) {
        $scope.besked = "PROJECT";
    }]);