<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchérir</title>
</head>
<body>
<h1>Détail vente</h1>

<p>${model.currentArticle.nomArticle}</p>
<label for="description">Description : </label><p id="description">${model.currentArticle.description}</p>
<label for="categorie">Catégorie : </label><p id="categorie">${model.currentArticle.categorie.libelle}</p>
<label for="meilleurEnchere">Meilleure offre : </label><p id="meilleurEnchere">${model.meilleureEnchere}</p>
<label for="miseAPrix">Mise à prix : </label><p id="miseAPrix">${model.currentArticle.miseAPrix}</p>
<label for="dateFinEncheres">Fin de l'enchère : </label><p id="dateFinEncheres">${model.currentArticle.dateFinEncheres}</p>
<label for="retrait">Retrait : </label><p id="retrait">${model.currentArticle.retrait.rue} ${model.currentArticle.retrait.codePostal} ${model.currentArticle.retrait.ville}</p>
<label for="vendeur">Vendeur : </label><p id="vendeur">${model.vendeur.pseudo}</p>
<form action="EncherirServlet" method="post">
	<label for="montantEnchere">Ma proposition : </label><input type="number" id="montantEnchere" name="montantEnchere" value="${model.meilleureEnchere}">
	<input type="submit" name="BTN_ENCHERIR" value="Enchérir">
</form>

<p style="color:red">${error}</p>
</body>
</html>