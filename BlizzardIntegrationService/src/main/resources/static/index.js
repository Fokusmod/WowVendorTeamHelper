angular.module('index_front',[]).controller('indexController', function ($rootScope, $scope, $http) {


    const contextPath = 'http://localhost:8081/front/api/v1';

    $scope.test = function () {

        console.log($scope.user)
        $http.post(contextPath + '/character', $scope.user)
            .then(function successCallback(response) {
                alert("Отправлено на бэк")
                $scope.user.nickname = "";
                $scope.user.realm = "";
            }, function failCallback(response) {
                console.log(response)
                alert("Что то пошло не так")
            })


    }

});

