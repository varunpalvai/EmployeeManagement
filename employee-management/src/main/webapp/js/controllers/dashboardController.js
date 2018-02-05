'use strict';

/**
 * @ngdoc function
 * @name dayLeasingApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the dayLeasingApp
 */
angular.module('poc')
.controller('dashboardController', 
  function($scope, $resource, $httpParamSerializer,serviceCalls) {
	
	$scope.options={
		    chart: {
		        type: 'column'
		    },
		    title: {
		        text: 'Stacked column chart'
		    },
		    xAxis: {
		        categories: ['All','Java','Hadoop','Big Data','Devops']
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
		        data: [5, 3, 4, 7, 2]
		    }, {
		        name: 'On Bench',
		        data: [2, 2, 3, 2, 1]
		    }]
		};
	
});