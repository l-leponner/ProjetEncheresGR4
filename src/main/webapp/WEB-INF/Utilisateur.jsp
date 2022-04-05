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
	
	Pseudo:<p type="texte" name="Pseudo" value="${model.current.pseudo}"/><br>
	Nom:<p type="texte" name="nom" value="${model.current.nom}"/><br>
	Prenom:<p type="texte" name="Prenom" value="${model.current.prenom}"/><br>
	Email:<p type="texte" name="Email" value="${model.current.email}"/><br>
	Telephone:<p type="texte" name="Telephone" value="${model.current.telephone}"/><br>
	Rue:<p type="texte" name="Rue" value="${model.current.rue}"/><br>
	Code postal:<p type="texte" name="Code postal" value="${model.current.codePostal}"/><br>
	Ville:<p type="texte" name="Ville" value="${model.current.ville}"/><br>

	<input type="submit" name="BT_MODIFIER" value="Modifier"/>
</form>

</body>
</html>