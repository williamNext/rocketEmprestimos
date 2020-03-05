<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/emprestimos" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Cabeçalho</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/header.css" />
</head>

<body>
	<div
		class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top menuSuperior">
		<img src="https://i.imgur.com/zTuqL9y.png" alt="banner" height="40"
			width="160" />
		<ul class="navbar-nav">
			<li class="nav-item"><a id="cadastra" class="nav-link"
				href="${linkEntradaServlet}?acao=FormCadastraEmprestimo">CADASTRAR
					EMPRÉSTIMO</a></li>
			<li class="nav-item"><a id="lista" class="nav-link"
				href="${linkEntradaServlet}?acao=ListaEmprestimos">LISTAR
					EMPRÉSTIMOS</a></li>
			<c:if test="${usuarioLogado.tipoUsuario == 'GERENTE'}">
				<li class="nav-item"><a id="aprovacao" class="nav-link"
					href="${linkEntradaServlet}?acao=FormAtualizaStatusCadastro">PÁGINA
						DE APROVAÇÃO</a></li>
			</c:if>
			
			<li class="nav-item"><a id="logout" class="nav-link"
				href="${linkEntradaServlet}?acao=FazLogout">SAIR</a></li>
		</ul>
	</div>

	<div class="container-fluid" style="margin-top: 80px"></div>
</body>

</html>