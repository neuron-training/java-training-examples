<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/training.css">
</head>
<body>
	<!-- Javascript sources -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="resources/js/training.js"></script>

	<fieldset class="login">
		<legend>Login</legend>
		<form id="login-form">
			<div id="message"></div>
			<label for="username">Username: </label>
			<input id="username" name="username"><br>
			<label for="password">Password: </label>
			<input id="password" name="password" type="password"><br>
			<button id="login" disabled type="button">Login</button>
		</form>
	</fieldset>
</body>
</html>