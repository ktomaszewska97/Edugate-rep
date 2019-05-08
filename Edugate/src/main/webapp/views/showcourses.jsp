<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Course" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
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
                        <th scope="row"><%= idCourse  %></th>
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
</body>
</html>

           