<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
<style type="text/css">
<%@ include file="/css/header.css" %>
</style>
</head>

<body>
	<div class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top menuSuperior" style="margin-bottom: 80px">
		<img src="https://i.imgur.com/zTuqL9y.png" alt="banner" height="40"
			width="160" />
			<ul class="navbar-nav">
				<li class="nav-item"><a id="cadastra" class="nav-link"
					href="/emprestimos?acao=CadastraEmprestimo">CADASTRAR EMPRÉSTIMO</a></li>
				<li class="nav-item"><a id="lista" class="nav-link"
					href="/emprestimos?acao=ListaEmprestimos">LISTAR EMPRÉSTIMOS</a></li>
				<li class="nav-item"><a id="aprovacao" class="nav-link"
					href="/emprestimos?acao=AprovacaoEmprestimo">PÁGINA DE APROVAÇÃO</a></li>
			</ul>
	</div>
	
	<div class="container-fluid" style="margin-top: 80px"></div>
</body>

</html>