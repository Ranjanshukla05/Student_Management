package Com.Student.Manage;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao { 
	
	public static boolean InsertStudentDataToDb(Student st) {
		boolean f= false;
		//jdbc code
		
		try {
			Connection con = Cp.createC();
			String q = "insert into students(sname,sphone,scity) value (?,?,?)";
			//PreparedStatement.
			PreparedStatement pstm = con.prepareStatement(q);
			//Set the value of parameter
			pstm.setString(1, st.getStudentname());
			pstm.setString(2, st.getStudentphone());
			pstm.setString(3, st.getStudentcity());
		
			//execute 
			pstm.executeUpdate();
			
			f= true;
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
				
		
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f= false;
		try {
			Connection con= Cp.createC();
			String q = "delete from students where sid = ?";
			PreparedStatement pstm = con.prepareStatement(q);
			pstm.setInt(1, userId);
			
			pstm.executeUpdate();
			f= true;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static void ShowAllStudent() {
		// TODO Auto-generated method stub
		try {
			Connection con=Cp.createC();
			String q= "select * from students;";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id =(set.getInt(1));
				String name = (set.getString(2));
				String phone = (set.getString(3));
				String city =(set.getString("scity"));
				
				System.out.println("Id "+id);
				System.out.println("Name "+name);
				System.out.println("Phone "+phone);
				System.out.println("City "+city);
				
				System.out.println("----------------------");

				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
