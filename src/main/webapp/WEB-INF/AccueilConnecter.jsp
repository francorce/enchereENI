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
		<a class="navbar-brand" href="./AccueilConnecter"> ENI-Enchères</a>
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
				<div class="alert alert-success">Votre enchère a bien été
					prise en compte</div>
			</c:if>
			<br> <label style="float: left;">filtres :&nbsp;</label> <input
				type="text" id="myInput" class="form-control" onkeyup="myFunction()"
				placeholder="Rechercher"> <label for="categorie">Categorie</label>
			<select class="form-control" type="text" id="categorie"
				name="categorie" xxxonchange="yesnoCheck(this);">
				<option>Afficher Tout</option>


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

						<li style="list-style: none;"><input name="check"
							type="checkbox" id="myCheck1"> enchère ouvertes</li>
						<li style="list-style: none;"><input name="check"
							type="checkbox" id="myCheck2"> mes enchères</li>
						<li style="list-style: none;"><input name="check"
							type="checkbox" id="myCheck3"> mes enchères remportées</li>

					</ul>
				</div>
				<div class="col">
					<input type="radio" name="radio" values="Mes_ventes"
						onClick="ventes()"> Mes ventes
					<ul>


						<li style="list-style: none;"><input name="check"
							type="checkbox" id="myCheck4"> mes ventes en cours</li>
						<li style="list-style: none;"><input name="check"
							type="checkbox" id="myCheck5"> ventes non débutées</li>
						<li style="list-style: none;"><input name="check"
							type="checkbox" id="myCheck6"> ventes termiées</li>

					</ul>
				</div>
			</div>


			<script>
function myFunction() {
    var input, div, filter, ul, li, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("div");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = '';
        } else {
            li[i].style.display = 'none';
        }
    }
}


</script>

			<div class="row" id="art">
				<ul
					style="list-style: none; display: flex; flex-wrap: wrap; border: 0; padding: 0; margin: 0;"
					id="myUL">
					<c:forEach items="${listArticles}" var="listArticles">
						<div class="col-sm-4" style=""
							data-category="${listArticles.categorie.libelle}">

							<div class="card" id="${listArticles.categorie.libelle}">
								<img class="card-img-top"
									src="data:image/jpeg;base64,${listArticles.base64image}"
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
				</ul>
			</div>
		</div>
		</div>
</body>
</html>