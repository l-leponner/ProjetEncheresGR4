<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.utilisateur.deconnecte.css" /> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>UtilisateurDeconnecte</title>
</head>
<body>
<h2><strong>ENI_ENCHERES</strong></h2>

<form action="UtilisateurDeconnecteServlet" method="post">
	
	<ul>
		<li>Pseudo: ${model.current.pseudo}</li>
		<li>Nom: ${model.current.nom}</li>
		<li>Prenom: ${model.current.prenom}</li>
		<li>Email: ${model.current.email}</li>
		<li>Telephone:${model.current.telephone}</li>
		<li>Rue: ${model.current.rue}</li>
		<li>Code postal: ${model.current.codePostal}</li>
		<li>Ville: ${model.current.ville}</li>
	</ul>


</form>

</body>
</html>