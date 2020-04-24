/**
 * 
 */
package com.Database;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDAO == null)
		{
			userDAO= new UserDAO();
		}
		return userDAO;
	}
	
	public static boolean deleteReq1(int rno)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "delete from m_user where u_no='"+rno+"'";
				
				
				int i = statement.executeUpdate(sql);
				if(i!=0)
				{
					flg=true;
					
				}
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean ChangePass(String name,String pwd)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_user set u_pass = '"+pwd+"' where u_id = '"+name+"' ";
			
		 int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flg=true;
			}
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	
	public static int Checkuser(String uid)
	{
		int flg=0;;
		try
		{
			ResultSet rs;
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select * from m_user where u_id='"+uid+"'";
			
		 rs=statement.executeQuery(sql);
			
			while(rs.next())
			{
				flg=2;
			}
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	
	
	public static boolean signUp(String u_id,String u_pass,String u_name,String u_email,String u_phone,String grade)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "insert into m_user (u_id,u_pass,u_name,u_email,u_phone,grade)values ('"+u_id+"','"+u_pass+"','"+u_name+"','"+u_email+"','"+u_phone+"','"+grade+"') ";
			
		 int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flg=true;
			}
			 
			System.out.println("Data Added Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	
	public static ArrayList getFileNo(String fkey)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="select f_no,weightage from t_count where key_word='"+fkey.trim()+"'";
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				list.add(resultSet.getInt(1)+"~"+resultSet.getInt(2));
			}
			
			System.out.println(sql);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	public static boolean updatekey(String userid,String pubkey,String privkey)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set public_key = '"+pubkey+"',private_key='"+privkey+"' where admin_id = '"+userid+"' ";
			
		 int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flg=true;
			}
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	
	public static boolean updatekeyStatus(String userid)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_request_secfile set status = 'Done' where userid = '"+userid+"' ";
			
		 int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flg=true;
			}
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	
	public static boolean insertTrans(String date,String time,String loid,String fname) throws SQLException
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_transaction(t_date,t_time,m_loginid,f_name,f_status) values('"+date+"','"+time+"','"+loid+"','"+fname+"','Downloaded')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("insertTrans download status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}
	
	public static boolean insertReq(String uid) throws SQLException
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_request_secfile(userid,status) values('"+uid+"','Pennding')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("insertTrans download status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}
	
	
	public static ResultSet gettReq(String uid) throws SQLException
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *from m_request_secfile where userid='"+uid+"'");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}
		
		return resultSet;
	}
	
	public static String gettPrivatekey(String uid) throws SQLException
	{
		String privatek="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select private_key from m_admin where admin_id='"+uid+"'");
			
			while(resultSet.next())
			{
				privatek = resultSet.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}
		
		return privatek;
	}
	
	public static String gettPublickey(String uid) throws SQLException
	{
		String publick="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select public_key from m_admin where admin_id='"+uid+"'");
			
			while(resultSet.next())
			{
				publick = resultSet.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}
		
		return publick;
	}
	
	public static ArrayList<String> getCloud()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_code,c_url,c_uname,c_pwd from m_cloud where c_code='1'");
		
			while(resultSet.next())
			{
				
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
				list.add(resultSet.getString(4));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	public static ResultSet getFile_Name()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_id,f_name from m_file");
		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return resultSet;
	}
	
	public static ResultSet getFile_Weight(String key)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			String sql="select a.t_no,b.f_name,a.key_rank from t_count a,m_file b where a.key_word='"+key+"' and a.f_no=b.f_no ORDER BY a.key_rank DESC";
			
			resultSet = statement.executeQuery(sql);
			
			System.out.println(sql);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return resultSet;
	}
	
	
	public static ResultSet keyRankWeight(String hash_keyword)
	{
		int k=0;
		boolean flag=false;
		ResultSet rs=null;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("select fileno,key_no,rank_val from m_hashtable where key_word='"+hash_keyword+"'");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return rs;
	}
	
	
	public static String userRank(String uid)
	{
		String rank=null;
		boolean flag=false;
		ResultSet rs=null;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("select grade from m_user where u_id='"+uid+"'");
			while(rs.next())
			{
				rank=rs.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return rank;
	}
	
	
	public static String getFilename(String fileno)
	{
		String rank=null;
		boolean flag=false;
		ResultSet rs=null;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("select f_name from m_file where f_no='"+fileno+"'");
			while(rs.next())
			{
				rank=rs.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return rank;
	}
	public static ArrayList getFile()
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="select f_name from m_file";
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
			System.out.println(sql);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getKey()
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="select f_name,key_word from m_file";
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				list.add(resultSet.getString(1)+"~"+resultSet.getString(2));
			}
			
			System.out.println(sql);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	
	public static ResultSet getUsers()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *from m_user");
		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return resultSet;
	}
	public static ResultSet getRequest()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *from m_request_secfile");
		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return resultSet;
	}
	
	public static String getUser_Email(String userid)
	{
		
		String email="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_email from m_user where u_id='"+userid+"'");
		
			while(resultSet.next())
			{
				email=resultSet.getString(1);
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return email;
	}
	public static ArrayList getWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select no_of_times from m_parent where f_id='"+fid+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getWeight(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select parent_tag,weightage from m_parent where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1)+"~"+resultSet.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	
	
	
	public static boolean checkUser(String username,String password)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+username+"' and u_pass='"+password+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean checkAlreadyExist(String userid)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+userid+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	public static int selectFileid(String username)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_id from m_file where f_name='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return i;
	}
	
	
	
	
	public boolean addUser(String userid,String password,String name,String email,String phone)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_user(u_id,u_pass,u_name,u_email,u_phone) values('"+userid+"','"+password+"','"+name+"','"+email+"','"+phone+"')";
			
			int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			//System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	/* Get Profile Details (Starts) */
	
	public static ResultSet getProfile(String username)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+username+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	
	/* Get Profile Details (Ends) */
	
	public String getID(String username)
	{
		String i="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getString(1);
			}
			//System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	 public static boolean fileExist(String filename) throws SQLException
		{
			boolean flag=false;
			

			try
			{
				DAO dao=DAO.getInstance();
				connection=dao.connector();
				statement = connection.createStatement();

				String sql="select *from m_file where f_name='"+filename+"'";
				
				resultSet=(ResultSet) statement.executeQuery(sql);

				while(resultSet.next())
				{
		
					flag=true;
				}

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				connection.close();
			}

			return flag;
		}
	    
	
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set u_name='"+s[1]+"',u_id='"+s[2]+"',u_email='"+s[3]+"',u_phone='"+s[4]+"' where u_no='"+s[0]+"'";
			//System.out.println("******* Edit User Profile Info *********\n");
			//System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			//System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile() :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean chnagePass(int id,String cpass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set password='"+cpass+"' where u_code='"+id+"'";
			//System.out.println("******* Change User Password Info *********\n");
			//System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			//System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	// tag reading process methods //
	
	
	public static boolean checkParent_Tag(String wor,int fid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from m_parent where parent_tag='"+wor+"' and f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean insert_Tag(String wor,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into m_parent(parent_tag,no_of_times,f_id) values('"+wor+"','"+count+"','"+fid+"')";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean update_Tag(String wor,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "update m_parent set no_of_times='"+count+"' where parent_tag='"+wor+"' and f_id='"+fid+"'";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static int select_parentIdTag(String ptag,int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select parent_id from m_parent where parent_tag='"+ptag+"' and f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
		id = resultSet.getInt(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return id;
	}

	
	public static boolean checkContent(String wor,int fid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from m_content where content='"+wor+"' and f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean checkChild_Tag(String wor,int fid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from m_child where child_tag='"+wor+"' and f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean insertChild_Tag(String wor,int parentid,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into m_child(child_tag,parent_id,no_of_times,f_id) values('"+wor+"','"+parentid+"','"+count+"','"+fid+"')";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean insertContent(String wor,int parentid,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into m_content(content,parent_id,no_of_times,f_id) values('"+wor+"','"+parentid+"','"+count+"','"+fid+"')";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean addFile(String filename,String datetime)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into m_file(f_name,f_date) values('"+filename+"','"+datetime+"')";
				
				//System.out.println(sql);
				int i = statement.executeUpdate(sql);
				if(i!=0)
				{
					flg=true;
					
				}
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean deleteReq(int rno)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "delete from m_request_secfile where req_no='"+rno+"'";
				
				//System.out.println(sql);
				int i = statement.executeUpdate(sql);
				if(i!=0)
				{
					flg=true;
					
				}
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean emptyTables()
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "Delete from m_file";
				String sql1 = "Delete from m_parent";
				String sql2 = "Delete from m_child";
				String sql3 = "Delete from m_content";
				
				//System.out.println(sql);
				int i = statement.executeUpdate(sql);
				int i1 = statement.executeUpdate(sql1);
				int i2 = statement.executeUpdate(sql2);
				int i3 = statement.executeUpdate(sql3);
				if(i!=0)
				{
					flg=true;
					
				}
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static ResultSet selectFiles()
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "select *from m_file";
				
				//System.out.println(sql);
				resultSet = statement.executeQuery(sql);
				
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}


	public static int select_childIdTag(String ptag,int pid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select no_of_times from m_child where child_tag='"+ptag+"' and parent_id='"+pid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
		id = resultSet.getInt(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return id;
	}

	public static int select_contentId(String ptag,int pid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select no_of_times from m_content where content='"+ptag+"' and parent_id='"+pid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
		id = resultSet.getInt(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return id;
	}
	
	public static ResultSet select_ParentTag(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.parent_tag,a.no_of_times,b.f_name,a.weightage from m_parent a,m_file b where a.f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_ChildTag(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.child_tag,a.parent_id,a.no_of_times,b.f_name,a.weightage from m_child a,m_file b where a.f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_Content(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.content,a.parent_id,a.no_of_times,b.f_name,a.weightage from m_content a,m_file b where a.f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}

	public static ResultSet select_Vector(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_name,struct_vector from m_file where f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_ConVector(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_name,content_vector from m_file where f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_classify(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_name,classification from m_file where f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static boolean updateChild_Tag(String wor,int pid,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				int count =  select_childIdTag(wor,pid);
				
				count=count+1;
				
				String sql = "update m_child set no_of_times='"+count+"' where child_tag='"+wor+"' and parent_id='"+pid+"' and f_id='"+fid+"'";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean updateContent(String wor,int pid,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				int count =  select_contentId(wor,pid);
				
				count=count+1;
				
				String sql = "update m_content set no_of_times='"+count+"' where content='"+wor+"' and parent_id='"+pid+"' and f_id='"+fid+"'";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	
}
