<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sorted by Product Model ID  in Descending Order</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="headerContent1.jsp" flush="true"></jsp:include>
<br><br><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<center>
					<%@ page import="java.util.ArrayList" %>
					<%@ page import="com.tcs.ilp.tsi.vo.ProductModelVO" %>
					<%ArrayList<ProductModelVO> lister=new ArrayList<ProductModelVO>();
					lister=(ArrayList<ProductModelVO>)request.getAttribute("arrayList");%>
					<div style="width:844px;overflow-x:scroll">
					<table border=1>
					<tr><th colspan="9">AVAILABLE PRODUCT MODELS SORTED BY ID IN DESCENDING ORDER</th></tr>
					<tr><th>PRODUCT MODEL ID</th><th>PRODUCT MODEL NAME</th><th>PRODUCT MODEL DESCRIPTION</th><th>PRODUCT MODEL FEATURES</th><th>PRODUCT MODEL PRICE</th><th>PRODUCT MODEL THRESHOLD LIMIT</th><th>RETAILER TAGGED</th><th>TAGGED DATE</th><th>QUANTITY</th></tr>
					<%for(ProductModelVO x: lister)
						{
						
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
					}%>
					</table>
					<br><br>
					<form name="sortform" action="<%=request.getContextPath()%>/ProductModelServlet" method="post">
					<table>
					<tr><td align="left"><input type="radio" name="sort" value="sortbyIDAsc" checked>Sort by ProductModel ID in Ascending</td></tr>
					<tr><td align="left"><input type="radio" name="sort" value="sortbyQuantityAsc">Sort by Quantity in Ascending</td></tr>
					<tr><td align="left"><input type="radio" name="sort" value="sortbyQuantityDes">Sort by Quantity in Descending</td></tr>
					<tr><td align="left"><input type="hidden" value="sort" name="choicer"/></td></tr>
					<tr><td align="center"><input type="submit" value="Click to View" class="style1"></input></td></tr>
					</table>
					<br><br>
					</form>
					</div>
					</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>

</body>
</html>