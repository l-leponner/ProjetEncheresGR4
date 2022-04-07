<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vente</title>
</head>
<body>
<h1>Nouvelle vente</h1>
<form action="VenteServlet" method="POST">
	<label for="nom">Article : </label>
		<input type="text" id="nom" name="nom" required><br>
	<label for="description">Description : </label>
		<textarea id="description" name="description" required maxlength="300" ></textarea><br>
	<label for="categorie">Catégorie : </label>
		<select name="categorie" id="categorie">
						<option selected>Toutes</option>
						<c:forEach items="${model.lstCategories}" var="categorie">
							<option>${categorie.libelle}</option>
						</c:forEach></select><br>
	
	<label for="miseAPrix">Mise à prix : </label>
		<input type="number" id="miseAPrix" name="miseAPrix" required><br>
	<label for="dateDebut">Date de début de l'enchère : </label>
		<input type="datetime-local" id="dateDebut" name="dateDebut" required><br>
	<label for="dateFin">Date de fin de l'enchère : </label>
		<input type="datetime-local" id="dateFin" name="dateFin" required><br>
	
	
	<fieldset>
		<legend>Retrait</legend>
		
		<label for="rue">Rue : </label>
			<input type="text" id="rue" name="rue"><br>
		<label for="codePostal">Code postal : </label>
			<input type="text" id="codePostal" name="codePostal"><br>
		<label for="ville">Ville : </label>
			<input type="text" id="ville" name="ville"><br>
	</fieldset>
	
	<br>
	<input type="submit" name="BTN_ENREGISTRER" value="Enregistrer">
</form>

<form action="VenteServlet" method="POST">
	<input type="submit" name="BTN_ANNULER" value="Annuler">
</form>



<p style="color:red">${error}</p>
</body>
</html>