<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<title>View Stock</title>
</head>
<body>
<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<br><br>
<center><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<%@page import="java.util.*" %>
<%@page import="com.tcs.ilp.tsi.vo.*"%>
<%List<StockVO> vp=new ArrayList<StockVO>(); %>
<%vp=(ArrayList<StockVO>)request.getAttribute("view");int count=0;  %>
<table border="1" width="600px">
<tr><th colspan="9">STOCK DETAILS
</th></tr>
<tr><th>PRODUCT CODE</th><th>PRODUCT MODEL ID</th><th>PRODUCT NAME</th><th>PRODUCT STATUS</th><th>ORDER ID</th></tr>
<%for(StockVO svo:vp)
{
	count++;%>
<tr>
<td> <%=svo.getProductCode()%></td>
<td><%=svo.getProduct_ModelID() %></td>
<td><%=svo.getProductName() %></td>
<td><%=svo.getProductStatus() %></td>
<td><%=svo.getOrder_ID() %></td>
</tr>
<%}
if(count==0)
{%>
<tr><td colspan="9"> NO RECORDS FOUND </td></tr>
<%} %>
</table>
<br><br>
<%request.setAttribute("arrayList",vp); %>
<form name="sortform"  action="<%=request.getContextPath()%>/StockDetailsServlet" method="post">
<table>
<tr><td><input type="radio" name="order" value="asc" checked>Sort by product code in ascending order</td>
<tr><td><input type="radio" name="order" value="desc">Sort by product code in descending order</td></tr>
<tr><td align="center"><input type="submit" value="Click to View" class="style1"></input></td></tr>
</table>
<input type="hidden" name="Stock" value="sort""></input>
<br><br>
</form>
</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>