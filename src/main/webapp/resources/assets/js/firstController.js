app.controller("firstController", function($scope, $http) {
    $scope.message = "";
    $scope.left  = function() {return 100 - $scope.message.length;};
    $scope.clear = function() {$scope.message = "";};
    $scope.send  = function() {

        $http.get('test/hello').
            success(function(data, status, headers, config) {
                $scope.message = data.value;
            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
    };
});