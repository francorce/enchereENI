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
			<form action="/enchereENI/">
				<button class="btn btn-info" type="submit">Accueil</button>
			</form>
		</div>
	</nav>



		<div class="container" >
		<div class="jumbotron" >
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>

							<th scope="col">Numéro utilisateur</th>
							<th scope="col">Pseudo</th>
							<th scope="col">Nom</th>
							<th scope="col">Prénom</th>
							<th scope="col">E-mail</th>
							<th scope="col">Téléphone</th>
							<th scope="col">Rue</th>
							<th scope="col">Code postal</th>
							<th scope="col">Ville</th>
							<th scope="col">Mot de passe</th>
							<th scope="col">Crédits</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="utilisateur" items="${ utilisateurs }">
							<tr>
								<td>${ utilisateur.no_utilisateur }</td>
								<td>${ utilisateur.pseudo }</td>
								<td>${ utilisateur.nom }</td>
								<td>${ utilisateur.prenom }</td>
								<td>${ utilisateur.email }</td>
								<td>${ utilisateur.telephone }</td>
								<td>${ utilisateur.rue }</td>
								<td>${ utilisateur.cp }</td>
								<td>${ utilisateur.ville }</td>
								<td>${ utilisateur.password }</td>
								<td>${ utilisateur.credit }</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
			</div>

<div class="container" >
		<div class="jumbotron" >
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>

							<th scope="col">Numéro catégorie</th>
							<th scope="col">Libelle</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="categorie" items="${ categories }">
							<tr>
							
								<td>${ categorie.noCategorie }</td>
								<td>${ categorie.libelle }</td>
								
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
		</div>
		
		
		<div class="container" >
		<div class="jumbotron" >
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>

							<th scope="col">Numéro article</th>
							<th scope="col">Nom article</th>
							<th scope="col">Description</th>
							<th scope="col">Date début enchère</th>
							<th scope="col">Date fin enchère</th>
							<th scope="col">Prix initial</th>
							<th scope="col">Prix de vente</th>
							<th scope="col">Utilisateur lié</th>
							<th scope="col">Catégorie lié</th>
							
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="article" items="${ articles }">
							<tr>
							
								<td>${ article.noArticle }</td>
								<td>${ article.nomArticle }</td>
								<td>${ article.description }</td>
								<td>${ article.debutEnchere }</td>
								<td>${ article.finEnchere }</td>
								<td>${ article.prixInitial }</td>
								<td>${ article.prixVente }</td>
								<td>${ article.vendeur.pseudo }</td>
								<td>${ article.categorie.libelle }</td>
							
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
		</div>
		
		
		<div class="jumbotron" >
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>

							<th scope="col">R</th>
							<th scope="col">Libelle</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="categorie" items="${ categories }">
							<tr>
							
								<td>${ categorie.noCategorie }</td>
								<td>${ categorie.libelle }</td>
								
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
		
		
		<div class="jumbotron" >
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>

							<th scope="col">Numéro catégorie</th>
							<th scope="col">Libelle</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="categorie" items="${ categories }">
							<tr>
							
								<td>${ categorie.noCategorie }</td>
								<td>${ categorie.libelle }</td>
								
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
		

</body>
</html>