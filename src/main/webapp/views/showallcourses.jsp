<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Course" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
<link href="/css/showallcourses.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>

                <h1 class="signup-title">Lista kursów</h1>
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Name</th>
                      <th scope="col">Semester</th>
                      <th scope="col">About</th>
                      <th scope="col">Wybór</th>
                    </tr>
                  </thead>
                  <tbody>

                <%
                List<Course> coursesList = (List<Course>)request.getAttribute("coursesList");   
				
				        int idCourse = 0;
				
                if(coursesList != null){
                    for (Course course : coursesList)
                    { 
                    
                    idCourse = course.getIDCourse();
                    
                    %>

					
                     <tr>
                        <td><%= idCourse  %></td>
                        <td><%= course.getName() %></td>
                        <td><%= course.getSemester() %></td>
                        <td><%= course.getAbout() %></td>
                        <td><form method="post" action="courseView">
                        	<input name="IDCourseRealization" type="number" value="<%= idCourse  %>" hidden>
                        	<input type="submit" class="btn btn-primary btn-outline" value="Select">
                        	</form> </td>
                     </tr>
            
                <% }} %>
        </tbody>
    </table>

<%
                List<Course> coursesList2 = (List<Course>)request.getAttribute("coursesList");   
        
                int idCourse2 = 0;
        
                if(coursesList2 != null){
                    for (Course course : coursesList2)
                    { 
                    
                    idCourse2 = course.getIDCourse();
                    
                    %>
<div>                   
<button class="collapsible"><%= course.getName() %></button>
<div class="content">
  <p>Kurs odbywa się na semestrze: </p>
  <%= course.getSemester() %>
  <br>
  <p>Opis kursu: </p>
  <br>
  <%= course.getAbout() %>
</div>

<% }} %>
</div>

<script>
  
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
  
</script>


</body>
</html>

           