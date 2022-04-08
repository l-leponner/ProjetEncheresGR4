<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/inscription.css" />


<title>Inscription</title>
</head>
<body>
	<header>
		<a class="eni" href="ConnecterIndex" target="_blank">ENI-Enchères</a>
	</header>
	<div class="container">
		<div class="contenu">
			<h1>Mon Profil</h1>
			<form action="InscriptionServlet" method="POST">
				<br> <label for="pseudo">Pseudo : </label> <input type="text"
					id="pseudo" name="pseudo" required placeholder="Votre pseudo"
					pattern="[A-Za-z0-9]{1,30}$"><br> <br> <label
					for="nom">Nom : </label> <input type="text" id="nom" name="nom"
					required placeholder="Votre nom"><br> <br> <label
					for="prenom">Prénom : </label> <input type="text" id="prenom"
					name="prenom" required placeholder="Votre prénom"><br>
				<br> <label for="email">Email : </label> <input type="email"
					id="email" name="email" required placeholder="Votre email"><br>
				<br> <label for="telephone">Téléphone : </label> <input
					type="tel" id="telephone" name="telephone" required
					placeholder="Votre téléphone"><br> <br> <label
					for="rue">Rue : </label> <input type="text" id="rue" name="rue"
					required placeholder="Votre rue"><br> <br> <label
					for="codePostal">Code postal : </label> <input type="text"
					id="codePostal" name="codePostal" required
					placeholder="Votre code postal"><br> <br> <label
					for="ville">Ville : </label> <input type="text" id="ville"
					name="ville" required placeholder="Votre ville"><br> <br>
				<label for="MDP">Mot de passe : </label> <input type="password"
					id="MDP" name="MDP" required placeholder="Votre mot de passe"><br>
				<br> <label for="confirmationMDP">Confirmation : </label> <input
					type="password" id="confirmationMDP" name="confirmationMDP"
					required placeholder="Confirmation de votre mot de passe"><br>
				<br> <input type="submit" name="BTN_CREER" value="Créer">
			</form>
			<br>
			<form action="DeConnecterIndex" method="POST">
				<input type="submit" name="BTN_ANNULER" value="Annuler">
			</form>

			<p style="color: red">${error}</p>
		</div>
	</div>
</body>
</html>