<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="./AccueilConnecter"> ENI-Enchères</a>
		<div class="btn-group" role="group" aria-label="ez">
			<form action="/enchereENI/">
				<button class="btn btn-info" type="submit">Accueil</button>
			</form>
		</div>
	</nav>


	<div class="container">
		<div class="jumbotron">
			<form action="Connexion" method="post">
				<div class="form-group" style="">
					<label style="float: left;" for="username">Identifiant
						:&nbsp;</label> <input type="text" class="form-control" name="username"
						id="username" />
				</div>

				<div class="form-group" style="">
					<label style="float: left;" for="password">Mot de passe
						:&nbsp;</label> <input type="password" class="form-control" name="password"
						id="password">
				</div>

				<button type="submit" class="btn btn-primary">Connexion</button>




				<div class="form-group mt-5">

					<input type="checkbox" id="rememberMe" name="rememberMe" /> <label class="checkbox"
						for="rememberMe">Se souvenir de moi </label> </label>
				</div>
				<a href="/enchereENI/">Mot de passe oublié</a>
			</form>
			<br>
			<form action="/enchereENI/Inscription">
				<input type="submit" class="btn btn-primary" value="Créer un compte" />
			</form>







			<c:if test="${hasErrors != null}">
				<div class="alert alert-danger">${hasErrors}</div>
			</c:if>
		</div>
	</div>
</body>
</html>