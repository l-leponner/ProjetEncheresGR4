<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<title>UtilisateurDeconnecte</title>
</head>
<body>
<h2><strong>ENI_ENCHERES</strong></h2>

<form action="UtilisateurDeconnecteServlet" method="post">
	
	Pseudo:<p>${model.current.pseudo}</p><br>
	Nom:<p type="text" name="nom" value="${model.current.nom}"/><br>
	Prenom:<p type="text" name="Prenom" value="${model.current.prenom}"/><br>
	Email:<p type="text" name="Email" value="${model.current.email}"/><br>
	Telephone:<p type="text" name="Telephone" value="${model.current.telephone}"/><br>
	Rue:<p type="text" name="Rue" value="${model.current.rue}"/><br>
	Code postal:<p type="text" name="Code postal" value="${model.current.codePostal}"/><br>
	Ville:<p type="text" name="Ville" value="${model.current.ville}"/><br>


</form>

</body>
</html>