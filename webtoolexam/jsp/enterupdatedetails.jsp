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
<center>
<%
String s = request.getParameter("updateId");
%>

Updating Details for Product with ID : <%=s %>

<br></br>
<br></br>
<br></br>

Enter New Details:
<br></br>

<form name="enterupdateprodmod" method="post" action="<%=request.getContextPath() %>/ProductModelServlet" onSubmit="return display();">

<input type="hidden" name="choicer" value="enterupdater">


Name:
<input type="text" name="updateModelName" value=""></input>
<br></br>
Description:
<input type="text" name="updateModelDescrip" value=""></input>
<br></br>
Features:
<input type="text" name="updateModelFeat" value=""></input>
<br></br>
Price:
<input type="text" name="updateModelPrice" value=""></input>
<br></br>
Threshold:
<input type="text" name="updateModelThresh" value=""></input>
<br></br>


<input type="submit" name="Submit" value="Submit"></input>

</form>
</center>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>