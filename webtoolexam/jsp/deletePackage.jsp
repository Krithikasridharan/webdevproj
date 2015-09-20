<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Package Redirect</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
%>

<jsp:forward page="../PackageServlet">
	<jsp:param value="deleteSelectID" name="Package"/>
</jsp:forward>
</body>
</html>