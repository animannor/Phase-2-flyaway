<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 	 
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flyaway/Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<style>
	.error{
		color:red;
	}
	</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Flyaway</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<%
					String email = (String) session.getAttribute("email");
					if (email == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
					</li>
					
				   
					<%
					}
					if (email != null) 
					  {
					  %>
					  <li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a>
					 <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div>
			<div class="wrapper fadeInDown">
				<div id="formContent">
					<div class="fadeIn first">
					<%-- <%
					
					if (email == null) {
						
						<h2 class='sign'>login In</h2>
						out.println("kindly sign-in to continue");
						<br><h3>kindly sign-in to continue <h3>
						<br><h3 Or sign-up for new user"<h3>
						
					}
					%> --%>
					
					
						<h2 class='sign'>login In</h2>
					</div>
					<form action="userdetails" method="get">
					<label for="name">Enter email</label><br>  
                        <input type="text" id="name" name="email"><br>  
                        <label for="password">Enter Password</label><br>  
                         <input type="Password" id="password" name="password"><br>  
                         <input type="submit" value="submit">  
                     </form>
					<%
						String error = request.getParameter("error");
					if(error !=  null){
					%>
					<div class="error"><%= error %></div>
					<%} %>
				</div>
			</div>
		</div>
	</div>

</body>
</html>