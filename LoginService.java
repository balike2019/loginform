package za.co.loginform.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import za.co.loginform.dao.JdbcConnection;
import za.co.loginform.models.User;


public class LoginService {
	JdbcConnection jdbc=new JdbcConnection();
	
	public String register(User user) {
String studentQuery = "INSERT INTO user(username,password)"
	+"VALUES('" + user.getUsername() + "','" + user.getPassword()+"')";

		System.out.println(studentQuery);

		return jdbc.insert(studentQuery);
	}
	
public boolean logi(User user) {
	String usern=null;
	String pass=null;
	String loginquery="SELEC *  FROM user ";
	if(user.getUsername().equals(usern)&& user. getPassword().equals(pass)) {
	
	return true;
}else {
	return false;
}
}
public boolean login(User user) {
	
	
	
	  String sql="Select * from user where username='" + user.getUsername()+"', password='"+ user.getPassword()+"';";
	    	System.out.println(sql);
	    			try {
	    				
	    		ResultSet rs=	JdbcConnection.getResultSet(sql);	
	    			while(rs.next()) {
	    			
	    return true;
	    				
	    	}

	    		}catch(SQLException a) {
	    		a.printStackTrace();
	   	
			
		}
		return false;
		}



}