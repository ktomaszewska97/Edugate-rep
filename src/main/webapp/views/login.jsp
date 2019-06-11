<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/Login.css" rel="stylesheet">

</head>

<body>
<div class="login-container">
<div class="login-content">
<h1 class="login-title">Log in to Edugate</h2>
    <form method="POST" action="${contextPath}/login">
        

        <div class="form-group ${error != null ? 'has-error' : ''}">
        
            <span>${message}</span>
            
            <div class="divForInput">
             <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
                   </div>
            </div>
            
            <div class="divForInput">
             <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            </div>
            </div>
            
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            
            
            
            <span class="signup-link"><a href="${contextPath}/registration">Create an account</a></span4>
            
        </div>
    </form>
</div>
</div>

<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>