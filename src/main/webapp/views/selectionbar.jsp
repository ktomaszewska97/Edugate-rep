<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.*" %>

<html>

<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/Profile.css" rel="stylesheet">
</head>


<body>


<% School school=(School)request.getAttribute("currentUserSchool");
    List<Department> departmentList = (List<Department>)request.getAttribute("currentUserDepartment");
    List<FieldOfStudy> fieldOfStudyList = (List<FieldOfStudy>)request.getAttribute("currentUserFieldOfStudy");
    List<Course> courseList = (List<Course>)request.getAttribute("currentUserCourses");
    List<CourseRealization> courseRealizationList = (List<CourseRealization>)request.getAttribute("currentUserCourseRealizations");
    %>
<details>
    <summary><b>Uczelnia: </b><%=school.getName()%></summary>
    <a  onclick="fetch(<%=school.getIDSchool()%>)">Przejdź</a>

   <%if(departmentList!=null){
    for(Department department:departmentList)
    {
        if(department.getIDSchool().equals(school.getIDSchool())){
        %>
    <details>
        <summary><b>Wydział: </b><%=department.getName()%></summary>
        <a  onclick="fetch(<%=school.getIDSchool()%>,<%=department.getIdDepartament()%>)">Przejdź</a>
        <% if(fieldOfStudyList!=null){
            for (FieldOfStudy fieldOfStudy : fieldOfStudyList)
            {
        if(fieldOfStudy.getIDDepartment().equals(department.getIdDepartament())){
                %>
        <details>
            <summary><b>Kierunek: </b><%=fieldOfStudy.getName()%></summary>
            <a  onclick="fetch(<%=school.getIDSchool()%>,<%=department.getIdDepartament()%>,<%=fieldOfStudy.getIDFieldOfStudy()%>)">Przejdź</a>
            <% if(courseList != null){
                for (Course course : courseList)
                {
                    if(course.getIDFieldOfStudy().equals(fieldOfStudy.getIDFieldOfStudy())){
                    %>
            <details>
                <summary><b>Kurs: </b><%=course.getName()%></summary>
                <a onclick="fetch(<%=school.getIDSchool()%>,<%=department.getIdDepartament()%>,<%=fieldOfStudy.getIDFieldOfStudy()%>,<%=course.getIDCourse()%>)">Przejdź</a>
            </details>
            <%}}}%>
        </details>
        <%}}}%>
    </details>
    <% }}}else{ %>
    <p>lista wydziałów jest pusta</p>
    <%}%>
</details>




</body>

</html>