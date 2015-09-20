<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en">

<head>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<title>Product Model Update Details</title>

<script type="text/javascript" src="./js/updateproductdetails.js"></script>

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
	
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
	<%@ page import="java.util.*" %>
	<%ProductModelVO prodMod = new ProductModelVO();
	prodMod=(ProductModelVO)request.getAttribute("object");
	ArrayList<RetailerVO> alRVO=new ArrayList<RetailerVO>();
	alRVO=(ArrayList<RetailerVO>) request.getAttribute("list");%>
	<%int id=(Integer)request.getAttribute("ID");%>
	
	
	
	<form name="updateProduct" onsubmit="return validate()" action="<%=request.getContextPath() %>/ProductModelServlet" method="post" >
		<table border=0><tr><th colspan=3>Details of Product Model Id:<%=id%></th></tr>
		
			<tr><td>PRODUCT MODEL ID</td><td>:</td><td><input type="text" value="<%=id %>" disabled/></td></tr>
			<tr><td>PRODUCT MODEL NAME<span class="red_text">*</span></td><td>:</td><td><input type="text" name="productname" value="<%=prodMod.getProductModelName()%>"></td></tr>
			<tr><td>PRODUCT MODEL DESCRIPTION<span class="red_text">*</span></td><td>:</td><td><textarea name="description"><%=prodMod.getProductModelDescription()%></textarea></td></tr>
			<tr><td>PRODUCT MODEL FEATURES<span class="red_text">*</span></td><td>:</td><td><textarea name="features"><%=prodMod.getProductModelFeatures()%></textarea></td></tr>
			<tr><td>PRODUCT MODEL PRICE<span class="red_text">*</span></td><td>:</td><td><input type="text" name="price" value="<%=prodMod.getProductModelPrice()%>"></td></tr>
			<tr><td>PRODUCT MODEL THRESHOLD<span class="red_text">*</span></td><td>:</td><td><input type="text" name="threshold" value="<%=prodMod.getProductModelThreshold()%>"></td></tr>
			<tr><td>TAGGED RETAILER</td><td>:</td><td><input type="text" name="taggedretailer" value="<%=prodMod.getRetailerID()%>" disabled></td></tr>
			
			<tr><td>TAG RETAILER OR UPDATE TAGGED RETAILER </td><td>:</td>
			<td><select name="retailerID">
			<option value="">Select Retailer ID</option>
			<%for(RetailerVO rvo:alRVO)
				{
			%>
			<option value="<%=rvo.getRetailerID()%>"><%=rvo.getRetailerID()%></option>
			<%} 
			%></select></td></tr>
			<tr><td><input type="hidden" value="update" name="choicer"></input></td></tr>
			<tr><td colspan=2 align="center"><input type="submit" value="UPDATE" class="style1"></td></tr>
		</table>
		</center>
		<input type="hidden" value="<%=id%>" name="id"></input>
	</form>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>