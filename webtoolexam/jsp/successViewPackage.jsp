<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>


<!DOCTYPE html>

<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<title>Package Details</title>

</head>


<body>
<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<br><br><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<center>
	<%@ page import="java.sql.*" %>
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
	<%ArrayList<PackageVO> alPVO=new ArrayList<PackageVO>();
	alPVO=(ArrayList<PackageVO>)request.getAttribute("arrayList");
	int count=0;
	%>
	
	<table border="1" width="400px">
		<tr><th colspan="3">
			COMPLEMENTARY PACKAGE OFFERS
		</th></tr>
		
		<tr><th>PACKAGE ID</th><th>OFFERS</th><th>OFFER AMOUNT</th></tr>
		
		<%for(PackageVO rvo:alPVO)
		{
			count++;%>
			<tr><td><%=rvo.getPackage_id()%></td><td><%=rvo.getOffers()%></td><td><%=rvo.getAmount()%></td></tr>
		<%} 
		if(count==0)
		{
			%>
			<tr><td colspan="2">No records found</td></tr>
			<%
		}%>
	</table>
	<br><br>
	<form name="sortform" action="<%=request.getContextPath()%>/PackageServlet" method="post">
	<table>
	<tr><td align="left"><input type="radio" name="sort" value="sortbyIDAsc" checked>Sort by PackageID in Ascending</td></tr>
	<tr><td align="left"><input type="radio" name="sort" value="sortbyIDDes">Sort by PackageID in Descending</td></tr>
	<tr><td align="left"><input type="radio" name="sort" value="sortbyAmountAsc">Sort by Amount in Ascending</td></tr>
	<tr><td align="left"><input type="radio" name="sort" value="sortbyAmountDes">Sort by Amount in Descending</td></tr>
	<tr><td align="center"><input type="submit" value="Click to sort" class="style1"></input></td></tr>
	</table>
	<br><br>
	<input type="hidden" value="sort" name="Package"/>	
</center>
	</form>
	<br><br>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>