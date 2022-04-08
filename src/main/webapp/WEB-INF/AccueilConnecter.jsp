<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère ENI</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="<%=request.getContextPath() %>/js/myjs.js" defer ></script>

</head>
<body>
			<nav class="navbar navbar-light bg-light">
				<a class="navbar-brand" href="#"> ENI-Enchères</a>
				<div class="btn-group" role="group" aria-label="ez">
					<form action="VendreArticle" method="get">
						<button class="btn btn-primary"  type="submit">Vendre un article</button>
					</form> &nbsp
					
					<form action="Deconnexion" method="get">
						<button class="btn btn-danger"  type="submit">Déconnexion</button>
					</form> &nbsp
			
					<form action="/enchereENI/Profil">
						<button class="btn btn-info"  type="submit">Mon profil</button>
					</form>
				</div>
			</nav>



	
	<div class="container">
		<div class="jumbotron">
			<h1 class="display-3">Listes des enchères</h1>
			<button class="btn btn-primary" style="float: right;">Rechercher</button>
			<br>

				<label style="float: left;">filtres :&nbsp;</label> <input type="text" class="form-control">
	<!--			
<script>
		
		function yesnoCheck(that) {
    if (that.value == "Livre") {
		
			document.getElementById("Livre").style.display = "block";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
		
    } else if (that.value == "Viande")  {
    
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "block";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    } else if (that.value == "Mode")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "block";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    
    } else if (that.value == "Electromenager")  {
	
	document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "block";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    } else if (that.value == "Informatique")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "block";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    }else if (that.value == "Maison")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "block";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    } else if (that.value == "Automoto")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "block";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    }else if (that.value == "Animalerie")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "block";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "none";
			
    } else if (that.value == "Epicerie")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "block";
			document.getElementById("Jouets").style.display = "none";
			
    }else if (that.value == "Jouets")  {
	
			document.getElementById("Livre").style.display = "none";
			document.getElementById("Viande").style.display = "none";
			document.getElementById("Mode").style.display = "none";
			document.getElementById("Electromenager").style.display = "none";
			document.getElementById("Informatique").style.display = "none";
			document.getElementById("Maison").style.display = "none";
			document.getElementById("Automoto").style.display = "none";
			document.getElementById("Animalerie").style.display = "none";
			document.getElementById("Epicerie").style.display = "none";
			document.getElementById("Jouets").style.display = "block";
			
    } else{ 
    	document.getElementById("Livre").style.display = "block";
    	document.getElementById("Livre").style.display = "block";
		document.getElementById("Viande").style.display = "block";
		document.getElementById("Mode").style.display = "block";
		document.getElementById("Electromenager").style.display = "block";
		document.getElementById("Informatique").style.display = "block";
		document.getElementById("Maison").style.display = "block";
		document.getElementById("Automoto").style.display = "block";
		document.getElementById("Animalerie").style.display = "block";
		document.getElementById("Epicerie").style.display = "block";
		document.getElementById("Jouets").style.display = "block";
	}
	
}</script>
				-->
				<label for="categorie">Categorie</label>
				 <select class="form-control" type="text" id="categorie" name="categorie"  xxxonchange="yesnoCheck(this);">
				<option>Afficher tout</option>


				<c:forEach items="${listeCategorie}" var="categorie">
					<option value="${categorie.libelle}">${categorie.libelle}</option>
				</c:forEach>
				 </select>
			
	
			<div class="row"> 
				<div class="col">
					<input type="radio" name="radio" values="Achats">Achats
					<ul>
						<li><input name="check" type="checkbox"> enchère ouvertes</li>
						<li><input name="check" type="checkbox"> mes enchères</li>
						<li><input name="check" type="checkbox">mes enchères remportées</li>
					</ul>
				</div>
				<div class="col">
					<input type="radio" name="radio" values="Mes_ventes"> Mes ventes
					<ul>
						<li><input name="check" type="checkbox"> mes ventes en cours</li>
						<li><input name="check" type="checkbox"> ventes non débutées</li>
						<li><input name="check" type="checkbox">ventes termiées</li>
					</ul>
				</div>
			</div>




			<div class="row" id="listeArticles">
	         <c:forEach items="${listArticles}" var="listArticles"> 
		        <div class="col-sm-4" data-category="${listArticles.categorie.libelle}" >
			        <div class="card" id ="${listArticles.categorie.libelle}"  >
			        <img class="card-img-top" src="https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg" alt="Card image cap" style="float: left;">
						<div class="card-body" >
							<h4 class="card-title">${listArticles.nomArticle}</h4>
							<p class="card-text">Prix : ${listArticles.prixInitial}</p>
							<p class="card-text">Catégorie : ${listArticles.categorie.libelle}</p>
							<p class="card-text">Fin de l'enchère : ${listArticles.finEnchere}</p>
							Vendeur : <a class="card-text" href="${'/enchereENI/Profil?no_utilisateur='}${listArticles.vendeur.no_utilisateur}">${listArticles.vendeur.pseudo}</a>					  			
						</div>
					</div>
				</div>
				</c:forEach>
	        </div>
		</div>
	</div>
</body>
</html>