<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel='stylesheet' type='text/css' />
<title>Jobbing-Login</title>
</head>
<body>
	<%
		String err = "";
		if (request.getAttribute("err") != null) {
			err = (String) request.getAttribute("err");
		}
	%>
	
	<!--/start-login-one-->
	<div class="login-01">
		<div class="one-login  hvr-float-shadow">
			<div class="one-login-head">
				<img src="images/top-lock.png" alt="" />
				<h1>LOGIN</h1>
				<div style="color: red"><%=err%></div>
				<%
				request.setAttribute("err", "");
				%>
				
			</div>
			<form action="LoginServlet" method="post">
			
				
				<input type="text" class="text" value=""
					name="username" placeholder="username/companyname" maxlength="10" required>
				
				<input type="password" value=""
					name="password" placeholder="password" maxlength="8" required>
				<div class="p-container">	
					
					
				</div>
				<div class="submit">
					<input type="submit" value="SIGN IN">
				</div>
				
				<h5>
					don't have an account? then register as Company here<a href="companyregister.jsp"> register </a>
					don't have an account? then register as Employee here<a href="empregister.jsp"> register </a>
				</h5>
			</form>
		</div>
	</div>

</body>
</html>