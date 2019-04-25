<link rel="stylesheet" type="text/css" href="Signup.css">
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.School" %>
<html>
<head>
<title>Date JSP</title>
</head>
<body>

<%
School newSchool = (School)request.getAttribute("newSchool"); 
if(newSchool != null){ %>
	
	<script>
	  alert("Dodano szkołę <%= newSchool.getName() %>");
	</script>

<% 
	request.setAttribute("newSchool", null);

} %>


 <div class="signup-container">
                <div class="signup-content">
                    <h1 class="signup-title">Dodaj szkole wyzsza</h1>
           <form action="addSchool" method="post">
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
                <input type="text" name="description" 
                        class="form-control" placeholder="Description"
                        valuedescription="" onChange=""
                        maxLength="255" required/>
                </div>
                <div className="form-item">
                    <button type="submit" class="btn btn-block btn-primary">Przeslij</button>
                </div>
            </form>                    
            </div>
            </div>                   
</body>
</html>

           