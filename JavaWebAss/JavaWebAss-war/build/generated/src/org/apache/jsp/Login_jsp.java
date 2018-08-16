package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

    
    private String sha1(String input) throws NoSuchAlgorithmException {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(input.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/function.jspf");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String dbLoc  = "jdbc:derby://localhost:1527/ABC";
    String dbUser = "john";
    String dbPwd  = "john";
    

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"ExCss.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>   \n");
      out.write("        ");

            if(request.getParameter("btnCreateAcc")!=null){
                response.sendRedirect("Registration.jsp");
        
      out.write("\n");
      out.write("                \n");
      out.write("           ");
 }
            if (request.getParameter("btnLogin") != null) {
                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                PreparedStatement stmt  = conn.prepareStatement(
                        "SELECT * FROM Login WHERE username = ? AND password = ?", 
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_READ_ONLY);
                
                String username = request.getParameter("txtUser").trim().toLowerCase();
                String password = request.getParameter("txtPass");    
                
                stmt.setString(1, username);
                stmt.setString(2, sha1(password));  
                               
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    session.setAttribute("userid", rs.getString("username"));
                    session.setMaxInactiveInterval(60*60);  
                    response.sendRedirect("homepage.jsp");
                }
                else { 
      out.write("\n");
      out.write("                    <div class=\"loginpg\">\n");
      out.write("                           <div class=\"form\">\n");
      out.write("                              <form method=\"post\" class=\"login-form\">\n");
      out.write("                                <div class=\"logo\"><img src=\"Logo.png\" alt=\"logo\" width=\"150\" height=\"150\" /></div>\n");
      out.write("                                <input type=\"text\" name=\"txtUser\" placeholder=\"username\"/>\n");
      out.write("                                <input type=\"password\" name=\"txtPass\" placeholder=\"password\"/>\n");
      out.write("                                <button name=\"btnLogin\" type=\"submit\">LOGIN</button>\n");
      out.write("                                <p class=\"message\">Forgot your password? <a href=\"#\">Reset password</a></p>\n");
      out.write("                                <p class=\"messageerror\">Invalid password</p>\n");
      out.write("                              </form>\n");
      out.write("                            </div>\n");
      out.write("                      </div>\n");
      out.write("                ");

                }
                        
                rs.close();
                stmt.close();
                conn.close();
            }
            else
            {// user first landed on page            
        
      out.write("\n");
      out.write("        <div class=\"loginpg\">\n");
      out.write("           <div class=\"form\">\n");
      out.write("              <form method=\"post\" class=\"login-form\">\n");
      out.write("                <div class=\"logo\"><img src=\"Logo.png\" alt=\"logo\" width=\"150\" height=\"150\" /></div>\n");
      out.write("                <input type=\"text\" name=\"txtUser\" placeholder=\"username\"/>\n");
      out.write("                <input type=\"password\" name=\"txtPass\" placeholder=\"password\"/>\n");
      out.write("                <button name=\"btnLogin\" type=\"submit\">LOGIN</button>\n");
      out.write("                <p class=\"message\">Forgotten your password? <a href=\"ResetPass.jsp\">Reset password</a></p>\n");
      out.write("                <br/>\n");
      out.write("                <button name=\"btnCreateAcc\" type=\"submit\">CREATE NEW ACCOUNT</button>\n");
      out.write("              </form>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("        ");

        }
        
      out.write("\n");
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
