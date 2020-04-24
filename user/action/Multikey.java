package com.user.action;

import java.util.ArrayList;

import com.Database.UserDAO;
import com.supportclass.HashingTechnique;
import com.supportclass.ReadFile;

public class Multikey
{

	public static StringBuffer multiKey(String key)
	{
		StringBuffer sb = new StringBuffer();
		String[] str = key.split(" "); 
		ArrayList li = UserDAO.getKey();
		
		for(int i=0;i<li.size();i++)
		{
			
			String fnm = li.get(i).toString();
			
			String[] st = fnm.split("~");
			
			//System.out.println("Key Found.........."+fnm);
			
			if(st[1].trim().contains(str[0].trim())&&(fnm.contains(str[1].trim())))
			{
				
				System.out.println("Key Found..........");
				sb.append(st[0].trim()+"~");
			}
			else
			{
				
				System.out.println("Key Not Found..........");
			}
			
			
		}
		return sb;
		
	}
	
	public static StringBuffer multiKeyTop(String key)
	{
		
		int count=0;
		StringBuffer sb = new StringBuffer();
		String[] str = key.split(" "); 
		
		//String search_con = HashingTechnique.MD5(str[0].trim());
		
		//String search_con1 = HashingTechnique.MD5(str[1].trim());
		
		ArrayList li = UserDAO.getFileNo(str[0].trim());
		ArrayList li1 = UserDAO.getFileNo(str[1].trim());
		
		System.out.println("List :"+li+"List 2 :"+li1);
		
		for(int i=0;i<li.size();i++)
		{
			
			String fnm = li.get(i).toString();
			
			String[] st = fnm.split("~");
			
			
				
				if(li1.contains(st[0].trim())&&(li1.contains(st[1].trim())))
				{
					
					System.out.println("Key Found..........");
					sb.append(st[0].trim()+"~");
					count=count+1;
				}
				else
				{
					
					System.out.println("Key Not Found..........");
				}
				
			
			
			
			
			System.out.println("Count data :"+count);
			
		}
		return sb;
		
	}
	
	public static void main(String[] args) {
		
		//multiKey("university indian");
		
		multiKeyTop("university indian");
		
	}
}
