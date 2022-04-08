<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->



<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mes Enchères Remportées</title>
</head>
<body>
<h1>Vous avez remporté la vente</h1>
<p>${model.currentArticle.nomArticle}</p>
<label for="description">Description : </label><p id="description">${model.currentArticle.description}</p>
<label for="meilleurEnchere">Meilleure offre : </label><p id="meilleurEnchere">${model.meilleureEnchere.montantEnchere} points</p>
<label for="miseAPrix">Mise à prix : </label><p id="miseAPrix">${model.currentArticle.miseAPrix} points</p>
<label for="retrait">Retrait : </label><p id="retrait">${model.currentArticle.retrait.rue} ${model.currentArticle.retrait.codePostal} ${model.currentArticle.retrait.ville}</p>
<label for="vendeur">Vendeur : </label><p id="vendeur">${model.vendeur.pseudo}</p>
<label for="telephone">Téléphone : </label><p id="telephone">${model.acheteur.telephone}</p>

<br>
<input type="submit" name="BTN_RETOUR" value="Retour">


<p style="color:red">${error}</p>
</body>
</html>