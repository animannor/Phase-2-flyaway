<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flyaway/home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="about.html">Flyaway</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
					</li>
					
					 <%
	              
					String email = (String) session.getAttribute("email");
					 
					 if(email!=null)
					   {
						 out.println("<li class=nav-item><a class=nav-link href=logout.jsp>Logout</a></li>");
					   }
	                
	                %>
					
					
				</ul>
			</div>
		</div>
	</nav>
	
	             
	
	
	<div class="container">
	
	              
	            	
	        <%
	              
					 if(email!=null)
					   
						 out.println("<h3>"+ email + "  welcome to flyaway.com </h3>");
					   
					 else
						 out.println(" <h3>Welcome to flyaway.com </h3>");
	                %>     	   
	            	
	               
		<br ><br />
               <br> <h2>We guarantee affordable flights bookings at your comfort  </h2><br />

		

		<h3> Search available flights</h3>
		<form action="search" method="post">
			<input type="text" placeholder="Enter departure" name="departure" /><br />
			<input type=hidden id= email name= email value=<%=email %>>
			<br /> <input type="text" placeholder="Enter destination" name="destination" /><br />
			<br /> <input type="Text" placeholder="Day eg: dd:mm:yyyy"name="dday" /><br /> <br /> <input type="submit" /><br />
		</form>

		
	</div>
</body>
</html>