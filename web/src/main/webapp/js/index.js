var converterApp = angular.module('converterApp', []);

converterApp.controller('AppController', function ($scope, $http) {

    $http.defaults.headers.post["Content-Type"] = "application/json";

    $scope.units = [{key: "Celsius", value: "Metric"}, {key: "Fahrenheit", value: "Imperial"}];
    $scope.cities = ['Amsterdam', 'Utrecht', 'Eindhoven'];
    $scope.weatherResultAvailable = false;
    $scope.isLoadWeather = false;

    $scope.getWeather = function () {
        $http.post('rest/convert/weather', $scope.weather).then(function (result) {
            $scope.weather = result.data;
            $scope.weatherResultAvailable = true;
        }, function (result) {
            alert(result);
        });
    };

    $scope.reset = function () {
        $scope.weather = '';
        $scope.weatherResultAvailable = false;
    };

    $scope.showWeather = function () {
        $scope.isLoadWeather = true;
    };

    $scope.convert = function (unit) {
        $scope.weather.unit = unit;
        $scope.getWeather();
    };
});
