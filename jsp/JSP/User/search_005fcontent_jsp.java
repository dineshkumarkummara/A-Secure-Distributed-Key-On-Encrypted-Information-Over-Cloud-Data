package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.supportclass.*;

public final class search_005fcontent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Search Content</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/Images/back4.jpg\">\r\n");
      out.write("\r\n");
      out.write("<DIV id=popCal onclick=event.cancelBubble=true style=\"BORDER-BOTTOM: 2px ridge; BORDER-LEFT: 2px \r\n");
      out.write("ridge; BORDER-RIGHT: 2px ridge; BORDER-TOP: 2px ridge; POSITION: absolute; VISIBILITY: hidden; \r\n");
      out.write("WIDTH: 10px; Z-INDEX: 100\">\r\n");
      out.write("<IFRAME frameBorder=0 height=188 name=popFrame scrolling=no src=\"Images/popcjs.htm\" width=183>\r\n");
      out.write("</IFRAME>\r\n");
      out.write("</DIV>\r\n");
      out.write("<script event=onclick() \r\n");
      out.write("                for=document>popCal.style.visibility = \"hidden\";\r\n");
      out.write(" </script>\r\n");
      out.write(" \r\n");

	


	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"m_user\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/SearchContent\"  >\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\t<div align=\"left\" style=\"position: absolute;top: 40px;left:0px;\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"50%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font color=#993333 size=\"5\" >Search File with Content</font></b>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t  <center>\r\n");
      out.write("\t  <br>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <table align=\"center\"   style=\"position: absolute;top: 80px;left:50px;\" >\r\n");
      out.write("\t  \r\n");
      out.write("\t  <tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t \r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td colspan=\"1\" ><b>Search Content :</b>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<input type=\"text\" name=\"content\" placeholder=\"Search...\" required=\"yes\" style=\"width: 200px;\" >\r\n");
      out.write("\t\t\t     \t\t<input type=\"image\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/searchcon.png\" style=\"position: absolute;top: 20px;left: 340px;\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     </tr>\t\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t  \r\n");
      out.write("\t  </table>\r\n");
      out.write("\t \r\n");
      out.write("\t  </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</center>\r\n");
      out.write("<center>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\" style=\"position:absolute;top:-10px;font-size: 20px;color:#33A1C9;font-family: monotype corsiva;\">\t\r\n");
      out.write("    \t\t<p>Keyword not Found.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==2)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:-10px;font-size: 20px;color: #33A1C9;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>Please Enter Upto 5 words only.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");

	}
	
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
