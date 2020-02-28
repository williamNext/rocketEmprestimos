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
	
	<div class="container">
	
	<label for="nome-aviao">CPF</label> <input type="text" id="cpf" name="cpf">
	
	<button onsubmit="return false" onclick="valida()">Validar</button>
	
	<c:if >
	
	<form action="CadastraEmprestimo" method="post">
			
			<script>
				
			</script>
			
			<label for="modelo-aviao">Nome</label> <input type="text" id="nome" name="nome">
			
			<label for="modelo-aviao">Valor</label> <input type="text" id="valor" name="valor">
			
			<label for="modelo-aviao">Juros ao mês</label> <input type="text" id="juros" name="juros">
			
			<label for="modelo-aviao">Numero de parcelas</label> <input type="text" id="parcelas" name="parcelas">

		<input class="btn btn-primary" type="submit" value="cadastrar">
		
	</form>
	
	</c:if>
	
	</div>
	
</body>
</html>