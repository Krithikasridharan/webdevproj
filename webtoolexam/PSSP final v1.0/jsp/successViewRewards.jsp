<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.tcs.ilp.tsi.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<RewardVO> alRVO=new ArrayList<RewardVO>();
alRVO=(ArrayList<RewardVO>)request.getAttribute("arrayList");
int count=0;%>
<table border="1">
<tr><th colspan="5">REWARDS TAGGED</th></tr>
<tr><th>REWARD ID</th><th>RETAILER ID</th><th>PACKAGE ID</th><th>REWARD DATE</th><th>REWARD STATUS</th></tr>
<%for(RewardVO rvo:alRVO)
	{
		count++;%>
<tr><td><%=rvo.getRewardID()%></td><td><%=rvo.getRetailerID()%></td><td><%=rvo.getPackageID()%></td><td><%=rvo.getRewardDate()%></td><td><%=rvo.getRewardStatus()%></td></tr>
<%} 
if(count==0)
{
	%>
	<tr><td colspan="5">No records found</td></tr>
	<%
}%>
</table>
</body>
</html>