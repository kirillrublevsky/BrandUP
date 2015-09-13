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
    $scope.formData = {};
    $scope.send = function () {

        $http.post('/sendMessage', $scope.message).
            success(function (data) {
                console.log(data);

                if (!data.success) {
                    // if not successful, bind errors to error variables
                    $scope.errorName = "Введите имя";
                    $scope.errorEmail = "Введите email";
                } else {
                    // if successful, bind success message to message
                    $scope.message = data.message;
                    $scope.errorName = "";
                    $scope.errorSuperhero = "";
                    $('#contactForm').hide();
                }

            });
    };
}]);

