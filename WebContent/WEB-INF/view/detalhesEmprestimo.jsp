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
						<th scope="col">Nome</th>
						<th scope="col">CPF</th>
						<th scope="col">N° Agencia</th>
						<th scope="col">Banco</th>
						<th scope="col">Valor</th>
						<th scope="col">Juros</th>
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
						<td>${emprestimo.valor}</td>
						<td>${emprestimo.jurosAoMes}</td>
						<td>${emprestimo.parcelas}</td>
						<td>${emprestimo.pagamento}</td>
						<td>${emprestimo.status}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>