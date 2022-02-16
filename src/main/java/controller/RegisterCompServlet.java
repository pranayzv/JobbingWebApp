package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.Company;

public class RegisterCompServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511376868622051989L;


	public RegisterCompServlet() {
	}

	
Connection con;
	
	
	
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
		
		String cname = request.getParameter("cname").toString();
		String postname = request.getParameter("postname").toString();
		String jobdesc = request.getParameter("jobdesc").toString();
		int exp =Integer.parseInt(request.getParameter("exp").toString());
		long sal = Long.parseLong(request.getParameter("sal").toString());
		String pass = request.getParameter("password").toString();
		con=getConnection();
		if(dao.CmpDao.cmpCheck(cname,pass,con)) {
			//UserExists
			request.setAttribute("err", "Company already exists please check your credentials or create a new account.");
			redirectTo("/companyregister.jsp",request,response);
		}
		else {
			//userdoes'nt exits
			dao.CmpDao.addCmp(new Company(cname,pass,postname,jobdesc,exp,sal),con);
			HttpSession session = request.getSession();
			session.setAttribute("cname", cname);
			session.setAttribute("username", "");
			redirectTo("/applicants.jsp",request,response);
		}
		
	}
	
	public void redirectTo(String url ,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);	
	}
	
	
	public boolean userCheck(String u, String p){
		return true;
	}
	
}
