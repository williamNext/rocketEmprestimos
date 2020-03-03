<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/emprestimos" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empréstimos</title>
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
							<th scope="col">Nome</th>
							<th scope="col">Valor</th>
							<th scope="col">Pagamento</th>
							<th scope="col">Status</th>

						</tr>
					</thead>
					<c:forEach items="${emprestimos}" var="emprestimo">
						<tr class="emprestimo" id="${emprestimo.id}">
							<td>${emprestimo.conta.cliente.nome}</td>
							<td>${emprestimo.valor}</td>
							<td>${emprestimo.pagamento}</td>
							<td>${emprestimo.status}</td>
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