package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.UserDAO;

public class UserCPass1 extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		
		PrintWriter out=response.getWriter();
		System.out.println("Pass_Word Setting is Going on");
		String uid=request.getParameter("uid");
		System.out.println(uid);
		String pass=request.getParameter("newpass");
		System.out.println(pass);
		
		
boolean		result=UserDAO.ChangePass(uid, pass);
		if(result)
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp?no=9");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp?n=10");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
