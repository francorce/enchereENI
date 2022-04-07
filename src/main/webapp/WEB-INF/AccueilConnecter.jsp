<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

			<div class="card" style="">
				<div class="card-body" style="float: none;">
					<h4 class="card-title"></h4>
					<p class="card-text"></p>
				</div>
				<img class="card-img-top" src="" alt="Card image cap" width="128"
					height="128" style="float: left;">
			</div>
		</div>
		<div class="row marketing">
			<div class="col-lg-6"></div>
		</div>
	</div>
</body>
</html>