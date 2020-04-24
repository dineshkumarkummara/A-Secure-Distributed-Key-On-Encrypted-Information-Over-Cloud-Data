/**
 * 
 */
package com.supportclass;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * @author Amutha
 
 */
public class Utility
{
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	Utility.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\Config.properties");
			property.load(in);
			pro=property.getProperty(str);
			System.out.println("Property to return : "+pro);
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	public static void hideProcess(File bmpinfile,String bmpoutfile,byte intxt[]) throws Exception
	{

		try
		{
			FileInputStream inbmp=new FileInputStream(bmpinfile);
			FileOutputStream outbmpf=new FileOutputStream(bmpoutfile);
			//FileInputStream intxt=new FileInputStream(txtinfile);
			DataOutputStream outbmp=new DataOutputStream(outbmpf);
			int norm_byte;
			int in_byte;
			int xor;
			int count=1;
			int in_size=intxt.length;
			//in_size gives the length of the array(intxt[])
			int inb=0;
			int skip=0;
			
			System.out.println("Processing....");

			while((norm_byte=inbmp.read())!= -1)
			{
				if(count<55)
				{
					outbmp.write(norm_byte);				
				}	
				
				if(count==55)
				{
					outbmp.writeInt(in_size);
					inbmp.skip(2);
					count=count+2;
					
				}
				
				if((count==59) || (count==60))
				{
					outbmp.write(norm_byte);
				}

				
				if (count > 60)  
				{
					if (count <(61 + 101 * in_size)) 
					{
						//System.out.println(norm_byte);						
						if(skip<100)
						{
							outbmp.write(norm_byte);									
							skip++;						
						}
						else
						{							
							skip=0;
							in_byte=intxt[inb++];
							xor=in_byte ^ 1;
//							System.out.println(in_byte+","+xor);
							outbmp.write(xor);								
						}
						
					}
					else
					{
						outbmp.write(norm_byte);
					}

				}

				count++;
			
			}
//			System.out.println("Count : "+count);
			outbmp.flush();	
			inbmp.close();
			outbmp.close();
			outbmpf.close();
			System.out.println("Process Successfull.....!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static byte[] extractProcess(String bmpinfile) throws Exception
	{	
		byte bout[] = null;
		try
		{			
			FileInputStream in=new FileInputStream(bmpinfile);
			DataInputStream din=new DataInputStream(in);
			din.skip(54);
			int size=din.readInt();
			System.out.println("Size :"+size);
			bout=new byte[size];
			int count=0;
			int insec_txt=0;
			
			din.skip(2);
			
			while(count < size)
			{
				din.skip(100);
				insec_txt=din.read();
				bout[count]=(byte)(insec_txt ^ 1);
				
				count++;		
			}
						
			System.out.println("The byte length is  :"+bout.length);
			System.out.println(count+","+size+","+bout[0]+","+bout[1]+","+bout[2]+","+bout[3]+","+bout[4]);
			in.close();		

		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		return bout;
	}
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="TUESDAY";
			else if(no==4)
				day="WEDNESDAY";
			else if(no==5)
				day="THURSDAY";
			else if(no==6)
				day="FRIDAY";
			else if(no==7)
				day="SATURDAY";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	public static void main(String asdf[])
	{
		System.out.println(Utility.getPro("Driver"));
	}
}
