'use strict';

/* Controllers */

function StockListCtrl($scope,$timeout,stocks) {
  
  $scope.setSmiley = function (stock,index){
  	console.log(stock.stock_price);
  	var moving_daily_average = 50;
  		if(((stock.stock_price - moving_daily_average)/moving_daily_average)> 0.0){
          console.log("good" + index);
          $scope.stocks[index].hash = $scope.smileys[0];
          /*$scope.hash = $scope.smileys[0];*/
  		}
  		else{
  		console.log("bad"+index);
  		  $scope.stocks[index].hash = $scope.smileys[1];
  		}
  	
  }
  $scope.smileys = ['/images/happy.jpeg','/images/cry.jpeg'];
  
  $scope.getAllStocks = function(){
	console.log("Making a call to the backend to get stocks");
	//TODO uncomment this after fixing NPE
	//var promise  = stocks.getstocks();  
	//promise.then(onSuccess,onError);
	 
	  
  };
  var onSuccess = function(result){
	  $scope.stocks = result.quote;
	  var length = $scope.stocks.length;
	  for (var i=0;i<length;i++)
		{ 
			  /*setsmiley($scope.stocks[i],i);*/
		      
			  var stock = $scope.stocks[i];
			  stock.moving_daily_average = 50;
			   console.log(parseFloat(stock.stock_price) - stock.moving_daily_average);
	  		if(((parseFloat(stock.stock_price) - stock.moving_daily_average)/stock.moving_daily_average)> 0.0){
	          console.log("good" + i);
	          $scope.stocks[i].hash = $scope.smileys[0];
	          /*$scope.hash = $scope.smileys[0];*/
	  		}
	  		else{
	  		console.log("bad"+i);
	  		  $scope.stocks[i].hash = $scope.smileys[1];
	  		}
		}
	  
  };
  var onError = function(result){
	  alert("Something went wrong");
  }

 
 
 this.startPolling = function(){
   function poll(){
     // do something.
	 $scope.getAllStocks();
     $timeout(poll, 60000); //make a call every 60 secs
   };
   poll();
 };
 this.startPolling();

}
StockListCtrl.$inject = ['$scope','$timeout','stocks'];