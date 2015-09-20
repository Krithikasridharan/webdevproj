<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<title>Delete Stock</title>
<script type="text/javascript">
		function validate()
		{
			if(document.selectID.pcode.value=="")
			{
				alert("Select package ID");
				document.selectID.pcode.focus();
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
<br><br>
<center>
	<%@page import="java.util.*" %>
	<%@page import="com.tcs.ilp.tsi.vo.*" %>
	<form onsubmit="return validate()" name="selectID" action="<%request.getContextPath(); %>../StockDetailsServlet" method="post">
	<table height="200px">
	<tr><th colspan="3">DELETE STOCK</th></tr>
	<tr><td>ProductCode <span class="red_text">*</span> </td><td> :  </td>
	<td>
		<select name="pcode">
		<option value="">Select Product Code</option>
			<%List<StockVO>us=new ArrayList<StockVO>(); %>
			<%us=(ArrayList<StockVO>)request.getAttribute("dl");%>
			<%for(StockVO vo:us){%>
			<option value="<%=vo.getProductCode() %>">
				<%=vo.getProductCode() %>
			</option><%} %>
		</select>
	</td>
	</tr>
	<tr><td colspan="3" align="center"><input type="submit" value="DELETE" class="style1"></input></td></tr>
	</table>
		<input type="hidden" name="Stock" value="delete"></input>
	</form>
	<br><br>
	</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>	
</body>
</html>