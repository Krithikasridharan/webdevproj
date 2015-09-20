<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sorted by Product Code is Ascending Order</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="headerContent1.jsp" flush="true"></jsp:include>
<br><br>

<%@page import="java.util.*" %>
<%@page import="com.tcs.ilp.tsi.vo.*"%>
<%List<StockVO> vp=new ArrayList<StockVO>(); %>
<%vp=(ArrayList<StockVO>)request.getAttribute("view");%>
<br><br><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<center>
<table border="1" width="600px">
<tr><th colspan="9">
STOCK DETAILS SORTED BY PRODUCT CODE IN DESCENDING ORDER
	
</th></tr>
<tr><th>PRODUCT CODE</th><th>PRODUCT MODEL ID</th><th>PRODUCT NAME</th><th>PRODUCT STATUS</th><th>ORDER ID</th></tr>
<%for(StockVO svo:vp)
{
	%>
<tr>
<td> <%=svo.getProductCode()%></td>
<td><%=svo.getProduct_ModelID() %></td>
<td><%=svo.getProductName() %></td>
<td><%=svo.getProductStatus() %></td>
<td><%=svo.getOrder_ID() %></td>
</tr>
<%} %>
</table>
<br><br>
<%request.setAttribute("arrayList",vp); %>
<form name="sortform"  action="<%=request.getContextPath()%>/StockDetailsServlet" method="post">
<table>
<tr><td><input type="radio" name="order" value="desc" checked>Sort by product code in descending order</td></tr>
<tr><td align="center"><input type="submit" value="Click to View" class="style1"></input></td></tr>
</table>
<input type="hidden" name="Stock" value="sort"></input>
</form>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>