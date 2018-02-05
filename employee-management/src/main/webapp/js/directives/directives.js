 angular.module('poc')
            // Directive for generic chart, pass in chart options
            .directive('hcChart', function ($timeout) {
                return {
                    restrict: 'E',
                    template: '<div></div>',
                    scope: '@',
                    link: function (scope, element) {
                    	$timeout(function(){
                    		var chart= Highcharts.chart(element[0], scope.options);	
                    	
                    	},0);
                       
                    }
                };
            })