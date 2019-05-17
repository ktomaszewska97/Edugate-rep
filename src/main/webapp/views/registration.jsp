<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/Login.css" rel="stylesheet">
	
</head>

<body>

<div class="login-container">
<div class="login-content">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
    
        <h1 class="login-title">Create your account</h1>
        
        <spring:bind path="login">
            <div class="divForInput ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="login" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="login"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="divForInput ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="divForInput ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>
</div>

<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>