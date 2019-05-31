<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Course" %>
<%@ page import="edugate.demo.model.CourseRealization" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
<link href="/css/showallcourses.css" rel="stylesheet">
</head>
<body>

<%@include file="header.jsp" %>

<h1 class="signup-title">Lista kursów</h1>

<%
List<Course> coursesList = (List<Course>)request.getAttribute("coursesList");   
List<CourseRealization> courseRealizationsList = (List<CourseRealization>)request.getAttribute("courseRealizationsList");
        
  int idCourse = 0;
        
  if(coursesList != null){
    for (Course course : coursesList)
      { 
                    
  idCourse = course.getiDCourse();
                    
%>

<div>                   
<button class="collapsible"><b><%= course.getName() %></b></button>
<div class="content">
  <i><p>Kurs odbywa się na semestrze: <%= course.getSemester() %></p>
  <p>Opis kursu: 
  <%= course.getAbout() %></p></i>
  
  

  <%
   int idCourseRealization;
  
   for (CourseRealization courseRealization : courseRealizationsList){ 
	   
        if(courseRealization.getIdcourse()==idCourse) {
        	
        	idCourseRealization = courseRealization.getIdcourserealization();
      %>
      <p><%=idCourseRealization%> <%= course.getName() + ","%> <%=courseRealization.getNote()%> 
      <form method="post" action="courseView">
      <input name="IDCourseRealization" type="number" value="<%= idCourseRealization  %>" hidden>
      <input type="submit" class="btn btn-primary btn-outline" value="Select">
      </form>
      </p>
     <% }} %>

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

           