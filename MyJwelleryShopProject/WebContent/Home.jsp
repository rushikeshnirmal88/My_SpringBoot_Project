<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String un=(String)session.getAttribute("username"); %>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="Home.css">
</head>
<body bgcolor="Orange">
 

<div class="div">
<h1 style="color:white">Welcome! <%=un %></h1>
<form >
   
   <a href="search.jsp"><button type="button">GenerateBill</button></a>
   <a href="Inventory.jsp"><button type="button">Inventory</button></a>
  
   <a href="RateGold.jsp"><button type="button">GoldRate</button></a>
 <a href="RateSilver.jsp"><button type="button">SilverRate</button></a>
 <a href="CoustomerRegistration.jsp"><button type="button">Add Customer</button></a>
 <a href="InventoryView.jsp"><button type="button">View</button></a>




 
</form>
</div>
</body>
</html>
