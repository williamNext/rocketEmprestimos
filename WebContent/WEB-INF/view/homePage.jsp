<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Rocket Empr�stimos - P�gina inicial</title>
<link rel="stylesheet" type="text/css" href="css/homePage.css" />
</head>

<body>
	<c:import url="Header.jsp"></c:import>

	<script>
		$("#inicio").addClass("mudaCorLink");
	</script>
	
	<img id="banner" src="https://i.imgur.com/08qHELw.jpg">
	
	<div class="principal">
		<h2 class="titulo-centralizado">Seja bem-vindo ao Rocket Empr�stimos!</h2>	 
	
		<p>Aqui voc� pode realizar um empr�stimo de forma r�pida, f�cil e segura. Fundada em 2020, a Rocket Empr�stimos j� � destaque em todo o pa�s e conquista novos clientes a cada dia.</p>

		<p id="missao"><em>Nossa miss�o �: <strong>"Tornar os sonhos de nossos clientes realidade"</strong>.</em></p>

		<p>Oferecemos profissionais experientes e antenados �s mudan�as na �rea das fian�as. O atendimento possui padr�o de excel�ncia e agilidade, garantindo qualidade e satisfa��o dos nossos clientes.</p>
	</div>
</body>
</html>