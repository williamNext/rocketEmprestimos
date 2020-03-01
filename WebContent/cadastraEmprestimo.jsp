<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitação de empréstimo</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<style type="text/css">
<%@ include file="/css/cadastraEmprestimo.css" %>
</style>
</head>
<body>

	<c:import url="Header.jsp"></c:import>
	
	<script>
		$("#cadastra").addClass("mudaCorLink");
	</script>

	<form action="CadastraEmprestimo" method="post">
	
		<div class="container">
			
			<label for="nome-cliente">Nome:</label>
			<select class="selector" id="nome" name="nome">
				<option value="-">-</option>
				
				<c:forEach items="${ clientes }" var="cidade">
					<option value="${cliente.nome}"><c:out value="${cliente.nome}"></c:out> </option>
				</c:forEach>
			</select> 		
			
			<label for="valor-emprestimo">Valor à ser solicitado:</label> <input type="text" id="valor" name="valor">			
			
			<label for="juros-emprestimo">Juros ao mês:</label> <input type="text" id="juros" name="juros">			
			
			<label for="parcelas-emprestimo">Quantidade de parcelas:</label> <input type="text" id="parcelas" name="parcelas">

		</div>			

		<input class="btn btn-dark btn-sm" type="submit" value="CADASTRAR">

	</form>

</body>
</html>