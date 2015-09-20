<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<title>Delete Package Select ID</title>
<script type="text/javascript">
	function validateDeleteP()
	{
		if(document.deletePackage.packageID.value=="")
		{
			alert("select package ID");
			document.deletePackage.packageID.focus();
        	return false;
		}
	}
</script>
</head>
<body>
<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<br><br>
<center>
	<%@ page import="java.util.*" %>
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
	<form action="../PackageServlet" method="post" name="deletePackage" onsubmit="return validateDeleteP()">
	
		<%ArrayList<PackageVO> alPVO=new ArrayList<PackageVO>(); %>
		<% alPVO=(ArrayList<PackageVO>)request.getAttribute("arrayList");
		int count=0;%>
		
		<table border="0" height="200px">
			<tr><th colspan="3">SELECT PACKAGE ID</th></tr>
			<tr><td>Package ID <span class="red_text">*</span></td><td>:</td>
				<td>
					<select name="packageID">
					<option value="">Select Package ID</option>
						<%for(PackageVO pvo:alPVO)
						{
							count++;%>
							<option value="<%=pvo.getPackage_id()%>"><%=pvo.getPackage_id()%></option>
						<%}%>
					
					</select>
				</td>
			</tr>
			<tr><td colspan="3" align="center"><input type="submit" value="SELECT" class="style1"></input></td></tr>
		</table>
		
		<input type="hidden" value="deleteID" name="Package"></input>
		
		</center>
	</form>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
	
</body>
</html>