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

    <div class="header clearfix">
        <h3 class="text-muted">ENI - Enchère</h3>
    </div>
    <div class="container">
      <div class="jumbotron">
        <div class="form-group" style="">
          <label style="float: left;">Identifiant :&nbsp;</label>
          <input type="text" class="form-control">
        </div>
        <div class="form-group" style="">
          <label style="float: left;">Mot de passe :&nbsp;</label>
          <input type="text" class="form-control">
        </div>
      <ul class="list-group" style="">
  <li class="list-group-item" style="background-color: rgb(233, 236, 239); border-width: 0px;">
    <button type="button" class="btn btn-primary" style="float: left;">Connexion</button>
    <br><br>
    <label class="checkbox" style="">
      <input type="checkbox">Se souvenir de moi&nbsp;
      <br>
      <a href="www.google.com">Mot de passe oublié</a>
    </label>
    </li>
  <li class="list-group-item" style="background-color: rgb(233, 236, 239); border-width: 0px;">
  <form action="/enchereENI/Inscription">
  <input type="submit" class="btn btn-primary" value="Créer un compte" style="float: left; text-align: left;"/>
  </form>
    </li>
    </ul>
      </div>    
</div>
</body>
</html>