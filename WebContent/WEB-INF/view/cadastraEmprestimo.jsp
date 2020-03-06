<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Rocket Empr�stimos - Solicita��o de empr�stimo</title>
<link rel="stylesheet" type="text/css" href="css/form.css" />
</head>

<body>

	<c:import url="Header.jsp"></c:import>

	<script>
		$("#cadastra").addClass("mudaCorLink");
	</script>

	<form action="${linkEntradaServlet}" method="post">
		<div class="container">
			<label for="nome-cliente">Nome do cliente:</label>
			<select class="selector" id="nome" name="nomeCliente">
				<option value="-">-</option>
				<c:forEach items="${ clientes }" var="cliente">
					<option value="${cliente.nome}"><c:out
							value="${cliente.nome}"></c:out>
					</option>
				</c:forEach>
			</select>
			
			<label for="valor-emprestimo">Valor em reais � ser solicitado:</label>
			<input type="number" id="valor" name="valorEmprestimo" step="1" min="10" placeholder="Selecione um cliente" disabled>
			
			<label for="juros-emprestimo">Juros ao m�s em porcentagem:</label>
			<input type="number" id="juros" name="jurosMes" step="0.01" min="2.5" max="10" placeholder="Selecione um cliente" disabled>
			
			<label for="pagamento-emprestimo">Forma de pagamento:</label>
			<select class="selector" id="pagamento" name="metodoPagamento" disabled>
				<option value="-">-</option>
				<option value="A_VISTA">� VISTA</option>
				<option value="BOLETO">BOLETO</option>
				<option value="DEBITO_CONTA">D�BITO EM CONTA</option>
				<option value="PARCELADO_CARNE">PARCELADO NO CARN�</option>
				<option value="PARCELADO_CREDITO">PARCELADO NO CR�DITO</option>
			</select>
			
			<label for="parcelas-emprestimo">Quantidade de parcelas:</label>
			<select class="selector" id="parcelas" name="numeroParcelas" disabled>
				<option id="defaultParcelas" value="-">-</option>
				<option id="1" value="1">1 x</option>
			</select>
			
			<input type="hidden" name="acao" value="CadastraEmprestimo">
			<input class="btn btn-dark btn-sm" id="botao" type="submit" value="CADASTRAR" disabled>
		</div>
	</form>

	<script src="js/cadastraEmprestimo.js"></script>
</body>
</html>