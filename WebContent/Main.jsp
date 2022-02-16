<%@page import="java.util.*"%>

<%@page import="model.Company"%>
<%@page import="model.Employee"%>




<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page import="java.sql.*"%>
	<%! Connection con; %>
	
	<%! 
	public Connection getConnection() {
        try {
            Class.forName(jobbingutils.Constants.JDBC);
            if (con != null) {
                con.close();
            }
            return DriverManager.getConnection(jobbingutils.Constants.URL, jobbingutils.Constants.USER, jobbingutils.Constants.PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
	
	%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/head.css" />
<link rel="stylesheet" href="css/style.css" />


<script type="text/javascript">


</script>

</head>
<body>




<div class="header">
				<h1>Jobbing</h1>
				<h5>let's go jobbing..</h5>
				
			</div>
			
<H4> Jobs list </H4>


<%   
	con=getConnection();
	
	 
	if(session.getAttribute("username")==null){
		request.setAttribute("err", "User does'nt exists please check your credentials or create a new account.");
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);	
	}
	String uname= session.getAttribute("username").toString();
	ArrayList<Company> cmp = dao.CmpDao.getCompanyList(uname, con);
%>
<% if(cmp.size()==0){ %>
<h3 style="color:red">You have already applied to all postings, check out later if new posts are available.</h2>
<%} %>

<form action="MainServlet" method="post">
 <% for(int i = 0; i<cmp.size();i++){%>
 
 
          
          <div>
           
          <div class="divheader" >
          <h4><%=i+1 %>) </h4>
          Comapny Name: <%=cmp.get(i).getCname()%><br>
          Post: <%=cmp.get(i).getPostname()%><br>
          Job description:<%=cmp.get(i).getJobdesc()%><br>
          Experience needed: <%=cmp.get(i).getExperience()%><br>
          Monthly Salary: $<%=cmp.get(i).getSalary()%><br>
          <input class="btncompare" type="submit"  name="cmp" value=Apply:<%=uname%>:<%=cmp.get(i).getCname()%>>
          </div>
          	
          </div>
          <br> 
          
          
          
          
  <%} %>

</form>			
			
		


</body>
</html>