/* App Module */

var app = angular.module("mainApp", [
    'ui.bootstrap',
    'ngRoute',
    'appControllers']);


app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'resources/assets/views/home.html',
                controller: 'MainPageCtrl'
            }).
            when('/items/:itemGroup/:itemId', {
                templateUrl: '/resources/assets/views/items.html',
                controller: 'ItemsPageCtrl'
            }).
            when('/contact', {
                templateUrl: '/resources/contact-form.html',
                controller: 'ContactFormCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);

function isNotMax(textArea) {
    return textArea.value.length <= textArea.getAttribute('maxlength');
}
