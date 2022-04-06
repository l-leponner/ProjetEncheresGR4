<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Utilisateur</title>
</head>
<body>
<h2><strong>ENI_ENCHERES</strong></h2>
	<form action="LoginServlet" method="POST">
	
	<div>
		<label for="identifiant">Identifiant : </label>
		<input type="text" name="identifiant" id="identifiant" required/><br> 
		<label for="MDP">Mot de passe:</label>
		<input type="password" name="MDP" id="MDP" required/><br> 
	</div>
	<div>
		<a href="/DeConnecterIndex">
			<input type="submit" name="BT_CONNEXION" value="Connexion" />
		</a>
	
		<input type="checkbox" name="BT_SE_SOUVENIR_DE_MOI" id="BT_SE_SOUVENIR_DE_MOI"/> 
		<label for="BT_SE_SOUVENIR_DE_MOI">Se souvenir de moi</label>
		<a href="#" data-name="">Mot de passe oublié</a>
	
	</div>
	</form>
	<form action="InscriptionServlet" method="POST">
	<div>
		<input type="submit" name="BT_CREER_UN_COMPTE" value="Créer un compte"/>
	</div>
	</form>
	
	<p>${error}</p>

</body>
</html>