<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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

	<div class="container">

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#utilisateurs">Utilisateurs</a></li>
			<li><a data-toggle="tab" href="#categories">Catégories</a></li>
			<li><a data-toggle="tab" href="#articles">Articles</a></li>
			<li><a data-toggle="tab" href="#encheres">Enchères</a></li>
			<li><a data-toggle="tab" href="#retraits">Retraits</a></li>
		</ul>

		<div class="tab-content">
			<div id="utilisateurs" class="tab-pane fade in active">
				<div class="container">
					<div class="jumbotron">
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
			</div>
			<div id="categories" class="tab-pane fade">
				<div class="container">
					<div class="jumbotron">
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
			</div>
			<div id="articles" class="tab-pane fade">
				<div class="container">
					<div class="jumbotron">
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
											<td>${ article.debutEnchereStr }</td>
											<td>${ article.finEnchereStr }</td>
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
			</div>
			<div id="encheres" class="tab-pane fade">
				<div class="container">
					<div class="jumbotron">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>

										<th scope="col">Numéro enchères</th>
										<th scope="col">Date enchères</th>
										<th scope="col">Montant enchères</th>
										<th scope="col">Numéro articles</th>
										<th scope="col">Enchérisseur</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="enchere" items="${ enchereList }">
										<tr>

											<td>${ enchere.noEnchere }</td>
											<td>${ enchere.dateEnchereStr }</td>
											<td>${ enchere.montantEnchere }</td>
											<td>${ enchere.articles.noArticle }</td>
											<td>${ enchere.encherisseur.pseudo }</td>

										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
				</div>
			</div>
			<div id="retraits" class="tab-pane fade">
				<div class="container">
					<div class="jumbotron">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>

										<th scope="col">Numéro article</th>
										<th scope="col">Rue</th>
										<th scope="col">Code postal</th>
										<th scope="col">Ville</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="retrait" items="${ listeRetrait }">
										<tr>

											<td>${ retrait.article.noArticle }</td>
											<td>${ retrait.rue }</td>
											<td>${ retrait.cp }</td>
											<td>${ retrait.ville }</td>

										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
</body>
</html>