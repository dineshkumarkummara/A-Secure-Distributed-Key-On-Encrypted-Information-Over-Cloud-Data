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
import com.Database.UserDAO;




public class EditProfile extends HttpServlet 
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
				ResultSet rs=AdminDAO.getProfile(name);
				if(rs.next())
				{
					rs=AdminDAO.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("admin", name);
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/editprof.jsp?no=0");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/JSP/Admin/editprof.jsp?no=1");

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
				boolean result=AdminDAO.editProfile(s);
				if(result)
				{
					ResultSet rs=AdminDAO.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("admin", name);
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/JSP/Admin/editprof.jsp?no=1");
			}
			if(no==3)
			{
				String req_no=request.getParameter("requestno");
				
				System.out.println("Req No :"+req_no);
				
				boolean gl = UserDAO.deleteReq1(Integer.parseInt(req_no));
				    
				System.out.println("Delete Status :"+gl);
				 if(gl)
				 {
					 RequestDispatcher rd=null;
					 rd = request.getRequestDispatcher("/JSP/User/users.jsp?no=2");
						rd.forward(request,response); 
				 }
				 else
				 {
					 RequestDispatcher rd=null;
					 rd = request.getRequestDispatcher("/JSP/User/users.jsp?no=2");
						rd.forward(request,response); 
				 }
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin EditProfile Servlet......"+e);
			out.println("Opps's Error is in Admin EditProfile Servlet......"+e);
		}
	}
}
