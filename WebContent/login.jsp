<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/emprestimos" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style type="text/css">
<%@ include file="/css/form.css" %>
</style>
</head>

<body>
	<form action="${ linkEntradaServlet }" method="post">
		<div class="container" style="margin-top: 80px">
			<img class="logo" src="https://i.imgur.com/zTuqL9y.png" alt="banner"/>
			
			<label for="usuario">Usuário:</label> <input type="text" id="usuario" name="usuario">			
			<label for="senha">Senha:</label> <input type="text" id="senha" name="senha">	
			
			<input type="hidden" name="acao" value="Login">
			<input class="btn btn-dark btn-sm" id= "botao" type="submit" value="LOGIN" disabled>
		</div>			

	</form>
	
	<script src="js/login.js"></script>
</body>
</html>