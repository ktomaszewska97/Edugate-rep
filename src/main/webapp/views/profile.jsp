<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Users" %>
<%@ page import="edugate.demo.model.UserProfile" %>
<%@ page import="edugate.demo.model.Department" %>
<html>

<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/Profile.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/style.css">
</head>


<body>
    <%@include file="header.jsp" %>
    <% String userLogin=(String)request.getAttribute("currentUserLogin");%>
    <% int userId=(int)request.getAttribute("currentUserId");%>
    <% String userEmail=(String)request.getAttribute("currentUserEmail");%>
    <% String username=(String)request.getAttribute("currentUserName");%>
    <% String userLastname=(String)request.getAttribute("currentUserLastname");%>
    <% String userSchool=(String)request.getAttribute("currentUserSchool");%>
    <% List<String> userCourses=(List<String> )request.getAttribute("currentUserCourses");%>
    <% List<Department> departments=(List<Department> )request.getAttribute("currentUserDepartment");%>

    <% if(username==null) username="brak";%>
    <% if(userLastname==null) userLastname="brak";%>
    <% if(userEmail==null) userEmail="brak";%>
    
<div class="container">
  <div class="avatar-flip">
    <img src="http://media.idownloadblog.com/wp-content/uploads/2012/04/Phil-Schiller-headshot-e1362692403868.jpg" height="150" width="150">
    <img src="http://i1112.photobucket.com/albums/k497/animalsbeingdicks/abd-3-12-2015.gif~original" height="150" width="150">
  </div>
  <% String titleName=username + " " + userLastname; %>
  <h2><%=titleName%> </h2>
  <h4><%=userEmail%></h4>
  <h4><%=userEmail%></h4>
  <h5><%=userSchool%></h5>
  
  <p>Jestem wykładowcą od 15 lat. Jeżeli chcesz się ze mną skontaktować, proszę, napisz email.</p>
  
  
   <div class="col">
                           <h5>Realizowane kursy</h5>
                           <% if(!userCourses.isEmpty()){
                               for (String ucr: userCourses) {

                           %>
                                   <p><%=ucr%></p>
                           <%
                               }

                               }%>
	</div> 
                       
</div>

</body>

</html>