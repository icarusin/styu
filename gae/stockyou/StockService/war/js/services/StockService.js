
 myModule.factory('stocks',['$http', '$q',function($http,$q){
	'use strict';
	return {
		getstocks : function(){
		var deferred = $q.defer();
		var url = '/resources/portfolio/nse';
		$http.get(url).success(function(data){
			deferred.resolve(data);
			}).error(function(data) {
	            deferred.reject(data);
	        });
			return deferred.promise;
		}
	};
}]);
