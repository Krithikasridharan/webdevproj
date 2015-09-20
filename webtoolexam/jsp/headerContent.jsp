<!DOCTYPE html>
<html>
<head>
<title>TSIMS</title>
<link rel="stylesheet" href="../css/style.css" type="text/css" />
</head>
<body>
<center>
<%
String user=null;
		user=(String)session.getAttribute("name");
		
		if((user==null)||(user=="null")||(user==""))
		{
			%>
			<jsp:forward page="index.jsp"></jsp:forward>
			<%
		}
		 %>
<div id="supercontainer">
	<div id="headcontainer"></div>
	<div id="container">
		<table id="tab">
			<tr>
				<td id="data">
					<div id="menu">
					<nav>
            <ul>
	            <li><a href="home.jsp" id="ul">HOME</a></li>
                <hr>                
                <li><a href="#" id="ul">PRODUCT MODEL</a>
                <hr>
                    <ul>
                        <li><a href="addPM.jsp">Add</a></li>
                        <li><a href="updateproductmodel.jsp">Update</a></li>
                        <li><a href="deleteproduct.jsp">Delete</a></li>
                        <li><a href="">View&nbsp;&nbsp;<strong>></strong></a>
                        <ul>
	                        <li><a href="viewcaller.jsp">View ProductModel</a></li>
                            <li><a href="viewThreshold.jsp">View Threshold</a></li>
                        </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#" id="ul">STOCK</a>
                <hr>                
                    <ul>
                        <li><a href="addStock.jsp">Add</a></li>
                        <li><a href="updatestock1.jsp">Update</a></li>
                        <li><a href="deletestock1.jsp">Delete</a></li>
                        <li><a href="viewStock1.jsp">View</a></li>
                    </ul>
                </li>
                <li><a href="#" id="ul">COMPLEMENTARY PACKAGE</a>
                <hr>                
	                <ul>
                        <li><a href="addPackage.jsp">Add</a></li>
                        <li><a href="updatePackage.jsp">Update</a></li>
                        <li><a href="deletePackage.jsp">Delete</a></li>
                        <li><a href="viewPackage.jsp">View</a></li>
                    </ul>
                </li>
	            <li><a href="logout.jsp" id="ul">LOGOUT</a></li>                
            </ul>
        </nav>
					</div>
		  	  </td>
				<td id="data">
					<div id="content">
					<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>
					
