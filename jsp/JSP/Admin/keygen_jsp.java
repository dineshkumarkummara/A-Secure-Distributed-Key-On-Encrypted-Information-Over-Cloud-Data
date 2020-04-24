package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.supportclass.*;
import com.test.*;
import javax.xml.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.math.BigInteger;
import com.supportclass.RSA_File_EncryptionDecryption;
import com.Database.UserDAO;

public final class keygen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("</head>\r\n");


RequestDispatcher rd=null;
String s = request.getParameter("ownerid");

//String public_key = request.getRealPath("")+"\\Keys\\public_key.txt";
//String private_key = request.getRealPath("")+"\\Keys\\private_key.txt";
//boolean f = RSA_File_EncryptionDecryption.generateRSAKey1(public_key,private_key,s);

BigInteger n = null;
BigInteger d = null;
BigInteger e = null;


RSA_New rsa = new RSA_New();

n=rsa.getN();///n contains product of two prime num
e=rsa.getE();///E contains some Value
d=rsa.getD();

System.out.println("N Value :"+n+"E Value :"+e+"D Value :"+d);

String publickey=n+"~"+e;

String privatekey=n+"~"+d;

boolean f = UserDAO.updatekey(s,publickey,privatekey);


if(f)
{
	 rd=request.getRequestDispatcher("/JSP/Admin/content.jsp?no=1");
	rd.forward(request, response);
}
else
{
	 rd=request.getRequestDispatcher("/JSP/Admin/content.jsp?no=2");
	rd.forward(request, response);
}



      out.write('\r');
      out.write('\n');
      out.write(' ');

    int no=Utility.parse(request.getParameter("no"));
if(no==1)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: 10px;color:red;font-size: 20px;\">\t\r\n");
      out.write("\t\t\t<p>Key Generated Successfully!</p>\r\n");
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
      out.write("<body>\r\n");
      out.write("\r\n");
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
