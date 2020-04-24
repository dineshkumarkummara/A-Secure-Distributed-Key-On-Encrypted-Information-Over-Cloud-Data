package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Accesspriority extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
		{
	HttpSession s=req.getSession();
	StringBuffer sb=new StringBuffer();
	String grade[]=req.getParameterValues("grades");
	if(grade==null)
	{
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/JSP/Admin/fileupload1.jsp");
		rd.forward(req, resp);
		
	}else
	{
		for(int i=0;i<grade.length;i++)
		{
			System.out.println("got value is :"+grade[i]);
			sb.append(grade[i]+"~");
		}
		s.setAttribute("grade", sb.toString());
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/JSP/Admin/fileupload.jsp");
		rd.forward(req, resp);
	}
	
	
}
}
