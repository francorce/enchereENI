<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
				<a class="navbar-brand" href="#"> ENI-Enchères</a>
				<div class="btn-group" role="group" aria-label="ez">
					<form action="/enchereENI/ProfilModifier">
						<button class="btn btn-primary" type="submit">Modifier</button>
					</form> &nbsp
					<form action="/enchereENI/AccueilConnecter">
						<button class="btn btn-info"  type="submit">Accueil</button>
					</form>
				</div>
			</nav>
	
	<div class="container">
		<h1 style="float: none;">Mon profil :</h1>
		<div class="jumbotron">
			<ul class="list-group" style="">
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Pseudo :<input
					type="text" value="${userProfil.pseudo}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Nom :<input
					type="text" value="${userProfil.nom}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Prénom:<input
					type="text" value="${userProfil.prenom}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">E-mail :<input
					type="text" value="${userProfil.email}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Téléphone :<input
					type="text" value="${userProfil.telephone}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Rue :<input
					type="text" value="${userProfil.rue}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Code postal :<input
					type="text" value="${userProfil.cp}" class="form-control" readonly></li>
				<li class="list-group-item"
					style="text-align: left; border-width: 0px;">Ville :<input
					type="text" value="${userProfil.ville}" class="form-control" readonly></li>
			</ul>
			
			<c:if test="${userProfil.no_utilisateur eq user.no_utilisateur}">
				<form action="/enchereENI/ProfilModifier">
					<br>
					<button type="submit" class="btn btn-primary" style="float: right;">Modifier</button>
				</form>
			</c:if>
		</div>


	</div>

</body>
</html>