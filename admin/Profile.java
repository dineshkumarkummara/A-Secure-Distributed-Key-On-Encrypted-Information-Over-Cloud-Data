/**
 * 
 */
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.AdminDAO;



public class Profile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			String name=request.getParameter("name");
			
			ResultSet rs=AdminDAO.getProfile(name);
			if(rs.next())
			{
				rs=AdminDAO.getProfile(name);
				request.setAttribute("rs",rs);
				request.setAttribute("admin", name);
				RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/profile.jsp?no=0");
				rd.forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath()+"/JSP/Admin/profile.jsp?no=1");
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in AdminProfile Servlet......"+e);
			out.println("Opps's Error is in AdminProfile Servlet......"+e);
		}
	}
}
