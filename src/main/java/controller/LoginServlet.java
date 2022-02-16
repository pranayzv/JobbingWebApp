package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.http.*;
import jakarta.servlet.*;


public class LoginServlet extends HttpServlet {
	

    /**
	 * 
	 */
	
	Connection con;
	
	private static final long serialVersionUID = 1828656851528113526L;


	public LoginServlet() {

    }
	
    private Connection getConnection() {
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


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		con = getConnection();
		
		String u = request.getParameter("username").toString();
		String p = request.getParameter("password").toString();
		if(dao.CmpDao.cmpCheck(u,p,con)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("cname", u);
			redirectTo("/applicants.jsp",request,response);
			
		}
		else {
			if(dao.EmpDao.empCheck(u,p,con)){
				HttpSession session = request.getSession();
				session.setAttribute("username", u);
				redirectTo("/Main.jsp",request,response);
			
			}
			else {
				//userdoes'nt exits
				request.setAttribute("err", "User does'nt exists please check your credentials or create a new account.");
				redirectTo("/login.jsp",request,response);
			}
		
		}
		
		
	}
	
	public void redirectTo(String url ,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);	
	}
	

}
