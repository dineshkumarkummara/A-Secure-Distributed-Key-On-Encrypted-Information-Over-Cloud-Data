package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.supportclass.Utility;

public final class select_005fpublickey_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");


	int no=Utility.parse(request.getParameter("no"));
	String f_name = request.getParameter("filename");
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");

	if(no == 0)
	{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/Decryption\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"tab\" style=\"position:absolute;top:50px;left:100px;width:400px;\">\r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t     <table id=\"login\">\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"3\" align=\"center\"><font style=\"font-family:Arial;font-size: 20px;color: black;\"><b>Decryption Process</b></font></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"3\" align=\"center\"><hr size=\"3\" ></hr></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Select Public Key For Decryption</td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"file\" name=\"file\" style=\"width:250px\"></input>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"hidden\" name=\"file\" value=\"");
      out.print(f_name);
      out.write("\" style=\"width:250px\"></input>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     </table>\r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t\t<input class=\"gradientbuttons\" type=\"submit\" value=\"Decypt Process\" style=\"position:absolute;top:200px;left:150px;\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");

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
