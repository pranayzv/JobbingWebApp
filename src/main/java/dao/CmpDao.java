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




public class CmpDao {

	
	
	public static ArrayList<Company> getCompanyList(String u,Connection con) {
		ArrayList<Company> cmp = new ArrayList<Company>();
		 String query = " SELECT * FROM "+jobbingutils.Constants.COMPTABLE;
         Statement st;
     try {
         st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
         
         while(rs.next()){
         	
             if(!ReqDao.reqCheck(rs.getString("cname"), u, con)){
                 cmp.add(new Company(rs.getString("cname"),"" ,rs.getString("postname"), rs.getString("jobdesc"), rs.getInt("exp"),rs.getLong("salary")));
             }
         }
     } catch (SQLException ex) {
         
     }
   
     return cmp;
	}
	
	

	public static boolean cmpCheck(String usr, String pass,Connection con){
	        String query = " SELECT * FROM "+jobbingutils.Constants.COMPTABLE;
	            Statement st;
	        try {
	            st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            
	            while(rs.next()){
	            	
	                if(rs.getString("cname").equals(usr) && rs.getString("pass").equals(pass)){
	                	
	                    return true;
	                }
	            }
	        } catch (SQLException ex) {
	            
	        }
	       
	        return false;
	    }
	public static Company getCmp(String usr,Connection con){
        String query = " SELECT * FROM "+jobbingutils.Constants.COMPTABLE;
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
            	
                if(rs.getString("cname").equals(usr)){
                    return new Company(rs.getString("cname"),"" ,rs.getString("postname"), rs.getString("jobdesc"), rs.getInt("exp"),rs.getLong("salary"));
                	
                }
            }
        } catch (SQLException ex) {
            
        }
       
        return null;
    }
	
public static void addCmp(Company e,Connection con){
		
		try {
			PreparedStatement ps = con.prepareStatement(jobbingutils.Constants.COMPINSERT);
			ps.setString(1,e.getCname());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getPostname());
			ps.setString(4,e.getJobdesc());
			ps.setInt(5,e.getExperience());
			ps.setLong(6,e.getSalary());			
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
	}
	
	

}
