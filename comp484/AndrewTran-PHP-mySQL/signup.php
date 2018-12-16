<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<?php
			//make a connection with the database, NOTE: mysqli_connect returns a handle
			$connect_handle = mysqli_connect("localhost", "webphp", "password", "finaldb");

			//check connection
			if(!$connect_handle){
				die("connection failed" . mysqli_connect_error());
			}

			// select the database
			mysqli_select_db($connect_handle, "finaldb");

			// retrieve the user inputs (no need for encryption/validation)
			$firstname = $_POST['firstname'];
			$lastname = $_POST['lastname'];
			$phone = $_POST['phone'];
			$email = $_POST['email'];
			$username = $_POST['username'];
			$password = $_POST['repassword'];

			// insert a new record
			$sqlQuery = "INSERT INTO auth (username, password, firstName, lastName, email, phone) VALUES ('$username', '$password', '$firstname', '$lastname', '$email', '$phone')";

			// check if insertion is successful
			if(mysqli_query($connect_handle, $sqlQuery)){
				print("you are registered now! </br>");
			}else{
				print("Error: " . mysqli_error($connect_handle));
			}

			// close connection
			// mysqli_close($connect_handle);

			// add a function showTable to display a table of users' names
			function showTable(){
				$connect_handle = mysqli_connect("localhost", "webphp", "password", "finaldb");

				// check connection
				if(!$connect_handle){
					die("connection failed" . mysqli_connect_error());
				}

				// create a query to get first and last names
				$nameQuery = "SELECT firstName, lastName FROM auth";
				$result = mysqli_query($connect_handle, $nameQuery);

				if(mysqli_num_rows($result) > 0){
					// output data of each row
					while($row = mysqli_fetch_assoc($result)){
						echo "first name: " . $row["firstName"] . " - last name: " . $row["lastName"] . "</br>";
					}
				}else{
					echo "no results";
				}

				// close connection
				mysqli_close($connect_handle);
			}

			showTable();

		?>
	</body>
</html>
