<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Home.css" rel="stylesheet">

	<style>

		div.w30 {

			width: 20%;
		}
		div.w70 {

			width: 80%;
		}
	</style>
</head>
<body>

<div>



	<%@include file="header.jsp" %>



	<div class="row">
	<div class="w30">
			<%@include file="selectionbar.jsp" %>
	</div>
	<div class="w70">
				<div class="container">
					<div className="home-container">
						<div className="container">
							<div>
								<h2></h2>
								<a href="courseLink"> Dodaj kurs </a>
								<a href="schoolLink">Dodaj szkołę</a>
								<a href="departmentLink">Dodaj wydział</a>
								<a href="profileLink">Profil</a>
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

           