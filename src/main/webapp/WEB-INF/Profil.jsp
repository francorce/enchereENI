<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="header clearfix">
	<h3 class="text-muted">ENI - Enchère</h3>
    </div>
    	<div class="container"><h1 style="float: none;">Mon profil :</h1>      
      		<div class="jumbotron">
        		<ul class="list-group" style="">
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Pseudo :<input type="text" class="form-control" readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Nom :<input type="text" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Prénom:<input type="text" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">E-mail :<input type="text" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Téléphone :<input type="text" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Rue :<input type="text" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Code postal :<input type="text" class="form-control"readonly></li>
	              <li class="list-group-item" style="text-align: left; border-width: 0px;">Ville :<input type="text" class="form-control"readonly></li>
	          	</ul>
     		</div>
     		<form action="/enchereENI/">
     			<button type="submit" class="btn btn-primary" style="float: right;">Modifier</button></div>
     		</form>
     		
    	</div> <!-- /container -->
</body>
</html>