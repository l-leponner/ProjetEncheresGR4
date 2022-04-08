<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/utilisateur.css" />

<title>Utilisateur</title>
</head>
<body>
	<header>
		<a href="ConnecterIndex" target="_blank">ENI-Enchères</a>
	</header>


	<div class="container">
		<div class="row">
			<form class="myform" action="UtilisateurServlet" method="post">
				<div class="row">
					<ul>
						<li>Pseudo: ${model.current.pseudo}</li>
						<li>Nom: ${model.current.nom}</li>
						<li>Prenom: ${model.current.prenom}</li>
						<li>Email: ${model.current.email}</li>
						<li>Telephone:${model.current.telephone}</li>
						<li>Rue: ${model.current.rue}</li>
						<li>Code postal: ${model.current.codePostal}</li>
						<li>Ville: ${model.current.ville}</li>
						<li>Crédits : ${model.current.credit}</li>
					</ul>
				</div>


				<div class="bouton">

					<input type="submit" name="BT_MODIFIER" value="Modifier" />
				</div>

			</form>
		</div>
	</div>
</body>
</html>