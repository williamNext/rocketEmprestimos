<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Aprovação de Empréstimo</title>
<link  rel="stylesheet" type="text/css" href="css/lista.css"/>
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
						<th scope="col">Nome</th>
						<th scope="col">Valor</th>
						<th scope="col">Juros</th>
						<th scope="col">Parcelas</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
							<tr>
								<td>Renato dos Santos Machado Júnior</td>
								<td>te</td>
								<td>tes</td>
								<td>te</td>
								<td>
									<select class="selector" id="status" name="status">
										<option value="APROVADO"><c:out value="APROVADO"></c:out></option>
										
										<c:if test="${ 'APROVADO' != 'SOLICITACAO_ENVIADA' }">
											<option value="SOLICITACAO_ENVIADA">SOLICITAÇÃO ENVIADA</option>
										</c:if>
										
										<c:if test="${ 'APROVADO' != 'EM_ANALISE' }">
											<option value="EM_ANALISE">EM ANÁLISE</option>
										</c:if>
											
										<c:if test="${ 'APROVADO' != 'APROVADO' }">
											<option value="APROVADO">APROVADO</option>
										</c:if>
										
										<c:if test="${ 'APROVADO' != 'REPROVADO' }">
											<option value="REPROVADO">REPROVADO</option>
										</c:if>
									</select>
									<input type="hidden" name="acao" value="AprovacaoEmprestimo">
									<input class="btn btn-dark btn-sm" type="submit" value="ATUALIZAR">
								</td>
							</tr>
			</table>
		</div>
	</div>
</body>
</html>