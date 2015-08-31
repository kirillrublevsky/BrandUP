var app = angular.module("firstApp", [
	'ui.bootstrap',
	'ngRoute',
  	'appControllers']);


app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
        when('/', {
        templateUrl: 'resources/home.html',
        controller: 'MainPageController'
      }).
        when('/items/:itemGroup/:itemId', {
        templateUrl: '/resources/items.html',
        controller: 'ItemsPageController'
      }).
      when('/contact', {
        templateUrl: '/resources/contact-form.html',
        controller: 'ContactFormController'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);