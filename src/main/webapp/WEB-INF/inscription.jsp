<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

<h1>Mon Profil</h1>
<form action="InscriptionServlet" method="POST">
<label for="pseudo">Pseudo : </label>
<input type="text" id="pseudo" name="pseudo" required placeholder="Votre pseudo"><br>
<label for="nom">Nom : </label>
<input type="text" id="nom" name="nom" required placeholder="Votre nom"><br>
<label for="prenom">Prénom : </label>
<input type="text" id="prenom" name="prenom" required placeholder="Votre prénom"><br>
<label for="email">Email : </label>
<input type="text" id="email" name="email" required placeholder="Votre email"><br>
<label for="telephone">Téléphone : </label>
<input type="text" id="telephone" name="telephone" required placeholder="Votre téléphone"><br>
<label for="rue">Rue : </label>
<input type="text" id="rue" name="rue" required placeholder="Votre rue"><br>
<label for="codePostal">Code postal : </label>
<input type="text" id="codePostal" name="codePostal" required placeholder="Votre code postal"><br>
<label for="ville">Ville : </label>
<input type="text" id="ville" name="ville" required placeholder="Votre ville"><br>
<label for="MDP">Mot de passe : </label>
<input type="text" id="MDP" name="MDP" required placeholder="Votre mot de passe"><br>
<label for="confirmationMDP">Confirmation : </label>
<input type="text" id="confirmationMDP" name="confirmationMDP" required placeholder="Confirmation de votre mot de passe"><br>
<br>
<input type="submit" name="BTN_CREER" value="Créer">
<input type="reset" name="BTN_ANNULER" value="Annuler">
</form>

<p style="color:red">${error}</p>
</body>
</html>