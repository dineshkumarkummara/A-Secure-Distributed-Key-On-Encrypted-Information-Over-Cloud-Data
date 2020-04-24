import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
public class login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		java.sql.Statement s;
		java.sql.ResultSet rs=null;
		String reg_no=req.getParameter("reg_no");
		System.out.println("registration number is-"+reg_no);
		String password = req.getParameter("password");
		System.out.println("password is-"+password);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","admin");
		 s =  conn.createStatement();
	     s =  conn.createStatement();
	    
	     rs=s.executeQuery("select*from student1 where reg_no='"+reg_no+"' and password='"+password+"'");    
	     
	    if(rs.next()){

	    	System.out.println("Success");
	    }else{
	    	System.out.println("Unsuccessful");
	    	
	    }
	      }catch(Exception e){
	    	  System.out.println(e);
	      }
	}
		
}



