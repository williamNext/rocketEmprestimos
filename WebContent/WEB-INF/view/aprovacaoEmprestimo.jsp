<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Aprova��o de Empr�stimo</title>
<link rel="stylesheet" type="text/css" href="css/lista.css" />
</head>

<body>
	<c:import url="Header.jsp"></c:import>

	<script>
		$("#aprovacao").addClass("mudaCorLink");
	</script>

	<div class="mainContainer">
		<div class="tableContainer">
			<form action="${linkEntradaServlet}" method="post" id="form-atualiza">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Nome do cliente</th>
							<th scope="col">Valor</th>
							<th scope="col">Juros</th>
							<th scope="col">Parcelas</th>
							<th scope="col">Forma de pagamento</th>
							<th scope="col">Status</th>
						</tr>
					</thead>

					<c:forEach items="${emprestimos}" var="emprestimo">
						<tr>
							<td>${emprestimo.conta.cliente.nome}</td>
							<td>R$ ${emprestimo.valor}</td>
							<td>${emprestimo.jurosAoMes}%</td>
							<td>${emprestimo.parcelas}x</td>
							<td><c:if test="${emprestimo.pagamento == 'A_VISTA'}">
								� VISTA
							</c:if>
							
							<c:if test="${emprestimo.pagamento == 'BOLETO'}">
								BOLETO
							</c:if>
							
							<c:if test="${emprestimo.pagamento == 'DEBITO_CONTA'}">
								D�BITO EM CONTA
							</c:if>
							
							<c:if test="${emprestimo.pagamento == 'PARCELADO_CARNE'}">
								PARCELADO NO CARN�
							</c:if>
							
							<c:if test="${emprestimo.pagamento == 'PARCELADO_CREDITO'}">
								PARCELADO NO CR�DITO
							</c:if>
						</td>
							<td id="${emprestimo.id}"><select class="selector" id="status" name="status">
									
									<c:if test="${emprestimo.status == 'SOLICITACAO_ENVIADA'}">
										<option value="${emprestimo.status}">SOLICITA��O ENVIADA</option>
										<option value="EM_ANALISE">EM AN�LISE</option>
									</c:if>

									<c:if test="${emprestimo.status == 'EM_ANALISE'}">
										<option value="${emprestimo.status}">EM AN�LISE</option>
										<option value="SOLICITACAO_ENVIADA">SOLICITA��O ENVIADA</option>
									</c:if>
									
									<option value="APROVADO">APROVADO</option>
									<option value="REPROVADO">REPROVADO</option>
								</select> 
								<input type="hidden" name="acao" value="MudaStatusEmprestimo">
								<input class="btn btn-dark btn-sm" type="submit" value="ATUALIZAR" id="atualiza-btn"></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/atualizaStatusEmprestimo.js"></script>
</body>
</html>