<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#"> ENI-Enchères</a>
		<div class="btn-group" role="group" aria-label="ez">

			<form action="VendreArticle" method="get">
				Credit : ${user.credit}
				<button class="btn btn-primary" type="submit">Vendre un
					article</button>
			</form>
			&nbsp

			<form action="Deconnexion" method="get">
				<button class="btn btn-danger" type="submit">Déconnexion</button>
			</form>
			&nbsp

			<form action="/enchereENI/Profil">
				<button class="btn btn-info" type="submit">Mon profil</button>
			</form>
		</div>
	</nav>

<div class="container">
	<h2> Détail vente</h2>
	${article.nomArticle}<br>
	<label class="form-label" for="form9Example4">Description : ${article.description}</label> <br>
	<label class="form-label" for="form9Example4">Catégorie : ${article.categorie.libelle}</label><br>
	<label class="form-label" for="form9Example4">Meilleure offre : ${article.categorie.libelle}</label><br>
	<label class="form-label" for="form9Example4">Mise à prix : ${article.prixInitial}</label><br>
	<label class="form-label" for="form9Example4">Fin de l'enchère : ${article.finEnchere}</label><br>
	
	<label class="form-label" for="form9Example4">Rue : ${rue}</label><br>
	<label class="form-label" for="form9Example4">Code_postal : ${cp}</label><br>
	<label class="form-label" for="form9Example4">Ville : ${ville}</label><br>
	
	<label class="form-label" for="form9Example4">Vendeur : ${article.vendeur.pseudo}</label><br>
	
	<form action="encherir" method="post">
		<input type="number" value="${prix}" id="montantEnchere"
			name="montantEnchere" /> <input type="hidden"
			value="${article.noArticle}" id="no_article" name="no_article" />
		<button type="submit">Enchérir</button>
	</form>
	
	</div>
	
	
	

</body>
</html>