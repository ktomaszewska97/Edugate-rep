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
       	int courseRealizationId = currentCourseRealization.getIdcourserealization();
       	double mean = (double)request.getAttribute("mean");
		boolean hasEvaluated = (boolean)request.getAttribute("hasEvaluated");
		
		NumberFormat formatter = new DecimalFormat("#0.00");     
       	
        %>
            <h3><%=currentCourse.getName()%></h3><br>
            				<h6>O kursie:</h6>
                            <h5><%= currentCourseRealization.getNote() %></h5>

							
							<p><h6>Prowadzący kursu:</h6></p>
							
							<% if(lecturer == null) {
							%>
							<p><h5>Brak przypisanego prowadzącego</h5></p>
							<%
							}
							else {
							%>
							<p><h5><%= lecturer.getFirstName() + " " + lecturer.getLastName()%></h5></p>
							<%
							}
							%>
							<br>
        					<form action="editcourseview">
        						<input type="number" name="idCourseRealization" value="<%=courseRealizationId%>" hidden>
        						<button class="btn btn-outline-primary btn-md" type="submit">Edytuj dane</button>
        					</form>
        					<br>
        
        
        
        <div class="container">
        	<div class="paragraph">
        	
        				<p>Średnia ocena tej realizacji kursu aktualnie wynosi: <b><%=formatter.format(mean)%></b></p>
						<br>
						<%if(!hasEvaluated){%>
        				<p>Chcesz coś zmienić? Oceń kurs!</p>
                        <form name="evaluationform" action="addcourseevaluation" method="post">
                        
                            <div class="form-group">
                                <input class="formsize" type="number" name="courseEvaluation" id= "courseevaluation" class="form-control" value="" hidden>
                            </div>
                            <div>
								<input type="number" name="idCourseRealization" value="<%=courseRealizationId%>" hidden>
							</div>
                        </form>
        
            </div>   
            	
            	
				<div class="rating">
				
				<span id="5" class="star" onclick="setgoldFive()">☆</span>
				<span id="4" class="star" onclick="setgoldFour()">☆</span>
				<span id="3" class="star" onclick="setgoldThree()">☆</span>
				<span id="2" class="star" onclick="setgoldTwo()">☆</span>
				<span id="1" class="star" onclick="setgoldOne()">☆</span>
					
				</div>
				<% }
					else{ %>
					
					<p>Dziękujemy za ocenę tego kursu!</p>
					
					<% } %>
			<script>
				function setgoldOne() {
					document.getElementById(1).style.color = "gold";
					document.getElementById('courseevaluation').value=1;
					var x = document.getElementsByName('evaluationform');
					x[0].submit();
					}
					
				function setgoldTwo() {
					document.getElementById(1).style.color = "gold";
					document.getElementById(2).style.color = "gold";
					document.getElementById('courseevaluation').value=2;
					var x = document.getElementsByName('evaluationform');
					x[0].submit();
					}
					
				function setgoldThree() {
					document.getElementById(1).style.color = "gold";
					document.getElementById(2).style.color = "gold";
					document.getElementById(3).style.color = "gold";
					document.getElementById('courseevaluation').value=3;
					var x = document.getElementsByName('evaluationform');
					x[0].submit();
					}
					
				function setgoldFour() {
					document.getElementById(1).style.color = "gold";
					document.getElementById(2).style.color = "gold";
					document.getElementById(3).style.color = "gold";
					document.getElementById(4).style.color = "gold";
					document.getElementById('courseevaluation').value=4;
					var x = document.getElementsByName('evaluationform');
					x[0].submit();
					}
					
				function setgoldFive() {
					document.getElementById(1).style.color = "gold";
					document.getElementById(2).style.color = "gold";
					document.getElementById(3).style.color = "gold";
					document.getElementById(4).style.color = "gold";
					document.getElementById(5).style.color = "gold";
					document.getElementById('courseevaluation').value=5;
					var x = document.getElementsByName('evaluationform');
					x[0].submit(); 
					}
			</script>

        </div>  

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
                        Collections.sort(comments);
                        Collections.reverse(comments);
                        
                        int listSize = comments.size();	
                        int counter = 0;
                        //comment.getIdcomment
                        UserProfile actualUser = null;
                        String userName = "";
                        String dateString = "";
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                     
                          for (Comment comment : comments){    
                        	  
                        	  actualUser = commentsAndUsers.get(comment);
                        	  userName = actualUser.getFirstName() +" "+actualUser.getLastName();
                        	  dateString = dateFormat.format(comment.getCreatedon());
                        	 
                                  if(counter % 2 == 0) { 
                                  %>

                                <br>
                                <p class="commentLeft">
  								<%=dateString%>
                                <b><%=userName%></b> 
                                <br>
                            	
                        		<%=comment.getMessage()%>
                       		 	</p>
                       		 	<br>
                       		 	
                                  <%
                                  }
                                  else {
                                  %>
                                <br>
                                <p class="commentRight">
                                <%=dateString%>
                                <b><%=userName%></b> 
                                <br>
                            	
                        		<%=comment.getMessage()%>
                       		 	</p>
                       		 	<br>

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