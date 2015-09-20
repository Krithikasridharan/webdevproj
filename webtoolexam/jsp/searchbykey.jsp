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

<jsp:include page="headerContent.jsp" flush="true"></jsp:include>
<br><br>
<form name="deleteprodmod" method="post" action="<%=request.getContextPath() %>/ProductModelServlet" >

<input type="hidden" name="choicer" value="searcherbykey">

Enter Product Id to search:
<input type="text" name="searchId" value=""></input>

<input type="submit" name="Submit" value="Submit" class="style1"></input>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</form>
</body>
</html>