/**
 * 
 */
package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.UserDAO;








public class EditProfile_User extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			
			if(no==1)
			{
				String name=request.getParameter("name");
				System.out.println("Name :"+name);
				ResultSet rs=UserDAO.getProfile(name);
				if(rs.next())
				{
					rs=UserDAO.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("admin", name);
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/editprof.jsp?no=0");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/JSP/User/editprof.jsp?no=1");

			}
			if(no==2)
			{
				String name=request.getParameter("admin");
				String [] s=new String [5];
				s[0] =request.getParameter("id");
				s[1]=request.getParameter("name");
				s[2]=request.getParameter("loginid");
				s[3]=request.getParameter("email");
				s[4]=request.getParameter("phone");
				boolean result=UserDAO.editProfile(s);
				if(result)
				{
					ResultSet rs=UserDAO.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("admin", name);
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/JSP/User/editprof.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User EditProfile Servlet......"+e);
			out.println("Opps's Error is in User EditProfile Servlet......"+e);
		}
	}
}
