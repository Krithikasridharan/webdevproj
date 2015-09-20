<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../js/addStock.js"></script>

<title>Add Stock</title>
</head>


<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<center>
	<form name="addstockform" onsubmit="return validate()" action="../StockDetailsServlet" method="post" >
		<input type="hidden" name="Stock" value="add"></input>
		
		<table border=0  height="400px">
			<tr><th colspan=3>ADD STOCK</th></tr>
			<tr><td>Product Model Code</td><td>:</td><td><b>Product Code is Auto-Generated</b></td></tr>
			<tr><td>Product Model ID<span class="red_text">*</span></td><td>:</td><td><input type="text" name="product"></input></td></tr>
			<tr><td>Product Name<span class="red_text">*</span></td><td>:</td><td><input type="text" name="name"></input></td></tr>
			<tr><td>Product Status<span class="red_text">*</span></td><td>:</td><td><input type="text" name="status" value="available" disabled></input></td></tr>
			<tr><td></td><td><input type="submit" value="SUBMIT" class="style1"></input></td>
			<td><input type="reset" value="RESET" class="style1"></input></td></tr>
		</table>
	</form>
</center>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>