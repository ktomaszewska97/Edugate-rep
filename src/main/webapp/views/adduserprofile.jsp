<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.School" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
</head>
<body>

<%@include file="header.jsp" %>

 <div class="signup-container">
                <div class="signup-content">
                    <h1 class="signup-title">Uzupełnij swoje dane</h1>
           <form action="createuserprofile" method="post">

                <div class="form-group">
                    <input type="text" name="firstName" 
                        class="form-control" placeholder="Imię" 
                        value="" required/>
                </div>
                <div class="form-group">
                    <input type="text" name="lastName" 
                        class="form-control" placeholder="Nazwisko" 
                        value="" required/>
                </div>
                <div class="form-group">
                <p>Jesteś:</p>
                	<input type="radio" name="gender" value="m" checked> Mężczyzną<br>
                	<input type="radio" name="gender" value="k"> Kobietą<br>
                </div>
                <div class="form-group">
                <p>Powiedz nam coś o sobie:</p>
                <textarea type="text" name="about" 
                        class="form-control" placeholder="Powiedz nam coś o sobie!"
                        valueabout=""
                        maxLength="255" required/>
                </textarea>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-block btn-primary">Zapisz</button>
                </div>
            </form>                    
            </div>
            </div>                   
</body>
</html>
           