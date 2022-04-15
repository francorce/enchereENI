<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="./AccueilConnecter"> ENI-Enchères</a>
		<div class="btn-group" role="group" aria-label="ez">

			<form action="VendreArticle" method="get">
				Credit : ${user.credit}
				<button class="btn btn-primary" type="submit">Vendre un
					article</button>
			</form>
			&nbsp;

			<form action="Deconnexion" method="get">
				<button class="btn btn-danger" type="submit">Déconnexion</button>
			</form>
			&nbsp;

			<form action="/enchereENI/Profil">
				<button class="btn btn-info" type="submit">Mon profil</button>
			</form>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">

			<h2>Détail vente</h2>
			<br><b><h4>${article.nomArticle}</h4></b><br> 
			
			<b>
			<label class="form-label" >Description : </label> 
			</b>
			<br> ${article.description}
			<br>
			<br>
			<b>
			<label class="form-label" >Catégorie : </b> ${article.categorie.libelle}</label><br> 
			<b>
			
			<hr>
			<label class="form-label" >Meilleure offre :</b> ${article.prixVente} </label>
			<hr>

			<br> 
			<b>
			<label class="form-label" >Mise à prix :</b> ${article.prixInitial} crédits</label><br> <b>
			
			<label class="form-label" >Fin de l'enchère :</b> ${article.finEnchereStr}</label><br> <b>
					
			<label class="form-label">Rue :</b> ${rue}</label><br>
			
			<b><label class="form-label" >Code postal :</b> ${cp}</label><br> <b>
			
			<label class="form-label" >Ville : </b> ${ville}</label><br> 
			
			<b>Vendeur :</b>
			<a class="card-text" href="${'/enchereENI/Profil?no_utilisateur='}${article.vendeur.no_utilisateur}">${article.vendeur.pseudo}</a>

			<c:if test="${peuxEncherir == true }">
				<form action="encherir" method="post">
					<input type="number" class="form-control" style="width: 150px"
						value="${prix}" id="montantEnchere" name="montantEnchere" /> <input
						type="hidden" value="${article.noArticle}" id="no_article"
						name="no_article" />
					<button type="submit" class="btn btn-primary">Enchérir</button>
				</form>
			</c:if>
			<c:if test="${peuxEncherir == false }">
				<div class="alert alert-warning">Vous ne pouvez pas enchérir
					actuellement</div>
			</c:if>
			<br>
			<c:if test="${canModif == true }">
				<a class="card-text"
					href="${'/enchereENI/ModifierArticle?no_article='}${article.noArticle}"><button
						class="btn btn-warning" type="button">Modifier</button></a>
			</c:if>
			<br>
<br>
			<c:if test="${isVendeur == true }">
			Listes des enchères : 
			<ul>
					<c:forEach var="entry" items="${listeEncherisseur}">
						<li>Utilisateur : <c:out value="${entry.key.pseudo}" /> / Montant enchère : <c:out
								value="${entry.value.montantEnchere}" />
						</li>
					</c:forEach>
			</c:if>
			</ul>
		</div>
	</div>




</body>
</html>