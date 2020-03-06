<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Rocket Empréstimos - Página inicial</title>
<link rel="stylesheet" type="text/css" href="css/homePage.css" />
</head>

<body>
	<c:import url="Header.jsp"></c:import>

	<script>
		$("#inicio").addClass("mudaCorLink");
	</script>
	
	<img id="banner" src="https://i.imgur.com/08qHELw.jpg">
	
	<div class="principal">
		<h2 class="titulo-centralizado">Seja bem-vindo ao Rocket Empréstimos!</h2>	 
	
		<p>Aqui você pode realizar um empréstimo de forma rápida, fácil e segura. Fundada em 2020, a Rocket Empréstimos já é destaque em todo o país e conquista novos clientes a cada dia.</p>

		<p id="missao"><em>Nossa missão é: <strong>"Tornar os sonhos de nossos clientes realidade"</strong>.</em></p>

		<p>Oferecemos profissionais experientes e antenados às mudanças na área das fianças. O atendimento possui padrão de excelência e agilidade, garantindo qualidade e satisfação dos nossos clientes.</p>
	</div>
</body>
</html>