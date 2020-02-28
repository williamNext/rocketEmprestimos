<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empréstimos</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<link href="css/listaEmprestimos.css" rel="stylesheet" type="text/css">
<style type="text/css">
<%@ include file="/css/listaEmprestimos.css" %>
</style>
</head>
<body>
<c:import url="Header.jsp"></c:import>
	<div class="mainContainer">
		<div class="tableTitle">
			<h3>Lista de Empréstimos</h3>
		</div>
		<div class="tableContainer" style="overflow-x: scroll !important;">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Valor</th>
						<th scope="col">Pagamento</th>
						<th scope="col">Status</th>
						</tr>
				</thead>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.valor}</td>
						<td>${cliente.pagamento}</td>
						<td>${cliente.status}</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>