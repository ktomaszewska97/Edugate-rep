<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="edugate.demo.model.*" %>

<html>

<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/Profile.css" rel="stylesheet">
</head>
<style>
    b.p5{
        margin-left: 13px;
    }
    b.p10{
        margin-left: 26px;
    }
    b.p15{
        margin-left: 39px;
    }
    a.p0{
        margin-left: 18px;
    }
    a.p5{
        margin-left: 30px;
    }
    a.p10{
        margin-left: 43px;
    }
    a.p15{
        margin-left: 56px;
    }

</style>


<body>


<% School school=(School)request.getAttribute("currentUserSchool");
    List<Department> departmentList = (List<Department>)request.getAttribute("currentUserDepartment");
    List<FieldOfStudy> fieldOfStudyList = (List<FieldOfStudy>)request.getAttribute("currentUserFieldOfStudy");
    List<Course> courseList = (List<Course>)request.getAttribute("currentUserCourses");
    List<CourseRealization> courseRealizationList = (List<CourseRealization>)request.getAttribute("currentUserCourseRealizations");
    %>
<details>
    <summary><b>Uczelnia: </b><%=school.getName()%></summary>
    <a  class="p0" href="#" onclick="fetch(<%=school.getiDSchool()%>)">Przejdź</a>

   <%if(departmentList!=null){
    for(Department department:departmentList)
    {
        if(department.getIDSchool().equals(school.getiDSchool())){
        %>
    <details>
        <summary><b class="p5">Wydział: </b><%=department.getName()%></summary>
        <a class="p5" href="#" onclick="fetch(<%=school.getiDSchool()%>,<%=department.getiDDepartament()%>)">Przejdź</a>
        <% if(fieldOfStudyList!=null){
            for (FieldOfStudy fieldOfStudy : fieldOfStudyList)
            {
        if(fieldOfStudy.getIDDepartment().equals(department.getiDDepartament())){
                %>
        <details>
            <summary><b class="p10">Kierunek: </b><%=fieldOfStudy.getName()%></summary>
            <a class="p10" href="#" onclick="fetch(<%=school.getiDSchool()%>,<%=department.getiDDepartament()%>,<%=fieldOfStudy.getiDFieldOfStudy()%>)">Przejdź</a>
            <% if(courseList != null){
                for (Course course : courseList)
                {
                    if(course.getIDFieldOfStudy().equals(fieldOfStudy.getiDFieldOfStudy())){
                    %>
            <details>
                <summary><b class="p15">Kurs: </b><%=course.getName()%></summary>
                <a class="p15" href="#" onclick="fetch(<%=school.getiDSchool()%>,<%=department.getiDDepartament()%>,<%=fieldOfStudy.getiDFieldOfStudy()%>,<%=course.getiDCourse()%>)">Przejdź</a>
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