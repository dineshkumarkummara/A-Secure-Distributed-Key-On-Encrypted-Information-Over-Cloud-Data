/**
 * 
 */
package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.UserDAO;




/**
 * @author Amutha

 *Project:-DM_DataRetrieva
 
 *File:-ChangePass.java
 */
public class ChangePass_User extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			if(no==1)
			{
				String name=request.getParameter("id");
				request.setAttribute("userid",name);
				RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/changepass.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				String id=request.getParameter("user_id");
				String pass=request.getParameter("pass");
				String npass=request.getParameter("npass");
				String cpass=request.getParameter("cpass");
				
				
				
				boolean result=UserDAO.checkUser(id, pass);
				if(result)
				{
					if(npass.equals(cpass))
					{
						result=UserDAO.ChangePass(id, cpass);
						if(result)
						{
							
							RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/changepass.jsp?no=4");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/changepass.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/changepass.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/User/changepass.jsp?no=1");
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
