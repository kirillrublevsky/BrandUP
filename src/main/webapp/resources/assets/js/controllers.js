/* Controllers */

var appControllers = angular.module('appControllers', []);


appControllers.controller("MainPageCtrl", ['$scope', function ($scope) {
    $scope.who = 'We';
}]);

appControllers.controller("ItemsPageCtrl", ['$scope', '$routeParams', '$http', function ($scope, $routeParams, $http) {
    $scope.itemGroup = $routeParams.itemGroup;
    $scope.itemId = $routeParams.itemId;

    $http.get('/items/' + $routeParams.itemGroup + '/' + $routeParams.itemId).success(function (response) {
        $scope.data = response;
    });

}]);

appControllers.controller("ContactFormCtrl", ['$scope', '$http', function ($scope, $http) {
    $scope.send = function () {

        $http.post('/sendMessage', $scope.message).
            success(function () {
                alert('Hello');
                $('#contactForm').hide();
            }).
            error(function (data, status, headers, config) {
                alert("Exception details: " + "data:");
            });
        $scope.message = "";
    };
}]);

