<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controle Usuario</title>
</head>
<body>
	<h1>Efetuar Logon</h1>
	<br>
	<form action="LoginControlServlet" method="post">
	    <label>E-mail:</label>
		<input type="text" name="email">
	     <label>Senha:</label>
		<input type="password" name="senha">
		<input type="submit" value = "Enviar">
	</form>
</body>
</html>