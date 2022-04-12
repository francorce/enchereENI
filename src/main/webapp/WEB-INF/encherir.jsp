<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${article.nomArticle}
	<form action="encherir" method="post">
		<input type="number" value="${prix}" id="montantEnchere"
			name="montantEnchere" /> <input type="hidden"
			value="${article.noArticle}" id="no_article" name="no_article" />
		<button type="submit">Enchérir</button>
	</form>

</body>
</html>