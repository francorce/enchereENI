<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère ENI</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="<%=request.getContextPath() %>/js/myjs.js" defer ></script>
</head>
<body>


		<nav class="navbar navbar-light bg-light">
				<a class="navbar-brand" href="#"> ENI-Enchères</a>
			<form action="/enchereENI/Connexion">
        		<button class="btn btn-primary" style="float: right;">S'incrire / Se connecter</button>
        	</form>
        
		</nav>
	
      <div class="container">
		<div class="jumbotron">
        <h1 class="display-3">Listes des enchères</h1>
        <button class="btn btn-primary" style="float: right;">Rechercher</button><br>
        <label style="float: left;">filtres :&nbsp;</label>
          <input type="text" class="form-control">
       <label for="categorie">Categorie</label>
				 <select class="form-control" type="text" id="categorie" name="categorie"  xxxonchange="yesnoCheck(this);">
				<option>Afficher tout</option>


				<c:forEach items="${listeCategorie}" var="categorie">
					<option value="${categorie.libelle}">${categorie.libelle}</option>
				</c:forEach>
				 </select>
			<br>
        
	        <div class="row" id="listeArticles">
	         <c:forEach items="${listArticles}" var="listArticles"> 
		        <div class="col-sm-4" data-category="${listArticles.categorie.libelle}">
			        <div class="card" id ="${listArticles.categorie.libelle}">
			        <img class="card-img-top" src="https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg" alt="Card image cap"  style="float: left;">
						<div class="card-body">
							<h4 class="card-title">${listArticles.nomArticle}</h4>
							<p class="card-text">Prix : ${listArticles.prixInitial}</p>
							<p class="card-text">Catégorie : ${listArticles.categorie.libelle}</p>
							<p class="card-text">Fin de l'enchère : ${listArticles.finEnchere}</p>
							Vendeur : <a class="card-text">${listArticles.vendeur.pseudo}</a>					  			
						</div>
					</div>
				</div>
				</c:forEach>
	        </div>
       
      </div>
      </div>
	</body>
</html>