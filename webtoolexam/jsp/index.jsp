<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>Login Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<meta name="description" content="Login Page of Group B">
		<meta name="keywords" content="login, form, css3, jquery, animate">
		
		<script type="text/javascript" src="../js/login.js">
		</script>
		
		<link rel="stylesheet" type="text/css" href="../css/loginstyle.css">
</head>
<body>

<%String error=request.getParameter("error");
if(error==null||error=="null")
{
	error="";
}
%>

						<!--  <form action="../LoginServlet" method="post">
						<table border=0>
						<tr><th colspan=3><b>LOGIN</b></th></tr>
						<tr><td>USERNAME</td><td>:</td><td><input type="text" name="uname"/></td></tr>
						<tr><td>PASSWORD</td><td>:</td><td><input type="password" name="pwd"/></td></tr>
						<tr><td colspan=3 align="right"><input type="submit" value="LOGIN"></input></td></tr>
						</table>
						<input type="text" name="error" value="<%=error %>" style="border:0px; color:red; width:50em;background-color: #FFF" disabled></input>
						</form>-->
						
<div id="wrapper" class="wrapper">
			
			
			<form name="loginform" onsubmit="return validate()" class="login active" action="<%=request.getContextPath()%>/LoginServlet" method="post">
				<h3>Login</h3>
				
				<div>
					<label>Username:</label>
					<input type="text" id="uname" name="uname"/>
				</div>
				
				<div>
					<label>Password: 
					
					</label>
					<input type="password" name="pwd"/>
				</div>
				
				<div class="bottom">
										
					<input type="submit" value="LOGIN"></input>
					<div class="clear"></div>
					
				</div>
				<input type="text" name="error" value="<%=error %>" style="border:0px; color:red; width:20em;background-color: #FFF" disabled></input>
			</form>
									
</div>			
						
</body>
</html>