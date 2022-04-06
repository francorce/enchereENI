<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>ENI - Enchère</h1>
	<form action="Connexion" method="post">
		<div class="card">
			<label for="username">Pseudo ou email</label> <input type="text"
				name="username" id="username" />
		</div>
		<div class="card">
			<label for="password">Mot de passe</label> <input type="password"
				name="password" id="password" />
		</div>

		<div class="card">
			<button type="submit">Connexion</button>
			<input type='checkbox' id='remember' name='remember'> <label
				htmlfor="remember">se souvenir de moi</label>
		</div>

		<div class="card">
			<button>Créer un compte</button>
		</div>
	</form>
	<div>${hasErrors}</div>

</body>
</html>