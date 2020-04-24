package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.supportclass.*;
import java.util.ArrayList;
import com.Database.AdminDAO;

public final class cloud_005fconfig_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");

	
ResultSet list = AdminDAO.getCloud();
	
System.out.println("List :");

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: absolute;top: 10px;left:450px;\">\t\t\t\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/editcloud.jsp\" target=\"myframe\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/next.png\" height=\"30\" width=\"50\" /></a>\r\n");
      out.write("\t\t<br><font style=\"font-family: cursive;size: 5px;color: #FF2400;\" >Edit Cloud </font>\r\n");
      out.write("\t</span></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<form action=\"\" method=\"get\">\r\n");
      out.write("\t<style>\r\n");
      out.write("  \r\n");
      out.write("  th,td{\r\n");
      out.write("  color:white;\r\n");
      out.write("  }\r\n");
      out.write("  </style>\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<table id=\"login\" align=\"center\" border=\"1\" width=\"500px\" style=\"position: absolute;top: 100px;left:50px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"7\" align=\"center\"><font style=\"font-family:cursive;font-size: 20px;color: black;\"><b>Cloud Details</b></font></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<th colspan=\"1\" align=\"center\">Cloud Code</th>\r\n");
      out.write("\t\t\t     \t\t<th  colspan=\"1\" align=\"center\">Cloud URL</th>\r\n");
      out.write("\t\t\t     \t\t<th  colspan=\"1\" align=\"center\">Cloud Name </th>\r\n");
      out.write("\t\t\t     \t\t<th  colspan=\"1\" align=\"center\">Cloud Password </th>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t");

			     	if(list!=null)
			     	while(list.next())
			     	{
			     	
      out.write("\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t");
      out.print(list.getInt(1));
      out.write("\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t\t<td >\r\n");
      out.write("\t\t\t     \t\t\t");
      out.print(list.getString(2));
      out.write("\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td >\r\n");
      out.write("\t\t\t     \t\t\t");
      out.print(list.getString(3));
      out.write("\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t\t<td >\r\n");
      out.write("\t\t\t     \t\t\t");
      out.print(list.getString(4));
      out.write("\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t");

			     	}
			     	list.close();
			     	 
      out.write("\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");

int no=Utility.parse(request.getParameter("no"));
if(no==1)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: 10px;color:red;font-size: 20px;\">\t\r\n");
      out.write("\t\t\t<p>Cloud Updated Successfully!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

}
if(no==2)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: -10px;color:red;font-size: 20px;\">\t\r\n");
      out.write("\t\t\t<p>Something wrong oing update ..!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

}

      out.write("\r\n");
      out.write("\t\t\r\n");
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
