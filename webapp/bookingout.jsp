<%@page import="flyaway.models.masterlist"%>
<%@page import="flyaway.models.reservation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 	 
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking-output</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>Booking successful</h1>
	<%
	  masterlist finfo = (masterlist) request.getAttribute("finfo");
	  String psgname = (String) request.getAttribute("psgname");
	  String seatnum = (String) request.getAttribute("seatnum");
	 
	  String email = (String)request.getAttribute("email");
	  
	  
	  
		
	%>
	<div class="container">
	<table class="table">
		<tr>
		                    <th>Flight ID</th>
							<th>Departure</th>
							<th>Destination</th>
							<th>Airline</th>
							<th>Airplane Type</th>
							<th>Fare</th>
							<th>Departure Day</th>
							<th>Departure Time</th>
		</tr>
		
			<tr>
				<td>${finfo.flightindex}</td>
				<td>${finfo.departure}</td>
				<td>${finfo.destination}</td>
				<td>${finfo.airlinename}</td>
				<td>${finfo.aircrafttype}</td>
				<td>${finfo.flightprice}</td>
				<td>${finfo.dday}</td>
				<td>${finfo.dhour}</td>
				</tr></table>
				
				
				<br><h1>Passenger Details</h1>;
				
				
				
				
				<table class="table">
		            <tr>
		                    <th>Passenger Name</th>
							<th>Seat Number</th>
				    </tr>
				
		  
				    
		               
			           <tr>
				           <td>${psgname}</td>
				           <td>${seatnum}</td></tr>
				       
				       </table>
			           
			           
			       
			               
			
				<br><a href=" index.html?email=${email}"> Book to Home page</a> 
				<br><a href="logout.jsp?email=${email}"> logout</a>
			
		
	
	</div>
</body>
</html>