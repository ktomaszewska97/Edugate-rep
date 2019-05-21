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
    <summary><%=school.getName()%></summary>

   <%if(departmentList!=null){
    for(Department department:departmentList)
    {
        %>
    <details>
        <summary><%=department.getName()%></summary>
        <% if(fieldOfStudyList!=null){
            for (FieldOfStudy fieldOfStudy : fieldOfStudyList)
            {%>
        <details>
            <summary> <%=fieldOfStudy.getName()%></summary>
            <% if(courseList != null){
                for (Course course : courseList)
                {%>
            <details>
                <summary><%=course.getName()%></summary>
            </details>
        </details>
    </details>
    <% }}}}}}else{ %>
    <p>lista wydziałów jest pusta</p>
    <%}%>
</details>
<br><br><br>
<details>
    <summary>szkola</summary>

    <%
        for(int i=0;i<3;i++)
        {
    %>
    <details>
        <summary>wydz</summary>
        <%
            for(int j=0;j<3;j++)
            {%>
        <details>
            <summary>kierunek</summary>
            <% for(int k=0;k<3;k++)
                {%>
            <details>
                <summary>kurs</summary>
            </details>
        </details>
    </details>
    <% }}}%>
</details>










</body>

</html>