<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">

<head>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<script type="text/javascript" src="./js/updatePackageOffers.js"></script>

<title>Update Package Details</title>

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
	
	<%ArrayList<PackageVO> alPVO=new ArrayList<PackageVO>();
	alPVO=(ArrayList<PackageVO>)request.getAttribute("arrayList");%>
	
	<%int id=(Integer)request.getAttribute("ID");%>
	
	<form name="updatePackageForm" onsubmit="return validate()" action="<%=request.getContextPath() %>/PackageServlet" method="post">
		<table border=0 height="300px"><tr><th colspan=3>Details of Package Id:<%=id%></th></tr>
			<%for(PackageVO pvo:alPVO)
			{ %>
			<tr><td>PACKAGEID</td><td>:</td><td><input type="text" value="<%=id %>" disabled/></td></tr>
			<tr><td>Offers <span class="red_text">*</span></td><td>:</td><td><input type="text" name="offers" value="<%=pvo.getOffers()%>"></td></tr>
			<tr><td>Amount <span class="red_text">*</span></td><td>:</td><td><input type="text" name="amount" value="<%=pvo.getAmount()%>"></td></tr>
			<%}%>
			<tr><td><input type="hidden" value="update" name="Package"></input></td></tr>
			<tr><td colspan="3" align="center"><input type="submit" value="UPDATE" class="style1"></td></tr>
		</table>
		<input type="hidden" value="<%=id%>" name="id"></input>
		</center>
	</form>
	
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>