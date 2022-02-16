package controller;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {


	public Connection con;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmp = request.getParameter("cmp").toString().split(":")[2];
		String u = request.getParameter("cmp").toString().split(":")[1];
		con=getConnection();
		dao.ReqDao.addReq(cmp, u, con);
		redirectTo("/Main.jsp",request,response);
		
	}
	
	public void redirectTo(String url ,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);	
	}
	
	
	public boolean userCheck(String u, String p){
		return false;
	}

}
