<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encheres</title>
</head>
<body>

	<p>${FilterArticle}</p>
	<p>${FilterCategorie}</p>
	

	<h1>ENI-Encheres</h1>
	<ul>
		<li><a href="https://example.com">S'inscrire - Se connecter</a></li>
	</ul>

	<h2>Liste des enchères</h2>
	<p style="color: red">${model.message}</p>
	<form action="IndexServlet" method="post">
		<div>
			<h2>Filtres :</h2> 
			<input type="search" id="filtres" name="filtreNomArticle" placeholder="Le nom de l'article contient">

			<h2>Catégorie : </h2> 
			<select name="filtreCategorie" id="categorie">
				<option selected>Toutes</option>
				<c:forEach items="${model.lstCategories}" var="categorie">
					<option>${categorie.libelle}</option>
				</c:forEach>
			</select>
			<input type="submit" name="BT_RECHERCHER" value="Rechercher"/>
		</div>
	</form>

	<c:forEach items="${model.lstArticleVendus}" var="article">
		<p>${article.nomArticle}Prix:${article.miseAPrix} Fin de l'enchère
			: ${article.dateFinEncheres} Vendeur : ${article.utilisateur.pseudo}</p>
	</c:forEach>

</body>
</html>