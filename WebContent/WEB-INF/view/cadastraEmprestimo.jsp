<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Solicita��o de empr�stimo</title>
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
			<input type="number" id="valor" name="valorEmprestimo" step="1.00" min="10.00" placeholder="Selecione um cliente" disabled>
			
			<label for="juros-emprestimo">Juros ao m�s em porcentagem:</label>
			<input type="number" id="juros" name="jurosMes" step="0.01" min="0.01" placeholder="Selecione um cliente" disabled>
			
			<label for="parcelas-emprestimo">Quantidade de parcelas:</label>
			<select class="selector" id="parcelas" name="numeroParcelas" disabled>
				<option value="-">-</option>
				<option value="1">1x</option>
				<option id="2x" value="2">2x</option>
				<option id="3x" value="3">3x</option>
				<option id="6x" value="6">6x</option>
				<option id="9x" value="9">9x</option>
				<option id="12x" value="12">12x</option>
				<option id="18x" value="18">18x</option>
				<option id="24x" value="24">24x</option>
				<option id="30x" value="30">30x</option>
				<option id="60x" value="60">60x</option>
				<option id="120x" value="120">120x</option>
				<option id="240x" value="240">240x</option>
			</select>
			
			<label id=parcelas for="parcelas-emprestimo">Forma de pagamento:</label>
			<select class="selector" id="pagamento" name="metodoPagamento" disabled>
				<option value="-">-</option>
				<option value="A_VISTA">� VISTA</option>
				<option value="BOLETO">BOLETO</option>
				<option value="DEBITO_CONTA">D�BITO EM CONTA</option>
				<option value="PARCELADO_CARNE">PARCELADO NO CARN�</option>
				<option value="PARCELADO_CREDITO">PARCELADO NO CR�DITO</option>
			</select>
			
			<input type="hidden" name="acao" value="CadastraEmprestimo">
			<input class="btn btn-dark btn-sm" id="botao" type="submit" value="CADASTRAR" disabled>
		</div>
	</form>

	<script src="js/cadastraEmprestimo.js" charset="UTF-8"></script>
</body>
</html>