<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name = "authen_form" action="/AuthorizationCodeServer/oauth/token" method="post">
	    <input type = "text" name = "client_id" value = "test"><br/>
	    <input type = "text" name = "client_secret" value = "secret"><br/>
	    <input type = "text" name = "redirect_uri" value = "http://localhost:8888/AuthorizationCodeServer/anonymous/home"><br/>
	    <input type = "text" name = "grant_type" value = "authorization_code"><br/>
	    <input type = "text" name = "code"><br/>
	    <input type = "submit" name = "btnAcess" value = "Click me">
	</form>
</body>
</html>