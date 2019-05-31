<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>


<html>
<head>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Home.css" rel="stylesheet">
</head>

<body>

<%@include file="header.jsp" %>
<%@include file="selectionbar.jsp" %>

<div class="row">
        
    <div class="col-3">
    <div class="ladder">

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
	</div><!--ladder-->
	</div> <!--Col9-->



<div class="col-7">
<div class="home-container">
                <div class="container">
                
                	<div class="paragraph">
          				<h2>Welcome to Edugate!</h2>
	            		<img class="imgDiploma" src="https://iv.pl/images/56595203293597956665.png"/>
        			</div>
        			
        			<div class="wrapper">
						<div class="divider div-transparent"></div>
					</div>
					
					<div class="paragraph">
					<p>We will make your college experience easier!</p>
					</div>
	
                </div>
</div>
</div><!--Col7-->
</div><!--Row-->

</body>
</html>

           