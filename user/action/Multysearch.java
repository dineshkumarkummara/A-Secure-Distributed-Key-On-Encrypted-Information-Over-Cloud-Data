package com.user.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.Database.UserDAO;
import com.util.Hashing;

public class Multysearch 
{
	
	
public static HashMap<String, Double> searchKey(String key,int urank)
{
	
	
	//key=urank1+key;
	
	String hashkey=Hashing.HashingFunction(key, urank);
	HashMap<String, Double> hash = new HashMap<>();
	try{
	
		
		
		
		
		
        ResultSet rs = UserDAO.keyRankWeight(hashkey);
       // ResultSet rs1 = UserDAO.keyRankWeight(hashkey);
		
		int recordCount =0;
		int count=0;
		int test=0;
		String fileno=null;
		String keywordNO=null;
		double rankvalue = 0;
		rs.last();
		int t=rs.getRow();
		System.out.println("row value :"+t);
		
		if(t==0)
		{
			
		}else
		{
			
			
			
			if(t>1)
			{
				System.out.println("its came to more than one record block");
				rs.beforeFirst();
				while(rs.next())
				{
					
					if(count==0)
					{
						
						
						fileno=rs.getString(1);
						keywordNO=rs.getString(2);
						String rankvalue1=rs.getString(3);
						rankvalue=Double.parseDouble(rankvalue1);
						
						
						//hash.put(fileno, rankvalue);
						System.out.println("1");
						count++;
						test++;
						if(test==t)
						{
							hash.put(fileno, rankvalue);
						}
					}else
					{
						String temp=rs.getString(1);
						System.out.println("tem :"+temp+"and fileno :"+fileno);
						if(fileno.trim().equals(temp.trim()))
						{
							keywordNO=rs.getString(2);
							String rankvalue1=rs.getString(3);
							Double rankvaluet=Double.parseDouble(rankvalue1);
							rankvalue=rankvalue+rankvaluet;
							
							System.out.println("2");
							
							test++;
							if(test==t)
							{
								hash.put(fileno, rankvalue);
								rankvalue=0;
							}
							
						}else
						{
							hash.put(fileno, rankvalue);
							//sb.append(fileno+"~"+rankvalue+"@");
							System.out.println("3");
							rankvalue=0;
							
							keywordNO=rs.getString(2);
							String rankvalue1=rs.getString(3);
							Double rankvaluet=Double.parseDouble(rankvalue1);
							rankvalue=rankvalue+rankvaluet;
							
							fileno=temp;
							
							test++;
							if(test==t)
							{
								hash.put(fileno, rankvalue);
								rankvalue=0;
							}
					
						}
					}
					
					

					
				recordCount++;
				}
				
				
			}else
			{
				System.out.println("its came to  one record block");
				rs.beforeFirst();
				
				while(rs.next())
				{
					
					
						fileno=rs.getString(1);
						keywordNO=rs.getString(2);
						String rankvalue1=rs.getString(3);
						rankvalue=Double.parseDouble(rankvalue1);
						
						
						hash.put(fileno, rankvalue);
						count++;
						
						recordCount++;	
					
					}
					
											
				
				
				
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	catch (Exception e)
	{
		System.out.println("Exception :"+e.toString());
	}
	return hash;
	
}

}
