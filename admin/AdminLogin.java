package com.admin;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.AdminDAO;

/**
 * @author Amutha
 * @ProjectName Cloud_Query
 * @FileName AdminLogin.java
 */
public class AdminLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");

		System.out.println("userid and password is: " + userid + ","+ password + "");
		
		boolean checkFlag = AdminDAO.checkAdmin(userid, password);
		
		System.out.println("chkflag........." + checkFlag);
		
		if (checkFlag)
		{
			System.out.println("Status ");
			
			HttpSession hs = req.getSession(true);
			hs.setAttribute("userid", userid);
			RequestDispatcher rd = req.getRequestDispatcher("/JSP/Admin/adminhome1.jsp");
			rd.forward(req, resp);

		} 
		else
		{
			System.out.println("Fail");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp?no=1");
	
			rd.forward(req, resp);

		}
	}

}
