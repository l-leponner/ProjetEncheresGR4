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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/indexDeconnecter.css" />

<title>Encheres</title>
</head>
<body>
	<header>
		<a href="ConnecterIndex" target="_blank" id="ENI">ENI-Enchères</a>

		<h2 id="titreDeLaPage">Liste des enchères</h2>

		<ul>
			<li id="login"><a
				href="http://localhost:8080/Encheres/LoginServlet">S'inscrire -
					Se connecter</a></li>
		</ul>

	</header>
	<p style="color: red">${model.message}</p>
	<form action="DeConnecterIndex" method="post">
		<div id="ensembleFilCatBtn">
			<div id="ensembleFilCat">
				<h2 id="filtresTitre">Filtres :</h2>
				<input type="search" id="filtres" name="filtreNomArticle"
					placeholder="Le nom de l'article contient"> 
				<div id="ensembleCat">
					<label for="categorie"> Catégorie :</label> 
					<select name="filtreCategorie" id="categorie">
						<option selected>Toutes</option>
						<c:forEach items="${model.lstCategories}" var="categorie">
							<option>${categorie.libelle}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<input type="submit" name="BT_RECHERCHER" value="Rechercher"
				id="Rechercher" />
		</div>
	</form>
<div id="ensembleArticle">
	<c:forEach items="${model.lstArticleVendus}" var="article">
		<div id="Article">
		<ul>
			<li>${article.nomArticle}</li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : ${article.utilisateur.pseudo}</li>
		</ul>
		</div>
	</c:forEach>
</div>
</body>
</html>