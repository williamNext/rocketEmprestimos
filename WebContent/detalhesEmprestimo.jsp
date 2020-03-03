<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Detalhes</title>
<style type="text/css">
<%@ include file="/css/detalhes.css" %>
</style>
</head>
<body>
	<c:import url="Header.jsp"></c:import>

	<script>
		$("#lista").addClass("mudaCorLink");
	</script>

	<div class="mainContainer">
		<div class="tableContainer" style="overflow-x: scroll !important;">
			<h2>Detalhes do Empréstimo</h2>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Nome:</th>
						<th scope="col">CPF:</th>
						<th scope="col">N° Agencia:</th>
						<th scope="col">Banco:</th>
						<th scope="col">Valor:</th>
						<th scope="col">Juros:</th>
						<th scope="col">Parcelas:</th>
						<th scope="col">Pagamento:</th>
						<th scope="col">Status:</th>
					</tr>

				</thead>

				<tbody id="detalhes-emprestimos">
					<c:forEach items="${emprestimos}" var="emprestimo">
						<tr class="emprestimo">
							<td>${emprestimo.cliente.nome}</td>
							<td>${emprestimo.cliente.cpf}</td>
							<td>${emprestimo.agencia}</td>
							<td>${emprestimo.banco}</td>
							<td>${emprestimo.valor}</td>
							<td>${emprestimo.juros}</td>
							<td>${emprestimo.parcelas}</td>
							<td>${emprestimo.pagamento}</td>
							<td>${emprestimo.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
</body>
</html>