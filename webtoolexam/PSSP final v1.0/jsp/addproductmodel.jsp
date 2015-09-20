<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/addproductmodel.js"></script>
<title>Add Product Model</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

	<jsp:include page="../jsp/headerContent.jsp" flush="true"></jsp:include>
	
		<%@ page import="java.util.*" %>
	<%@ page import="com.tcs.ilp.tsi.vo.*" %>
		<%ArrayList<RetailerVO> alRVO=new ArrayList<RetailerVO>();
		alRVO=(ArrayList<RetailerVO>)request.getAttribute("ArrayList");%>
	<center>	
		
		<form name="addprodmod" onsubmit="return validate()" method="post" action="<%=request.getContextPath() %>/ProductModelServlet" >
			<input type="hidden" name="choicer" value="adder">
			<table height="400px">
				<tr><th colspan="3">ADD PRODUCT MODEL</th></tr>
				<tr><td>Product Model ID</td> <td>:</td> <td><b>Auto-Generated</b></td> </tr>
				<tr><td>Name <span class="red_text">*</span></td><td>:</td><td><input type="text" name="prodModelName" value=""></input></td></tr>
				<tr><td>Description <span class="red_text">*</span></td><td>:</td><td><textarea name="prodModelDescrip" value=""></textarea></td></tr>
				<tr><td>Features <span class="red_text">*</span></td><td>:</td><td><textarea name="prodModelFeat" value=""></textarea></td></tr>
				<tr><td>Price <span class="red_text">*</span></td><td>:</td><td><input type="text" name="prodModelPrice" value=""></input></td></tr>
				<tr><td>Threshold <span class="red_text">*</span></td><td>:</td><td><input type="text" name="prodModelThresh" value=""></input></td></tr>
				<tr><td>Tag Retailer</td><td>:</td>
				
				<td>
				
				<select name="retailerID">
					<option value="">Select Retailer ID</option>
					
					<%for(RetailerVO rvo:alRVO)
					{%>
						<option value="<%=rvo.getRetailerID()%>"><%=rvo.getRetailerID()%></option>
					<%}%>
					
				</select>
				</td>
				</tr>
				
				<tr><td colspan="3" align="center"><input type="submit" name="Submit" value="SUBMIT" class="style1"></input></td></tr>
			</table>
		</form>
	</center> 
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>