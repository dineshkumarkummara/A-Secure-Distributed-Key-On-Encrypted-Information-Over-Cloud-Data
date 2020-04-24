package com.user.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.UserDAO;

public class Request extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
	
		HttpSession s=req.getSession();
		RequestDispatcher rd=null;
		String ui = s.getAttribute("userid").toString();
		
		try
		{
			boolean f = UserDAO.insertReq(ui);
			
			if(f)
			{
				rd = req.getRequestDispatcher("/JSP/User/key_request.jsp?no=1");
				rd.forward(req, resp);
			}
			else
			{
				
				rd = req.getRequestDispatcher("/JSP/User/key_request.jsp?no=2");
				rd.forward(req, resp);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
