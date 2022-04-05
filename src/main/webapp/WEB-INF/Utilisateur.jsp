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
	
	Pseudo:<p>${model.current.pseudo}</p><br>
	Nom:<p>${model.current.nom}</p><br>
	Prenom:<p>${model.current.prenom}</p><br>
	Email:<p>${model.current.email}</p><br>
	Telephone:<p>${model.current.telephone}</p><br>
	Rue:<p>${model.current.rue}<br>
	Code postal:<p>${model.current.codePostal}</p><br>
	Ville:<p>${model.current.ville}</p><br>

	<input type="submit" name="BT_MODIFIER" value="Modifier"/>
</form>

</body>
</html>