'use strict';

/* Controllers */

function StockListCtrl($scope, $http) {
  var url = '/resources/portfolio/nse';
  function setsmiley(stock,index){
  	console.log(stock.stock_price - stock.moving_daily_average);
  		if(((stock.stock_price - stock.moving_daily_average)/stock.moving_daily_average)> 0.0){
          console.log("good" + index);
          $scope.stocks[index].hash = $scope.smileys[0];
          /*$scope.hash = $scope.smileys[0];*/
  		}
  		else{
  		console.log("bad"+index);
  		  $scope.stocks[index].hash = $scope.smileys[1];
  		}
  	
  }
  $scope.smileys = ['/images/happy.jpeg','/images/cry.jpeg']
  $http.get(url).success(function(data) {
    $scope.stocks = data.quote;
    for (var i=0;i<$scope.stocks.length;i++)
		{ 
			  /*setsmiley($scope.stocks[i],i);*/
			  var stock = $scope.stocks[i];
			   console.log(stock.stock_price - stock.moving_daily_average);
	  		if(((stock.stock_price - stock.moving_daily_average)/stock.moving_daily_average)> 0.0){
	          console.log("good" + i);
	          $scope.stocks[i].hash = $scope.smileys[0];
	          /*$scope.hash = $scope.smileys[0];*/
	  		}
	  		else{
	  		console.log("bad"+i);
	  		  $scope.stocks[i].hash = $scope.smileys[1];
	  		}
		}
		
  });

}