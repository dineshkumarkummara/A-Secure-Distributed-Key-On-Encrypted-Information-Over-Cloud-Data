package com.user.action;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import com.Database.Global;
import com.Database.UserDAO;
import com.supportclass.Cloud1_Download;
import com.supportclass.RSA_File_EncryptionDecryption;
import com.supportclass.ReadFile;
import com.supportclass.ReadFile1;
import com.supportclass.SerializeToDatabase;
import com.test.Decrypt_New;




public class Decryption extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		String dest ="", dest1="";
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userid = session.getAttribute("userid").toString();
		
		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		try {
			
			
			List fileItems = servletFileUpload.parseRequest(request);

			FileItem file = (FileItem) fileItems.get(0);
			
			FileItem file1 = (FileItem) fileItems.get(1);
			
			String filenm = file1.getString();
			
			System.out.println("File Intem cvcbcv:" + file.getName()+"File Name "+file1.getString());

			String fileName = request.getRealPath("") + "/Files/Decryption/"+ file.getName();
			
			System.out.println("File Name :"+fileName.trim());
			

			OutputStream outputStream2 = new FileOutputStream(fileName);
			InputStream inputStream2 = file.getInputStream();

			int readBytes2 = 0;
			byte[] buffer2 = new byte[10000];
			while ((readBytes2 = inputStream2.read(buffer2, 0, 10000)) != -1)
			{
				outputStream2.write(buffer2, 0, readBytes2);
				
			}
			outputStream2.close();
			inputStream2.close();
			
			    
			if (file.getName() != null)
			{
				
				System.out.println("-------------------- "+fileName);
				//File Download Process //
				String server = Global.SERVER1;
		     
		        String user = Global.FTP_USER1;
		        String pass = Global.FTP_PASS1;
		        
		        

				String dirToCreate = "Cloud_DataRetrieval";

				String dwn_file_path = request.getRealPath("") + "/Files/Download/"+filenm;

				// Download File From Cloud 1 //
				String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filenm.trim(),dirToCreate.trim(),dwn_file_path.trim());
						
				 System.out.println("Download File Path :"+dwn_file_path);
				 
					
				//Read Public Key //
				String pubkey = ReadFile1.readfile(fileName);
				
				String[] pu = pubkey.split("~");
				
				
								
				BigInteger n = null,e = null;
				
				BigInteger[] ciphertext=new BigInteger[pu.length];
				
				for(int i=0;i<pu.length;i++)
				{
					
					
					 n=new BigInteger(pu[0]);
					 e=new BigInteger(pu[1]);
					
					
				}
				System.out.println("BigInteger "+n+"."+e);
				
				
				
				String encry_data = ReadFile.readfile(dwn_file_path);
				
				System.out.println("encry_data "+encry_data.trim());
				
				//Decryption Process //
				String s = Decrypt_New.decrypt(encry_data.trim(),n,e);
				
				System.out.println("s "+s.trim());
				
				
				dest = request.getRealPath("")+ "/Files/Decryption/Decrypt_" +filenm;
				dest="E:\\Downloads\\"+filenm;
					System.out.println("Decryption File Path :" + dest);
					
					
					File f = new File(dest);
					 FileWriter fos1 = new FileWriter(f);
				     BufferedWriter fw = new BufferedWriter(fos1);
				     fw.write(s.trim());
				     fw.close();
				
				
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				String date = formatter.format(currentDate.getTime());
				String time = formatter1.format(currentDate.getTime());
				System.out.println("++++++++=========++++++++++++++++++++++++++++++");
				 System.out.println("Date:"+date+  "Time:"+time+   "User:"+userid+  "Filename:"+filenm);
				boolean flag = UserDAO.insertTrans(date,time,userid,filenm);
				System.out.println("Your File Successfully Downloaded");
				System.out.println("Decryption Status :"+f);
				
				//response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+dest+"&download=true");
				response.sendRedirect(request.getContextPath()+"/DownloadFile?fileNames="+dest+"&download=true");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}