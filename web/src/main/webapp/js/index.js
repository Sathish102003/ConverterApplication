var converterApp = angular.module('converterApp', []);

converterApp.controller('AppController', function ($scope, $http) {

    $http.defaults.headers.post["Content-Type"] = "application/json";

    $scope.units = [{key: "Celsius", value: "Metric"}, {key: "Fahrenheit", value: "Imperial"}];
    $scope.cities = ['Amsterdam', 'Utrecht', 'Eindhoven'];
    $scope.currencies = ['USD', 'INR', 'EUR'];
    $scope.weatherResultAvailable = false;
    $scope.currencyResultAvailable = false;
    $scope.isLoadWeather = false;
    $scope.isLoadCurrency = false;

    $scope.getWeather = function () {
        $http.post('rest/convert/weather', $scope.weather).then(function (result) {
            $scope.weather = result.data;
            $scope.weatherResultAvailable = true;
        }, function (result) {
            alert(result);
        });
    };

    $scope.getCurrency = function () {
        $http.post('rest/convert/currency', $scope.currency).then(function (result) {
            $scope.currency = result.data;
            $scope.currencyResultAvailable = true;
        }, function (result) {
            alert(result);
        });
    };

    $scope.reset = function () {
        $scope.weatherResultAvailable = false;
        $scope.currencyResultAvailable = false;
    };

    $scope.loadWeather = function () {
        $scope.isLoadWeather = true;
        $scope.isLoadCurrency = false;
    };

    $scope.loadCurrency = function () {
        $scope.isLoadWeather = false;
        $scope.isLoadCurrency = true;
    };

    $scope.convert = function (unit) {
        $scope.weather.unit = unit;
        $scope.getWeather();
    };
});
