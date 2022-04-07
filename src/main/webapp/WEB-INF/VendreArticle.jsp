<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#"> ENI-Enchères</a>
	</nav>
	<div class="container">
		<div class="d-flex justify-content-center">
			<h2>Vendre un article</h2>
		</div>
		<form action="VendreArticle" method="post" class="d-flex flex-column">
			<label for="nomArticle">Article</label> <input type="text"
				id="nomArticle" name="nomArticle" /> <label for="description">Description</label>
			<textarea type="text" id="description" name="description"></textarea>

			<label for="categorie">Categorie</label> <select type="text"
				id="categorie" name="categorie">
				<option></option>

				<c:forEach items="${listeCategorie}" var="categorie">
					<option>${categorie.libelle}</option>
				</c:forEach>

			</select> <label for="buttonPhoto">Photo de l'article</label>
			<button type="button" id="buttonPhoto">Uploader</button>

			<label for="prixDepart">Mise à prix</label> <input id="prixDepart"
				name="prixDepart" type="number" /> <label for="debutEnchere">Début
				de l'enchère</label> <input id="debutEnchere" name="debutEnchere"
				type="date" /> <label for="finEnchere">Fin de l'enchère</label> <input
				id="finEnchere" name="finEnchere" type="date" />

			<fieldset class="d-flex flex-column mt-3">
				<legend>Retrait</legend>

				<label for="rue">Rue</label> <input id="rue" name="rue" type="text" />

				<label for="cp">Code postal</label> <input id="cp" name="cp"
					type="text" /> <label for="ville">Ville</label> <input id="ville"
					name="ville" type="text" />
			</fieldset>
			<div class="d-flex justify-content-around mt-5">
				<button class="btn btn-secondary" type="submit">Enregistrer</button>
				<button class="btn btn-secondary" type="button">Annuler</button>
				<button class="btn btn-secondary" type="submit">Annuler la
					vente</button>
			</div>
		</form>
	</div>
</body>
</html>