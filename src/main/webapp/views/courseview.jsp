<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Course" %>
<%@ page import="edugate.demo.model.Comment" %>
<%@ page import="edugate.demo.model.CourseRealization" %>
<%@ page import="edugate.demo.model.File" %>
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
       	String name= (String)request.getAttribute("currentCourseName");
        %>
            <h3><%=name%></h3>
                            <h5>O kursie</h5>
                            
							<div>
							<%= currentCourseRealization.getAbout() %>
							</div>
        
        </div>
        
        			<div class="container">
        				<div class="paragraph">
        				
        				<p>Oceń kurs</p>
                        <form action="addCourseEvaluation">
                        
                            <div class="form-group">
                                <input class="formsize" type="number" name="courseevaluation" class="form-control" placeholder="2-5"
                                    required min="2" max="5">
                            </div>

                            <div>
                                <button type="submit" class="btn btn-outline-primary btn-md">Oceń</button>
                            </div>
                        </form>
                        <p>Srednia ocena kursu:x</p>
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
                        
                </div>
          </div>

				<div>
                <p>Komentarze:</p>
                
                    <div class="list-group">

                        <%
                        List<Comment> commentList = (List<Comment>)request.getAttribute("commentList");
                        List<UserProfile> userProfileList = (List<UserProfile>)request.getAttribute("userProfileList");
                        String userName="";
        
                        if(commentList != null){
                          for (Comment comment : commentList)
                          {
                              if(comment.getIdcourserealization()==currentCourseRealization.getIdcourserealization()){ 
                                  for(UserProfile user: userProfileList){
                                      if(comment.getIduser()==user.getIDUserProfile()){
                                      
                                          userName=user.getFirstName()+" "+user.getLastName();
                                      }
                                  }%>

                        <p class="comment"><%=userName+" "+comment.getMessage()%>
                        </p>

                        <%
                              }
                                 }} %>

                    </div>
                    
                </div> 
                    
    </div>


    <script>
        function goBack() {
            window.history.back();
        }
    </script>


</body>

</html>