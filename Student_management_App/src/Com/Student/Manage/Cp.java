package Com.Student.Manage;

import java.sql.Connection;
import java.sql.DriverManager;


public class Cp {
	
	static Connection con;
	
	public static Connection createC() {
		
		try {
			//load Driver
		   
			
			//create connection..
			String user="root";
			String password="ranjan123";
			String url ="jdbc:mysql://localhost:3306/ranjan_manage";
			
			
			con = DriverManager.getConnection(url, user, password);
		

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		} 
		return con; 
		
	}
	
	

}
