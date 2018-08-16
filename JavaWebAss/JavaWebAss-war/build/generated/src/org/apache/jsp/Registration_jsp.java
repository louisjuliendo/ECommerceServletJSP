package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String dbLoc  = "jdbc:derby://localhost:1527/shoppingcart";
    String dbUser = "louis";
    String dbPwd  = "louis";
    

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"ExCss.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>   \n");
      out.write("        ");

            
            
            if (request.getParameter("btnSubmit") != null) {
                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                PreparedStatement stmt  = conn.prepareStatement(
                        "INSERT INTO LOGIN VALUES (?,?,'C02')", 
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_READ_ONLY);
                PreparedStatement stmt2  = conn.prepareStatement(
                        "INSERT INTO CUSTOMER VALUES ('C02',?,?,?,?,?,?,?,?,?,?)", 
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_READ_ONLY);
                
                String user = request.getParameter("txtUser");
                String pass = request.getParameter("txtPass");
                //String conPass = request.getParameter("txtConPass");
                String fname = request.getParameter("txtFname");
                String lname = request.getParameter("txtLname");
                String email = request.getParameter("txtEmail");
                String gender = request.getParameter("ddlGender");
                String telephone = request.getParameter("txtTelephone");
                String street = request.getParameter("txtStreet");
                String postcode = request.getParameter("txtPostcode");
                String city = request.getParameter("txtCity");
                String state = request.getParameter("txtState");
                String country = request.getParameter("txtCountry");
//                int Q1 = Integer.parseInt(request.getParameter("ddlSq1"));
//                String A1 = request.getParameter("txtSq1");
//                int Q2 = Integer.parseInt(request.getParameter("ddlSq1"));
//                String A2 = request.getParameter("txtSq2");
//                int Q3 = Integer.parseInt(request.getParameter("ddlSq1"));
//                String A3 = request.getParameter("txtSq3");

                stmt.setString(1, user);
                stmt.setString(2, pass);  
                //stmt.setString(3, user);  
                
                //stmt2.setString(1, user);  
                stmt2.setString(1, fname);  
                stmt2.setString(2, lname);  
                stmt2.setString(3, email);  
                stmt2.setString(4, gender);  
                stmt2.setString(5, telephone);  
                stmt2.setString(6, street);  
                stmt2.setString(7, postcode);  
                stmt2.setString(8, city);  
                stmt2.setString(9, state);  
                stmt2.setString(10, country);  
//                stmt.setInt(15,Q1);  
//                stmt.setString(16, A1);  
//                stmt.setInt(17,Q2);  
//                stmt.setString(18, A2);  
//                stmt.setInt(19,Q3);  
//                stmt.setString(20, A3);  
                
                
                               
//                ResultSet rs = stmt.executeUpdate();
//                ResultSet rs2 =stmt2.executeQuery();
                   stmt2.executeUpdate();                
                   stmt.executeUpdate();
               
                
 
                
      out.write("\n");
      out.write("                        ");
      if (true) {
        _jspx_page_context.forward("Success.jsp");
        return;
      }
      out.write(" \n");
      out.write("<!--                ");

//                else { 
      out.write("\n");
      out.write("                    <div class=\"loginpg\">\n");
      out.write("                           <div class=\"form\">\n");
      out.write("                              <form method=\"post\" class=\"login-form\">\n");
      out.write("                                <div class=\"logo\"><img src=\"Logo.png\" alt=\"logo\" width=\"150\" height=\"150\" /></div>\n");
      out.write("                                <input type=\"text\" name=\"txtUser\" placeholder=\"username\" required/>\n");
      out.write("                                <input type=\"password\" name=\"txtPass\" placeholder=\"password\" required/>\n");
      out.write("                                <input type=\"password\" name=\"txtConPass\" placeholder=\"confirm password\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtFname\" placeholder=\"first name\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtLname\" placeholder=\"last name\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtEmail\" placeholder=\"email\" required/>\n");
      out.write("                                <select name=\"ddlGender\" required >\n");
      out.write("                                    <option value=\"\">I am...</option>\n");
      out.write("                                    <option value=\"Female\">Female</option>\n");
      out.write("                                    <option value=\"Male\">Male</option>\n");
      out.write("                                    <option value=\"Other\">Other</option>\n");
      out.write("                                    <option value=\"Decline\">Rather not say</option>\n");
      out.write("                                 </select>\n");
      out.write("                                <input type=\"tel\" name=\"txtTelephone\" placeholder=\"telephone\" maxlength=\"11\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtStreet\" placeholder=\"address\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtPostcode\" placeholder=\"postcode\" maxlength=\"5\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtCity\" placeholder=\"city\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtState\" placeholder=\"state\" required/>\n");
      out.write("                                <input type=\"text\" name=\"txtCountry\" placeholder=\"country\" required/>\n");
      out.write("                                <select name=\"ddlSq1\" size=\"1\" required>\n");
      out.write("                                    <option value=\"\">Select Security Question 1</option>\n");
      out.write("                                    <option value=\"1\">What was your childhood nickname?</option>\n");
      out.write("                                    <option value=\"2\">In what city or town did your mother and father meet?</option>\n");
      out.write("                                    <option value=\"3\">What is your favorite team?</option>\n");
      out.write("                                    <option value=\"4\">What was your favorite sport in high school?</option>\n");
      out.write("                                    <option value=\"5\">What is the first name of the boy or girl that you first kissed?</option>\n");
      out.write("                                </select>\n");
      out.write("                                <input type=\"text\" name=\"txtSq1\" placeholder=\"answer 1\" size=\"20\" required/>\n");
      out.write("                                <select name=\"ddlSq2\" size=\"1\" required>\n");
      out.write("                                    <option value=\"\">Select Security Question 2</option>\n");
      out.write("                                       <option value=\"6\">What is the name of your favorite childhood friend?</option>\n");
      out.write("                                       <option value=\"7\">What is the middle name of your oldest child?</option>\n");
      out.write("                                       <option value=\"8\">What is your favorite movie?</option>\n");
      out.write("                                       <option value=\"9\">In what town was your first job?</option>\n");
      out.write("                                       <option value=\"10\">What was the last name of your third grade teacher?</option>\n");
      out.write("                                   </select>\n");
      out.write("                                <input type=\"text\" name=\"txtSq2\" placeholder=\"answer 2\" size=\"20\" required/>\n");
      out.write("                                <select name=\"ddlSq3\" size=\"1\" required>\n");
      out.write("                                    <option value=\"\">Select Security Question 3</option>\n");
      out.write("                                    <option value=\"11\">What was your favorite food as a child?</option>\n");
      out.write("                                    <option value=\"12\">What was the make and model of your first car?</option>\n");
      out.write("                                    <option value=\"13\">Who is your childhood sports hero?</option>\n");
      out.write("                                    <option value=\"14\">What school did you attend for sixth grade?</option>\n");
      out.write("                                    <option value=\"15\">What was the name of the company where you had your first job?</option>\n");
      out.write("                                </select>\n");
      out.write("                                <input type=\"text\" name=\"txtSq3\" placeholder=\"answer 3\" size=\"20\" required/>                                             \n");
      out.write("                                <p>By creating an account, you agree to our <a href=\"#\">Terms & Privacy</a>.</p>                               \n");
      out.write("                                <button name=\"btnSubmit\" type=\"submit\">Sign Up</button>\n");
      out.write("                                <button name=\"btnReset\" type=\"reset\">Reset</button>\n");
      out.write("                                <p class=\"message\">Forgot your password? <a href=\"#\">Reset password</a></p>\n");
      out.write("                                <p class=\"messageerror\">Invalid password</p>\n");
      out.write("                              </form>\n");
      out.write("                            </div>\n");
      out.write("                      </div>-->\n");
      out.write("                ");

   
                //rs.close();
                stmt.close();
                stmt2.close();
                conn.close();
            }
            else
            {// user first landed on page            
        
      out.write("\n");
      out.write("         <div class=\"loginpg\">\n");
      out.write("                <div class=\"form\">\n");
      out.write("                   <form method=\"post\" class=\"login-form\">\n");
      out.write("                     <div class=\"logo\"><img src=\"createacc.png\" alt=\"logo\" width=\"150\" height=\"150\" /></div>\n");
      out.write("                     <p class=\"title\">Create your new account</p>\n");
      out.write("                     <br/>\n");
      out.write("                     <input type=\"text\" name=\"txtUser\" placeholder=\"username\" required/>\n");
      out.write("                     <input type=\"password\" name=\"txtPass\" placeholder=\"password\" required/>\n");
      out.write("                     <input type=\"password\" name=\"txtConPass\" placeholder=\"confirm password\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtFname\" placeholder=\"first name\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtLname\" placeholder=\"last name\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtEmail\" placeholder=\"email\" required/>\n");
      out.write("                     <select name=\"ddlGender\" required >\n");
      out.write("                         <option value=\"\">I am...</option>\n");
      out.write("                         <option value=\"FEMALE\">Female</option>\n");
      out.write("                         <option value=\"MALE\">Male</option>\n");
      out.write("                         <option value=\"OTHER\">Other</option>\n");
      out.write("                         <option value=\"DECLINE\">Rather not say</option>\n");
      out.write("                      </select>\n");
      out.write("                     <input type=\"tel\" name=\"txtTelephone\" placeholder=\"telephone\" maxlength=\"11\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtStreet\" placeholder=\"address\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtPostcode\" placeholder=\"postcode\" maxlength=\"5\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtCity\" placeholder=\"city\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtState\" placeholder=\"state\" required/>\n");
      out.write("                     <input type=\"text\" name=\"txtCountry\" placeholder=\"country\" required/>\n");
      out.write("                     <br/>\n");
      out.write("                     <br/>\n");
      out.write("                     <br/>\n");
      out.write("                     <select name=\"ddlsq1\" size=\"1\" required>\n");
      out.write("                         <option value=\"\">Select Security Question 1</option>\n");
      out.write("                         <option value=\"1\">What was your childhood nickname?</option>\n");
      out.write("                         <option value=\"2\">In what city or town did your mother and father meet?</option>\n");
      out.write("                         <option value=\"3\">What is your favorite team?</option>\n");
      out.write("                         <option value=\"4\">What was your favorite sport in high school?</option>\n");
      out.write("                         <option value=\"5\">What is the first name of the boy or girl that you first kissed?</option>\n");
      out.write("                     </select>\n");
      out.write("                     <input type=\"text\" name=\"txtSq1\" placeholder=\"answer 1\" size=\"20\" required/>\n");
      out.write("                     <select name=\"ddlsq2\" size=\"1\" required>\n");
      out.write("                         <option value=\"\">Select Security Question 2</option>\n");
      out.write("                            <option value=\"6\">What is the name of your favorite childhood friend?</option>\n");
      out.write("                            <option value=\"7\">What is the middle name of your oldest child?</option>\n");
      out.write("                            <option value=\"8\">What is your favorite movie?</option>\n");
      out.write("                            <option value=\"9\">In what town was your first job?</option>\n");
      out.write("                            <option value=\"10\">What was the last name of your third grade teacher?</option>\n");
      out.write("                        </select>\n");
      out.write("                     <input type=\"text\" name=\"txtSq2\" placeholder=\"answer 2\" size=\"20\" required/>\n");
      out.write("                     <select name=\"ddlsq3\" size=\"1\" required>\n");
      out.write("                         <option value=\"\">Select Security Question 3</option>\n");
      out.write("                         <option value=\"11\">What was your favorite food as a child?</option>\n");
      out.write("                         <option value=\"12\">What was the make and model of your first car?</option>\n");
      out.write("                         <option value=\"13\">Who is your childhood sports hero?</option>\n");
      out.write("                         <option value=\"14\">What school did you attend for sixth grade?</option>\n");
      out.write("                         <option value=\"15\">What was the name of the company where you had your first job?</option>\n");
      out.write("                     </select>\n");
      out.write("                     <input type=\"text\" name=\"txtSq3\" placeholder=\"answer 3\" size=\"20\" required/>                                           \n");
      out.write("                     <p class=\"message\">By creating an account, you agree to our <a href=\"#\">Terms & Privacy</a>.</p>    \n");
      out.write("                     &nbsp;\n");
      out.write("                     <button name=\"btnSubmit\" type=\"submit\">Sign Up</button>\n");
      out.write("                     <button name=\"btnReset\" type=\"reset\">Reset</button>\n");
      out.write("                   </form>\n");
      out.write("                 </div>\n");
      out.write("           </div>\n");
      out.write("        ");

        }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
