<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/views/include/style.jsp"%>
<title>AUTHORIZATION PAGE</title>
<style>
.main-container {

margin-top: 10%;
}
.main-content{
    border: 1px black solid;
}

.btn-author {
    width: 100%;
}
</style>
</head>
<body>
    <div class = "container main-container">
        <div class = "row">
            <div class = "col-md-3 left-content"></div>
            <div class = "col-md-6 main-content">
	            <h3>Do you authorize '${authorizationRequest.clientId}' to access your protected resources?</h3>
	            
	            <table width="100%">
	               <tr>
	                   <td>
	                       <form id='confirmationForm' name='confirmationForm' 
			                    action='${path}/oauth/authorize' method='post'>
			                    <input name='user_oauth_approval' value='true' type='hidden'/>
			                    <input class = "form-control btn btn-info btn-author" name='authorize' value='Authorize' type='submit'>
			                </form>
	                   </td>
	                </tr>
	                <tr>
	                   <td >
	                        <form id='denialForm' name='denialForm' action='${path}/oauth/authorize' method='post'>
			                    <input name='user_oauth_approval' value='false' type='hidden'/>
			                    <input class = "form-control btn btn-info btn-author" name='deny' value='Deny' type='submit'>
			                </form>
	                   </td>
	               </tr>
	            </table>
			    
			   
            
            </div>
            <div class = "col-md-3 right-content"></div>
        </div>
    </div>
    
    
</body>
</html>