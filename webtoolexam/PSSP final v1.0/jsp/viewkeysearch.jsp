<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tcs.ilp.tsi.vo.ProductModelVO" %>

<% ProductModelVO pM = new ProductModelVO(); %>
<% pM = (ProductModelVO)request.getAttribute("keyedProductModel"); %>


	ID: <%=pM.getProductModelId() %>
	Name:<%=pM.getProductModelName() %>
	Description:<%=pM.getProductModelDescription() %>
	Features: <%=pM.getProductModelFeatures() %>
	Price: <%=pM.getProductModelPrice() %>
	Threshold: <%=pM.getProductModelThreshold() %>
	

</body>
</html>