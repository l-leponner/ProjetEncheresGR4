<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>${FilterArticle}</p>
	<p>${FilterCategorie}</p>
	

	<h1>ENI-Encheres</h1>
	<ul>
		<li><a href="https://example.com">Enchères</a></li>
		<li><a href="https://example.com">Vendre un article</a></li>
		<li><a href="https://example.com">Mon profil</a></li>
		<li><a href="https://example.com">Déconnexion</a></li>
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
			: ${article.dateFinEncheres} Vendeur : <a href="https://example.com">${article.utilisateur.pseudo}</a> </p>
	</c:forEach>


</body>
</html>