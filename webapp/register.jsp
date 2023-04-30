<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flyaway/register</title>
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
.error {
	color: red;
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
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a>
					</li>
					</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<h2 align="center">Customer Registration!!</h2>
	</div>
	<div class="container">
		
			
		<form action="userdetails" method="post">
          <div class="row">
				<div class="col-lg-6 col-lg-offset-3">
								

					<div class="form-group">
						<label for="customerEmailId">Enter Email Id:* </label> <input type="text"
							class="form-control" id="customerEmailId"
							placeholder="abc@eg.com" name="email">
					</div>
					<div class="form-group">
						<label for="password">Enter Password:* </label> <input type="password"
							class="form-control" id="password" placeholder="password"
							name="password">
					
					<label for="password">Confirm password:* </label> <input type="password"
							class="form-control" id="newpassword" placeholder=" confirm password"
							name="newpassword">
					</div>

					<div align="center">
						<input type="submit" class="btn btn-primary" value="Sign-up" />
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>