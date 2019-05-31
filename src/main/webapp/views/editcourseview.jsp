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
       	Users currentLecturer = (Users)request.getAttribute("lecturer");
       	
       	Map<Users, UserProfile> lecturersProfiles = (Map<Users, UserProfile>)request.getAttribute("lecturers");
       	List<Users> lecturers = new ArrayList<>(lecturersProfiles.keySet());
       	
       	UserProfile currentLecturerProfile = lecturersProfiles.get(currentLecturer);
       	
       	Map<Users, UserProfile> studentsProfiles = (Map<Users, UserProfile>)request.getAttribute("students");
       	
        %>
            <h3><%=currentCourse.getName()%></h3><br>
                            <h6>O kursie:</h6>

              <form method="post" action="editcourse">
               <div class="form-group">
                    <textarea type="text" name="note" 
                        class="form-control" placeholder=""/>
                        <%= currentCourseRealization.getNote() %>
                    </textarea>
                </div>
							
							<p><h6>Aktualny prowadzący kursu:</h6></p>
							
							<% if(currentLecturer == null) {
							%>
							<p>Brak przypisanego prowadzącego!</p>
							<%
							}
							else {
							%>
							<p><%= currentLecturerProfile.getFirstName() + " " + currentLecturerProfile.getLastName()%></p>
							<%
							}
							%>

              <input list="lecturers" name="lecturer" value="<%=currentLecturer.getIduser() + " " + currentLecturerProfile.getFirstName() + " " + currentLecturerProfile.getLastName()%>">
              <datalist id="lecturers">
              <%
              UserProfile userProfile;
              
              for (Users lecturer : lecturers){ 
                                     
              userProfile = lecturersProfiles.get(lecturer);
              %>
              <option value="<%= lecturer.getIduser() + " " + userProfile.getFirstName() +" "+ userProfile.getLastName()%>" label="<%=userProfile.getFirstName() +" "+ userProfile.getLastName()%>">
              <% } %>
              </datalist>
              <input name="idCourseRealization" type="number" value="<%=currentCourseRealization.getIdcourserealization() %>" hidden>        
       
    </div> <!--Signup Container-->

    <div class="wrapper">
		<div class="divider div-transparent"></div>
	</div>
        
    <div class="row">
        
        <div class="col-9">
 
                <p><h5>Aktualności</h5>
                    <div>
                    <p>W tym miejscu będą pojawiały się najnowsze informacje, opublikowane przez prowadzącego.</p>
                    </div>
                    <div class="form-group">
                    <textarea type="text" name="news" 
                        class="form-control" placeholder="" />
                    </textarea>
                    </div>
                </p>			
                	
                    <input type="submit" class="btn btn-primary btn-outline" value="Zapisz">
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
	               if(studentsProfiles != null){
	                	
	                	List<Users> students = new ArrayList<>(studentsProfiles.keySet());
	                	UserProfile studentProfile= null;
	                	
	                    for (Users student : students){ 
              				
	                    	studentProfile = studentsProfiles.get(student);
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