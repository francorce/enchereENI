<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère ENI</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="<%=request.getContextPath()%>/js/myjs.js" defer></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>

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
		<div class="jumbotron">
			<h1 class="display-3">Listes des enchères</h1>
			<c:if test="${succes == true}">
				<div class="alert alert-success">Votre enchère a bien été prise
					en compte</div>
			</c:if>
			<button class="btn btn-primary" style="float: right;">Rechercher</button>
			<br> <label style="float: left;">filtres :&nbsp;</label> <input
				type="text" class="form-control"> <label for="categorie">Categorie</label>
			<select class="form-control" type="text" id="categorie"
				name="categorie" xxxonchange="yesnoCheck(this);">
				<option>Afficher tout</option>


				<c:forEach items="${listeCategorie}" var="categorie">
					<option value="${categorie.libelle}">${categorie.libelle}</option>
				</c:forEach>
			</select>


			<div class="row">
				<script>
					function achats() {
						document.getElementById("myCheck1").disabled = false;
						document.getElementById("myCheck2").disabled = false;
						document.getElementById("myCheck3").disabled = false;
						document.getElementById("myCheck4").disabled = true;
						document.getElementById("myCheck5").disabled = true;
						document.getElementById("myCheck6").disabled = true;

					}
					function ventes() {
						document.getElementById("myCheck1").disabled = true;
						document.getElementById("myCheck2").disabled = true;
						document.getElementById("myCheck3").disabled = true;
						document.getElementById("myCheck4").disabled = false;
						document.getElementById("myCheck5").disabled = false;
						document.getElementById("myCheck6").disabled = false;

					}
				</script>

				<div class="col">

					<input type="radio" name="radio" values="Achats" onClick="achats()">
					Achats
					<ul>

						<li class="list-group-item"
							style="background-color: rgb(233, 236, 239); border-width: 0px; padding-top: 0px; padding-bottom: 0px;"><input
							name="check" type="checkbox" id="myCheck1"> enchère
							ouvertes</li>
						<li class="list-group-item"
							style="background-color: rgb(233, 236, 239); border-width: 0px; padding-top: 0px; padding-bottom: 0px;"><input
							name="check" type="checkbox" id="myCheck2"> mes enchères</li>
						<li class="list-group-item"
							style="background-color: rgb(233, 236, 239); border-width: 0px; padding-top: 0px; padding-bottom: 0px;"><input
							name="check" type="checkbox" id="myCheck3"> mes enchères
							remportées</li>

					</ul>
				</div>
				<div class="col">
					<input type="radio" name="radio" values="Mes_ventes"
						onClick="ventes()"> Mes ventes
					<ul>


						<li class="list-group-item"
							style="background-color: rgb(233, 236, 239); border-width: 0px; padding-top: 0px; padding-bottom: 0px;"><input
							name="check" type="checkbox" id="myCheck4"> mes ventes en
							cours</li>
						<li class="list-group-item"
							style="background-color: rgb(233, 236, 239); border-width: 0px; padding-top: 0px; padding-bottom: 0px;"><input
							name="check" type="checkbox" id="myCheck5"> ventes non
							débutées</li>
						<li class="list-group-item"
							style="background-color: rgb(233, 236, 239); border-width: 0px; padding-top: 0px; padding-bottom: 0px;"><input
							name="check" type="checkbox" id="myCheck6"> ventes
							termiées</li>

					</ul>
				</div>
			</div>




			<div class="row" id="listeArticles">
				<c:forEach items="${listArticles}" var="listArticles">
					<div class="col-sm-4"
						data-category="${listArticles.categorie.libelle}">
						<div class="card" id="${listArticles.categorie.libelle}">
							<img class="card-img-top"
								src="https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg"
								alt="Card image cap" style="float: left;">
							<div class="card-body">
								<h4 class="card-title">
									<a class="card-text"
										href="${'/enchereENI/encherir?no_article='}${listArticles.noArticle}">${listArticles.nomArticle}</a>
								</h4>
								<p class="card-text">Prix : ${listArticles.prixVente}</p>
								<p class="card-text">Catégorie :
									${listArticles.categorie.libelle}</p>
								<p class="card-text">Fin de l'enchère :
									${listArticles.finEnchere}</p>
								Vendeur : <a class="card-text"
									href="${'/enchereENI/Profil?no_utilisateur='}${listArticles.vendeur.no_utilisateur}">${listArticles.vendeur.pseudo}</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
</body>
</html>