var app = angular.module("firstApp", [
	'ui.bootstrap',
	'ngRoute',
  	'appControllers']);


app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'contact-form.html',
        controller: 'ContactFormController'
      }).
      when('/test', {
        templateUrl: 'items/test.html',
        controller: 'TestController'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);