<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empréstimos</title>
<link  rel="stylesheet" type="text/css" href="css/lista.css"/>
</head>
<body>
<c:import url="Header.jsp"></c:import>
	
	<script>
		$("#lista").addClass("mudaCorLink");
	</script>
	
	<div class="mainContainer">
		<div class="tableContainer" style="overflow-x: scroll !important;">
		<form method="get" action="detalhesEmprestimo.jsp" id="meu-form">
			<table class="table">
				<thead class="thead-dark">
						<tr>
							<th scope="col">Nome:</th>
							<th scope="col">Valor:</th>
							<th scope="col">Pagamento:</th>
							<th scope="col">Status:</th>
							
							</tr>
					</thead>
					<tbody id="tabela-emprestimos">
					<c:forEach items="${emprestimos}" var="emprestimo">
						<tr class="emprestimo" >
							<td>${emprestimo.cliente.nome}</td>
							<td>${emprestimo.valor}</td>
							<td>${emprestimo.pagamento}</td>	
							<td>${emprestimo.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				</form>
			</div>
	</div>
		<script src="js/removerEmprestimo.js" ></script>
</body>
</html>