<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<?php
			// make a connection to the db
			$connect_handle = mysqli_connect("localhost", "webphp", "password");

			if(!$connect_handle){
				die("connection failed" . mysqli_connect_error());
			}

			// select the database
			mysqli_select_db($connect_handle, "finaldb");

			// retrieve username and password
			$username = $_POST['username'];
			$password = $_POST['password'];

			$pw_query = ("SELECT password from auth WHERE username = '$username'");
			$result = mysqli_query($connect_handle, $pw_query);

			// check the password of that username
			if(mysqli_num_rows($result) > 0){
				while($row = mysqli_fetch_assoc($result)){
					// while loop should only check once because the mysql query returns only the password of that username
					// fetch the password from the database .
					$password_from_db = $row['password'];
					if($password == $password_from_db){
						// success
						echo "Welcome back $username! Login was successful";
						// after login, display user's firstname, lastname, email, and phone in a table with headers.
						$user_query = ("SELECT firstname, lastname, email, phone FROM auth WHERE username = '$username'");
						$user_result = mysqli_query($connect_handle, $user_query);
						echo "<table>
						<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Phone</th>
						</tr>";
						while($row = mysqli_fetch_assoc($user_result)){
							echo "<tr>";
							echo "<td>" . $row['firstname'] . "</td>";
							echo "<td>" . $row['lastname'] . "</td>";
							echo "<td>" . $row['email'] . "</td>";
							echo "<td>" . $row['phone'] . "</td>";
							echo "</tr>";
						}
						echo "</table>";
					}
				}
			}else{
				echo "Incorrect username or password";
			}

		?>
	</body>
</html>
