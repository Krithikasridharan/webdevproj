<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Threshold Page Redirect</title>
</head>
<body><%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<jsp:forward page="../ProductModelServlet">
	<jsp:param value="threshold" name="choicer"/>
</jsp:forward>
</body>
</html>