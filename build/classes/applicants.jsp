<%@page import="java.util.*"%>

<%@page import="model.Company"%>
<%@page import="model.Employee"%>

<%@page import="java.text.NumberFormat"%>



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



</head>
<body>




<div class="header">
				<h1>Jobbing</h1>
				<h5>let's go jobbing..</h5>
			</div>
			
<H4> Applicants list </H4>

<%   
	con=getConnection();
	
	 
	if(session.getAttribute("cname")==null){
		request.setAttribute("err", "User doesnt exists please check your credentials or create a new account.");
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);	
	}
	String cname= session.getAttribute("cname").toString();
	ArrayList<Employee> emp = dao.EmpDao.getEmpList(cname, con);
%>

 <% for(int i = 0; i<emp.size();i++){%>
 
 
          
          
          <div class="divheader" >
          <h4><%=i+1 %>) </h4>
          Full Name: <%=emp.get(i).getFullname()%><br>
          Qualification: <%=emp.get(i).getQualification()%><br>
          Experience: <%=emp.get(i).getExperience()%><br>
          Gender: <%=emp.get(i).getGender()%><br>
          Phone Number: <%=emp.get(i).getMob()%><br>
          </div>
          <br> 
          
          
          
          
  <%} %>

		


</body>
</html>