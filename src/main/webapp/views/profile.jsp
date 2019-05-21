<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Users" %>
<%@ page import="edugate.demo.model.UserProfile" %>
<html>

<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/Profile.css" rel="stylesheet">
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

    <% if(username==null) username="brak";%>
    <% if(userLastname==null) userLastname="brak";%>
    <% if(userEmail==null) userEmail="brak";%>




    <div class="profile-container">
        <div class="container">
            <div class="profile-info">

                

                <h2>Użytkownik <%=userId%></h2>
                <br>

                <div class="row">
                   <div class="col">
                    <h5>Szczegóły użytkownika</h5>
                    <b>Imię</b>
                    <p><%=username%></p>
                    <b>Nazwisko</b>
                    <p><%=userLastname%></p>
                    <b>Login</b>
                    <p><%=userLogin%></p>
                    <b>E-mail</b>
                    <p><%=userEmail%></p>
                       <b>Uczelnia</b>
                       <p><%=userSchool%></p>
                    <b></b>

                    <br>

                </div>
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
                        
                        

                    </div>
                   
                </div>




            </div>
        </div>
    </div>
    </div>
</body>

</html>