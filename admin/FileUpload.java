package com.admin;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

import com.Database.AdminDAO;
import com.Database.Global;
import com.Database.UserDAO;

import com.supportclass.*;

import com.test.*;
import com.util.Hashing;





public class FileUpload extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		
		HttpSession s3=request.getSession();
		String grades1=s3.getAttribute("grade").toString();
		String grades2 []=grades1.split("~");
	
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ArrayList list=new ArrayList();
		
		
	//	List list =  Arrays.asList(names); 
		
		System.out.println("========FileUpload Servlet in admin package===============");
		//System.out.println("length :"+grade.length);
		
			
		
		System.out.println("=======================");
		HttpSession hs = request.getSession();

		//String id = hs.getAttribute("useid1").toString();

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		try {

			List fileItems = servletFileUpload.parseRequest(request);
			FileItem file = (FileItem) fileItems.get(0);
			

			// Read First Files //
			
			String fileName = request.getRealPath("") + "/Files/Upload/"+ file.getName();
			System.out.println("Source FILE Path :=>"+fileName);
			OutputStream outputStream = new FileOutputStream(fileName);
			InputStream inputStream = file.getInputStream();

			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
			{
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			
			
			if (file.getName() != null)
			{

				String id = hs.getAttribute("userid").toString();
				
				
				File fl = new File(fileName);
				//boolean f = RSA_File_EncryptionDecryption.decryptFile(fileName,dest, privateKey);
				
				String destFilePath = request.getRealPath("")+"\\Files\\Encryption\\Encrypt_"+fl.getName();
				//PublicKey pubKey = (PublicKey) SerializeToDatabase.getPublicKey(id);
				
				//PrivateKey privateKey = (PrivateKey) SerializeToDatabase.getPrivateKey(id);
				
				//boolean flg = RSA_File_EncryptionDecryption.encryptFile(fileName, destFilePath.trim(),privateKey);

				String s = ReadFile.readfile(fileName);
				
				System.out.println("s"+s);
				///its conidering spaces 
				
				String privateley =UserDAO.gettPrivatekey(id);
				///it returns the private key 
				String[] ne=privateley.split("~");
				
				//String n=ne[0].trim();
				//String d=ne[1].trim();
				
				BigInteger n=null,d=null;				
				BigInteger[] ciphertext=new BigInteger[ne.length];				
				for(int i=0;i<ne.length;i++)	
				{				
					 n=new BigInteger(ne[0]);
					 d=new BigInteger(ne[1]);				
					
				}
				
				///extracting it
				
				String s1=Encrypt_New.encrypt(s,n,d);///File Encrypted Successfully
				
				System.out.println("s1"+s1);
				
				File output = new File(destFilePath);				
				FileWriter fw = new FileWriter(output);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(s1.trim());
				bw.close();
				fw.close();
				
				System.out.println("Encryption :"+s1);
				//if(flg)
				//{
					//File Upload Process //
					String server = Global.SERVER1;
			       String filename = file.getName();
			        String user = Global.FTP_USER1;
			        String pass = Global.FTP_PASS1;
			        
			        ////gettting the cloud link
			        String dirToCreate = "Cloud_DataRetrieval/"+filename;
			        
			        File f = new File(destFilePath);
			        System.out.println( "======URL===========");
			        System.out.println("server :"+server+" filename :"+filename+" User :"+user+" pass "+pass+" F :"+f+" dirToCreate :"+dirToCreate);
			        
			       System.out.println("===========File uploading to cloud==============");
					FileUpload1.upload(server,user,pass,filename,f,dirToCreate);
					System.out.println("File uploaded Successfuly!!");
					// Read  file //
					
					////Encrypted and stored successfully 
					
					///now the key rank start
					
					
					String data1 = ReadFile.readfile(fileName);
					String data3=data1.toLowerCase();
					System.out.println("**Lower case Covert File :***\n"+data3);
					
					///Reading the words and converting into Loweracse
					// fileName = new File(" data1");
					FileWriter fooWriter = new FileWriter(fileName, false); // true to append  & false to overwrite.					                                                
					fooWriter.write(data3);
					fooWriter.close();					
					
					//String data2=Program.remov(fileName);
					String data2=Program.filterwords(data3);//(fileName);
					
					
					
					System.out.println("**Remove Covert File :***\n"+data2);
					FileWriter foWriter = new FileWriter(fileName, false); // true to append
                    // false to overwrite.
                     foWriter.write(data2);
                     foWriter.close();
					
					String dat = TextSearch.text_Search(fileName);					
					 System.out.println("Text_Search Of words :==>"+dat);
					   
					   // Filter Process
					   ArrayList key_data = TextSearch.text_filter(dat);	////This method is checking stop words				   
					   System.out.println("Text_filter data  :"+key_data);
					   
					   
					   ///Heree we got the data with arraylist
					   StringBuffer sb = new StringBuffer();
					   
					  
					   for(int i=1;i<key_data.size();i++)
					   {
							  sb.append((key_data.get(i))+"-");				  
						 					
					   }
					   System.out.println("Buffer dataa :"+sb);
					   System.out.println("Key word Inserstion method@@@"+key_data);
					   
					   
					   TextSearch.text_count1(key_data,file.getName());///Contents to database done					   
					   System.out.println("word Counting methos@@@@");
					   TextSearch.text_count(key_data,file.getName());
					   
					   
					   int tot = AdminDAO.gettotal(file.getName());///THis will print toatal number of keywords
					   
					   System.out.println("KNN Needed first X1 value:::::--"+tot);
					   System.out.println("-------------------KNN");
					   
					   int X1=tot;
					   int mindistance= KNN_Classifier.KNN_PreProcess(X1,filename);
					   
					   AdminDAO.find_min_file(mindistance);
					   
					  // System.out.println("Found file"+rs4.getString(2));
					   
					   
					  
					  
					  
					  
					  
					   boolean status = AdminDAO.updatetotal(file.getName(),tot);
					   boolean status1=AdminDAO.KNN_Upload(file.getName(), key_data, X1);
							   
					   ///File Keywords total Updates
					   //Find Ranking 
					   
					   
					  TextSearch.Calculate_Rank(file.getName());
					  
					  int fno1=AdminDAO.getFileno(file.getName());
					  String fno=String.valueOf(fno1);
					  
					  for(int i=0;i<key_data.size();i++)
					   {
						  String msg=(String) key_data.get(i);
						  
						  int count = Collections.frequency(list, msg);
						  if(count==0)
						  {
							  
							  for(int j=0;j<grades2.length;j++)
							  {
								  String k1=grades2[j];
								  int k3=0;
								  int k=Integer.parseInt(k1);
								  String hash=Hashing.HashingFunction(msg, k) ;
								 ResultSet rs=AdminDAO.keyNo(msg, fno);
								  String rank=null;;
								  while(rs.next())
									{
										k3=rs.getInt(1);
										rank=rs.getString(2);
									}
								  String k4=String.valueOf(k3);
								  boolean flag=AdminDAO.insertHashcode(hash, fno,k4,rank);
							  }
							  list.add(msg);
							  
						  }else
						  {
							  list.add(msg);
						  }
						  
						  
						  
						   //need to get Hashcode for each word
					   }
					   
					   
					   
					System.out.println("File insertion status : "+status);
					
					if(status)
					{
						
						HttpSession hs5=request.getSession();
						hs5.setAttribute("file", filename);
						////hs5.setAttribute("min", mindistance);
					 rd = request.getRequestDispatcher("/JSP/Admin/KNN_Recom.jsp");
						
					 rd.forward(request, response);
						
					}
					else
					{
						rd = request.getRequestDispatcher("/JSP/Admin/fileupload.jsp?no=2");
						
						 rd.forward(request, response);
					}
				//}
				//else
				//{
					System.out.println("Error,In Encryption Process");
				//}
				
				
				
			}
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	
}