<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Solicita��o de empr�stimo</title>
<style type="text/css">
<%@ include file="/css/form.css" %>
</style>
</head>

<body>

	<c:import url="Header.jsp"></c:import>
	
	<script>
		$("#cadastra").addClass("mudaCorLink");
	</script>

	<form action="${ linkEntradaServlet }" method="post">
		<div class="container">
			<label for="nome-cliente">Nome:</label>
			<select class="selector" id="nome" name="nome">
				<option value="-">-</option>
				
				<c:forEach items="${ clientes }" var="cidade">
					<option value="${cliente.nome}"><c:out value="${cliente.nome}"></c:out> </option>
				</c:forEach>
			</select> 		
			
			<label for="valor-emprestimo">Valor � ser solicitado:</label> <input type="text" id="valor" name="valor">			
			
			<label for="juros-emprestimo">Juros ao m�s:</label> <input type="text" id="juros" name="juros">			
			
			<label for="parcelas-emprestimo">Quantidade de parcelas:</label> <input type="text" id="parcelas" name="parcelas">
			
			<label for="parcelas-emprestimo">Forma de pagamento:</label> 
			<select class="selector" id="nome" name="nome">
				<option value="-">-</option>
				<option value="A_VISTA">� VISTA</option>
				<option value="BOLETO">BOLETO</option>
				<option value="DEBITO_CONTA">D�BITO EM CONTA</option>
				<option value="PARCELADO_CARNE">PARCELADO NO CARN�</option>
				<option value="PARCELADO_CREDITO">PARCELADO NO CR�DITO</option>
			</select>
		</div>			

		<input class="btn btn-dark btn-sm" type="submit" value="CADASTRAR">
	</form>
</body>
</html>