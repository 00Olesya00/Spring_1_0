 angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/store';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/All_products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

     $http({
         url: contextPath + '/products/delete',
         method: 'DELETE',
         params: {
             id: productId,
         }
     }).then(function (response) {
         $scope.loadProducts();
     });

 $scope.filterProducts = function () {
     $http({
         url: contextPath + '/products/filter',
         method: 'GET',
         params: {
             minCost: $scope.minCost,
             maxCost: $scope.maxCost
         }
     }).then(function (response) {
         $scope.ProductsList = response.data;
         $scope.minCost=null;
         $scope.maxCost=null;
     });
    }

    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/All_products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});