package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.Database.*;
import com.supportclass.*;

public final class matched_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
int k=1;
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
      out.write("\r\n");
      out.write("\r\n");



String rs = request.getAttribute("sb").toString();

System.out.println("rs :"+rs);

String[] str = rs.trim().split("@");



      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br></br>\r\n");
      out.write("<div style=\"position: absolute;top: 10px;left: 220px;\">\r\n");
      out.write("<p style=\"color: red;\"><b>Ranked Files from Server</b></p>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"CSSTableGenerator\" style=\"width:580px;height:150px;\">\r\n");
      out.write("<table class=\"pretty-table\" border=\"1\">\r\n");
      out.write("  \r\n");
      out.write("      <th scope=\"col\">S.NO</th>\r\n");
      out.write("    <th scope=\"col\"> File Name</th>\r\n");
      out.write("    <th scope=\"col\"> Word %</th>\r\n");
      out.write("    <th scope=\"col\">Download</th>\r\n");
      out.write("  \r\n");


String st[];
for(int i=0;i<str.length;i++)
{

 st = str[i].trim().split("~");
 String fname=UserDAO.getFilename(st[0]);

 
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" <tr>\r\n");
      out.write(" <td>");
      out.print(k);
      out.write("</td>\r\n");
      out.write(" \t<td>");
      out.print(fname);
      out.write("</td>\r\n");
      out.write(" \t<td>");
      out.print(st[1].trim());
      out.write("</td>\r\n");
      out.write(" \t<td><a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/select_publickey.jsp?filename=");
      out.print(fname);
      out.write("&no=0\" ><font style=\"color: blue;\"><b>Download</b></font></a></td>\r\n");
      out.write("</tr>\r\n");
      out.write(" ");

 
 k=k+1;

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
      out.write("\t\t<div  style=\"position: absolute;top: -10px;left: 50px;color: #000;font-size: 20px;font-family: monotype corsiva; \">\r\n");
      out.write("\t\t<p>User Details Updated Successfully..</p>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==2)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: -10px;left: 50px;color: #000;font-size: 20px; \">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p>User Deleted Successfully</p>\t\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t");

		}
		if(no==3)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: -10px;left: 50px;color: #000;font-size: 20px; \">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p>Somthing wrong please try again......//</p>\t\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t");

		}
		
	
      out.write("\r\n");
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
