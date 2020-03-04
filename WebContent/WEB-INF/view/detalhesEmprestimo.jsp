<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Detalhes</title>
<link rel="stylesheet" type="text/css" href="css/lista.css" />
</head>
<body>
	<c:import url="Header.jsp"></c:import>

	<script>
		$("#lista").addClass("mudaCorLink");
	</script>

	<div class="mainContainer">
		<div class="tableContainer">
			<h2>Detalhes do Empréstimo</h2>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Nome do cliente</th>
						<th scope="col">CPF</th>
						<th scope="col">N° Agencia</th>
						<th scope="col">Banco</th>
						<th scope="col">Valor</th>
						<th scope="col">Juros ao mês</th>
						<th scope="col">Parcelas</th>
						<th scope="col">Pagamento</th>
						<th scope="col">Status</th>
					</tr>

				</thead>

				<tbody id="detalhes-emprestimos">

					<tr class="emprestimo">
						<td>${emprestimo.conta.cliente.nome}</td>
						<td>${emprestimo.conta.cliente.cpf}</td>
						<td>${emprestimo.conta.agencia.numero}</td>
						<td>${emprestimo.conta.agencia.banco.nome}</td>
						<td>R$ ${emprestimo.valor}</td>
						<td>${emprestimo.jurosAoMes}%</td>
						<td>${emprestimo.parcelas}x</td>
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
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>