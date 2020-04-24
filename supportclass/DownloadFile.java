/*
 * 
 */
package com.supportclass;
/**
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DownloadFile extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		File prefile = null;
		ServletOutputStream outputStream = null;
		InputStream input = null;
		try 
		{
			outputStream = response.getOutputStream();
			String filePath = request.getParameter("fileNames");  //filepath
			if(filePath != null && filePath.trim().length()>0)
			{
				String download = request.getParameter("download");//download or display
				prefile = new File(filePath);
				byte buff[] = new byte[8192];
				input = new FileInputStream(prefile);
				String contenttype = filePath.substring(filePath.lastIndexOf(".")+1, filePath.length());
				contenttype = contenttype.toLowerCase();
				
				if(download != null && download.trim().length()>0)
				{
					response.setContentType("application/octet-stream");
				}
				
				
					if (contenttype != null)
					{
						String responseType = getResponseContentType(contenttype);
						response.setContentType(responseType);
					}
					else 
					{
						response.setContentType("application/octet-stream");
					}
				
				response.setHeader("Content-Length", String.valueOf(prefile.length()));
				if(download != null && download.trim().length()>0)
				{
					response.setHeader("Content-Disposition","attachment; filename=\""+ prefile.getName()+"\"");
				}
				else
				{
					response.setHeader("Content-disposition", (new StringBuilder("inline; filename=")).append(prefile.getName()).toString());
				}
				response.addHeader("Cache-Control", "no-transform,max-age=0");
				int i = 0;
				while ((i = input.read(buff)) > 0) 
				{
					outputStream.write(buff, 0, i);
					outputStream.flush();
				}
			}
			//DeleteFiles.delete(prefile);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (input != null)
				input.close();
			if (outputStream != null)
				outputStream.close();
		}
	}
	private String getResponseContentType(String contenttype)
	{
		String responseType = "";
		if(contenttype.indexOf("doc")>-1)
		{
			responseType = "application/vnd.ms-word";
		}
		if(contenttype.indexOf("rtf")>-1)
		{
			responseType = "application/rtf";
		}
		else if(contenttype.indexOf("xls")>-1)
		{
			responseType = "application/vnd.ms-excel";
		}
		else if(contenttype.indexOf("ppt")>-1)
		{
			responseType = "application/ppt";
		}
		else if(contenttype.indexOf("xml")>-1)
		{
			responseType = "text/xml";
		}
		else if(contenttype.indexOf("html")>-1)
		{
			responseType = "text/html";
		}
		else if(contenttype.indexOf("htm")>-1)
		{
			responseType = "text/htm";
		}
		else if(contenttype.indexOf("txt")>-1 || contenttype.indexOf("log")>-1)
		{
			responseType = "text/plain";
		}
		else if(contenttype.indexOf("pdf")>-1)
		{
			responseType = "application/pdf";
		}
		else if(contenttype.indexOf("gif")>-1)
		{
			responseType = "image/gif";
		}
		else if(contenttype.indexOf("png")>-1)
		{
			responseType = "image/png";
		}
		else if(contenttype.indexOf("jpg")>-1)
		{
			responseType = "image/jpg";
		}
		else if(contenttype.indexOf("jpeg")>-1)
		{
			responseType = "image/JPEG";
		}
		else if(contenttype.indexOf("jpe")>-1)
		{
			responseType = "image/JPEG";
		}
		else if(contenttype.indexOf("bmp")>-1)
		{
			responseType = "image/bmp";
		}
		else if(contenttype.indexOf("jpeg")>-1)
		{
			responseType = "image/JPEG";
		}
		else if(contenttype.indexOf("tiff")>-1)
		{
			responseType = "image/tiff";
		}
		else if(contenttype.indexOf("tif")>-1)
		{
			responseType = "image/tiff";
		}
		else if(contenttype.indexOf("html")>-1)
		{
			responseType = "text/html";
		}
		else
		{
			responseType = "application/octet-stream";
		}
		return responseType;
	}
}
