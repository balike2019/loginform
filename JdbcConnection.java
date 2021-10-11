package za.co.loginform.dao;

import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
public class JdbcConnection {
	String jdbc="jdbc:mysql://localhost:3306/unisa_db";	
	
	String pass="pvi@2021";
	String user="root";
	//String jdbc="jdbc:mysql://localhost:3306/unisa_db;
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	private   void connectDriver(String dbDriver) {
		
	
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbc, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public String insert(String studentQuery) {
		connectDriver(dbDriver);
		Connection conn = getConnection();
		String result = "Student Successfully Registered !";

		try {
			Statement stmt = conn.createStatement();
			
			/*String studentQuery = "INSERT INTO Student(first_name, last_name, email, phone_number, date_Of_Birth, course,maritalStatus)"
					+ "VALUES('" + student.getFirstName() + "','" + student.getLastName() + "','"
					+ student.getEmail() + "','" + student.getPhoneNumber() + "','"
					+ student.getDateOfBirth() + "','" + student.getCourse() +"','"+student.getMaritalStatus()+ "')";
*/			
			stmt.execute(studentQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}

		return result;

	}
public static int executeQuery(String sqlQuery)throws SQLException{
	Statement stmt=null;
	try {
		stmt=DriverManager.getConnection(sqlQuery).createStatement();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	int affectedRows=stmt.executeUpdate(sqlQuery);
	return affectedRows;
	}
	
	public  static  ResultSet getResultSet(String sqlQuery)throws SQLException{
		
		Statement stmt=null;
		Connection conn= DriverManager.getConnection(sqlQuery);
		try {
		stmt=conn.createStatement();
	}catch(Exception e) {
		e.printStackTrace();
		
	}
		ResultSet rs=stmt.executeQuery(sqlQuery);
return rs;
}


}