<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/addPackage.js"></script>
<title>Add Package</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<center>
	<form name="addPackageForm" onsubmit="return validate()" action="<%=request.getContextPath() %>/PackageServlet" method="post" >
		<table border="0" height="400px">
			<tr><th colspan=3>ADD PACKAGE</th></tr>
			<tr><td>PackageID</td><td> :</td><td><b>Package ID is Auto-Generated</b></td></tr>
			<tr><td>Offers<span class="red_text">*</span></td> <td>:</td>  <td> <input type="text" name="offers"></input></td></tr> 
			<tr><td>Amount<span class="red_text">*</span></td><td>:</td><td> <input type="text" name="amount"></input></td></tr>
			<tr><td colspan="3" align="center"><input type="submit" value="SUBMIT" class="style1"></input></td></tr>
		</table>
		<input type="hidden" value="add" name="Package"></input>
	</form>
</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>