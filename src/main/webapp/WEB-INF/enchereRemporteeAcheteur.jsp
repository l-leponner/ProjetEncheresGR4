<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encheres remportées par ${model.acheteur.pseudo}</title>
</head>
<body>
<h1>${model.acheteur.pseudo} a remporté l'enchère</h1>
<p>${model.currentArticle.nomArticle}</p>
<label for="description">Description : </label><p id="description">${model.currentArticle.description}</p>
<label for="meilleurEnchere">Meilleure offre : </label><p id="meilleurEnchere">${model.meilleureEnchere.montantEnchere} points par ${model.meilleureEnchere.utilisateur.pseudo }</p>
<label for="miseAPrix">Mise à prix : </label><p id="miseAPrix">${model.currentArticle.miseAPrix} points</p>
<label for="retrait">Retrait : </label><p id="retrait">${model.currentArticle.retrait.rue} ${model.currentArticle.retrait.codePostal} ${model.currentArticle.retrait.ville}</p>
<label for="vendeur">Vendeur : </label><p id="vendeur">${model.acheteur.pseudo}</p>
<label for="telephone">Téléphone : </label><p id="telephone">${model.acheteur.telephone}</p>

<br>
<input type="submit" name="BTN_RETRAIT" value="Retrait effectué">


<p style="color:red">${error}</p>
</body>
</html>