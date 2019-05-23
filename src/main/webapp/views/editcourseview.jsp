<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Course" %>
<%@ page import="edugate.demo.model.Comment" %>
<%@ page import="edugate.demo.model.CourseRealization" %>
<%@ page import="edugate.demo.model.File" %>
<%@ page import="edugate.demo.model.Users" %>
<%@ page import="edugate.demo.model.UserProfile" %>
<html>

<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/Signup.css" rel="stylesheet">
    <link href="/css/courseview.css" rel="stylesheet">
</head>

<body>

    <%@include file="header.jsp" %>

    <div class="padding">

        <div class="signup-container">
        
        <%
        CourseRealization currentCourseRealization = (CourseRealization)request.getAttribute("currentCourseRealization");
       	Course currentCourse = (Course)request.getAttribute("currentCourse");
       	UserProfile lecturer = (UserProfile)request.getAttribute("lecturer");
       	
        %>
            <h3><%=currentCourse.getName()%></h3>
                            <h5>O kursie</h5>

              <form method="post" action="addlecturer">
               <div class="form-group">
                    <textarea type="text" name="name" 
                        class="form-control" placeholder="" 
                        value="<%= currentCourseRealization.getAbout() %>"/>
                </div>
							
							<p>Prowadzący kursu:</p>
							
							<% if(lecturer == null) {
							%>
							<p>Brak przypisanego prowadzącego!</p>
							<%
							}
							else {
							%>
							<p><%= lecturer.getFirstName() + " " + lecturer.getLastName()%></p>
							<%
							}
							%>

              <input list="lecturers" name="idLecturer">
              <datalist id="lecturers">
              <%
              for (Users lecturer : lecturers){ 
                                     
              UserProfile userProfile = usersAndProfiles.get(lecturer);
              %>
              <option value="<%= lecturer.getIduser() %>" label="<%=userProfile.getFirstName() +" "+ userProfile.getLastName()%>">
              <% } %>
              </datalist>
              <input name="idCourseRealization" type="number" value="<%=courseRealization.getIdcourserealization() %>" hidden>
              <input type="submit" class="btn btn-primary btn-outline" value="Sele">
        
        
       
    </div> <!--Signup Container-->

    <div class="wrapper">
		<div class="divider div-transparent"></div>
	</div>
        
    <div class="row">
        
        <div class="col-9">
 
                <p>Aktualności
                    <div>
                    <p>W tym miejscu będą pojawiały się najnowsze informacje, opublikowane przez prowadzącego.</p>
                    </div>
                    <div class="form-group">
                    <textarea type="text" name="name" 
                        class="form-control" placeholder="" 
                        value="<%= currentCourseRealization.getAbout() %>"/>
                    </div>
                </p>
		</div>
	</form>
  
		<div class="col-3">

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
	                Map<Users, UserProfile> usersAndProfiles = (Map<Users, UserProfile>)request.getAttribute("users");  
					
	                if(usersAndProfiles != null){
	                	
	                	List<Users> students = new ArrayList<>(usersAndProfiles.keySet());
	                	UserProfile studentProfile= null;
	                	
	                    for (Users student : students){ 
              				
	                    	studentProfile = usersAndProfiles.get(student);
	                    %>

	                     <tr>
	                        <td><%= student.getIduser()  %></td>
	                        <td><%= studentProfile.getFirstName() %></td>
	                        <td><%= studentProfile.getLastName() %></td>
	                     </tr>
	            
	                <% }} %>
	        		</tbody>
    			</table>
    	</div> <!--DIV Col3-->
	</div> <!--DIV ROW-->
</div>  <!--DIV PADDING-->     
                
    <script>
        function goBack() {
            window.history.back();
        }
    </script>



</body>

</html>