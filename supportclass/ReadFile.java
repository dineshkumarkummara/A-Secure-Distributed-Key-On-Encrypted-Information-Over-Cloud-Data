package com.supportclass;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile 
{
	
	public static String readfile(String fileName)
	{
		StringBuffer sb = new StringBuffer();
		try
		{
					FileInputStream fstream = new FileInputStream(fileName);  		
			  		DataInputStream in = new DataInputStream(fstream);
			        BufferedReader br = new BufferedReader(new InputStreamReader(in));        
			  		String strLine;  		
			  		while ((strLine = br.readLine()) != null)  	
			  		{
			  			String[] words=strLine.split(" ");
			  			for(String s: words)
			  			{
			  				sb.append(s);
			  				sb.append(" ");
			  				
			  			}
			  		//	sb.append(strLine.trim());
			  			
			  			
			  		}
			  		System.out.println(sb);
			  		in.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR : in ReadFile Class===>"+e);
		}
		return sb.toString();
	}

}
