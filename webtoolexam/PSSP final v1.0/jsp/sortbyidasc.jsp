<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<title>Package Details sorted by Package ID in Ascending order</title>
</head>
<body>
<jsp:include page="headerContent1.jsp" flush="true"></jsp:include>
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
				int count=0;%>
				<table border="1">
				<tr><th colspan="3">PACKAGE DETAILS SORTED BY PACKAGEID IN ASCENDING</th></tr>
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
				<form name="sortform" action="<%=request.getContextPath() %>/PackageServlet" method="post">
				<table>
				<tr><td align="left"><input type="radio" name="sort" value="sortbyIDDes" checked>Sort by PackageID in Descending</td></tr>
				<tr><td align="left"><input type="radio" name="sort" value="sortbyAmountAsc">Sort by Amount in Ascending </td></tr>
				<tr><td align="left"><input type="radio" name="sort" value="sortbyAmountDes">Sort by Amount in Descending </td></tr>
				<tr><td align="center"><input type="submit" value="Click to Sort" class="style1"></input></td></tr>
				</table>
				<input type="hidden" value="sort" name="Package"/>
				</form>
				<br><br>
				<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>