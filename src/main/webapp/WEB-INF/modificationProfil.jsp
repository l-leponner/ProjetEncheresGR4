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
<title>Modification du profil</title>
</head>
<body>
<h1>Mon Profil</h1>

<form action="ModificationProfilServlet" method="POST">
<label for="pseudo">Pseudo : </label>
<input type="text" id="pseudo" name="pseudo" required pattern="[A-Za-z0-9]{1,30}$" value="${model.current.pseudo}"><br>
<label for="nom">Nom : </label>
<input type="text" id="nom" name="nom" required value="${model.current.nom}"><br>
<label for="prenom">Prénom : </label>
<input type="text" id="prenom" name="prenom" required value="${model.current.prenom}"><br>
<label for="email">Email : </label>
<input type="email" id="email" name="email" required value="${model.current.email}"><br>
<label for="telephone">Téléphone : </label>
<input type="tel" id="telephone" name="telephone" required value="${model.current.telephone}"><br>
<label for="rue">Rue : </label>
<input type="text" id="rue" name="rue" required value="${model.current.rue}"><br>
<label for="codePostal">Code postal : </label>
<input type="text" id="codePostal" name="codePostal" required value="${model.current.codePostal}"><br>
<label for="ville">Ville : </label>
<input type="text" id="ville" name="ville" required value="${model.current.ville}"><br>
<label for="actuelMDP">Mot de passe actuel : </label>
<input type="password" id="actuelMDP" name="actuelMDP" required value="${model.current.motDePasse}"><br>
<label for="nouveauMDP">Nouveau mot de passe : </label>
<input type="password" id="nouveauMDP" name="nouveauMDP" required><br>
<label for="confirmationMDP">Confirmation : </label>
<input type="password" id="confirmationMDP" name="confirmationMDP" required><br>
<p>Crédit : ${model.current.credit} points</p>
<p>Id : ${model.current.noUtilisateur}
<br>
<input type="submit" name="BTN_ENREGISTRER" value="Enregistrer">
</form>
<form action="ModificationProfilServlet" method="POST">
<input type="submit" name="BTN_SUPPRIMER" value="Supprimer mon compte">
</form>

<p style="color:red">${error}</p>
</body>
</html>