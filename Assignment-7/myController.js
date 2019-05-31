var app = angular.module("myShoppingApp",[]);
app.controller("myController", ['$scope', function($scope){
	
	$scope.showProduct = {
		productList : [	{name:"Apple MacBook Pro", rating: 4 , price: 1250},
						{name:"Apple iPhone X", rating: 4.2 , price: 999},
						{name:"Samsung Galaxy S8", rating: 4 , price: 800},
						{name:"Sony PlayStation 4 Pro", rating: 4.5 , price: 300},
						{name:"Xbox One X", rating: 4.5 , price: 500},
						{name:"Dell XPS 15", rating: 4.6 , price: 1350},
						{name:"Razer Blade 2017", rating: 4.8 , price: 2000},
						{name:"Frigidaire 18cu. fridge", rating: 4.7, price: 500},
						{name:"Alienware 17", rating: 4.8 , price: 1550},
						{name:"OnePlus 5", rating: 4.6 , price: 450}],
	}


	$scope.products = [];
	$scope.addItem = function(product){
		$scope.products.push(product);
		//$window.alert("Added to Kart");

		alert(product.name + " Added to the Kart");	
		console.log(product.name+" "+ product.price);
		console.log($scope.products.length);
		
		

	}
	
	$scope.removeItem = function(x){
		$scope.products.splice(x,1);
	}

	$scope.totalPrice = function(){
		$scope.total = 0;
		for(var i = 0; i < $scope.products.length; i++){
        var product = $scope.products[i];
        $scope.total += product.price;
    }
    return $scope.total;
	}

	$scope.totalPriceWithTax = function(){

		return ($scope.totalPrice()) + ($scope.totalPrice() * 0.0625);

	}

	/*$scope.discounts = [{
		label : "DISCOUNT5",
		value : 0.05},
		{label : "DISCOUNT10",
		value : 0.1},
		{label : "DISCOUNT15",
		value : 0.15},
		{label : "DISCOUNT20",
		value : 0.20}
	];*/

	$scope.discountCoupons = {
		DISCOUNT5: {value : 0.05},
		DISCOUNT10: {value : 0.1},
		DISCOUNT15: {value : 0.15},
		DISCOUNT20: {value : 0.20},
	}

	/*function expand() {
		$scope.autoExpand('TextArea');
	}*/

	$scope.checkout = function(){
		if($scope.totalPriceWithTax() == 0){
			alert("You cannot checkout an empty cart");
		}else if($scope.myform.$pristine){
			alert("Please fill in your billing details");
		}
		else{
			alert("Thank you for shopping at ShopKart");
		}
	}

	}]);

