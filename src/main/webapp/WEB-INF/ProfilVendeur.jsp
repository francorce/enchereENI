<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<div class="header clearfix">
	<a class="navbar-brand" href="./AccueilConnecter"> ENI-Enchères</a>
    </div>
    	<div class="container"><h1 style="float: none;">Profil :</h1>      
      		<div class="jumbotron">
        		<ul class="list-group" style="">
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Pseudo :<input type="text" value="${user.pseudo}" class="form-control" readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Nom :<input type="text" value="${user.nom}" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Prénom:<input type="text" value="${user.prenom}" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">E-mail :<input type="text" value="${user.email}" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Téléphone :<input type="text" value="${user.telephone}" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Rue :<input type="text" value="${user.rue}" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Code postal :<input type="text" value="${user.cp}" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Ville :<input type="text" value="${user.ville}" class="form-control"readonly></li>
	          	</ul>
     		</div>
     		
    	</div> <!-- /container -->
</body>
</html>