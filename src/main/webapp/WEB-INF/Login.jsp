<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginUtilisateur</title>
</head>
<body>
<h2><strong>ENI_ENCHERES</strong></h2>
	<form action="LoginServlet" method="get">
	
	<div>
		Identifiant:<input type="texte" name="identifiant"
			value="${model.identifiant}" /><br> 
		Mot de passe:<input type="hidden" name="MDP" value="${model.motDePasse}" /><br> 
	</div>
	<div>
		<input type="submit" name="BT_CONNEXION" value="connexion" />
	<aside>
		<input type="checkbox" name="BT_SE_SOUVENIR_DE_MOI" value="se souvenir de moi" /> Se souvenir de moi
		<a href="http://localhost:8080/Encheres/LoginServlet">Mot de passe oublié</a>
	</aside>
	</div>
	<div>
		<input type="submit" name="BT_CREER_UN_COMPTE" value="créer un compte" width= "300px"/>
	</div>



	</form>

</body>
</html>