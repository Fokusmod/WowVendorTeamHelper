angular.module('front').controller('coreController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/core/';
    const PROXY_URL = 'http://localhost:8080';

    $scope.imageUrl = function (urlImage, width , height) {
        $scope.smalImage = PROXY_URL+"/rs:fill:"+width+":"+height+"/plain/"+urlImage;
        console.log($scope.smalImage);
    }

    $scope.loadAnimals = function (){
        // console.log("загружаем");
        $http.get(contextPath + 'api/v1/animals/foruser/' + $localStorage.springWebUser.username)
            .then(function (response) {
                $scope.AnimalList = response.data;
            });
    }

    $scope.details = function (id){
        // console.log(dateBorn, gender);
        // alert('Пол: ' + gender + ' Дата рождения : ' + dateBorn + 'URL : ' + URL);
        $http.get(contextPath + 'api/v1/animals/' + id)
            .then(function (response) {
                $scope.AnimalDetail = response.data;
            });
    }

    $scope.saveAnimal = function () {
        $scope.animalForm.username = $localStorage.springWebUser.username;
        $http.post(contextPath + 'api/v1/animals', $scope.animalForm
        ).then(function (response) {
            $scope.loadAnimals();
        },function errorCallback(response) {
            let exceptionObj = response.data;
            alert("Ошибка: " + exceptionObj.message);
        });
    }

    $scope.deleteAnimal = function (id) {
        $http.delete(contextPath + 'api/v1/animals/' + id)
            .then(function (response) {
                $scope.loadAnimals();
            });
    }

    $scope.loadAnimals();
});