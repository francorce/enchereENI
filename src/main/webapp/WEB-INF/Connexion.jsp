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

	<div class="header clearfix">
		<h3 class="text-muted">ENI - Enchère</h3>
	</div>
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
						:&nbsp;</label> <input type="text" class="form-control" name="password"
						id="password">
				</div>

				<button type="submit" class="btn btn-primary">Connexion</button>

			

			<ul class="list-group" style="">
			
				<li class="list-group-item"
					style="background-color: rgb(233, 236, 239); border-width: 0px;">
					<label class="checkbox" style=""> <input type="checkbox">Se souvenir de moi&nbsp; 
					<br> 
					<a href="/enchereENI/">Mot de passe oublié</a>
					</label>
				</li>
				
				<li class="list-group-item"
					style="background-color: rgb(233, 236, 239); border-width: 0px;">
					<form action="/enchereENI/Inscription">
						<input type="submit" class="btn btn-primary"
							value="Créer un compte"  />
					</form>
				</li>
			</ul>
			</form>
			<c:if test="${hasErrors != null}">
				<div class="alert alert-danger">${hasErrors}</div>
			</c:if>
		</div>
	</div>
</body>
</html>