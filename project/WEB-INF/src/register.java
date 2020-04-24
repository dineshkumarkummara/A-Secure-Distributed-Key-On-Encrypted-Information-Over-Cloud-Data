import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class register extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		Statement s;
		String reg_no=req.getParameter("reg_no");
		System.out.println("registration number is-"+reg_no);
		String password = req.getParameter("password");
		System.out.println("password is-"+password);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","admin");
		 s = (Statement) conn.createStatement();
	     s = (Statement) conn.createStatement();
	     int i=s.executeUpdate("insert into student1 (reg_no,password)values('"+reg_no+"',"+password+")");
	         
	     
	    if(i==1){

	    	System.out.println("Success");
	    }else{
	    	System.out.println("Unsuccessful");
	    	
	    }
	      }catch(Exception e){
	    	  System.out.println(e);
	      }
	}
		
}



