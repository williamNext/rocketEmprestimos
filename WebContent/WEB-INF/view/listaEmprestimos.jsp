<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rocket Empréstimos - Lista de Empréstimos</title>
<link rel="stylesheet" type="text/css" href="css/lista.css" />
</head>
<body>
	<c:import url="Header.jsp"></c:import>

	<script>
		$("#lista").addClass("mudaCorLink");
	</script>

	<div class="mainContainer">
		<div class="tableContainer">
			<form method="get" action="${linkEntradaServlet}" id="meu-form">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Nome do cliente</th>
							<th scope="col">Valor</th>
							<th scope="col">Forma de pagamento</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					
					<c:forEach items="${emprestimos}" var="emprestimo">
						<tr class="emprestimo" id="${emprestimo.id}">
							<td>${emprestimo.conta.cliente.nome}</td>
							<td>R$ ${emprestimo.valor}</td>
							<td><c:if test="${emprestimo.pagamento == 'A_VISTA'}">
									À VISTA
								</c:if>
							
								<c:if test="${emprestimo.pagamento == 'BOLETO'}">
									BOLETO
								</c:if>
							
								<c:if test="${emprestimo.pagamento == 'DEBITO_CONTA'}">
									DÉBITO EM CONTA
								</c:if>
							
								<c:if test="${emprestimo.pagamento == 'PARCELADO_CARNE'}">
									PARCELADO NO CARNÊ
								</c:if>
							
								<c:if test="${emprestimo.pagamento == 'PARCELADO_CREDITO'}">
									PARCELADO NO CRÉDITO
								</c:if>
							</td>
							<td><c:if test="${emprestimo.status == 'SOLICITACAO_ENVIADA'}">
									SOLICITAÇÃO ENVIADA
								</c:if>

								<c:if test="${emprestimo.status == 'EM_ANALISE'}">
									EM ANÁLISE
								</c:if>

								<c:if test="${(emprestimo.status != 'EM_ANALISE') && (emprestimo.status != 'SOLICITACAO_ENVIADA')}">
									${emprestimo.status}
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<input type="hidden" name="acao" value="DetalhaEmprestimo">
			</form>
		</div>
	</div>
	<script src="js/detalheEmprestimo.js"></script>
</body>
</html>