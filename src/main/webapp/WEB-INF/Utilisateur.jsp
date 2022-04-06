<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utilisateur</title>
</head>
<body>
<h2><strong>ENI_ENCHERES</strong></h2>

	<p>Pseudo: ${model.current.pseudo}</p>
	<p>Nom : ${model.current.nom}</p>
	<p>Prenom : ${model.current.prenom}</p>
	<p>Email : ${model.current.email}</p>
	<p>Telephone : ${model.current.telephone}</p>
	<p>Rue : ${model.current.rue}<br>
	<p>Code postal :${model.current.codePostal}</p>
	<p>Ville : ${model.current.ville}</p>
<form action="UtilisateurServlet" method="post">
	<input type="submit" name="BT_MODIFIER" value="Modifier"/>
</form>

</body>
</html>