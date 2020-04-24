package com.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.UserDAO;

import com.supportclass.*;


public class SendPublicKey extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		String sub = req.getParameter("no");
		
		System.out.println("Submit :"+sub);
		
		if(sub.trim().equals("1"))
		{
			
			
			HttpSession hs = req.getSession();
			String req_no=req.getParameter("requestno");
			
			String id=req.getParameter("uid");
			
			String ownerid = hs.getAttribute("userid").toString();
			try {
			
			String destFilePath = req.getRealPath("")+"\\Files\\Encryption\\public_key.txt";
			 
			 
			// PublicKey publicKey = (PublicKey) SerializeToDatabase.getPublicKey(ownerid);
			
			String publi = UserDAO.gettPublickey(ownerid);
				
				File f = new File(destFilePath);
				 FileWriter fos1 = new FileWriter(f);
			     BufferedWriter fw = new BufferedWriter(fos1);
			     fw.write(publi);
			     fw.close();
				 
				
			     
			  String user_email = UserDAO.getUser_Email(id);
			  

				boolean sendMailflag=CL_SendMail.sendPersonalizedMail(user_email.trim(), "internsangular@gmail.com", "internship", "Public Key Details", "PFA", destFilePath, "smtp.gmail.com", "465");
				  
				System.out.println("sendMailflag :"+sendMailflag);
				
				boolean flg = UserDAO.updatekeyStatus(id);
				
				if(flg&&sendMailflag)
				{
					boolean gl = UserDAO.deleteReq(Integer.parseInt(req_no));
					rd = req.getRequestDispatcher("/JSP/Admin/view_request.jsp?no=1");
					rd.forward(req,resp);
				}
				else
				{
					rd = req.getRequestDispatcher("/JSP/Admin/view_request.jsp?no=2");
					rd.forward(req,resp);
				}
			  
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		else
		{
			System.out.println("its came to reject part");
			String req_no=req.getParameter("requestno");
			
			System.out.println("Req No :"+req_no);
			
			boolean gl = UserDAO.deleteReq(Integer.parseInt(req_no));
			    
			System.out.println("Delete Status :"+gl);
			 if(gl)
			 {
				 rd = req.getRequestDispatcher("/JSP/Admin/view_request.jsp?no=3");
					rd.forward(req,resp); 
			 }
			 else
			 {
				 rd = req.getRequestDispatcher("/JSP/Admin/view_request.jsp?no=2");
					rd.forward(req,resp); 
			 }
		
		
		}
	}
			
	}

