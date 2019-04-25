<link rel="stylesheet" type="text/css" href="Signup.css">
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<title>Date JSP</title>
</head>
<body>

 <div class="signup-container">
                <div class="signup-content">
                    <h1 class="signup-title">Dodaj wydzial</h1>
           <form onSubmit="">
                <div class="form-item">
                    <input type="text" name="name" 
                        class="form-control" placeholder="Name" 
                        value="" onChange="" required/>
                </div>
                <div class="form-item">
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

           