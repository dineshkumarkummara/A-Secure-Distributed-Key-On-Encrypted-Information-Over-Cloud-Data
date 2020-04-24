package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminhome1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\">\r\n");
      out.write("        <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("        <meta name=\"apple-touch-fullscreen\" content=\"yes\">\r\n");
      out.write("        \r\n");
      out.write("   <link href=\"");
      out.print(request.getContextPath() );
      out.write("/newcss/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("  <link href=\"");
      out.print(request.getContextPath() );
      out.write("/newcss/style2.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"res/style.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");


String id = session.getAttribute("userid").toString();



      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body{\r\n");
      out.write("background-repeat: repeat;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/p7.jpg\">\r\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <img alt=\"\" style=\"width:1200px;\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/banner1.jpg\">\r\n");
      out.write("      \r\n");
      out.write("            <div style=\"position: absolute;top: 120px; left:-125px; color: blue; \">\r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                   \r\n");
      out.write("                   \r\n");
      out.write("                   <ul id=\"menu2\" class=\"menu\">\r\n");
      out.write("               \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<div  class=\"type-3\">\r\n");
      out.write("  <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/signup1.jsp\" target=\"myframe\" class=\"btn btn-1\">\r\n");
      out.write("      <span class=\"txt\">User Creation</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/users.jsp\" target=\"myframe\" class=\"btn btn-2\">\r\n");
      out.write("      <span class=\"txt\">User Details</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/cloud_config.jsp\" target=\"myframe\" class=\"btn btn-3\">\r\n");
      out.write("      <span class=\"txt\">Cloud Confi</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("   <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/keygen.jsp?ownerid=");
      out.print(id);
      out.write("\" target=\"myframe\" class=\"btn btn-4\">\r\n");
      out.write("      <span class=\"txt\">Key Setting</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("   <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/fileupload1.jsp\" target=\"myframe\" class=\"btn btn-5\">\r\n");
      out.write("      <span class=\"txt\">Upload Files</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("   <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/keyword_details.jsp\" target=\"myframe\" class=\"btn btn-6\">\r\n");
      out.write("      <span class=\"txt\">Keyword Rank</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("   <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/view_request.jsp\" target=\"myframe\" class=\"btn btn-7\">\r\n");
      out.write("      <span class=\"txt\">User Request</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath() );
      out.write("/ChangePass?name=");
      out.print(id);
      out.write("&no=1&id=");
      out.print(id );
      out.write("\" target=\"myframe\" class=\"btn btn-8\">\r\n");
      out.write("      <span class=\"txt\">Change Pass</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <div>\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/SignOut?no=1\" class=\"btn btn-9\">\r\n");
      out.write("      <span class=\"txt\">Logout</span>\r\n");
      out.write("      <span class=\"round\"><i class=\"fa fa-chevron-right\"></i></span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("    </ul>\r\n");
      out.write("               \r\n");
      out.write("               </div>    \r\n");
      out.write("                  \r\n");
      out.write("    \r\n");
      out.write("  <div id=\"content\" class=\"snap-content\" >\r\n");
      out.write("           \r\n");
      out.write("                \r\n");
      out.write("              \r\n");
      out.write("    \t<div style=\"position: absolute;top: 100px;left: 500px;font-family: monotype corsiva;font-size: 20px;\">\r\n");
      out.write("    \t\tWelcome ,");
      out.print(id);
      out.write("\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("                \r\n");
      out.write("              \r\n");
      out.write("                \r\n");
      out.write("                <iframe style=\"position: absolute;top: 150px;width: 700px;height: 450px;left: 220px;border-color: #556B2F;\" src=\"");
      out.print(request.getContextPath() );
      out.write("/signup1.jsp\"  frameborder=\"0\"  name=\"myframe\" >\r\n");
      out.write("                \r\n");
      out.write("               \r\n");
      out.write("                </iframe>\r\n");
      out.write("           \r\n");
      out.write("        </div>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/snap.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            var snapper = new Snap({\r\n");
      out.write("                element: document.getElementById('content')\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/demo.js\"></script>\r\n");
      out.write("        <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=\"https://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>       \r\n");
      out.write("     \r\n");
      out.write("    \r\n");
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
