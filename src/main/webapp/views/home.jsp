<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
	<script>
		function fetch(...restArgs){

			var request = new XMLHttpRequest();

			request.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					var response = this.responseText;
					//var fields = JSON.parse(response);
					//var nazwisko = fields["nazwisko"];
					//console.log(fields);
					document.getElementById("opis").innerText=response;
				}
			};
			//document.getElementById("login").value="abc2";

			if(restArgs.length === 1){
				request.open("GET","/home/"+restArgs[0]+"/-1/-1/-1");
				request.send()
			}
			if(restArgs.length === 2){
				request.open("GET","/home/"+restArgs[0]+"/"+restArgs[1]+"/-1/-1");
				request.send()
			}
			if(restArgs.length === 3){
				request.open("GET","/home/"+restArgs[0]+"/"+restArgs[1]+"/"+restArgs[2]+"/-1");
				request.send()
			}
			if(restArgs.length === 4){
				request.open("GET","/home/"+restArgs[0]+"/"+restArgs[1]+"/"+restArgs[2]+"/"+restArgs[3]);
				request.send()
			}

		}



	</script>

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
<p id="opis"> OPIS</p>
</body>
</html>

           