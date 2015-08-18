
var appControllers = angular.module('appControllers', []);


appControllers.controller("ContactFormController", ['$scope', '$http', function($scope, $http) {
    $scope.message = "";
    $scope.left  = function() {return 200 - $scope.message.length;};
    $scope.clear = function() {$scope.message = "";};
    $scope.send  = function() {

        $http.post('/sendMessage', {'message' : $scope.message}).
            success(function(data, status, headers, config) {
                alert(angular.fromJson(data).contents);
            }).
            error(function(data, status, headers, config) {
                alert( "Exception details: " + JSON.stringify({data: data}));
            });

        $scope.message = "";
    };
}]);

