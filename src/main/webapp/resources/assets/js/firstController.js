
var appControllers = angular.module('appControllers', []);




appControllers.controller("MainPageController", ['$scope', function($scope) {
    $scope.who ='We';
}]);

appControllers.controller("ItemsPageController", ['$scope','$routeParams', '$http', function($scope, $routeParams, $http) {
    $scope.itemGroup = $routeParams.itemGroup;
    $scope.itemId = $routeParams.itemId;

    $http.get('/items/' + $routeParams.itemGroup + '/' + $routeParams.itemId).success(function(response) {
        $scope.data = response;
    });

}]);

appControllers.controller("ContactFormController", ['$scope', '$http', function($scope, $http) {
    $scope.message = "";
    $scope.left  = function() {return 200 - $scope.message.length;};
    $scope.clear = function() {$scope.message = "";};
    $scope.send  = function() {

        $http.post('/sendMessage', {'message' : $scope.message}).
            success(function(data, status, headers, config) {
                alert(data.contents);
            }).
            error(function(data, status, headers, config) {
                alert( "Exception details: " + "data:" );
            });

        $scope.message = "";
    };
}]);

