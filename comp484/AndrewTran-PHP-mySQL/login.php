<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<?php
			// make a connection to the db
			$connect_handle = mysqli_connect("localhost", "root", "password");

			if(!$connect_handle){
				die("connection failed" . mysqli_connect_error());
			}

			// select the database
			mysqli_select_db($connect_handle, "finaldb");

			// retrieve username and password
			$username = $_POST['username'];
			$password = $_POST['password'];

			$password_check = ("SELECT password from auth WHERE username = $username");

			// check the password of that username
			if($password == $password_check){
				// success
				echo "Welcome back $username! Login was successful";
				// after login, display user's firstname, lastname, email, and phone in a table with headers.
			}else{
				echo "Incorrect username or password";
			}

		?>
	</body>
</html>
