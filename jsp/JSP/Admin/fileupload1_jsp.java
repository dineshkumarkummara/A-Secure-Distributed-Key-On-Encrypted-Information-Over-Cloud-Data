package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Database.AdminDAO;
import java.sql.ResultSet;

public final class fileupload1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write(" <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("  <title>CodePen - Custom checkboxes with CSS only</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/style.css\" media=\"screen\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <h1 style=\"color:white;\">Access Policy</h1>\r\n");
      out.write("<h2>On Your Uploading File</h2>\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/Accesspriority\" method=\"post\">\r\n");

ResultSet rs=AdminDAO.getGrade();
while(rs.next())
{
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <p>\r\n");
      out.write("    <input type=\"checkbox\" name=\"grades\" id=\"test1\" value=\"");
      out.print(rs.getInt(1));
      out.write("\" />\r\n");
      out.write("    <label for=\"test1\">");
      out.print(rs.getString(2) );
      out.write("</label>\r\n");
      out.write("  </p>\r\n");
      out.write("  \r\n");
      out.write("  ");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\">\r\n");
      out.write("  \r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
