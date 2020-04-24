package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>Bloom Filter</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Le styles -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style2.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("    <!--[if lt IE 9]><script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script><![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <IMG SRC=\"");
      out.print(request.getContextPath());
      out.write("/images/projecttopic.png\" width=100% height=\"13%\" style=\"position: absolute;top: -0.5px;left: 5px;\" BORDER=\"0\" ALT=\"\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body bgcolor=\"red\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("                <form name=\"login-form\" class=\"form-login\" action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\" method=\"post\"> \r\n");
      out.write("  \r\n");
      out.write("                        <div class=\"header\">\r\n");
      out.write("                            <a href=\"index.jsp\" class=\"link-head-left\"><i class=\"icon-home\"></i></a>\r\n");
      out.write("                            <span>Admin Login</span>\r\n");
      out.write("                            <a href=\"javascript:void(0);\" tabindex=\"1\" class=\"link-head-right main-item\"><i class=\"icon-config\"></i></a>\r\n");
      out.write("                            <div class=\"config-box\"> \r\n");
      out.write("                              <div class=\"colors\">\r\n");
      out.write("                           \t  ");
      out.write("\r\n");
      out.write("                               <div class=\"clear\"></div> \r\n");
      out.write("                              </div>\r\n");
      out.write("                              \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                       <!--  <div class=\"avatar\"><img src=\"images/avatar.png\" alt=\"\"></div> -->\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"inputs\">\r\n");
      out.write("                            <input name=\"userid\" type=\"text\" required placeholder=\"Username\" />\r\n");
      out.write("                            <input name=\"password\" type=\"password\" required placeholder=\"Password\" />\r\n");
      out.write("                \r\n");
      out.write("                        \r\n");
      out.write("                       \r\n");
      out.write("                        <div class=\"link-2\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/index.jsp\">Are You User..?</a></div>\r\n");
      out.write("                        <div class=\"clear\"></div>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"button-login\"><input type=\"submit\" value=\"Sign in\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write("       <div class=\"clear\"></div>  \r\n");
      out.write("    <div class=\"link-to-page\"></div>      \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <!-- Le javascript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/switcher.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
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
