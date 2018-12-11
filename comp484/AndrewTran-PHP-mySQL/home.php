<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<?php
			$username = $_POST["username"];
			$password = $_POST["password"];
			//validate email
			if(!filter_var($_POST["email"], FILTER_VALIDATE_EMAIL)){
				print("<p>email input is invalid</p>");
			}
		?>
	</body>
</html>
