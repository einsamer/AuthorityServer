<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN PAGE</title>
</head>
<body>
	<label id = "login">
		<img src = '<c:url value = "/resources/images/login_button.png">
		</c:url>' width = "80px" height="80px"/>
	</label>
	<div id = "login-load-form">
	
	</div>
	<button id = "login-button">LOGIN FORM</button>
</body>
</html>