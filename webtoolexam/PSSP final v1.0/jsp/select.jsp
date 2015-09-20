<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<script type="text/javascript" src="./js/updateStock.js"></script>

<title>Update Stock</title>

</head>


<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<br><br>
<center>
	<form name="updateform" onsubmit="return validate()" action="<%=request.getContextPath() %>/StockDetailsServlet" method="post">
	
		<%@ page import="java.sql.*" %>
		<%@ page import="com.tcs.ilp.tsi.vo.*" %>
		<% StockVO svo=new StockVO();
		svo=(StockVO)request.getAttribute("Previous");
		%>
		
		<input type="hidden" value="select" name="Stock"></input>
		<input type="hidden" value="<%=svo.getProductCode() %>" name="Next"></input>
		
		<table height="400px">
			<tr><th colspan="3">Details of Stock</th></tr>
			<tr><td>ProductCode</td><td>:</td><td><input type="text" name="productcode" value="<%=svo.getProductCode() %>"disabled></input></td></tr>
			<tr><td>ProductModelID<span class="red_text">*</span></td><td>:</td><td><input type="text" name="productmodelid" value="<%=svo.getProduct_ModelID() %>"></input></td></tr>
			<tr><td>Product Name<span class="red_text">*</span></td><td>:</td><td><input type="text" name="productname" value="<%=svo.getProductName() %>"></input></td></tr>
			<tr><td>Product Status<span class="red_text">*</span></td><td>:</td><td><select name="status"><option>allocated</option><option>available</option><option>dispatched</option></select></tr>
			<tr><td>Order ID</td><td>:</td><td><input type="text" name="orderid" value="<%=svo.getOrder_ID() %>"disabled></input></td></tr>
			<tr><td><input type="submit" value="UPDATE" class="style1"></input></td><td></td>
			<td><input type="reset" value="CANCEL" class="style1"></input></td></tr>
		</table>
		</center>
	</form>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>