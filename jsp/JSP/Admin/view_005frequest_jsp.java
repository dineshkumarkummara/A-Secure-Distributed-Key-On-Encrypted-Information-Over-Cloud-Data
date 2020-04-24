package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.Database.*;
import com.supportclass.*;

public final class view_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 

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
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write(" <!-- for popup message start -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/style.js\"></script>\t\r\n");
      out.write("<!-- for popup message end-->\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer();\">\r\n");
      out.write("<center>\r\n");



ResultSet rs = UserDAO.getRequest();




      out.write("\r\n");
      out.write("<br></br>\r\n");
      out.write("<div style=\"position: absolute;top: 10px;left: 220px;\">\r\n");
      out.write("<p style=\"color: red;\"><b>View User Request</b></p>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"CSSTableGenerator\" style=\"width:580px;height:150px;top: 50px;\">\r\n");
      out.write("<table class=\"pretty-table\" border=\"1\" id=\"user\">\r\n");
      out.write("  <style>\r\n");
      out.write("  \r\n");
      out.write("  th,td{\r\n");
      out.write("  color:white;\r\n");
      out.write("  }\r\n");
      out.write("  </style>\r\n");
      out.write("    <th scope=\"col\">Rec No</th>\r\n");
      out.write("    <th scope=\"col\"> User ID</th>\r\n");
      out.write("    \r\n");
      out.write("    <th scope=\"col\">Key Send</th>\r\n");
      out.write("    <th scope=\"col\">Reject</th>\r\n");
      out.write("  \r\n");
while(rs.next())
	{
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>");
      out.print(rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("    \t<td>");
      out.print(rs.getString(2));
      out.write("</td>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<td><a href=\"");
      out.print(request.getContextPath());
      out.write("/SendPublicKey?requestno=");
      out.print(rs.getInt(1));
      out.write("&uid=");
      out.print(rs.getString(2));
      out.write("&no=1\"><font style=\"color: blue;\"><b>Send Public Key</b></font></a></td>\r\n");
      out.write("    \t<td><a href=\"");
      out.print(request.getContextPath());
      out.write("/SendPublicKey?requestno=");
      out.print(rs.getInt(1));
      out.write("&no=2\"><font style=\"color: blue;\"><b>Reject</b></font></a></td>\r\n");
      out.write("  \r\n");
      out.write("  </tr>\r\n");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
	
		int no=Utility.parse(request.getParameter("no"));
	System.out.println("No :"+no);
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("            <div class=\"success\" id=\"message\" >\t\r\n");
      out.write("\t           <p> Key Sent Successfully.....!</p>\r\n");
      out.write("            </div>\r\n");
      out.write("             </div>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==3)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("            <div class=\"success\" id=\"message\" >\t\r\n");
      out.write("\t           <p> User request Deleted Successfully.....!</p>\r\n");
      out.write("            </div>\r\n");
      out.write("             </div>\t\r\n");
      out.write("\t\t");

		}
		if(no==2)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("            <div class=\"error\" id=\"message\" >\t\r\n");
      out.write("\t           <p>Oop's something went wrong.....!</p>\r\n");
      out.write("            </div>\r\n");
      out.write("             </div>\t\t\r\n");
      out.write("\t\t");

		}
		
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"pageNavPosition\" style=\"position:absolute;top:380px;left:400px\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('user',5); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");
      out.write("    \r\n");
      out.write("</body></html>");
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
