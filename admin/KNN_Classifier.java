package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.user.action.Request;

public class KNN_Classifier {
	 
	
	public static int KNN_PreProcess(int X1,String filename){
		String found="";
		ResultSet rs=null;
		int X2=0;
		int f=0;
		ArrayList<Integer> MinDist = new ArrayList<Integer>();
		try
		{
			System.out.println("KNN Starting process");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/securedynamic","root","admin");
			Statement stom=con.createStatement();
			rs=stom.executeQuery("Select * from knn_file");
			
			while(rs.next())
			{
				
				System.out.println(rs.getString(2)+"---------"+rs.getInt(4));
				System.out.println("file name---------file count");
				
				
				X2=rs.getInt(4);
				
				
				int output=(int)Math.pow((X1-X2), 2);
				
				
				System.out.println("----Output---Ecludiuan Min Distance-"+output);
				
				MinDist.add(output);
				
				f=MinDist.get(0);
				System.out.println("Got minimum values from from knn file"+f);
				
				
				System.out.println("compared with all the rows and got min distance");
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3307/securedynamic","root","admin");
					Statement stom2=con2.createStatement();
					String sql="insert into knn_recom (f_name,key_word,total,min_dist) values('"+rs.getString(2)+"','"+rs.getString(3)+"','"+X1+"','"+output+"')";
					
					int i2=stom2.executeUpdate(sql);
					
					if(i2==1){
						System.out.println("Success");
						
					}
					else{
						System.out.println("Failure");
						
					}
					
				}catch (Exception e2) {
					System.out.println(e2);
					
				
				}
			}	
			 for(int i=1;i<MinDist.size();i++)  
	           {  
				 
				 System.out.println("check f="+f);
				 if(MinDist.get(i)<f)
					{
						f=MinDist.get(i);
						System.out.println("If1="+f);
					}
				 
				 
				 
	            System.out.println("Min Dist BucketList---->"+MinDist.get(i));     
	           }  
			 System.out.println("Finded MinDistsance="+f+"For File Name-----");
		
		
		}
			catch (Exception e) {
				System.out.println(e);
			}
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3307/securedynamic","root","admin");
			Statement stom3=con3.createStatement();
			System.out.println("F avlues"+f);
			ResultSet rs3=stom3.executeQuery("Select * from knn_recom where min_dist='"+f+"'");
			
			while(rs3.next())
			{
				
		
		
		System.out.println("Output  Of KNN--->"+rs3.getString(2));
	
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3307/securedynamic","root","admin");
			Statement stom5=con5.createStatement();
			String sql="insert into knn_results (f_name,securedynamic,min_dist) values('"+filename+"','"+rs3.getString(2)+"','"+f+"')";
			
			int i3=stom5.executeUpdate(sql);
			
			if(i3==1){
				System.out.println("Success");
				
			}
			else{
				System.out.println("Failure");
			}
			}catch (Exception e4) {
				System.out.println(e4);
			}
		
		
		
			}
			}catch (Exception e3) {

				System.out.println(e3);
				// TODO: handle exception
			}
		
		
		
		return f;
		
		
	}
	

}
