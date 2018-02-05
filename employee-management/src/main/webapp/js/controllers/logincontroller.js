'use strict';

/**
 * @ngdoc function
 * @name dayLeasingApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the dayLeasingApp
 */
angular.module('poc')
.controller('loginController', 
  function($scope, $resource, $httpParamSerializer,serviceCalls,$state) {
	
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
        	var token=response.data;

        	sessionStorage.setItem("access_token", token.access_token);
        	$state.go("dashboard");

        })
        .catch(function (err) {
          alert('Login Failed');
        });
		};
	
});