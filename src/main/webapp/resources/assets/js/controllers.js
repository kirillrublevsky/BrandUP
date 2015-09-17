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

appControllers.controller("ContactFormCtrl", ['$scope', '$http', '$log', '$timeout', function ($scope, $http, $log, $timeout) {

    $scope.submit = function (form) {

        $scope.submitted = true;

        if (form.$invalid) {
            return;
        }

        var message = {
            "name": $scope.name,
            "phone": $scope.phone,
            "email": $scope.email,
            "contents": $scope.message
        };

        $http.post('/sendMessage', message)
            .success(function (data, status, headers, config) {
                $scope.name = null;
                $scope.phone = null;
                $scope.email = null;
                $scope.message = null;
                $scope.messages = 'Ваше сообщение успешно отправлено!';
                $scope.submitted = false;
            })
            .error(function (data, status, headers, config) {
                $scope.messages = 'Неполадки с сервером. Попробуйте позже';
                $log.error(data);
            })
            .finally(function () {
                $timeout(function () {
                    $scope.messages = null;
                }, 3000);
                $timeout(function () {
                    $('#contactForm').hide();
                }, 2000);
            });


    };
}]);

