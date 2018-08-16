package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MyClass.ShoppingCart;
import MyClass.Item;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Shopping Cart - Success</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            <!--\n");
      out.write("            .container {\n");
      out.write("                height: 700px;\n");
      out.write("                width: 900px;\n");
      out.write("                margin:auto;\n");
      out.write("            }\n");
      out.write("            .headbanner {\n");
      out.write("                float: left;\n");
      out.write("                height: 80px;\n");
      out.write("                width: 900px;\n");
      out.write("                vertical-align:middle;\n");
      out.write("                background-color:#FFCC00;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .container .headbanner h1 {\n");
      out.write("                font-family: Verdana, Geneva, sans-serif;\n");
      out.write("                color: #CC3300;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .mycontent {\n");
      out.write("                float: left;\n");
      out.write("                height: 400px;\n");
      out.write("                width: 900px;\n");
      out.write("                padding-top:100px;\n");
      out.write("            }\n");
      out.write("            .myfooter {\n");
      out.write("                float: left;\n");
      out.write("                height: 100px;\n");
      out.write("                width: 900px;\n");
      out.write("                border-top-width:3px;\n");
      out.write("                border-top-style:solid;\n");
      out.write("                border-top-color:#FFCC00;\n");
      out.write("            }\n");
      out.write("            .container .myfooter h3 {\n");
      out.write("                font-family: Verdana, Geneva, sans-serif;\n");
      out.write("                font-size: 12px;\n");
      out.write("                color:#CC3300;\n");
      out.write("            }\n");
      out.write("            .container .mycontent h3 {\n");
      out.write("                font-family: Verdana, Geneva, sans-serif;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            -->\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body style=\"margin:0; padding:0\">\n");
      out.write("        ");
if(session.getAttribute("purch")!="true"){response.sendRedirect("index.jsp");
        } 
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"shop.jsp\" method=\"post\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"headbanner\">\n");
      out.write("                    <h1 style=\"display:inline\"><center>\n");
      out.write("                            <img src=\"img/shopping.png\" />[My Shopping Cart]\n");
      out.write("                        </center></h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mycontent\">\n");
      out.write("                    <h3 align=\"center\" style=\"color:#CC3300;\">Purchase has been succeeded! Thank You.<br /><input type=\"submit\" value=\"Ok\" /></h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"myfooter\">\n");
      out.write("                    <h3 style=\"font-weight:normal; padding-left:10px\">&copy;This Sample Project is Designed and Developed by Dilukshan Mahendra</h3>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
