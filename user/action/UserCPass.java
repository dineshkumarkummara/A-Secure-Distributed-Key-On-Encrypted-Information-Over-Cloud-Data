package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.UserDAO;

public class UserCPass extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		System.out.println("Pass_Word Setting is Going on");
		String email=request.getParameter("email");
		System.out.println(email);
		String messsage="http://localhost:9999/multikeyword%20-%20Copy/changepass.jsp";
		Send_Mail.sendPersonalizedMail(email, "Link for Password Reset", messsage);
		
		response.sendRedirect("index.html");
		
		
	}
}
