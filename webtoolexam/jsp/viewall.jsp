<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">

<head>
	
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
	<title>View Product Models</title>
	
</head>

<body>
<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<br><br><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>


<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tcs.ilp.tsi.vo.ProductModelVO" %>
<%ArrayList<ProductModelVO> lister=new ArrayList<ProductModelVO>();
lister=(ArrayList<ProductModelVO>)request.getAttribute("arrayList");
int count=0;

%>
<div style="width:844px;overflow-x:scroll">
<table border="1" width="844px">
<tr><th colspan="9">
AVAILABLE PRODUCT MODELS
	
</th></tr>
<tr><th>PRODUCT MODEL ID</th><th>PRODUCT MODEL NAME</th><th>PRODUCT MODEL DESCRIPTION</th><th>PRODUCT MODEL FEATURES</th><th>PRODUCT MODEL PRICE</th><th>PRODUCT MODEL THRESHOLD LIMIT</th><th>RETAILER TAGGED</th><th>TAGGED DATE</th><th>QUANTITY</th></tr>
<%for(ProductModelVO x: lister)
	{
	count++;
	%>
<tr>
	<td><%=x.getProductModelId() %></td>
	<td><%=x.getProductModelName() %></td>
	<td><%=x.getProductModelDescription() %></td>
	<td><%=x.getProductModelFeatures() %></td>
	<td><%=x.getProductModelPrice() %></td>
	<td><%=x.getProductModelThreshold() %></td>
	<td><%=x.getRetailerID()%></td>
	<td><%=x.getTaggedDate()%></td>
	<td><%=x.getQuantity()%></td>
</tr>
<%
}if(count==0)
{
	%>
	<tr><td colspan="9">No records found</td></tr>
	<%
}%>
</table>

<%request.setAttribute("arrayList",lister); %>
<br><br>
<form name="sortform" action="<%=request.getContextPath()%>/ProductModelServlet" method="post">
<table align="center">
<tr><td align="left">
<input type="radio" name="sort" value="sortbyIDAsc" checked>Sort by ProductModel ID in Ascending
</td></tr>
<tr><td align="left">
	<input type="radio" name="sort" value="sortbyIDDes">Sort by ProductModel ID in Descending
</td></tr>
<tr><td align="left">
	<input type="radio" name="sort" value="sortbyQuantityAsc">Sort by Quantity in Ascending
 	</td></tr>
<tr><td align="left">
	<input type="radio" name="sort" value="sortbyQuantityDes">Sort by Quantity in Descending
    	</td></tr>
<tr><td align="left">
	<input type="hidden" value="sort" name="choicer"/>
	</td></tr>
<tr><td align="center">
<input type="submit" value="Click to View" class="style1" ></input>
</td></tr>
</table>
<br><br>
	</form>
    </div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
