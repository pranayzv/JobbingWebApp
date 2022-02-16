package dao;

import java.sql.*;

public class ReqDao {
	
	
	public static boolean reqCheck(String c,String e,Connection con){
		
		String query = "Select count(cname) from requests where uname='"+e+"' AND cname='"+c+"'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
            
            rs.next();
            if(rs.getInt("count(cname)")>0){
                    return true;
                }
                
            
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
	
	
public static void addReq(String c,String e,Connection con){
		if(!reqCheck(c,e,con)) {
	
		try {
			PreparedStatement ps = con.prepareStatement(jobbingutils.Constants.REQINSERT);
			ps.setString(1,c);
			ps.setString(2,e);
						
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		}
	}
	
	
	

}
