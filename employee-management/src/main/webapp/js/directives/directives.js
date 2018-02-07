 angular.module('poc')
            // Directive for generic chart, pass in chart options
            .directive('hcChart', function ($timeout) {
                return {
                    restrict: 'E',
                    template: '<div></div>',
                    scope: '@',
                    link: function (scope, element) {
                    	
                    	scope.drawHighChart(element[0]);
                    		
                    	
                    	
                       
                    }
                };
            })