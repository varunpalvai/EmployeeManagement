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

    	$http.post($rootScope.URL+'/oauth/token',user,$rootScope.config)
    .then(function(response) {
        console.log('registration service success');
        
       
       
        
        

        differed.resolve(response);
    }).catch(function(response){

    	differed.reject(response);
    });
    return differed.promise;
	
};


////////////////
this.addEmployee=function(emp){
	   
	    	var differed=$q.defer();
	    	

	    	$http.post($rootScope.URL+'/employee',emp,$rootScope.config)
	    .then(function(response) {
	        console.log('registration service success');
	        
	        differed.resolve(response);
	    }).catch(function(response){

	    	differed.reject(response);
	    });
	    return differed.promise;
		
	};
	
////////////////
	this.editEmployee=function(emp){
		   
    	var differed=$q.defer();
    	

    	$http.put($rootScope.URL+'/employee',emp,$rootScope.config)
    .then(function(response) {
        console.log('registration service success');
        
        differed.resolve(response);
    }).catch(function(response){

    	differed.reject(response);
    });
    return differed.promise;
	
};

////////////////
this.deleteEmployee=function(empid){
	   
	var differed=$q.defer();
	

	$http.delete($rootScope.URL+'/employee/'+empid,$rootScope.config)
.then(function(response) {
    console.log('delete service success');
    
    differed.resolve(response);
}).catch(function(response){

	differed.reject(response);
});
return differed.promise;

};

////////////////
	this.getEmployees=function(emp){
		   
		    	var differed=$q.defer();
		    	

		    	$http.get($rootScope.URL+'/employees',$rootScope.config)
		    .then(function(response) {
		        console.log('registration service success');
		        
		        differed.resolve(response);
		    }).catch(function(response){

		    	differed.reject(response);
		    });
		    return differed.promise;
			
		};
		//////////
		this.getEmployeeStats=function(){
			   
	    	var differed=$q.defer();
	    	

	    	$http.get($rootScope.URL+'/employee/getEmployeeDashboard',$rootScope.config)
	    .then(function(response) {
	        console.log('stat service success');
	        
	        differed.resolve(response);
	    }).catch(function(response){

	    	differed.reject(response);
	    });
	    return differed.promise;
		
	};

});