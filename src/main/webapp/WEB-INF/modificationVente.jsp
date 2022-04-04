<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Vente</title>
</head>
<body>
<h1>Nouvelle vente</h1>
<form action="VenteServlet" method="POST" enctype="multipart/form-data">
<label for="nom">Article : </label>
<input type="text" id="nom" name="nom" required><br>
<label for="description">Description : </label>
<textarea id="description" name="description" required></textarea><br>
<label for="categorie">Catégorie : </label>
<select name="filtreCategorie" id="categorie">
				<option selected>Toutes</option>
				<c:forEach items="${model.lstCategories}" var="categorie">
					<option>${categorie.libelle}</option>
				</c:forEach></select>
<label for="image">Photo de l'article : </label>	
<input type="file" id="image" name="image" accept=".jpg, .jpeg, .png"><br>
<label for="miseAPrix">Mise à prix : </label>
<input type="number" id="miseAPrix" name="miseAPrix" required><br>
<label for="dateDebut">Date de l'enchère : </label>
<input type="datetime-local" id="dateDebut" name="dateDebut" required><br>
<label for="dateFin">Rue : </label>
<input type="datetime-local" id="dateFin" name="dateFin" required><br>
</form>

<fieldset>
<legend>Retrait</legend>
<form action="VenteServlet" method="POST">
<label for="rue">Rue : </label>
<input type="text" id="rue" name="rue"><br>
<label for="codePostal">Code postal : </label>
<input type="text" id="codePostal" name="codePostal"><br>
<label for="ville">Ville : </label>
<input type="text" id="ville" name="ville"><br>
</form>
</fieldset>

<br>
<input type="submit" name="BTN_ENREGISTRER" value="Enregistrer">
<input type="reset" name="BTN_ANNULER" value="Annuler">
<input type="submit" name="BTN_SUPPRIMER" value="Annuler la vente">


<p style="color:red">${error}</p>
</body>
</html>