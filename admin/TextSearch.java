package com.admin;

import java.io.*;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.Database.AdminDAO;
class TextSearch 
{
	
	public static String text_Search(String file)
	{
		
		StringBuffer sb = new StringBuffer();
		 try
		 {
				
				FileInputStream fstream = new FileInputStream(file);
				DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				
				//Read File Line By Line
				while ((strLine = br.readLine()) != null)
				{
					
					System.out.println ("Input data :"+strLine.trim());
					
					String[] s = strLine.split(" ");
					
					
					for(int i=0;i<s.length;i++)
					{
						//System.out.println("outer loop");
						
						char chr = strLine.charAt(i);
						StringBuffer sb1 = new StringBuffer();
						
						//sb.append(Character.toLowerCase(s[i].charAt(0))).append(s[i].substring(1)+"~");
						String k=s[i];
						for(int j=0;j<k.length();j++)
						{
							//String temp=null;
							//System.out.println("inner Loop Char :"+k.charAt(j));
							String temp=k.charAt(j)+"";
							//System.out.println("temp :"+temp);
							
							if(temp.contains("."))
							{
								
							}
							else
							if(temp.contains(","))
							{
								//System.out.println("String cotains , in--"+search);
								//search= search.replace(",","");
							}
							else
							if(temp.contains("#"))
							{
								
							}
							else							
							if(temp.contains("@"))
							{
								//System.out.println("String cotains , in--"+search);
								//search= search.replace("@","");
							}else if(temp.contains(" "))
							{
								
							}else
							{
								//System.out.println("word block");
							sb1.append(temp);	
							}
						}
						
						
						//System.out.println("word adding ");
						//sb.append(s[i].toLowerCase()+"~");
						sb.append(sb1.toString()+"~");
					}
					
					sb.append("#");
					
				}
				
				
				in.close();
		}catch (Exception e)
		 {
			e.printStackTrace();
			
					
		}
		return sb.toString().trim();
	}
	
	public static ArrayList text_filter(String original)
	{
		ArrayList data = new ArrayList();
		String[] s = original.split("#");
		
		for(int i=0;i<s.length;i++)
		{
			
			if(s[i].trim()!=null)
			{
				
				String[] word = s[i].split("~");
				
				for(int j=0;j<word.length;j++)
				{
					
					String search = word[j].trim();
					
					boolean f = AdminDAO.check(search);
					
					if(f == true)
					{
						//System.out.println("Unwanted data");
						
					}
					else
					{
						
						data.add(search);
					}
				}
				
			}
			
		}
		
		return data;
		
	}
	
	public static void text_count(ArrayList datas,String fname)
	{
		Set<String> unique = new HashSet<String>(datas);
		
		for (String temp : unique)
		{
			
			int count = Collections.frequency(datas, temp);
				
			AdminDAO.count_word(temp,count,fname);
				
			System.out.println(temp + ": " +count );
			
			
		}
		
	}
	
	public static void text_count1(ArrayList datas,String fname)
	{
		
		StringBuffer sb = new StringBuffer();
		Set<String> unique = new HashSet<String>(datas);
		
		for (String temp : unique)
		{
			
			int count = Collections.frequency(datas, temp);
				
			sb.append(temp+"-");
				
			//System.out.println("String buff :"+sb.toString());
			
		}
		AdminDAO.upload1(fname,sb.toString());
		
	}
	
	public static void Calculate_Rank(String fname)
	{
		System.out.println("============================");
		
		DecimalFormat df = new DecimalFormat( "#.##" );  
		
		StringBuffer sb = new StringBuffer();
		 ArrayList rs = AdminDAO.getkey_word(fname);
		 ///fetch the same file contents
		 
		 int tot = AdminDAO.getFile_total(fname);
		 
		 ///This method will fetch the total
		 
		 for(int i=0;i<rs.size();i++)
		 {
			System.out.println("+++++++++++++++++++++++++++");
			 String key = rs.get(i).toString();
			 System.out.println("++++++++++++++"+key);
			 String[] s = key.split("@");
			 System.out.println("++++++"+s);
			 String keyword=s[0].trim();
			 String weight=s[1].trim();
			 System.out.println("++++++"+s[0]);
			 System.out.println("++++++"+s[1]);
			 int weig = Integer.parseInt(weight.trim());
				
				Double percentage = ((double)weig/tot) * 100; 
				
				String ran = df.format(percentage);
				
				boolean fl = AdminDAO.update_rank(keyword, fname, ran);
				System.out.println("Rank :"+df.format(percentage)+"======="+fl);
		 }
		
	}
	
	
   public static void main(String args[])
	{
	   
	   // Read Number of words in text file //
	   String dat = text_Search("test.txt");
	   
	   System.out.println("List Of words :"+dat);
	   
	   // Filter Process
	   ArrayList filtered_data = text_filter(dat);
	   
	   
	   // Word Count Process
	  // text_count(filtered_data);
	   
	   
	   
	}
     
}
