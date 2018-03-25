(function () {
    var app = angular.module('usersProject', []);
    app.controller('UsersController', ['$http',function($http) {
        var usersList = this;
        usersList.isFormVisible = false;

        usersList.getAllUsers = function () {
            return usersList.users;
        };

        usersList.getCurrentUser = function () {
            return usersList.currentUser;
        };
        usersList.getMaxId = function () {
        if(usersList.users.length>0) {
            return Math.max.apply(Math,usersList.users.map(function(o){return o.id;}))
        }else {
            return 0;
        }
        };

        usersList.addNewUser = function(user) {
            user.id=usersList.getMaxId()+1;
            usersList.users.push(user);
        };

        usersList.deleteUser = function (id) {
            var index = usersList.users.indexOf(usersList.currentUser);
            if (index === id) {
                usersList.closeForm();
            }
            $http.post('http://localhost:8080/delete',JSON.stringify(postData(usersList.users[id])));
            usersList.users.splice(id, 1);


        };

        usersList.editUser = function (id) {
            usersList.isFormVisible = true;
            usersList.currentUser = usersList.users[id];

        };

        usersList.openEmptyForm = function () {
            usersList.isFormVisible = true;
            usersList.currentUser = {};
        };

        usersList.closeForm = function () {
            usersList.isFormVisible = false;
        };

        usersList.submitForm = function (user) {
            if(!user.id) {
                usersList.addNewUser(user);
            }
            $http.post('http://localhost:8080',JSON.stringify(postData(user))).success(function(data){
            });

            usersList.currentUser = {};
            usersList.isFormVisible = false;
        };

         postData = function(user) {
                    if(user.active==null){
                        user.active=false;
                        };
                    var data ={
                    id: user.id,
                    name: user.name,
                    surname: user.surname,
                    yearOfBirth: user.yearOfBirth,
                    active: user.active
                    }
                    return data
                    };

        usersList.users = [];

		$http.get('http://localhost:8080/users').success(function(data){
			usersList.users = data;
		});

    }]);



})();