(function(){
	var app = angular.module("exchangeApp", []);
	
	var RegistrationController = function($scope, $http){
	$scope.passwordsNotEqual = false;
	$scope.errorTitle = "*fill all required fields";
	$scope.selectedGender = "male"
	
	$scope.RegisterUser = function(){
		$scope.passwordsNotEqual = false;

		var data = {};
		data.gender = $scope.selectedGender;
		data.name = $scope.name;
		data.nickname = $scope.nickname;
		data.wechatId = $scope.wechatId;
		data.email = $scope.email;
		data.phoneNumber = $scope.phoneNumber;
		data.userpassword = $scope.userpassword;
		
		// Comment this section out, when making call back to server
		// var request = $http.post(siteRoot + "ControllerName", data)
		// .then(onSuccessfull, onError);
		// var successfull = function(response){			
			// $scope.successMsm = "User" + $scope.name + "was successfully saved";
		// }
		// var onError = function(reason){
			// $scope.error = "Could not register user";
		// }
	}
	 document.addEventListener('invalid', (function () {
	   return function (e) {
		 e.preventDefault();
	   };
	 })(), true);
	 
	 $scope.validatePassword = function(){
		var pass1 = document.getElementById("userpassword");
		var pass2 = document.getElementById("confirmPassword");
		$scope.errorTitle = "*fill all required fields";
		if(pass1.value != pass2.value) {
		  $scope.myForm.userpassword.$setValidity("", false);
		  $scope.myForm.repPassword.$setValidity("", false);
		  $scope.passwordsNotEqual = true;
		  $scope.errorTitle = "*passwords must match";
		 } else if((pass1.value != "" && pass2.value != "")&&(pass1.value == pass2.value)){
			$scope.myForm.userpassword.$setValidity("", true);
			$scope.myForm.repPassword.$setValidity("", true);
			$scope.passwordsNotEqual = false;
			
		  }
		}
	};
	
	
	app.controller("RegistrationController", ["$scope", "$http", RegistrationController])
}());
