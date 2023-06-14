<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <% String un=(String)session.getAttribute("username"); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>AddInventory</title>
<link rel="stylesheet" href="loginpage.css">

<script type="text/javascript">
function update()
{
	
	var gold = ["c_18","c_22","c_24"];
	var silver = ["S1","S2"];
	
	var catagory=document.getElementById("cat");
    var carat=document.getElementById("2");
    var selected=catagory.value;
    var html='<option selected="selected">carat</option>';
    if(selected === "gold")
    {
        for(var i=0; i < gold.length; i++)
        {
            html+='<option value="' + gold[i] + '">' + gold[i] + '</option>';
        }
    }
    else if(selected === "silver")
    {
        for(var j=0; j < silver.length; j++)
        {
            html+='<option value="' + silver[j] + '">' + silver[j] + '</option>';
        }
    }
    
    carat.innerHTML=html;
	
 }
</script>
</head>
<body>
<h1 style="color:white">Welcome! <%=un %></h1>
<form action="InventoryServlet" method="post">
<div class = "headingContainer">
	<h1>INSERT NEW DATA TO INVENTORY</h1>
</div>	 
	
			<div class="mainContainer">
				<lable for ="item">Enter Item Name : </lable>
				<input type="text" name="pname" required="required"> <br>
				<lable for ="catagory" required="required">CATEGORY : </lable>
				<select id="cat" onchange="update()" name="category" required="required">
					<option >Choose Catagory</option>
					<option value="gold" required="required">GOLD</option>
					<option value="silver" required="required" >SILVER</option>
				</select> <br> <br>
				<lable for ="carcat" required="required">Carat-Category:</lable><%  %>
				<select id = "2" name="carat" required="required">
				<option selected = "selected"  required="required"></option> 
				</select><br><br>
				<!-- <select>
					<option>C_18</option>
					<option>C_22</option>
					<option>C_24</option>
					<option>S1</option>
					<option>S2</option>
				</select>   -->
				<!-- <select>
					<option>S1</option>
					<option>S2</option>
				</select> <br> -->
				<lable for ="quan" required="required">Quantity: </lable><br>
				<input type="text" name="quantity" required="required"> <br> 
				<lable for ="totalwt">Total Weight : </lable>
				<input type="text" name="weight" width="100px" required="required">Gms <br> <input
					type="submit" name="sub" value="Add ITEM"> <br>
				</div>	
			</form>
		</body>
</html>