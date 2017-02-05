var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){
	$scope.refreshCart = function (cartId){
		
		$http.get('/eMusicStore/rest/cart/' + $scope.cartId).success(function (data){
			$scope.cart = data;
		});
	}
	
	$scope.clearCart = function (){
			$http.delete('/eMusicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));
	}
	
	$scope.initCart = function (cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	}
	
	$scope.addToCart = function (productId){
		$http.put('/eMusicStore/rest/cart/addItem/' + productId).success(function (data){
			$scope.refreshCart($http.get('/eMusicStore/rest/cart/cartId'));
			alert("Product Added sucessfully");
		});
	}
	
	$scope.removeToCart = function (productId){
		$http.put('/eMusicStore/rest/cart/removeItem/' + productId).success(function (data){
			$scope.refreshCart($http.get('/eMusicStore/rest/cart/cartId'));
			alert("Product Deleted sucessfully");
		});
	}
});