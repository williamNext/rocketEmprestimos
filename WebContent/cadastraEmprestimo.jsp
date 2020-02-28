<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitação de empréstimo</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<link href="css/cadastraEmprestimo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<%@ include file="/css/cadastraEmprestimo.css" %>
</style>
</head>
<body>

	<c:import url="Header.jsp"></c:import>

	<script type="text/javascript">
	
		$(document).ready(function(){
			$("input[name='cpf']").blur(function() {
				var $nome = $("input[name='nome']");
			})
		})
	
	</script>

	<form action="CadastraEmprestimo" method="post">

		<div class="container">

			<script>
				
			</script>

			<label for="cpf-cliente">CPF</label> <input type="text" id="cpf" name="cpf">
			
			<label for="nome-cliente">Nome</label> <input type="text" id="nome" name="nome">
			
			<label for="valor-emprestimo">Valor</label> <input type="text" id="valor" name="valor">
			
			<label for="juros-emprestimo">Juros ao mês</label> <input type="text" id="juros" name="juros">
			
			<label for="parcelas-emprestimo">Numero de parcelas</label> <input type="text" id="parcelas" name="parcelas">
			
		</div>

		<input class="btn btn-dark btn-sm" type="submit" value="CADASTRAR">

	</form>

</body>
</html>