package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("    <!-- for popup message start -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/style.js\"></script>\t\r\n");
      out.write("<!-- for popup message end-->\r\n");
      out.write("\r\n");
      out.write("  <title>Bloom Filter</title>\r\n");
      out.write("\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/reset.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style4.css\" media=\"screen\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer();\">\r\n");
      out.write("\r\n");
      out.write(" ");


String k=null;
k=request.getParameter("no");
 int no=0;
 if(k!=null)
 {
	 no=Integer.parseInt(k); 
 }




      out.write("\r\n");
      out.write(" \r\n");
      out.write(" ");

if(no==1)
{

      out.write("\r\n");
      out.write("<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("<div class=\"error\" id=\"message\" >\t\r\n");
      out.write("\t<p> User ID Already Exist.....!</p>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
}else if(no==3)
{

      out.write("\r\n");
      out.write("<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("<div class=\"error\" id=\"message\" >\t\r\n");
      out.write("\t<p> Fill out all the field Required format.....!</p>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
} else
	if(no==4)
	{
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("<div class=\"error\" id=\"message\" >\t\r\n");
      out.write("\t<p> Password Confrim Password is not same.....!</p>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

		
	}else
		if(no==2)
		{
			
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"position: absolute;top: 150px;\">\r\n");
      out.write("\t<div class=\"error\" id=\"message\" >\t\r\n");
      out.write("\t\t<p> User Account Created Successfully.....!</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

			
			
		}else
{
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
} 
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!-- multistep form -->\r\n");
      out.write("<form class=\"form-control\" id=\"msform\" action=\"");
      out.print(request.getContextPath());
      out.write("/Signup\" method=\"post\">\r\n");
      out.write("\t<!-- progressbar -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<ul id=\"progressbar\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<!-- fieldsets -->\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t\t<h2 class=\"fs-title\" style=\"color:white;\"> Create User account</h2>\r\n");
      out.write("\t\t<h3 class=\"fs-subtitle\" style=\"color:white;\">This is step 1</h3>\r\n");
      out.write("\t\t<input type=\"text\"  name=\"uid\" placeholder=\"UserID\" required/>\r\n");
      out.write("\t\t<input class=\"form-control\" type=\"password\" name=\"pass\" placeholder=\"Password\" required/>\r\n");
      out.write("\t\t<input type=\"password\" name=\"cpass\" placeholder=\"Confirm Password\" required />\r\n");
      out.write("\t\t\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t\t<h2 class=\"fs-title\" style=\"color:white;\">Personal Details</h2>\r\n");
      out.write("\t\t<h3 class=\"fs-subtitle\" style=\"color:blue;\">Communication Details</h3>\r\n");
      out.write("\t\t<input type=\"text\" name=\"uname\" placeholder=\"User Name\" />\r\n");
      out.write("\t\t<input type=\"email\" name=\"email\" placeholder=\"Email\" />\r\n");
      out.write("\t\t<input type=\"text\" name=\"pno\" placeholder=\"Phone Number\" />\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t\t<h2 class=\"fs-title\" style=\"color:white;\">Work Details</h2>\r\n");
      out.write("\t\t<h3 class=\"fs-subtitle\" style=\"color:blue;\">Professional</h3>\r\n");
      out.write("\t\t<!-- <input type=\"text\" name=\"grade\" placeholder=\"Enter Your Grade\" /> -->\r\n");
      out.write("\t\t\t<label>Select :&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\"grade\">\r\n");
      out.write("                <option value=\"1\">Grade1</option>\r\n");
      out.write("                <option value=\"2\">Grade2</option>\r\n");
      out.write("                <option value=\"3\">Grade3</option>\r\n");
      out.write("               \r\n");
      out.write("            </select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<input type=\"submit\" name=\"submit\" class=\"submit action-button\" value=\"Submit\" />\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/min1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- jQuery easing plugin -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/min2.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/index.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
