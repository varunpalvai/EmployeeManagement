'use strict';

/**
 * @ngdoc function
 * @name dayLeasingApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the dayLeasingApp
 */
console.log('services');
angular.module('poc') .service('serviceCalls', function ($q,$rootScope,$http)  {
	
	var User={};
	
	this.validateLogin=function(user,encoded){
		
		
// var
// xyz={"fname":"test@gminor.net","password":"nopassword","dob":"2017-04-13T19:15:25.864Z","address1":"address1","state":"state","city":"city","zipCode":"121212","country":"india","emailId":"rhsbalaram@gmail.com"};
// var config = {
// headers : {
// 'Content-Type': 'application/json'
// }
// };
   
    	var differed=$q.defer();
    	 $rootScope.config = {
        		 headers: {
        	            "Authorization": "Basic " + encoded,
        	            "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
        	        }
            };

    	$http.post($rootScope.URL+'/oauth/token',$rootScope.config,user)
    .then(function(response) {
        console.log('registration service success');
        console.log(JSON.stringify(response.data));
       
       
        
        

        differed.resolve(response);
    }).catch(function(response){

    	differed.reject(response);
    });
    return differed.promise;
	
};

});