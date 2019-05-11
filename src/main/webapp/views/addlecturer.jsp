<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.CourseRealization" %>
<%@ page import="edugate.demo.model.Users" %>

<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>

<%
String confirmation = (String)request.getAttribute("confirmation"); 
if(confirmation != null){ %>
	
	<script>
	  alert("<%= confirmation %>");
	</script>

<% 
	request.setAttribute("newSchool", null);

} %>
                <h1 class="signup-title">Wybierz prowadzącego do zapisania:</h1>
                 <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Name</th>
                      <th scope="col">Year</th>
                      <th scope="col">Note</th>
                      <th scope="col">About</th>
                    </tr>
                  </thead>
                  <tbody>

                <%
                Map<CourseRealization, String> mapOfCourseRealizations = (Map<CourseRealization, String>)request.getAttribute("courseRealizations");        
				
				***NIE MA TEJ METODY- TRZEBA PODŁACZYC***
				List<Users> lecturersList = (List<Users>)request.getAttribute("lecturerList");
				
                if(mapOfCourseRealizations != null){
                	
                	Set<CourseRealization> courseRealizations = mapOfCourseRealizations.keySet(); 
                	
                    for (CourseRealization courseRealization : courseRealizations)
                    { 
                    %>

                    <tr>
                        <th scope="row"><%= courseRealization.getIdcourserealization() %></th>
						<td><%= mapOfCourseRealizations.get(courseRealization) %></td>
                        <td><%= courseRealization.getYear() %></td>
                        <td><%= courseRealization.getNote() %></td>
                        <td><%= courseRealization.getAbout() %></td>
                        <td> 
                        		<form method="post" action="AKCJA NA DODAWANIE WYKŁADOWCY">
          
                                   <datalist id="lecturerList">
                                   <%
                                   for (Users user: usersList)
				                    { 
				                    %>
    							   <option value="<%= user.getId() %>" label="<%=userProfile.getFirstName() +" "+ userProfile.getLastName()%>">
    							   <% } %>
  								   </datalist>
                                   <input type="submit" class="btn btn-primary btn-outline" value="Select">
                                   
                                </form> </td>
                    </tr>
                    <% }} %>     
                </tbody>
            </table>
</body>
</html>

           