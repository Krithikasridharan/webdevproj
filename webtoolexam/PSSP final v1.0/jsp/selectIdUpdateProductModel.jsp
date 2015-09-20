<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<title>Select ID for updating Product Model</title>
	<script type="text/javascript">
		function validateUpdatePMID()
		{
			if(document.selectID.productModelID.value=="")
			{
				alert("select product model ID");
				document.selectID.productModelID.focus();
		        return false;
			}
		}
	</script>
</head>
<body>
<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<center>
<br><br><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

	<%@ page import="java.util.*" %>
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
	<form action="../ProductModelServlet"  method="post" name="selectID" onSubmit="return validateUpdatePMID()">
		<%List<ProductModelVO> lister = new ArrayList<ProductModelVO>(); 
		lister=(List<ProductModelVO>)request.getAttribute("list");%>
		<table border=0 height="200px">
			<tr><th colspan="3"> SELECT PRODUCT MODEL ID</th></tr>
			<tr><td>PRODUCT MODEL ID<span class="red_text">*</span></td><td>:</td>
				<td><select name="productModelID">
						<option value="">Select product model ID</option>
							<%for(ProductModelVO pvo:lister)
							{%>
						<option value="<%=pvo.getProductModelId() %>"><%=pvo.getProductModelId() %></option>
						<%}%>
					</select>
				</td>
			</tr>
		</table>
		<input type="hidden" value="updateID" name="choicer"></input>
		<input type="submit" value="UPDATE" class="style1"></input>
	</form>
</center>	
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>