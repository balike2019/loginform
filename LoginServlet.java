package za.co.loginform.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.loginform.models.User;
import za.co.loginform.services.LoginService;

public class LoginServlet  extends  HttpServlet{
	
	
	
	 private static final long serialVersionUID = 1L;
	 
	 
	 
	 
 protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		 
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	  User user=new User(username,password);      
	        
	        LoginService loginService=new LoginService();
		 boolean loggin=loginService.login(user);
		 if(loggin) {
			 request.getRequestDispatcher("/success.jsp").forward(request,response);
			 
			 
		 }else {
			 request.setAttribute("/errormessage","invalid login credentoial");
			 request.getRequestDispatcher("/register.jsp").forward(request,response);
		 }
		 }
		 
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		 
		 
		 
	 } 
}
