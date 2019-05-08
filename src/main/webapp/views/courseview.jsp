<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.Course" %>
<%@ page import="edugate.demo.model.Comment" %>
<%@ page import="edugate.demo.model.File" %>
<%@ page import="edugate.demo.model.UserProfile" %>
<html>

<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/Signup.css" rel="stylesheet">
</head>

<body>
    <%@include file="header.jsp" %>

    <div class="padding">


        <div class="signup-container">
            <br>
            <p>Skrócna ścieżka do tego kursu</p>
        </div>
        <button onClick="goBack()">Back</button>
        <div class="signup-container">
            <h1 class="signup-title">Nazwa kursu</h1>

        </div>
        <div class="row">
            <div class="col-10">

                <p>Opis kursu
                    <br> bla
                    <br> bla
                </p>
                <br>
 
                <p>Aktualności
                    <br> bla
                    <br> blaaaa
                </p>
                <br>

                <div class="row">

                    <div class="col">
                        <p>Oceń kurs</p>
                        <form action="addCourseEvaluation">

                            <div class="form-group">
                                <input type="number" name="courseevaluation" class="form-control" placeholder="2-5"
                                    required min="2" max="5">
                            </div>

                            <div class="form-item">
                                <button type="submit" class="btn btn-block btn-primary">Oceń</button>
                            </div>
                        </form>
                    </div>
                    <div class="col"></div>
                    <div class="col">
                        <p>Srednia ocena kursu:x</p>
                    </div>
                    <div class="col"></div>
                    <div class="col"></div>

                </div>
                <br>

                <p>Komentarze:</p>
                <div style="overflow-y: scroll; height: 400px;">
                    <div class="list-group">

                        <%
                        List<Comment> commentList = (List<Comment>)request.getAttribute("commentList");
                        List<UserProfile> userProfileList = (List<UserProfile>)request.getAttribute("userProfileList");
                        int currentCourseRealization = (int)request.getAttribute("currentCourseRealization");
                        String name="";
        
                        if(commentList != null){
                          for (Comment comment : commentList)
                          {
                              if(comment.getIdCourseRealization==currentCourseRealization){ 
                                  for(UserProfile user: userProfileList){
                                      if(comment.getIduser==user.getIDUser){
                                          name=user.getFirstName+" "+user.getLastName;
                                      }
                                  }%>

                        <p><%=name+" "+comment.getMessage()%>
                        </p>

                        <%
                              }
                                 }} %>


                        <!--<p>kom1sdfgh</p>
                        <p>komsdfg1</p>
                        <p>komsdfg1</p>
                        <p>kosdfgm1</p>
                        <p>kosdfgm1</p>
                        <p>kosdfghm1</p>
                        <p>ksdfgom1</p>
                        <p>ksdfgom1</p>
                        <p>kosdfgm1</p>
                        <p>ksdfgom1</p>
                        <p>kosdfgm1</p>
                        <p>kosdfm1</p>
                        <p>kosdfghm1</p>-->>





                    </div>
                </div>

            </div>

            <div class="col">

                <p class="signup-container">Pliki</p>
                <div style="overflow-y: scroll; height:400px;">
                    <div class="list-group">

                        <%
                List<File> fileList = (List<File>)request.getAttribute("fileList");

                if(fileList != null){
                  for (File file : fileList)
                  {
              %>
                        <button type="button" class="list-group-item list-group-item-action"><%= file.getTitle()%>
                        </button>

                        <% }} %>
                        
                        <!--<p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>
                        <p>Plik1</p>-->




                    </div>
                </div>
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