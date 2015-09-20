<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<%
				response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>
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
	            <li><a href="jsp/home.jsp" id="ul">HOME</a></li>
                <hr>                
                <li><a href="#" id="ul">PRODUCT MODEL</a>
                <hr>
                    <ul>
                        <li><a href="jsp/addPM.jsp">Add</a></li>
                        <li><a href="jsp/updateproductmodel.jsp">Update</a></li>
                        <li><a href="jsp/deleteproduct.jsp">Delete</a></li>
                        <li><a href="">View&nbsp;&nbsp;<strong>></strong></a>
                        <ul>
	                        <li><a href="jsp/viewcaller.jsp">View ProductModel</a></li>
                            <li><a href="jsp/viewThreshold.jsp">View Threshold</a></li>
                        </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#" id="ul">STOCK</a>
                <hr>                
                    <ul>
                        <li><a href="jsp/addStock.jsp">Add</a></li>
                        <li><a href="jsp/updatestock1.jsp">Update</a></li>
                        <li><a href="jsp/deletestock1.jsp">Delete</a></li>
                        <li><a href="jsp/viewStock1.jsp">View</a></li>
                    </ul>
                </li>
                <li><a href="#" id="ul">COMPLEMENTARY PACKAGE</a>
                <hr>                
	                <ul>
                        <li><a href="jsp/addPackage.jsp">Add</a></li>
                        <li><a href="jsp/updatePackage.jsp">Update</a></li>
                        <li><a href="jsp/deletePackage.jsp">Delete</a></li>
                        <li><a href="jsp/viewPackage.jsp">View</a></li>
                    </ul>
                </li>
	            <li><a href="jsp/logout.jsp" id="ul">LOGOUT</a></li>                
            </ul>
        </nav>
					</div>
		  	  </td>
				<td id="data">
					<div id="content">
	
					