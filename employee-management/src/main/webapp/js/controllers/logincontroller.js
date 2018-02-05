'use strict';

/**
 * @ngdoc function
 * @name dayLeasingApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the dayLeasingApp
 */
angular.module('poc')
.controller('loginController', 
  function($scope, $resource, $httpParamSerializer,serviceCalls) {
	
	$scope.login=function(user){
		
		$scope.data = {
		        grant_type:"password", 
		        username: user.username, 
		        password: user.password, 
		        client_id: "devglan-client"
		    };
		
        var encoded = btoa("devglan-client:devglan-secret");
	    var data= $httpParamSerializer($scope.data);
	    serviceCalls.validateLogin(data,encoded)
        .then(function (response) {

         

        })
        .catch(function (err) {
          alert('failed');
        });
		};
	
});