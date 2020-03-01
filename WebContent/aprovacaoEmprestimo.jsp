<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Aprova��o de Empr�stimo</title>

<style type="text/css">
<%@ include file="/css/listaEmprestimos.css" %>
</style>

</head>

<body>
	
	<c:import url="Header.jsp"></c:import>
	
	<script>
		$("#aprovacao").addClass("mudaCorLink");
	</script>
	
	<div class="mainContainer">
	
		<div class="tableContainer" style="overflow-x: scroll !important;">
		
			<table class="table">
			
				<thead class="thead-dark">
				
					<tr>
						<th scope="col">Nome:</th>
						<th scope="col">Valor:</th>
						<th scope="col">Pagamento:</th>
						<th scope="col">Status:</th>
						<th scope="col">Salvar:</th>
					</tr>
					
				</thead>
				
				<c:forEach items="${ emprestimos }" var="emprestimo">
				
					<form action="AprovaEmprestimo" method="post">
					
						<table>
						
							<tr>
								<td>${emprestimo.cliente.nome}</td>
								<td>${emprestimo.valor}</td>
								<td>${emprestimo.pagamento}</td>	
								<td>
								<select class="selector" id="status" name="status">
									<option value="${ emprestimo.status }"><c:out value="${ emprestimo.status }"></c:out> </option>
				
									<c:forEach items="${ status }" var="stats">
										<option value="${ stats }"><c:out value="${ stats }"></c:out> </option>
									</c:forEach>
									
								</select>
								</td>
								<td><input class="btn btn-dark btn-sm" type="submit" value="ATUALIZAR"></td>
							</tr>
							
						</table>
						
					</form>
					
				</c:forEach>
				
			</table>
			
		</div>
		
	</div>

</body>
</html>