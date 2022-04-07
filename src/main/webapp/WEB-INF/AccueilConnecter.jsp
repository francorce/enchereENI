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

</head>
<body>
	<div class="header clearfix">
	
		<form action="VendreArticle" method="get">
			<button class="btn btn-primary" style="float: right;" type="submit">Vendre un article</button>
		</form>
		
		<form action="Deconnexion" method="get">
			<button class="btn btn-danger" style="float: right;" type="submit">Déconnexion</button>
		</form>

		<form action="/enchereENI/Profil">
			<button class="btn btn-info" style="float: right;" type="submit">Mon
				profil</button>
		</form>
		<h3 class="text-muted">ENI - Enchère&nbsp;</h3>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h1 class="display-3">Listes des enchères</h1>
			<button class="btn btn-primary" style="float: right;">Rechercher</button>

			<label style="float: left;">filtres :&nbsp;</label> <input
				type="text" class="form-control">
			<div class="form-group" style="">
				<label style="float: left;">Catégories :&nbsp;</label> <select
					class="form-control">
				</select>



			</div>
			<div class="row">
				<div class="col">
					<input type="radio" name="radio" values="Achats">Achats
					<ul>
						<li><input name="check" type="checkbox"> enchère
							ouvertes</li>
						<li><input name="check" type="checkbox"> mes enchères</li>
						<li><input name="check" type="checkbox">mes enchères
							remportées</li>
					</ul>
				</div>
				<div class="col">
					<input type="radio" name="radio" values="Mes_ventes"> Mes
					ventes
					<ul>
						<li><input name="check" type="checkbox"> mes ventes
							en cours</li>
						<li><input name="check" type="checkbox"> ventes non
							débutées</li>
						<li><input name="check" type="checkbox">ventes
							termiées</li>
					</ul>
				</div>
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