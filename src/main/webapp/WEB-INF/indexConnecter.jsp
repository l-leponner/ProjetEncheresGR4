<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Accueil</title>

<!-- Bootstrap CSS -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/indexConnecter.css" />

</head>
<body>
<header>
	<a href="ConnecterIndex" target="_blank" id="ENI">ENI-Enchères</a>
	
	
		<ul id="lienHeader">
			<li class="header"><a href="<%=request.getContextPath()%>/ConnecterIndex">Enchères</a></li>
			<li class="header"><a href="<%=request.getContextPath()%>/VenteServlet">Vendre un article</a></li>
			<li class="header"><a href="<%=request.getContextPath()%>/UtilisateurServlet">Mon profil</a></li>
			<li class="header"><a href="<%=request.getContextPath()%>/DeConnecterIndex?deconnexion=${deconnexion}" data-name="deconnexion">Déconnexion</a></li>
		</ul>
	
	
	</header>
	
<h2 id="titreDeLaPage">Liste des enchères</h2>

	<p style="color: red">${model.message}</p>
	<form action="ConnecterIndex" method="post">
		<div>
			<h2>Filtres :</h2>
			<input type="search" id="filtres" name="filtreNomArticle"
				placeholder="Le nom de l'article contient">

			<h2>Catégorie :</h2>
			<select name="filtreCategorie" id="categorie">
				<option selected>Toutes</option>
				<c:forEach items="${model.lstCategories}" var="categorie">
					<option>${categorie.libelle}</option>
				</c:forEach>
			</select> <input type="submit" name="BT_RECHERCHER" value="Rechercher" />
		</div>


		<div>
			<label for="achats">Achats :</label> 
			<input type="radio" id="achats"	name="radio" value="Achats" checked> 
			
			<label for="encheresOuvertes">Enchères ouvertes :</label> 
			<input type="checkbox" id="encheresOuvertes" name="checkboxEncheresOuvertes" value="EncheresOuvertes" checked>
			 
			<label for="mesEnchères">Mes enchères :</label>
			<input type="checkbox" id="mesEnchères" name="checkboxMesEncheres" value="MesEncheres">
			
			<label for="mesEncheresRemportees">Mes enchères remportées :</label>
			<input type="checkbox" id="mesEncheresRemportees" name="checkboxMesEncheresRemportees" value="MesEncheresRemportees">
		</div>

		<div>
			<label for="mesVentes">Mes ventes :</label> 
			<input type="radio" id="mesVentes" name="radio" value="MesVentes"> 
			
			<label for="mesVentesEnCours">Mes ventes en cours :</label> 
			<input type="checkbox" id="mesVentesEnCours" name="checkboxMesVentesEnCours" value="MesVentesEnCours"> 
			
			<label for="ventesNonDebutees">Ventes non débutées :</label>
			<input type="checkbox" id="ventesNonDebutees" name="checkboxVentesNonDebutees" value="VentesNonDebutees"> 
			
			<label for="ventesTerminees">Ventes terminées :</label>
			<input type="checkbox" id="ventesTerminees" name="checkboxVentesTerminees"	value="VentesTerminees">
		</div>
	</form>
	<c:forEach items="${model.lstArticlesVendus}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>
	
	<c:forEach items="${model.lstAchatsEnchOuvertes}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>
	
	<c:forEach items="${model.lstAchatsMesEnch}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>
	
	<c:forEach items="${model.lstAchatsMesEnchRemportees}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>
	
	<c:forEach items="${model.lstMesVentesTerminees}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>
	
	<c:forEach items="${model.lstMesVentesNonDebutees}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>
	
	<c:forEach items="${model.lstMesVentesEnCours}" var="article">
		<ul>
			<li><a href="<%=request.getContextPath()%>/EncherirServlet?article=${article.noArticle}" data-name="article">${article.nomArticle}</a></li>
			<li>Prix : ${article.miseAPrix}</li>
			<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
			<li>Vendeur : <a href="<%=request.getContextPath()%>/UtilisateurDeconnecteServlet?vendeur=${article.utilisateur.noUtilisateur}" data-name="vendeur"> ${article.utilisateur.pseudo}</a></li>
			<li id ="noArticle" data-name="noArticle"> ${article.noArticle}</li>
		</ul>
	</c:forEach>


</body>
</html>