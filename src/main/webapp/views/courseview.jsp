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
                            
							<div>
							<%= currentCourseRealization.getAbout() %>
							</div>
							
							<p>Prowadzący kursu:</p>
							
							<% if(lecturer == null) {
							%>
							<p>Brak przypisanego prowadzącego</p>
							<%
							}
							else {
							%>
							<p><%= lecturer.getFirstName() + " " + lecturer.getLastName()%></p>
							<%
							}
							%>
							
        					<form action="addlecturerview">
        					<button class="btn btn-outline-primary btn-md" type="submit">Dodaj</button>
        					</form>
        
        </div>
        
        <div class="container">
        	<div class="paragraph">
        		
        				<p>Oceń kurs</p>
                        <form action="addCourseEvaluation" method="post">
                        
                            <div class="form-group">
                                <input class="formsize" type="number" name="courseevaluation" class="form-control" placeholder="2-5"
                                    required min="2" max="5">
                            </div>
                            <div>
								<input type="text" name="idcourserealization" value="<%=currentCourseRealization.getIdcourserealization()%>" hidden>
							</div>
                            <div>
                                <button type="submit" class="btn btn-outline-primary btn-md">Oceń</button>
                            </div>
                        </form>
                        <p>Srednia ocena kursu:</p>
        
            </div>   
        </div>  

    <div class="wrapper">
		<div class="divider div-transparent"></div>
	</div>
        
    <div class="row">
        
        <div class="col-9">
 
                <p>Aktualności
                    <div>
                    <p>W tym miejscu będą pojawiały się najnowsze informacje, opublikowane przez prowadzącego.</p>
                    </div>
                </p>

		</div>
			
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

<div class="wrapper">
		<div class="divider div-transparent"></div>
</div>

<div class="row">
	<div class="col-9">
                
                    <div>

                        <%
                        Map<Comment, UserProfile> commentsAndUsers = (Map<Comment, UserProfile>)request.getAttribute("comments");
        
                        if(commentsAndUsers != null){
                        	
                        List<Comment> comments = new ArrayList<>(commentsAndUsers.keySet());
                        
                        
                        int listSize = comments.size();	
                        int counter = 0;
                        //comment.getIdcomment
                        
                          for (Comment comment : comments)
                          {                       	
                                  if(counter % 2 == 0) { 
                                  %>
                                <br>
                                <br>
                                <p class="commentLeft">
                        		<%=comment.getMessage()%>
                       		 	</p>

                                  <%
                                  }
                                  else {
                                  %>
                                <br>
                                <br>
                                <p class="commentRight">
                        		<%=comment.getMessage()%>
                       		 	</p>

                                 <%
                                  }
                                  
                                  %>

                        <% 
                        
                        counter++;
                              }
                                 } %>

                    </div> <!--DIV Comments-->
                    <div class="outer-form-comment">
                    <div class="form-comment">

					<form method="post" action="addcomment">
					
						<div>
							<input type="text" name="idCourseRealization" value="<%=currentCourseRealization.getIdcourserealization()%>" hidden>
						</div>
						
						<div class="form-item">
						<div>
							<textarea rows="10" class="form-control" name="message" placeholder="Comment" value=""></textarea>
						</div>
						</div>
						
						<input type="submit" class="btn btn-primary btn-outline" value="Dodaj">

                    </form>

                    </div>
                    </div>
    </div> <!--DIV Col9-->
                                       
 	<div class="col-3">   
    		<p>Pliki</p>
                <%
                List<File> fileList = (List<File>)request.getAttribute("fileList");

                if(fileList != null){
                  for (File file : fileList)
                  {
              %>
                        <button type="button" class="list-group-item list-group-item-action"><%= file.getTitle()%>
                        </button>

                        <% }} %>
            <a href=#>Plik 1</a>
            <br>
            <a href=#>Plik 2</a>
            <br>
            <a href=#>Plik 3</a>

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