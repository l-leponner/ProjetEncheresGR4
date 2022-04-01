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

<form action="UtilisateurServlet" method="post">
	
	Pseudo:<input type="texte" name="couleur" value="${model.current.pseudo}"/><br>
	Nom:<input type="texte" name="nom" value="${model.current.nom}"/><br>
	Prenom:<input type="texte" name="brasserie" value="${model.current.prenom}"/><br>
	Email:<input type="texte" name="couleur" value="${model.current.email}"/><br>
	Telephone:<input type="texte" name="couleur" value="${model.current.telephone}"/><br>
	Rue:<input type="texte" name="couleur" value="${model.current.rue}"/><br>
	Code postal:<input type="texte" name="couleur" value="${model.current.codePostal}"/><br>
	Ville:<input type="texte" name="couleur" value="${model.current.ville}"/><br>

	<input type="submit" name="BT_MODIFIER" value="Modifier"/>
</form>

</body>
</html>