package com.user.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOut extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		String num = req.getParameter("no");
		if(num.trim().equals("1"))
		{
			resp.sendRedirect(req.getContextPath()+"?no=6");
		}
		
	}

}
