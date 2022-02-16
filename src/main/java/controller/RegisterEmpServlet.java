package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Employee;

public class RegisterEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 856405032472024365L;
	
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


	public RegisterEmpServlet() {
		
	}

	

		

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String fname = request.getParameter("fname").toString();
			String uname = request.getParameter("uname").toString();
			String qualification = request.getParameter("qualification").toString();
			int exp = Integer.parseInt(request.getParameter("exp").toString());
			long mob = Long.parseLong(request.getParameter("mob").toString());
			String gender = request.getParameter("gender").toString();
			String pass = request.getParameter("password").toString();
			con=getConnection();
			if(dao.EmpDao.empCheck(uname,pass,con)) {
				//UserExists
				request.setAttribute("err", "Employee already exists please check your credentials or create a new account.");
				redirectTo("/empregister.jsp",request,response);
			}
			else {
				//userdoes'nt exits
				
				dao.EmpDao.addEmp(new Employee(fname,uname,pass,qualification,exp,gender,mob), con);
				HttpSession session = request.getSession();
				session.setAttribute("cname", "");
				session.setAttribute("username", uname);
				redirectTo("/Main.jsp",request,response);
			}
			
		}
		
		public void redirectTo(String url ,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);	
		}
		
		
		
		
	

	
	
}
