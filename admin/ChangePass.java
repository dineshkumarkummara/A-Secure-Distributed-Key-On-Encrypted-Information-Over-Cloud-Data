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

import com.Database.*;


/**
 * @author Amutha

 *Project:-Cloud_Query
 
 *File:-ChangePass.java
 */
public class ChangePass extends HttpServlet 
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
				request.setAttribute("admin",name);
				RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/changepass.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				String id=request.getParameter("user_id");
				String pass=request.getParameter("pass");
				String npass=request.getParameter("npass");
				String cpass=request.getParameter("cpass");
				String admin=request.getParameter("admin");
				request.setAttribute("admin", admin);
				
				//DBc dao=DAO.getInstance();
				boolean result=AdminDAO.loginCHK(admin, pass);
				if(result)
				{
					if(npass.equals(cpass))
					{
						result=AdminDAO.ChangePass(id, cpass);
						if(result)
						{
							
							RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/changepass.jsp?no=4");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/changepass.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/changepass.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/changepass.jsp?no=1");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
			out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
		}
	}
}
