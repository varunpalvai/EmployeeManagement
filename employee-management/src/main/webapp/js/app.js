angular.module('poc', [
    
    'ui.router',
    'ngResource'
   
  ])
  
  .config(function ($locationProvider , $stateProvider, $urlRouterProvider) {
	 
    $locationProvider.hashPrefix('');
    
//     "username":"EMAILID@gmail.com",
//    "password":"admin"
    //configuring all the urls
     $stateProvider
     .state('login', {
           url: '/',
           templateUrl: '/views/login.html' ,
           controller:'loginController',
          
       
     }).state('dashboard', {
         url: '/dashboard',
         templateUrl: '/views/dashboard.html' ,
         controller:'dashboardController',
         
     
   });
      
       
       $urlRouterProvider.otherwise('/');
      
   
  }).run(function ($rootScope) {
	  //base url of apis
	    $rootScope.URL='http://localhost:8090';
	   
  });
	  