package com.user.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.UserDAO;
import com.supportclass.ReadFile;
import com.util.Hashing;


public class SearchContent extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		String key = req.getParameter("content");
		
		String[] st=key.trim().split(" ");
		
		
		HttpSession hs = req.getSession();

		String id = hs.getAttribute("userid").toString();
		
		String urank1=UserDAO.userRank(id);
		int urank=Integer.parseInt(urank1);
		
		System.out.println("Length :"+st.length);
		
		if(st.length==1)
		{
			StringBuffer sb = new StringBuffer();
			System.out.println("Test "+key);
			
			//key=urank1+key;
			
			String hashkey=Hashing.HashingFunction(key, urank);
			
			
			try{
			
				/*old code
				 * 
				 * ResultSet rs = UserDAO.getFile_Weight(key.trim());
				
				int recordCount =0;
				while(rs.next())
				{
	
					sb.append(rs.getInt(1)+"~"+rs.getString(2)+"~"+rs.getString(3)+"#");
					
					System.out.println("-------------- "+rs.getInt(1)+"...."+rs.getString(2));
				recordCount++;
				}
				
				System.out.println("Count :"+recordCount);*/
				
				
				HashMap<String, Double> hash = new HashMap<>();
				
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
				
				
				
				
				
				
				
				System.out.println("Count :"+recordCount);
				
				if(recordCount==0)
				{
					
					System.out.println("Te+++++++++++++++++++++++++=");
					rd = req.getRequestDispatcher("/JSP/User/search_content.jsp?no=1");
					rd.forward(req,resp);
				}
				else
				{
					
					
					System.out.println("its came to count 1 block");
					Set<Entry<String, Double>> set = hash.entrySet();
			        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
			        Collections.sort( list, new Comparator<Map.Entry<String, Double>>()
			        {
			            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
			        for(Entry<String, Double> entry:list){
			            System.out.println(entry.getKey()+" ==== "+entry.getValue());
			           
			            sb.append(entry.getKey()+"~"+entry.getValue()+"@");
			            
			        }
					
			        
					/*Collections.frequency(set, o)*/
					
					
					req.setAttribute("sb", sb.toString());
					rd = req.getRequestDispatcher("/JSP/User/matched.jsp");
					rd.forward(req,resp);
				}
				
			}
			catch (Exception e)
			{
				System.out.println("Exception :"+e.toString());
			}
			
		}
		else if(st.length<6)
		{
			int count=0;
			
			Multysearch msrch=new Multysearch();
			
			HashMap<String, Double> hash0 = new HashMap<>();
			HashMap<String, Double> hash1 = new HashMap<>();
			HashMap<String, Double> hash2 = new HashMap<>();
			HashMap<String, Double> hash3 = new HashMap<>();
			HashMap<String, Double> hash4 = new HashMap<>();
			
			HashMap<String, Double> hashTemp = new HashMap<>();
			HashMap<String, Double> hashTemp1 = new HashMap<>();
			HashMap<String, Double> hashTemp2 = new HashMap<>();
			HashMap<String, Double> hashTemp3 = new HashMap<>();
			int tcount=0;
			StringBuffer sb = new StringBuffer();
			
			for(int i=0;i<st.length;i++)
			{
				if(count==0)
				{
					hash0=msrch.searchKey(st[i], urank);
					count++;
				}else if(count==1)
					{
						hash1=msrch.searchKey(st[i], urank);
						count++;
					}else if(count==2)
					{
						hash2=msrch.searchKey(st[i], urank);
						count++;
					}else if(count==3)
					{
						hash3=msrch.searchKey(st[i], urank);
						count++;
					}else if(count==4)
					{
						hash4=msrch.searchKey(st[i], urank);
						count++;
					}
				
				
				
				
				
				
			}
			int count1=0;
			for(int i=0;i<st.length;i++)
			{
				if(count1==0)
				{
					if(hash1.isEmpty() || hash0.isEmpty())
					{
						
						
						break;
						
					}else
					{
						for ( String key1 : hash1.keySet() ) {
							
							
							if(hash0.containsKey(key1))
							{
								
								double d1=hash0.get(key1);
								double d2=hash1.get(key1);
								double d3=d1+d2;
								
								hashTemp.put(key1, d3);
								
								
							}
					}
					}
					
					
				count1++;
				tcount++;
				   
				}else if(count1==1)
				{
					
					
					if(hashTemp.isEmpty() || hash2.isEmpty())
					{
						break;
					}else
					{
						for ( String key1 : hash2.keySet() ) {
							
							
							if(hashTemp.containsKey(key1))
							{
								
								double d1=hashTemp.get(key1);
								double d2=hash2.get(key1);
								double d3=d1+d2;
								
								hashTemp1.put(key1, d3);
								
								
							}
					}
					}
					
                    
				count1++;
				tcount++;
					
				}else if(count1==2)
                 {
					
					
                    for ( String key1 : hash3.keySet() ) {
						
						
						if(hashTemp1.containsKey(key1))
						{
							
							double d1=hashTemp1.get(key1);
							double d2=hash3.get(key1);
							double d3=d1+d2;
							
							hashTemp2.put(key1, d3);
							
							
						}
				}
				count1++;
				tcount++;
					
				}else if(count1==3)
                    {
					
					
                    for ( String key1 : hash4.keySet() ) {
						
						
						if(hashTemp2.containsKey(key1))
						{
							
							double d1=hashTemp2.get(key1);
							double d2=hash4.get(key1);
							double d3=d1+d2;
							
							hashTemp3.put(key1, d3);
							
							
						}
				}
				count1++;
				tcount++;
					
				}
				
				
			}
			
			
			
			
			
			
			if(tcount==0)
			{
				System.out.println("Te+++++++++++++++++++++++++=");
				rd = req.getRequestDispatcher("/JSP/User/search_content.jsp?no=1");
				rd.forward(req,resp);
			}else
			{
				
				
				if(st.length==2)
				{
					
					Set<Entry<String, Double>> set = hashTemp.entrySet();
			        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
			        Collections.sort( list, new Comparator<Map.Entry<String, Double>>()
			        {
			            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
			        for(Entry<String, Double> entry:list){
			            System.out.println(entry.getKey()+" ==== "+entry.getValue());
			           
			            sb.append(entry.getKey()+"~"+entry.getValue()+"@");
			            
			        }
					
					
					
				}else if(st.length==3)
				{
					
					Set<Entry<String, Double>> set = hashTemp1.entrySet();
			        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
			        Collections.sort( list, new Comparator<Map.Entry<String, Double>>()
			        {
			            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
			        for(Entry<String, Double> entry:list){
			            System.out.println(entry.getKey()+" ==== "+entry.getValue());
			           
			            sb.append(entry.getKey()+"~"+entry.getValue()+"@");
			            
			        }
					
					
					
				}else if(st.length==4)
				{
					Set<Entry<String, Double>> set = hashTemp2.entrySet();
			        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
			        Collections.sort( list, new Comparator<Map.Entry<String, Double>>()
			        {
			            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
			        for(Entry<String, Double> entry:list){
			            System.out.println(entry.getKey()+" ==== "+entry.getValue());
			           
			            sb.append(entry.getKey()+"~"+entry.getValue()+"@");
			            
			        }
				}else if(st.length==5)
				{
					Set<Entry<String, Double>> set = hashTemp3.entrySet();
			        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
			        Collections.sort( list, new Comparator<Map.Entry<String, Double>>()
			        {
			            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
			        for(Entry<String, Double> entry:list){
			            System.out.println(entry.getKey()+" ==== "+entry.getValue());
			           
			            sb.append(entry.getKey()+"~"+entry.getValue()+"@");
			            
			        }
				}
				
				
				
				
				
				req.setAttribute("sb", sb.toString());
				rd = req.getRequestDispatcher("/JSP/User/matched.jsp");
				rd.forward(req,resp);
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
		}else
		{
			System.out.println("Te+++++++++++++++++++++++++=");
			rd = req.getRequestDispatcher("/JSP/User/search_content.jsp?no=2");
			rd.forward(req,resp);
		}
		
		
			
		
		
		
	}
	
	
	
	
}
