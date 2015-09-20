<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*" %>

<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<title>Product Model Threshold Details</title>

</head>

<body>

<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<br><br>
<center><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

				
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
	<%ArrayList<ProductModelVO> alPVO=new ArrayList<ProductModelVO>();
	alPVO=(ArrayList<ProductModelVO>)request.getAttribute("arrayList");%>


	
	<table border=1>
		<tr><th colspan=4>THRESHOLD LEGENDS</th></tr>
		<tr><th>PRODUCT MODEL ID</th><th>THRESHOLD LIMIT</th><th>QUANTITY</th><th>THRESHOLD LEGENDS</th></tr>
		<%for(ProductModelVO pvo:alPVO){%>
			<tr>
			<td><%=pvo.getProductModelId() %></td><td><%=pvo.getProductModelThreshold() %></td><td><%=pvo.getQuantity() %></td>
			<td align="center">
			<%if(pvo.getThresholdlimit()==-1){%>
				<input type="text" style="width:15px; height:7px; background:red;  " disabled/></input> 
			<% }else if(pvo.getThresholdlimit()==0){%>
				<input type="text" style="width:15px; height:7px; background:yellow; " disabled/></input> 
			<% }else {%> 
				<input type="text" style="width:15px; height:7px; background:green;  " disabled/></input> 	
				<% }%>
			</td>
			</tr>
		<% }%>
	
	</table>
	
	<table>
		<tr><th colspan=3>LEGENDS</th></tr>
		<tr><td><input type="text" style="width:15px; height:7px; background:red;  " disabled/></td><td>:</td><td>Below Threshold Limit</td></tr>
		<tr><td><input type="text" style="width:15px; height:7px; background:yellow;  " disabled/></td><td>:</td><td>Nearing Threshold Limit</td></tr>
		<tr><td><input type="text" style="width:15px; height:7px; background:green;  " disabled/></td><td>:</td><td>Above Threshold Limit</td></tr>
	</table>

</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
	

</body>
</html>