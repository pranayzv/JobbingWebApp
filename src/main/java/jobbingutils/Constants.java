package jobbingutils;

import model.Company;
import model.Employee;

public class Constants {
	
	public static final String URL = "jdbc:mysql://localhost:3306/jobbing";
    public static final String USER = "root";
    public static final String PASS = "root";
    public static final String JDBC = "com.mysql.jdbc.Driver";
    public static final String COMPTABLE = "compacc";
    public static final String EMPTABLE = "empacc";
    public static final String REQTABLE = "requests";
    public static final String REQINSERT = "insert into "+REQTABLE+" values(?,?);";;
    public static final String COMPINSERT = "insert into "+COMPTABLE+" values(?,?,?,?,?,?);";
    public static final String EMPINSERT = "insert into "+EMPTABLE+" values(?,?,?,?,?,?,?);";
    public static Company company;
    public static Employee employee;
    
    /*
     * 
     * create database jobbing;
     * use jobbing;
     * 
     *  create table compacc(cname varchar(20),pass varchar(20),postname varchar(20),jobdesc varchar(50),exp int,salary bigint(20));
     *  insert into compacc values("abc","pqr","opp","related to automation",2,30000);
     *  
     *  create table empacc(fname varchar(20),uname varchar(20),pass varchar(20),qualification varchar(20),gender varchar(10),exp int,mob bigint(10));
     *  insert into empacc values("chef boi","bbvd","pass","bsc.css","attack helicopter",5,8454011899);
     *  
     *  create table requests(cname varchar(20),uname varchar(20));
     *  insert into requests values("chef","das");
     *  
     * 
     * */

}
