package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.Employee;

public class EmpDao {
	
	

	
	public static ArrayList<Employee> getEmpList(String u,Connection con) {
		ArrayList<Employee> emp = new ArrayList<Employee>();
		 String query = " SELECT * FROM "+jobbingutils.Constants.EMPTABLE;
         Statement st;
     try {
         st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
         
         while(rs.next()){
         	
             if(ReqDao.reqCheck(u,rs.getString("uname"), con)){
                 emp.add(new Employee(rs.getString("fname"),rs.getString("uname"),"" ,rs.getString("qualification"), rs.getInt("exp"), rs.getString("gender") ,rs.getLong("mob")));
             }
         }
     } catch (SQLException ex) {
         
     }
     return emp;
	}
	
	
	public static Employee getEmp(String usr,Connection con){
        String query = " SELECT * FROM "+jobbingutils.Constants.EMPTABLE;
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
            	
                if(rs.getString("uname").equals(usr)){
                    return new Employee(rs.getString("fname"),rs.getString("uname"),"" ,rs.getString("qualification"), rs.getInt("exp"), rs.getString("gender") ,rs.getLong("mob"));
                }
            }
        } catch (SQLException ex) {
            
        }
        return null;
    }

	public static boolean empCheck(String usr, String pass,Connection con){
	        String query = " SELECT * FROM "+jobbingutils.Constants.EMPTABLE;
	            Statement st;
	        try {
	            st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            
	            while(rs.next()){
	            	
	                if(rs.getString("uname").equals(usr) && rs.getString("pass").equals(pass)){
	                    return true;
	                }
	            }
	        } catch (SQLException ex) {
	            
	        }
	        return false;
	    }
	
	
	
	
	
	public static void addEmp(Employee e,Connection con){
		
		try {
			PreparedStatement ps = con.prepareStatement(jobbingutils.Constants.EMPINSERT);
			ps.setString(1,e.getFullname());
			ps.setString(2,e.getUsername());
			ps.setString(3,e.getPassword());
			ps.setString(4,e.getQualification());
			ps.setString(5,e.getGender());
			ps.setInt(6,e.getExperience());
			ps.setLong(7,e.getMob());			
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
	}
	
	
	
	
	

}
