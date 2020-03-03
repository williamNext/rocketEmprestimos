<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Solicitação de empréstimo</title>
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
				<option value="dsadsa">aa</option>
				<c:forEach items="${ clientes }" var="cidade">
					<option value="${cliente.nome}"><c:out value="${cliente.nome}"></c:out> </option>
				</c:forEach>
			</select> 		
			
			<label for="valor-emprestimo">Valor à ser solicitado:</label> <input  type="number" id="valor" name="valor" step="0.01" value="0.01" min="0.01" disabled>			
			
			<label for="juros-emprestimo">Juros ao mês:</label> <input type="number" id="juros" name="juros" step="0.01" value="0.01" min="0.01" disabled>			
			
			<label for="parcelas-emprestimo">Quantidade de parcelas:</label> 
			<select class="selector" id="parcelas" name="parcelas" disabled>
				<option value="-">-</option>
				<option value="1">1x</option>
				<option value="2">2x</option>
				<option value="3">3x</option>
				<option value="6">6x</option>
				<option value="9">9x</option>
				<option value="12">12x</option>
				<option value="18">18x</option>
				<option value="24">24x</option>
				<option value="30">30x</option>
				<option value="60">60x</option>
				<option value="120">120x</option>
				<option value="240">240x</option>
			</select>

			<label for="parcelas-emprestimo">Forma de pagamento:</label> 
			<select class="selector" id="pagamento" name="pagamento" disabled>
				<option value="-">-</option>
				<option value="A_VISTA">À VISTA</option>
				<option value="BOLETO">BOLETO</option>
				<option value="DEBITO_CONTA">DÉBITO EM CONTA</option>
				<option value="PARCELADO_CARNE">PARCELADO NO CARNÊ</option>
				<option value="PARCELADO_CREDITO">PARCELADO NO CRÉDITO</option>
			</select>
			
			<input type="hidden" name="acao" value="CadastraEmprestimo">
			<input class="btn btn-dark btn-sm" id="botao" type="submit" value="CADASTRAR" disabled>
		</div>
	</form>
	
	<script src="js/cadastraEmprestimo.js"></script>
</body>
</html>