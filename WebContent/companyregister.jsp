<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel='stylesheet' type='text/css' />
<title>Company-Register</title>
</head>
<body>
	<%
		String err = "";
		if (request.getAttribute("err") != null) {
			err = (String) request.getAttribute("err");
		}
	%>
	<!--/start-login-two-->
	<div class="login-02">
		<div class="two-login  hvr-float-shadow">
			<div class="two-login-head">
				<img src="images/top-note.png" alt="" />
				<h2>Register your company</h2>
				<div style="color: red"><%=err%></div>
				<%
				request.setAttribute("err", "");
				%>
				
			</div>
			<form action="RegisterCompServlet" method="post">
				
				<li>Company Name
				<input type="text" class="text" value=""
					name="cname" required></li>
				Password
				<li><input type="password" value=""
					name="password" required></li>
				<li>Post Name
				<input type="text" class="text" value=""
					name="postname" required></li>
					<li>Job description
				<input type="text" class="text" value=""
					name="jobdesc" required></li>
					<li>Experience
				<input type="number" class="text" 
					name="exp"  maxlength="10" required></li>
					<li>Salary
				<input type="number" class="text" 
					name="sal"  required></li>
					
				<div class="submit two">
					<input type="submit" value="Register">
				</div>
				<h5>
					<a href="empregister.jsp">Register as Employee</a>
				</h5>
				<h5>
					<a href="login.jsp">Login Here</a>
				</h5>
			</form>
		</div>
	</div>
</body>
</html>