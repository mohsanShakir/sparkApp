'use strict';

var sparkappControllers = angular.module('sparkappControllers', []);

sparkappControllers.controller('homeController', ['$scope',
    function ($scope) {
        $scope.header = "Home";
    }]);


sparkappControllers.controller('projectController', ['$scope', '$resource',
    function ($scope, $resource) {

        $scope.header = "Projects";

        var Projects = $resource('/projects/:projectId', {projectId:'@id'});

        Projects.query()
            .$promise.then(function (projects) {
                $scope.projects = projects;
            });

        $scope.deleteProject = function(id) {
           Projects.delete({projectId:id})
               .$promise.then(function (projects) {
               $scope.projects = projects;
           });

        };

    }]);

