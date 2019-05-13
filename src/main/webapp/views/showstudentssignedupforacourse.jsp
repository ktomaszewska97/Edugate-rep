<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Users" %>
<%@ page import="edugate.demo.model.UserProfile" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>

                <h1 class="signup-title">Lista studentów zapisanych na kurs</h1>
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">First name</th>
                      <th scope="col">Last name</th>
                    </tr>
                  </thead>
                  <tbody>

                <%
                List<UserProfile> userProfiles = (List<UserProfile>)request.getAttribute("userProfilesList");   
				
				int idUserProfile = 0;
				
                if(userProfilesList != null){
                    for (UserProfile userProfile : userProfilesList)
                    { 
                    
                    idUserProfile = course.getIDUserProfile();
                    
                    %>

					
                     <tr>
                        <td><%= idUserProfile  %></td>
                        <td><%= course.getFirstName() %></td>
                        <td><%= course.getLastName() %></td>
                     </tr>
            
                <% }} %>
        </tbody>
    </table>
</body>
</html>

           