/**
 * 
 */
package com.supportclass;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Cloud1_Download 
{
	public static String download( String ftpServer, String user, String password,
	         String fileName,String userName,String dwn_fp) throws MalformedURLException,
	         IOException
	   {
		
		System.out.println("ftpServer :"+ftpServer+"user :"+user+"password :"+password+"fileName  :"+fileName+"userName :"+userName+"dwn_fp :"+dwn_fp);
		 
		//String fopth = "C:/Dowmloads/"+fileName;
		boolean flag=false;
		   String dir="";
	      if (ftpServer != null && fileName != null )
	      {
	         StringBuffer sb = new StringBuffer( "ftp://" );
	         // check for authentication else assume its anonymous access.
	         if (user != null && password != null)
	         {
	            sb.append( user );
	            sb.append( ':' );
	            sb.append( password );
	            sb.append( '@' );
	         }
	         sb.append( ftpServer );
	         sb.append( '/' );
	         sb.append( userName );
	         sb.append( '/' );
	         sb.append( fileName );
	         /*
	          * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
	          * listing
	          */
	         sb.append( ";type=i" );
	         
	         System.out.println("sb :"+sb.toString());
	         BufferedInputStream bis = null;
	         BufferedOutputStream bos = null;
	         try
	         {
	            URL url = new URL(sb.toString().trim());
	            URLConnection urlc = url.openConnection();
	             //dir="C:/Downloads/"+fileName;
	            dir=dwn_fp;
	            
	            System.out.println("Dir : "+dir+"dwn_fp : "+dwn_fp+"fileName : "+fileName);
	            File f = new File(dir);
	            /*if(!f.exists())
	            {
	            	f.mkdir();
	            }*/
	            bis = new BufferedInputStream(urlc.getInputStream());
	            bos = new BufferedOutputStream( new FileOutputStream(dir) );

	            
	            int i;
	            while ((i = bis.read()) != -1)
	            {
	               bos.write( i );
	               flag=true;
	            }
	            
	            //System.out.println("Encrypted File Downloaded from Cloud CVS(Amutha) Successfully ========");
	            if(flag==true)
	            {
	            	//UserDAOImpl.deleteFile(fileName);
	            }
	            
	         }
	         finally
	         {
	            if (bis != null)
	               try
	               {
	                  bis.close();
	               }
	               catch (IOException ioe)
	               {
	                  ioe.printStackTrace();
	               }
	            if (bos != null)
	               try
	               {
	                  bos.close();
	               }
	               catch (IOException ioe)
	               {
	                  ioe.printStackTrace();
	               }
	         }
	      }
	      else
	      {
	         System.out.println( "Input not available" );
	      }
	      return dir;
	   }
}
