<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.CourseRealization" %>
<%@ page import="edugate.demo.model.Users" %>
<%@ page import="edugate.demo.model.UserProfile" %>

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
			
				Map<Users, UserProfile> usersAndProfiles = (Map<Users, UserProfile>)request.getAttribute("lecturers");        
				
                if(mapOfCourseRealizations != null){
                	
                	Set<CourseRealization> courseRealizations = mapOfCourseRealizations.keySet();
//                	Set<Users> lecturers = usersAndProfiles.keySet();
					List<Users> lecturers = new ArrayList<>(usersAndProfiles.keySet());
                	
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
                        		<form method="post" action="addlecturer">
          							
          						   <input list="lecturers" name="idLecturer">
                                   <datalist id="lecturers">
                                   <%
                                   for (Users lecturer : lecturers){ 
                                	   
                                	   UserProfile userProfile = usersAndProfiles.get(lecturer);
				                    %>
    							   <option value="<%= lecturer.getIduser() %>" label="<%=userProfile.getFirstName() +" "+ userProfile.getLastName()%>">
    							   <% } %>
  								   </datalist>
  								   <input name="idCourseRealization" type="number" value="<%= courseRealization.getIdcourserealization() %>" hidden>
                                   <input type="submit" class="btn btn-primary btn-outline" value="Select">
                                   
                                </form> </td>
                    </tr>
                    <% }} %>     
                </tbody>
            </table>
</body>
</html>

           