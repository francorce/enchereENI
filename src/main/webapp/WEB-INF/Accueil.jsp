<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère ENI</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
	<body>
	<div class="header clearfix">
        
        	<form action="/enchereENI/Connexion">
        	<button class="btn btn-primary" style="float: right;">S'incrire / Se connecter</button>
        	</form>
        	
    
        <h3 class="text-muted">ENI - Enchère&nbsp;</h3>
      </div>
      <div class="container">
		<div class="jumbotron">
        <h1 class="display-3">Listes des enchères</h1>
        <button class="btn btn-primary" style="float: right;">Rechercher</button>
        <label style="float: left;">filtres :&nbsp;</label>
          <input type="text" class="form-control">
        <div class="form-group" style="">
        <label style="float: left;">Catégories :&nbsp;</label>
          <select class="form-control">
            </select>
        </div>
        
	        <div class="row" >
	         <c:forEach items="${listArticles}" var="listArticles"> 
		        <div class="col-sm-4">
			        <div class="card">
			        <img class="card-img-top" src="" alt="Card image cap" width="128" height="128" style="float: left;">
						<div class="card-body">
							<h4 class="card-title">${listArticles.nomArticle}</h4>
							<p class="card-text">Prix : ${listArticles.prixInitial}</p>
							<p class="card-text">Fin de l'enchère : ${listArticles.finEnchere}</p>
							<a class="card-text" href="/enchereENI/ProfilVendeur">Vendeur : ${listArticles.vendeur}</a>					  			
						</div>
					</div>
				</div>
				</c:forEach>
	        </div>
       
      </div>
      </div>
	</body>
</html>