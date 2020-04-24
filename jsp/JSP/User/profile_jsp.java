package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.supportclass.*;
import java.sql.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");

	String user=Utility.parse1(request.getAttribute("user"));
	System.out.println("user cvcvfdf :"+user);
	
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int no=Utility.parse(request.getParameter("no"));
	int id=0;
	String userid="",name="",add="",email="",phone="";
	if(no==0)
	while(rs.next())
	{
		
		userid=rs.getString(2);
		name=rs.getString(4);
		
		email=rs.getString(5);
		phone=rs.getString(6);
	}
	
	System.out.println("Name "+userid);

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\t\t");

			if(no==1)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t\t\t<p>Opp's,Seems something went wrong ..!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

			}
			if(no==0)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/EditProfile_User\" method=\"get\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print(user );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"no\" value=\"");
      out.print(1);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"image\" value=\"submit\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/next.png\" alt=\"submit Button\" onMouseOver=\"this.src='");
      out.print(request.getContextPath());
      out.write("/images/edit.png'\" class=\"gradientbuttons\" width=\"10%\" height=\"10%\"/>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br></br>\r\n");
      out.write("\t\t\t\t\t<div id=\"a1\" style=\"position: absolute;top: 50px;left: 150px;\">\r\n");
      out.write("\t\t\t\t\t<style>\r\n");
      out.write("  \r\n");
      out.write("  th,td{\r\n");
      out.write("  color:white;\r\n");
      out.write("  }\r\n");
      out.write("  </style>\r\n");
      out.write("\t\t\t\t\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"7\" align=\"center\"><font style=\"font-family:Arial;font-size: 20px;color: White;\"><b>User Profile</b></font></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"10\" align=\"center\"><hr size=\"5\" ></hr></td>\r\n");
      out.write("\t\t\t     \t\t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td> Name</td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<p>");
      out.print(name );
      out.write("</p>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td> LoginID </td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<p>");
      out.print(userid );
      out.write("</p>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td>Mail ID </td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td><p>");
      out.print(email );
      out.write("</p></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Cell N0  </td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td><p>");
      out.print(phone );
      out.write(" </p></td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div></form>\r\n");
      out.write("\t\t\t\t");

				if(Utility.parse(request.getParameter("no1"))==1)
				{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:-10px;font-size: 20px;color:#33A1C9;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t\t\t\t\t<p>Your profile updated successfully ..!</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t");

				}
			}
		
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
