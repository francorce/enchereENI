<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Inscription</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="./AccueilConnecter"> ENI-Enchères</a>
		<div class="btn-group" role="group" aria-label="ez">
			<form action="/enchereENI/Profil">
				<button class="btn btn-primary" type="submit">Profil</button>
			</form>
			&nbsp
			<form action="/enchereENI/AccueilConnecter">
				<button class="btn btn-info" type="submit">Accueil</button>
			</form>
		</div>
	</nav>


	<script>
		var check = function() {
			if (document.getElementById('password').value == document
					.getElementById('passwordV').value) {
				document.getElementById('message').style.color = 'green';
				document.getElementById('message').innerHTML = 'Les mots de passe correspondent';
			} else {
				document.getElementById('message').style.color = 'red';
				document.getElementById('message').innerHTML = 'Les mots de passe ne correspondent pas';
			}
		}
	</script>
	<div class="container">
		<div class="jumbotron">
			<form method="post" action="/enchereENI/ProfilModifier">


				<div class="row g-5">
					<div class="col">
						<!-- Name input -->
						<div class="form-outline">
							<label class="form-label" for="pseudo">Pseudo :</label> <input
								type="text" name="pseudo" value="${user.pseudo}" id="pseudo"
								class="form-control" placeholder="Pseudo" />
						</div>
					</div>
					<div class="col">
						<!-- Email input -->
						<div class="form-outline">
							<label class="form-label" for="prenom">Prénom :</label> <input
								type="text" name="prenom" value="${user.prenom}" id="prenom"
								class="form-control" placeholder="Prenom" />
						</div>
					</div>
				</div>
				<div class="row g-5">
					<div class="col">
						<!-- Name input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example3">Nom :</label> <input
								type="text" name="nom" value="${user.nom}" id="nom"
								class="form-control" placeholder="Nom" />
						</div>
					</div>
					<div class="col">
						<!-- Email input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example4">Email :</label> <input
								type="email" name="email" value="${user.email}" id="email"
								class="form-control" placeholder="Adresse mail @" />
						</div>
					</div>
				</div>
				<div class="row g-5">
					<div class="col">
						<!-- Name input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example3">Telephone :</label>
							<input type="number" value="${user.telephone}" name="telephone"
								id="telepehone" class="form-control" placeholder="Telephone" />
						</div>
					</div>
					<div class="col">
						<!-- Email input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example4">CP :</label> <input
								type="number" value="${user.cp}" name="cp" id="cp"
								class="form-control" placeholder="Code postal" />
						</div>
					</div>
				</div>
				<div class="row g-5">
					<div class="col">
						<!-- Name input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example3">Ville :</label> <input
								type="text" value="${user.ville}" name="ville" id="ville"
								class="form-control" placeholder="Ville" />
						</div>
					</div>
					<div class="col">
						<!-- Email input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example4">Rue :</label> <input
								type="text" value="${user.rue}" name="rue" id="rue"
								class="form-control" placeholder="Rue" />
						</div>
					</div>
				</div>
				<div class="row g-5">
					<div class="col">
						<!-- Name input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example3">Mot de
								passe :</label> <input type="password" value="${user.password}"
								name="password" id="password" class="form-control"
								onkeyup='check();' placeholder="Mot de passe" />
						</div>
					</div>
					<div class="col">
						<!-- Email input -->
						<div class="form-outline">
							<label class="form-label" for="form9Example4">Confirmation
								:</label> <input type="password" name="passwordV" id="passwordV"
								class="form-control" onkeyup='check();'
								placeholder="Confirmation Mot de passe" />
						</div>
					</div>
				</div>
				<br> <label class="form-label" for="form9Example4">Credit
					: ${user.credit}</label> 
					<br> <span id='message'></span> <br>
<input type="submit" name="action" class="btn btn-primary" value="Modifier" />

			</form>
			

			<form action="supprimerUser" method="get">
			
				<button type="submit" class="btn btn-primary" style="float: right;" >Supprimer
					mon compte</button>
			</form>
		</div>
	</div>
	<c:if test="${isDeleted == false && fromDelete == true}">
		<div class="alert alert-danger">Cet utilisateur à des enchères
			en cours...!</div>
	</c:if>
</body>
</html>