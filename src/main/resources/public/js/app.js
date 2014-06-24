angular.module("sparkapp", ['sparkappControllers', 'ngRoute','ngResource'])

    .config(['$routeProvider','$locationProvider',
        function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: 'js/views/home.html',
                controller: 'homeController'

            })
            .when('/project', {
                templateUrl: 'js/views/projects.html',
                controller: 'projectController'
            })
            .otherwise({
                redirectTo: '/home'
            });

        // configure html5 to get links working on jsfiddle
        $locationProvider.html5Mode(true);

    }]);

