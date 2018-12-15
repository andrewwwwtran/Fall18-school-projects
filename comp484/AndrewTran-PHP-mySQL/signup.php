<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<?php
			//make a connection with the database, NOTE: mysqli_connect returns a handle
			$connect_handle = mysqli_connect("localhost", "root", "password", "finaldb");

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
			$sqlQuery = "INSERT INTO auth (username, password, firstName, lastName, email, phone) VALUES ($username, $password, $firstname, $lastname, $email, $phone)";

			// check if insertion is successful
			if(mysqli_query($connect_handle, $sqlQuery)){
				print("you are registered now");
			}else{
				print("Error: " . mysqli_error($connect_handle));
			}

			// close connection
			// mysqli_close($connect_handle);

			// add a function showTable to display a table of users' names
			function showTable(){
				// $connect_handle = mysqli_connect("localhost", "webphp", "password");

				// mysqli_select_db($connect_handle, "final");
				$nameQuery = "SELECT firstName, lastName FROM auth";
				$result = mysqli_query($connect_handle, $nameQuery);

				print("<table>");
				while($row = mysqli_fetch_row($result)){
					// make a table
					print("<tr>");
					foreach($row as $value){
						print("<td>$value</td>");
					}
					print("</tr>");
				}
				print("</table>");

				// close connection
				// mysqli_close($connect_handle);
			}

			showTable();

		?>
	</body>
</html>
