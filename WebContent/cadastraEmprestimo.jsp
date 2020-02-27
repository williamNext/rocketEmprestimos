<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/cadastraEmprestimo.css" rel="stylesheet" type="text/css" >
    <style type="text/css">
		<%@ include file="/css/cadastraEmprestimo.css" %>  
	</style>
</head>
<body>

	<c:import url="Header.jsp"></c:import>
	<form action="CadastraEmprestimo" method="post">
		<div class="container">

			<label for="nome-aviao">CPF</label> <input type="text" id="cpf" name="cpf">
			
			<select onchange="preenchenome()">
			<c:forEach items="${ clientes }" var="cidade">
					<option value="${cliente.nome}"><c:out value="${cliente.cpf}"></c:out> </option>
			</c:forEach>
			</select>
			<input type="text"  id="nome-cliente">
			
			<label for="modelo-aviao">Nome</label> <input type="text" id="nome" name="nome">
			
			<label for="modelo-aviao">Valor</label> <input type="text" id="nome" name="nome">
			
			<label for="modelo-aviao">Juros ao mês</label> <input type="text" id="nome" name="nome">
			
			<label for="modelo-aviao">Numero de parcelas</label> <input type="text" id="parcelas" name="parcelas">

		</div>
		<input class="btn btn-primary" type="submit" value="cadastrar">
	</form>
	
</body>
</html>