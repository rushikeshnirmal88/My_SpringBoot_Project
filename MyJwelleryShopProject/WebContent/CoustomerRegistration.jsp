<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String  un = (String)session.getAttribute("username"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration page</title>
<link rel="stylesheet" href="loginpage.css">
</head>
<body>
<h1 style="color: white"> Welcome !<%=un%></h1>
<h1>Customer Registration</h1>
    <form action="NewCustomerServlet" method="post">
        <!-- Headings for the foram -->
        <div class="headingsContainer">
            <h3>Sign Up</h3>
           
        </div>

        <!-- Main container for all inputs -->
        <div class="mainContainer">
            <!-- Username -->
            <label for="fname">First Name</label>
            <input type="text" placeholder="Enter First Name" name="fname" required>

            <br><br>

            <!-- Password -->
            <label for="lname">Last Name</label>
            <input type="text" placeholder="Enter Last Name" name="lname" required>
            <br><br>

            <!-- Password -->
            <label for="mno">Mobile No</label>
            <input type="text" placeholder="Enter Mobile No" name="mno" required>
            <br><br>

            <!-- Mobile -->
            <label for="mno">Address</label>
            <textarea rows = "5" cols = "70" placeholder="Enter Address" name="add" required></textarea>

          
            <!-- Submit button -->
            <button type="submit" onclick = "myFunction()"><a href="index.html">Submit </button>

            
            </div>
            </form>
</body>
</html>