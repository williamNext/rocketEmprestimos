<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empréstimos</title>
<style type="text/css">
<%@ include file="/css/listaEmprestimos.css" %>
</style>
</head>
<body>
<c:import url="Header.jsp"></c:import>
	
	<script>
		$("#lista").addClass("mudaCorLink");
	</script>
	
	<div class="mainContainer">
		<div class="tableContainer" style="overflow-x: scroll !important;">
			<table class="table">
					<tbody id="tabela-clientes">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Nome:</th>
						<th scope="col">Valor:</th>
						<th scope="col">Pagamento:</th>
						<th scope="col">Status:</th>
						</tr>
				</thead>
				<c:forEach items="${clientes}" var="cliente">
					<tr class="clientes">
						<td>${cliente.nome}</td>
						<td>${cliente.valor}</td>
						<td>${cliente.pagamento}</td>	
						<td>${cliente.status}</td>
					</tr>-
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="javascript/removerCliente.js" ></script>
</body>
</html>