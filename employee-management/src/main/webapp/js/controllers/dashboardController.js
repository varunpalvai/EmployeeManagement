'use strict';

/**
 * @ngdoc function
 * @name dayLeasingApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the dayLeasingApp
 */
angular.module('poc')
.controller('dashboardController', 
  function($scope, $resource, $httpParamSerializer,serviceCalls,$rootScope,$state,$filter) {
	 $rootScope.config = {
    		 headers: {
    	            "Authorization": "Bearer " + sessionStorage.getItem("access_token"),
    	            "Content-type": "application/json"
    	        }
        };
	 $scope.technology=[];
	 $scope.inProject=[];
	 $scope.inBench=[];
	 
	 serviceCalls.getEmployees()
     .then(function (response) {
     	$scope.ListOfEmployees=response.data;
     	$scope.employees=response.data;

     })
     .catch(function (err) {
       
       $state.go("login");
     });
	 
	
	 function filtering(skillfilter){
		 if(skillfilter=='All'){
			 $scope.employees=$scope.ListOfEmployees;
		 }
		 else{
			 $scope.employees= $filter('filter')($scope.ListOfEmployees, function(employee){
				 var filtered=false;
				 angular.forEach(employee.skills,function(skill){
					
					 if(skill.toUpperCase() == skillfilter.toUpperCase()){
						 filtered=true;
					 }
				 });
				 return filtered;
				 
				
	            });
			 
		 }
		 $scope.$digest();
		 
	 };
	 
	 $scope.logout=function(){
		 sessionStorage.removeItem('access_token');
		 $state.go("login");
		 
	 };
	 
	 $scope.drawHighChart=function(element){
		 
		 serviceCalls.getEmployeeStats()
	     .then(function (response) {
	     	
	     	var stats=response.data;
	     	var technology=[];
	     	var inProject=[];
	     	var inBench=[];
	     	angular.forEach(stats,function(value,key){
	     		technology.push(key);
	     		inProject.push(value[0]);
	     		inBench.push(value[1]);
	     	});
	     	/////////////////////////
	     	$scope.technology=technology;
	     	$scope.inProject =inProject;
	     	$scope.inBench =inBench;
	     	 $scope.options={
	      		    chart: {
	      		        type: 'column'
	      		    },
	      		    colors:['#0be828','#e50d64'],
	      		    title: {
	      		        text: 'Employee Management'
	      		    },
	      		    xAxis: {
	      		        categories: $scope.technology
	      		    },
	      		    yAxis: {
	      		        min: 0,
	      		        title: {
	      		            text: 'Total Resource Utilization'
	      		        },
	      		        stackLabels: {
	      		            enabled: true,
	      		            style: {
	      		                fontWeight: 'bold',
	      		                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
	      		            }
	      		        }
	      		    },
	      		    legend: {
	      		        align: 'right',
	      		        x: -30,
	      		        verticalAlign: 'top',
	      		        y: 25,
	      		        floating: true,
	      		        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
	      		        borderColor: '#CCC',
	      		        borderWidth: 1,
	      		        shadow: false
	      		    },
	      		    tooltip: {
	      		        headerFormat: '<b>{point.x}</b><br/>',
	      		        pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
	      		    },
	      		    plotOptions: {
	      		    	 series: {
	      		                cursor: 'pointer',
	      		                point: {
	      		                    events: {
	      		                        click: function() {
	      		                        	filtering(this.category);
	      		                           /* alert ('Category: '+ this.category +', value: '+ this.y);*/
	      		                            
	      		                        }
	      		                    }
	      		                }
	      		            },
	      		        column: {
	      		            stacking: 'normal',
	      		            dataLabels: {
	      		                enabled: true,
	      		                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
	      		            }
	      		        }
	      		    },
	      		    series: [{
	      		        name: 'On Project',
	      		        data: $scope.inProject
	      		    }, {
	      		        name: 'On Bench',
	      		        data: $scope.inBench
	      		    }]
	      		};
	     	 
	     	var chart= Highcharts.chart(element, $scope.options);	
	     	////////////////////////
	     	// $scope.$apply();
	     })
	     .catch(function (err) {
	       
	      // $state.go("login");
	     });
		 
		 
			
		};
	 
	
	 
	
	
	
	
	$scope.addEmployee=function(emp){
		if(emp.employeeId){
			
			serviceCalls.editEmployee(emp)
	        .then(function (response) {
	        	$('#exampleModal').modal('hide');
	        	$state.reload();
	        	$scope.emp={};
	        })
	        .catch(function (err) {
	          alert('Insertion Failed');
	          $scope.emp={};
	        });
		}
		else{
			serviceCalls.addEmployee(emp)
	        .then(function (response) {
	        	$('#exampleModal').modal('hide');
	        	$state.reload();
	        	$scope.emp={};
	        })
	        .catch(function (err) {
	          alert('Insertion Failed');
	          $scope.emp={};
	        });
		}
		
	};
	
	$scope.editEmployee=function(employee){
		$scope.emp=employee;
		$('#exampleModal').modal();
	};
	
	$scope.deleteEmployee=function(empid){
		
		swal({
			  title: "Are you sure?",
			  text: "Your will not be able to recover!",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-danger",
			  confirmButtonText: "Yes, delete it!",
			  closeOnConfirm: false
			},
			function(){
				serviceCalls.deleteEmployee(empid)
		        .then(function (response) {
		        	swal("Deleted!", "", "success");
		        	$state.reload();
		        	$scope.emp={};
		        })
		        .catch(function (err) {
		        	 swal("Failed", "Unable to delete", "error");
		          $scope.emp={};
		        });
			  
			});
		
		
	};
	
	
	
});