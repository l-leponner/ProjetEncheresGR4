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
	href="${pageContext.request.contextPath}/styles/css/login.css" />


<title>Login Utilisateur</title>
</head>
<body>
	<header>
		<a href="ConnecterIndex" target="_blank">ENI-Enchères</a>
	</header>
	<form action="LoginServlet" method="POST">
		<div class="container">
			<div class="hautpage">
				<div class="col-md-6">
					<label for="identifiant">Identifiant : </label> <input type="text"
						name="identifiant" id="identifiant" required /><br>
				</div>
				<div class="col-md-6">
					<label for="MDP">Mot de passe:</label> <input type="password"
						name="MDP" id="MDP" required /><br>
				</div>
			</div>

			<div class="milieupage">
				<div class="col-md-2">
					<input type="submit" name="BT_CONNEXION" value="Connexion" />
				</div>
				<div class="milieudroitpage">
					<div class="col-md-6">
						<input type="checkbox" name="BT_SE_SOUVENIR_DE_MOI"
							id="BT_SE_SOUVENIR_DE_MOI" /> <label for="BT_SE_SOUVENIR_DE_MOI">Se
							souvenir de moi</label>
					</div>
					<br>
				</div>
				<div class="col-md-6">
					<a href="#" data-name="">Mot de passe oublié</a>
				</div>
			</div>
		</div>
	</form>

	<form action="LoginServlet" method="POST">

		<div class="baspage">
			<div>
				<input type="submit" name="BT_CREER_UN_COMPTE"
					value="Créer un compte" />
			</div>
		</div>
	</form>

	<p>${error}</p>

</body>
</html>