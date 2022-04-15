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
<script src="<%=request.getContextPath() %>/js/myjs.js" defer></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
</head>
<body>


	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="/Accueil"> ENI-Enchères</a>
		<form action="/enchereENI/Connexion">
			<button class="btn btn-primary" style="float: right;">S'incrire
				/ Se connecter</button>
		</form>

	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1 class="display-3">Listes des enchères</h1>
			<br> <label style="float: left;">filtres :&nbsp;</label> <input
				type="text" id="myInput" class="form-control" onkeyup="myFunction()" placeholder="Rechercher"> <label for="categorie">Categorie</label>
			<select class="form-control" type="text" id="categorie"
				name="categorie" xxxonchange="yesnoCheck(this);">
				<option>Afficher tout</option>


				<c:forEach items="${listeCategorie}" var="categorie">
					<option value="${categorie.libelle}">${categorie.libelle}</option>
				</c:forEach>
			</select> <br>


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

			<div class="row" id="listeArticles">
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
										<a class="card-text">
											${listArticles.nomArticle}</a>
									</h4>
									<p class="card-text">Prix : ${listArticles.prixVente}</p>
									<p class="card-text">Catégorie :
										${listArticles.categorie.libelle}</p>
									<p class="card-text">Fin de l'enchère :
										${listArticles.finEnchere}</p>
									Vendeur : <a class="card-text"
										>${listArticles.vendeur.pseudo}</a>
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