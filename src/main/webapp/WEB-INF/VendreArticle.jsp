<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="./AccueilConnecter"> ENI-Enchères</a>
	</nav>
	<div class="container">
	<div class="jumbotron">
		<div class="d-flex justify-content-center">
			<h2>Vendre un article</h2>
		</div>
		<form action="VendreArticle" method="post" class="d-flex flex-column">
			<label for="nomArticle">Article</label> <input class="form-control" type="text"
				id="nomArticle" name="nomArticle" class="form-control" value="${nomArticle}" />
			<c:forEach items="${hasErrors}" var="entry">
				<c:if test="${entry.key == 'nom' && entry.value==true}">
					<div class="alert alert-danger">Le nom n'est pas valide</div>
				</c:if>
			</c:forEach>

			<label for="description">Description</label>
			<textarea class="form-control" type="text" id="description" name="description">${description}</textarea>
			<c:forEach items="${hasErrors}" var="entry">
				<c:if test="${entry.key == 'description' && entry.value==true}">
					<div class="alert alert-danger">La description n'est pas
						valide</div>
				</c:if>
			</c:forEach>


			<label for="categorie">Categorie</label> <select type="text"
				id="categorie" class="form-control" name="categorie">
				<option></option>

				<c:forEach items="${listeCategorie}" var="categorie">
					<c:choose>
						<c:when test="${categorie.libelle == categorieLibelle}">
							<option selected="selected">${categorie.libelle}</option>
						</c:when>
						<c:otherwise>
							<option>${categorie.libelle}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>



			</select>
			<c:forEach items="${hasErrors}" var="entry">
				<c:if test="${entry.key == 'categorieLibelle' && entry.value==true}">
					<div class="alert alert-danger">La catégorie n'est pas valide</div>
				</c:if>
			</c:forEach>

			<label for="buttonPhoto">Photo de l'article</label> <input 
				type="file" name="file" size="50" /><br>
				 <label
				for="prixDepart">Mise à prix</label> 
				<input class="form-control" class="form-control" id="prixDepart"
				name="prixDepart" type="number" value="${prixDepart }"/>

			<c:forEach items="${hasErrors}" var="entry">
				<c:if test="${entry.key == 'prixDepart' && entry.value==true}">
					<div class="alert alert-danger">Le prix de départ n'est pas
						valide</div>
				</c:if>
			</c:forEach>


			<label for="debutEnchere">Début de l'enchère</label> <input style = "width: 200px;" class="form-control"
				id="debutEnchere" name="debutEnchere" type="datetime-local" value="${debutEnchere}" > <label
				for="finEnchere">Fin de l'enchère</label> <input style = "width: 200px;" class="form-control" id="finEnchere"
				name="finEnchere" type="datetime-local"  value="${finEnchere}"/>

			<c:forEach items="${hasErrors}" var="entry">
					<c:if test="${entry.key == 'finEnchereString' && entry.value==true}">
						<div class="alert alert-danger">Les dates ne sont pas valide</div>
					</c:if>
				</c:forEach>



			<fieldset class="d-flex flex-column mt-3">
				<legend>Retrait</legend>

				<label for="rue">Rue</label> <input class="form-control" id="rue" name="rue" type="text" value="${rue}"/>
				<c:forEach items="${hasErrors}" var="entry">
					<c:if test="${entry.key == 'rue' && entry.value==true}">
						<div class="alert alert-danger">La rue n'est pas valide</div>
					</c:if>
				</c:forEach>
				<label for="cp">Code postal</label> <input class="form-control" id="cp" name="cp"
					type="text"  value="${cp}"/>
				<c:forEach items="${hasErrors}" var="entry">
					<c:if test="${entry.key == 'cp' && entry.value==true}">
						<div class="alert alert-danger">Le code postal n'est pas
							valide</div>
					</c:if>
				</c:forEach>

				<label for="ville">Ville</label> <input class="form-control" id="ville" name="ville"
					type="text"  value="${ville}"/>
				<c:forEach items="${hasErrors}" var="entry">
					<c:if test="${entry.key == 'ville' && entry.value==true}">
						<div class="alert alert-danger">La ville n'est pas valide</div>
					</c:if>
				</c:forEach>
			</fieldset>
			<div class="d-flex justify-content-around mt-5">
			
				<button class="btn btn-primary" type="submit">Enregistrer</button>
				<button class="btn btn-primary" type="submit" >Annuler</button>
				<button class="btn btn-primary" type="submit">Annuler la vente</button>
			
				
			</div>
		</form>	
	</div>
	</div>
</body>
</html>