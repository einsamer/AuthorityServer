<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
    ${greeting }
    <h3>Login with Username and Password</h3>
    <form name='f' action='/Spring-OAuth2/oauth/token?grant_type=implicit&client_id=id&client_secret=secret' method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                    value="Login" /></td>
            </tr>
            
        </table>
        <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
    </form>
    YOU NEED TO LOGIN FIRST TO KEEP GOING ON!!!
    
</body>
</html>
