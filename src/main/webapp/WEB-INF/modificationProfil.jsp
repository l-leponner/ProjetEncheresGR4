<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du profil</title>
</head>
<body>
<h1>Mon Profil</h1>
<form action="InscriptionServlet" method="POST">
<label for="pseudo">Pseudo : </label>
<input type="text" id="pseudo" name="pseudo" required placeholder="Votre pseudo" pattern="[A-Za-z0-9]{1,30}$" value="model.current.pseudo"><br>
<label for="nom">Nom : </label>
<input type="text" id="nom" name="nom" required placeholder="Votre nom" value="model.current.nom">><br>
<label for="prenom">Prénom : </label>
<input type="text" id="prenom" name="prenom" required placeholder="Votre prénom" value="model.current.prenom">><br>
<label for="email">Email : </label>
<input type="email" id="email" name="email" required placeholder="Votre email" value="model.current.email">><br>
<label for="telephone">Téléphone : </label>
<input type="tel" id="telephone" name="telephone" required placeholder="Votre téléphone" value="model.current.telephone">><br>
<label for="rue">Rue : </label>
<input type="text" id="rue" name="rue" required placeholder="Votre rue" value="model.current.rue">><br>
<label for="codePostal">Code postal : </label>
<input type="text" id="codePostal" name="codePostal" required placeholder="Votre code postal" value="model.current.codePostal">><br>
<label for="ville">Ville : </label>
<input type="text" id="ville" name="ville" required placeholder="Votre ville" value="model.current.ville">><br>
<label for="actuelMDP">Mot de passe actuel : </label>
<input type="password" id="actuelMDP" name="actuelMDP" required placeholder="Votre mot de passe actuel" value="model.current.motDePasse">><br>
<label for="nouveauMDP">Nouveau mot de passe : </label>
<input type="password" id="nouveauMDP" name="nouveauMDP" required placeholder="Votre nouveau smot de passe"><br>
<label for="confirmationMDP">Confirmation : </label>
<input type="password" id="confirmationMDP" name="confirmationMDP" required placeholder="Confirmation de votre mot de passe"><br>
<label for="credit">Crédit : </label>
<p id="credit">${credit}</p>
<br>
<input type="submit" name="BTN_ENREGISTRER" value="Enregistrer">
<input type="reset" name="BTN_SUPPRIMER" value="Supprimer mon compte">
</form>

<p style="color:red">${error}</p>
</body>
</html>