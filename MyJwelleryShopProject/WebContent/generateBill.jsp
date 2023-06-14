<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String id=request.getParameter("id");
    String name=request.getParameter("cname");
    String mob=request.getParameter("mob");
    String add=request.getParameter("add");
    String s=request.getParameter("iid");
    String s1=request.getParameter("pname");
    String s2=request.getParameter("cat");
    String s3=request.getParameter("caunt");
    String s4=request.getParameter("wei");
    String s5=request.getParameter("cara");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body{
            background-color: #F6F6F6; 
            margin: 0;
            padding: 0;
        }
        h1,h2,h3,h4,h5,h6{
            margin: 0;
            padding: 0;
        }
        p{
            margin: 0;
            padding: 0;
        }
        .container{
            width: 80%;
            margin-right: auto;
            margin-left: auto;
        }
        .brand-section{
           background-color: #0d1033;
           padding: 10px 40px;
        }
        .logo{
            width: 50%;
        }

        .row{
            display: flex;
            flex-wrap: wrap;
        }
        .col-6{
            width: 50%;
            flex: 0 0 auto;
        }
        .text-white{
            color: #fff;
        }
        .company-details{
            float: right;
            text-align: right;
        }
        .body-section{
            padding: 16px;
            border: 1px solid gray;
        }
        .heading{
            font-size: 20px;
            margin-bottom: 08px;
        }
        .sub-heading{
            color: #262626;
            margin-bottom: 05px;
        }
        table{
            background-color: #fff;
            width: 100%;
            border-collapse: collapse;
        }
        table thead tr{
            border: 1px solid #111;
            background-color: #f2f2f2;
        }
        table td {
            vertical-align: middle !important;
            text-align: center;
        }
        table th, table td {
            padding-top: 0px;
            padding-bottom: 0px;
            padding-left: 5px 8px;
        }
        .table-bordered{
            box-shadow: 0px 0px 5px 0.5px gray;
        }
        .table-bordered td, .table-bordered th {
            border: 1px solid #dee2e6;
        }
        .text-right{
            text-align: end;
        }
        .w-20{
            width: 20%;
        }
        .float-right{
            float: right;
        }
    </style>
</head>
<%-- <body>
<form action="">
<table border="1">
<tr>
<tr>
<th>Customer id  :</th>
<td><%=id %></td>
</tr>
<tr>
<th>Customer Name  :</th>
<td><%=name %></td>
</tr>
<tr>
<th>Mobile Number</th>
<td><%=mob %></td>
</tr>
<tr>
<th>Address </th>
<td><%=add %></td>
</tr>
<tr>
<th>Customer Name </th>
<td><input type="text"></td>
</tr>
</tr>
</table>
</div>
</form> --%>
<body>

    <div class="container">
        <div class="brand-section">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-white">JEWELLERY BILL</h1>
                </div>
                <div class="col-6">
                    <div class="company-details">
                        <p class="text-white">Omakar Shahane</p>
                        <p class="text-white">Barshi</p>
                        <p class="text-white">+91 888555XXXX</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="body-section">
            <div class="row">
                <div class="col-6">
                    <h2 class="heading">Invoice No.: 001</h2>
                    <p class="sub-heading"> Date: 20-20-2021 </p>
                    <p class="sub-heading">Email Address: OmakrShahanediamond@gfmail.com </p>
                </div>
                <div class="col-6">
                    <p class="sub-heading">Customer id: <%=id %>  </p>
                    <p class="sub-heading">Customer Name: <%=name %>  </p>
                    <p class="sub-heading">Mobile Number: <%=mob %>  </p>
                    <p class="sub-heading">Address: <%=add %>  </p>
                </div>
            </div>
        </div>

        <div class="body-section">
            <h3 class="heading">Selected Items</h3>
            <br>
            <table class="table-bordered">
                <thead>
                    <tr>
                        <!-- <th>Jewellery</th> -->
                        <th class="w-10">Sr.No</th>
                       
                        <th class="w-10">Particular Name</th>
                       
                        <th class="w-20">Category</th>
                       
                        <th class="w-20">Carat</th>
             
                        <th class="w-20">Quantity</th>
                        
                        <th class="w-20"> Weight</th>
             
                        <th class="w-20">Net Weight</th>
                        <th class="w-10">Rate</th>
                        <th class="w-10">Gst</th>
                        <th class="w-20">Making Charges</th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" size="2"><%=s1 %></td>
                    <td><input type="text"size="6"></td>
                    <td><input type="text" size="2"></td>
                    <td><input type="text" size="2"></td>
                    <td><input type="text" size="2"></td>
                    <td><input type="text" size="2"></td>
                    <td><input type="text" size="2"></td>
                </tr>
                
                
                
                    <%-- <tr>
                        <td><%=s1 %></td>
                        <td><%=s %></td>
                        <td><%=s1 %></td>
                        <td><%=s2 %></td>
                        <td><%=s5 %></td>
                        <td><%=s3 %></td>
                        <td><%=s4 %></td>                                                
                    </tr> --%>
                    <tr>
                        <td colspan="3" class="text-right">Sub Total</td>
                        <td> 10.XX</td>
                    </tr>
                    <tr>
                        <td colspan="3" class="text-right">Tax Total %1X</td>
                        <td> 2</td>
                    </tr>
                    <tr>
                        <td colspan="3" class="text-right">Grand Total</td>
                        <td> 12.XX</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <h3 class="heading">Payment Status: Paid</h3>
            <h3 class="heading">Payment Mode: Cash on Delivery</h3>
        </div>

        <div class="body-section">
            <p>&copy; Copyright 2021 - Fabcart. All rights reserved. 
                <a href="https://www.fundaofwebit.com/" class="float-right">www.fundaofwebit.com</a>
            </p>
        </div>      
    </div>      

</body>
</html>