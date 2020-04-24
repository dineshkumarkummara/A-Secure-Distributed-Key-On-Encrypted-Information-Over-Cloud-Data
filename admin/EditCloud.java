package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.AdminDAO;

public class EditCloud extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		String code=req.getParameter("c_c");
		String url=req.getParameter("curl");
		String uname=req.getParameter("cuname");
		String cpwd=req.getParameter("cpass");
		
		boolean flg = AdminDAO.updateCloud(Integer.parseInt(code), url, uname, cpwd);
		
		if(flg)
		{
			
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/cloud_config.jsp?no=1");
			rd.forward(req, resp);
		}
		else
		{

			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/cloud_config.jsp?no=2");
			rd.forward(req, resp);
			
		}
		
	}

}
