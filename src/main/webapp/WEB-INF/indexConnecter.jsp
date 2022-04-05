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
		<li><a href="http://localhost:8080/Encheres/LoginServlet">Enchères</a></li> 
		<li><a href="http://localhost:8080/Encheres/VenteServlet">Vendre un article</a></li>
		<li><a href="http://localhost:8080/Encheres/ModificationProfilServlet">Mon profil</a></li>
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

<div>
	Achats : <input type="radio" id="achats" name="radioAchats">
	Enchères ouvertes : <input type="checkbox" id="encheresOuvertes" name="checkboxEncheresOuvertes">
	Mes enchères : <input type="checkbox" id="mesEnchères" name="checkboxMesEncheres">
	Mes enchères remportées : <input type="checkbox" id="mesEncheresRemportees" name="checkboxmesEncheresRemportees">
</div>

	<c:forEach items="${model.lstArticleVendus}" var="article">
		<ul>
			<li>${article.nomArticle}</li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="http://localhost:8080/Encheres/LoginServlet" data-name = "vendeur"> ${article.utilisateur.pseudo}</a></li>
		</ul>
	</c:forEach>


</body>
</html>