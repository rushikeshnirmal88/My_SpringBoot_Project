<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% String un=(String)session.getAttribute("username"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Customer</title>

<style type="text/css">

 .R
 {
 	width: 54%;
 	border: 1px solid grey;
 	margin: auto;
 	padding: 54px;
 	font-size: 27px;
 	 color: gold;
    background-color: red;
 	padding-right: 54px;
 	 font-family: "Gill Sans", sans-serif;

border-radius: 27px
 	
 }
 #myform table tr td  input
 {
 	font-size: 18px;
 	padding: 18px;
 width:100%;
 	 font-family: "Gill Sans", sans-serif;
 	 align-content: center;



 }
 .body
 {
 	background-color: cyan;
 }
 .H1
 {
 	text-align: center;
 }
 
 button 
{
    background-color: #030804;
    color: white;
    padding: 14px 20px;
    border-radius: 5px;
    margin: 1px;
    width: 100%;
    font-size: 18px;
    
 }

button:hover 
{
    opacity: 0.6;
    cursor: pointer;
}
</style>
</head>

<body class="body">

	<div class="R">
	<h1 style="color:white">Welcome! <%=un %></h1>
	<h1 class="H1">Find Customer</h1>
	<form id="myform"  action="searchServlet">
		
		<table >
			<tr>
				<td>Customer Name :</td>
				<td><input type="text" name="cname" placeholder="Enter Customer"></td>
			</tr>
			
				<td>Customer Mobile :</td>
				<td><input type="text" name="cmobile" placeholder="Enter Mobile"></td>
			</tr>
			<tr>
				<td><button type="submit">Search</button></td>
				
			</tr>
			<tr>
			<td> <a href="CoustomerRegistration.html">AddCustomer</a></td>
			</tr>

		</table>
		
	</form>
</div>
</body>


</html>