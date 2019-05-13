<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>
 <div class="signup-container">
                <div class="signup-content">
                    <h1 class="signup-title">Dodaj wydzial</h1>
           <form onSubmit="">
                <div class="form-group">
                    <input type="text" name="name" 
                        class="form-control" placeholder="Name" 
                        value="" onChange="" required/>
                </div>
                <div class="form-group">
                <input type="text" name="about" 
                        class="form-control" placeholder="About"
                        valueabout="" onChange=""
                        maxLength="255" required/>
                </div>
                <div class="form-item">
                    <button type="submit" class="btn btn-block btn-primary">Przeslij</button>
                </div>
            </form> 
            </div>
            </div>                   
</body>
</html>

           