<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>


<html lang="en">

<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">

<title>Delete Product Model</title>
	<script type="text/javascript">
	function validateDeletePM()
	{
		if(document.deleteprodmod.productModelID.value=="")
		{
			alert("select product model ID");
			document.deleteprodmod.productModelID.focus();
        	return false;
		}
	}
</script>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
	
	<%@ page import="java.util.*" %>
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
	<%List<ProductModelVO> lister = new ArrayList<ProductModelVO>(); %>
	<% lister=(List<ProductModelVO>)request.getAttribute("list");
	int count=0;%>
	<center>
	<br>
	<form name="deleteprodmod" method="post" action="<%=request.getContextPath() %>/ProductModelServlet" onSubmit="return validateDeletePM()" >


		<table height="200px">
			<tr><th colspan="2">SELECT PRODUCT MODEL ID</th></tr>
			<tr><td>PRODUCT MODEL ID<span class="red_text"> *</span> :</td>
				<td>
					<select name="productModelID">
						<option value="">Select product model ID</option>
					
					<%for(ProductModelVO pvo:lister)
						{
						count++;%>
		
						<option value="<%=pvo.getProductModelId()%>"><%=pvo.getProductModelId()%></option>
						
						<%}%>
						
					</select>
				</td>
			</tr>
		</table>
		<input type="hidden" name="choicer" value="deleterbykey">
		<input type="submit" value="SELECT" class="style1"></input>
	</form>
	</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>




