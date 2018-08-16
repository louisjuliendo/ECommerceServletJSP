package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ResetPass_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Registration</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"ExCss.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>   \n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("function Validate() {\n");
      out.write("        var password = document.getElementById(\"pass1\").value;\n");
      out.write("        var confirmPassword = document.getElementById(\"pass2\").value;\n");
      out.write("        if (password !== confirmPassword) {\n");
      out.write("            alert(\"Passwords Do Not Match.\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("            \n");
      out.write("            function checkPass()\n");
      out.write("{\n");
      out.write("    //Store the password field objects into variables ...\n");
      out.write("    var pass1 = document.getElementById('pass1');\n");
      out.write("    var pass2 = document.getElementById('pass2');\n");
      out.write("    //Store the Confimation Message Object ...\n");
      out.write("    var message = document.getElementById('confirmMessage');\n");
      out.write("    //Set the colors we will be using ...\n");
      out.write("    var goodColor = \"#66cc66\";\n");
      out.write("    var badColor = \"#ff6666\";\n");
      out.write("    //Compare the values in the password field \n");
      out.write("    //and the confirmation field\n");
      out.write("    if(pass1.value === pass2.value){\n");
      out.write("        //The passwords match. \n");
      out.write("        //Set the color to the good color and inform\n");
      out.write("        //the user that they have entered the correct password \n");
      out.write("        pass2.style.backgroundColor = goodColor;\n");
      out.write("        message.style.color = goodColor;\n");
      out.write("        message.innerHTML = \"Passwords Match!\";\n");
      out.write("    }else{\n");
      out.write("        //The passwords do not match.\n");
      out.write("        //Set the color to the bad color and\n");
      out.write("        //notify the user.\n");
      out.write("        pass2.style.backgroundColor = badColor;\n");
      out.write("        message.style.color = badColor;\n");
      out.write("        message.innerHTML = \"Passwords Do Not Match!\";\n");
      out.write("    }\n");
      out.write("}  \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <form method = \"post\" class=\"login-form\">\n");
      out.write("            ");
 if (request.getParameter("btnVerify") == null && request.getParameter("btnConfirm") == null) { 
      out.write("\n");
      out.write("                       \n");
      out.write("            <div class=\"loginpg\">\n");
      out.write("                    <div class=\"form\">\n");
      out.write("                       <form method=\"post\" class=\"login-form\">\n");
      out.write("                         <div class=\"logo\"><img src=\"reset.png\" alt=\"logo\" width=\"150\" height=\"150\" /></div>\n");
      out.write("                         <p class=\"title\">Reset Password</p>\n");
      out.write("                         <br/>\n");
      out.write("                         <input type=\"text\" name=\"txtUser\" placeholder=\"username\" required/>\n");
      out.write("                         <input type=\"text\" name=\"txtEmail\" placeholder=\"email\" required/>\n");
      out.write("                         <button name=\"btnVerify\" type=\"submit\">VERIFY</button> \n");
      out.write("                       </form>\n");
      out.write("                     </div>\n");
      out.write("               </div>\n");
      out.write("            ");
 } else if (request.getParameter("btnConfirm") == null && request.getParameter("btnVerify") != null) { 

                String user = request.getParameter("txtUser");
                String email = request.getParameter("txtEmail");

                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                PreparedStatement stmt  = conn.prepareStatement(
                        "SELECT LOGIN.USERNAME, CUSTOMER.EMAIL "
                                + "FROM LOGIN "
                                + "INNER JOIN CUSTOMER "
                                + "ON LOGIN.CUSTOMERID = CUSTOMER.CUSTOMERID "
                                + "WHERE LOGIN.USERNAME=? AND CUSTOMER.EMAIL=?", 
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_READ_ONLY);
                
                PreparedStatement stmt3  = conn.prepareStatement(
                        "SELECT * FROM SECURITY WHERE CUSTOMERID=(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME=?)", 
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                                
                stmt.setString(1, user);
                stmt.setString(2, email);                
                stmt3.setString(1, user);
                                 
                
                ResultSet rs = stmt.executeQuery();//login
                ResultSet rs2 = stmt3.executeQuery();//security

//                if(rs.getString(1)!= user){
//                    out.println("ERROR NO USERNAME DETECTED");
//                }
                
                String questions []=
                {"0", "What was your childhood nickname?","In what city or town did your mother and father meet?","What is your favorite team?","What was your favorite sport in high school?", "What is the first name of the boy or girl that you first kissed?",
                "What is the name of your favorite childhood friend?","What is the middle name of your oldest child?","What is your favorite movie?","In what town was your first job?","What was the last name of your third grade teacher?",
                "What was your favorite food as a child?","What was the make and model of your first car?","Who is your childhood sports hero?","What school did you attend for sixth grade?","What was the name of the company where you had your first job?"
                };
                    String ans1, ans2, ans3;
                    ans1 = ans2 = ans3 = "";

                     if(rs.next() && rs2.next()){ 
                            ans1=rs2.getString("SA1");
                            ans2=rs2.getString("SA2");
                            ans3=rs2.getString("SA3");
                            session.setAttribute("sa1", ans1);
                            session.setAttribute("sa2", ans2);
                            session.setAttribute("sa3", ans3);
                            session.setAttribute("user", user);
                     }                 
            
            
      out.write("\n");
      out.write("                <div class=\"loginpg\">\n");
      out.write("                   <div class=\"form\">\n");
      out.write("                           <div class=\"logo\"><img src=\"reset.png\" alt=\"logo\" width=\"150\" height=\"150\" /></div>    \n");
      out.write("\n");
      out.write("                               <input type=\"password\" name=\"txtNewPass\" id=\"pass1\" placeholder=\"new password\" required/>\n");
      out.write("                               <input type=\"password\" name=\"txtConPass\" id=\"pass2\" onkeyup=\"checkPass(); return false;\" placeholder=\"confirm password\" required/>\n");
      out.write("                               <span id=\"confirmMessage\" class=\"confirmMessage\"></span>\n");
      out.write("                               <br/>\n");
      out.write("                               <br/>\n");
      out.write("                                   <input type=\"text\" name=\"txtS1\" placeholder=\"");
      out.print(questions[rs2.getInt("SQ1")]);
      out.write("\" disabled/>\n");
      out.write("                                   <input type=\"text\"  name=\"txtA1\" placeholder=\"answer 1\" size=\"20\" required>          \n");
      out.write("\n");
      out.write("                                   <input type=\"text\" name=\"txtS2\" placeholder=\"");
      out.print(questions[rs2.getInt("SQ2")]);
      out.write("\" disabled/>\n");
      out.write("                                   <input type=\"text\" name=\"txtA2\" placeholder=\"answer 2\" size=\"20\" required>\n");
      out.write("\n");
      out.write("                                   <input type=\"text\" name=\"txtS3\" placeholder=\"");
      out.print(questions[rs2.getInt("SQ3")]);
      out.write("\" disabled/>\n");
      out.write("                                   <input type=\"text\" name=\"txtA3\" placeholder=\"answer 3\" size=\"20\" required>\n");
      out.write("\n");
      out.write("                                   <button name=\"btnConfirm\" type=\"submit\" onclick=\"return Validate()\">CONFIRM</button>      \n");
      out.write("                                   \n");
      out.write("                                   \n");
      out.write("            ");
 
                rs.close();
                rs2.close();
                stmt.close();
                stmt3.close();
                conn.close(); }
                else { 

                try {
                    String newPass = request.getParameter("txtNewPass");
                    String conPass = request.getParameter("txtConPass");
                    String ans1 = (String) session.getAttribute("sa1");
                    String ans2 = (String) session.getAttribute("sa2");
                    String ans3 = (String) session.getAttribute("sa3");
                    String user = (String) session.getAttribute("user");
                    session.removeAttribute("sa1");
                    session.removeAttribute("sa2");
                    session.removeAttribute("sa3");
                    session.removeAttribute("user");

                    Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                    PreparedStatement stmt2  = conn.prepareStatement(
                        "UPDATE JOHN.LOGIN SET PASSWORD = ? WHERE USERNAME=?");

                    stmt2.setString(1, sha1(newPass));
                    stmt2.setString(2, user);

                    String SA1 = request.getParameter("txtA1");
                    String SA2 = request.getParameter("txtA2");
                    String SA3 = request.getParameter("txtA3");

                        
      out.write("\n");
      out.write("                    ");

                    if (newPass.equals(conPass)) {
                        if((ans1.equals(SA1)) && (ans2.equals(SA2))  &&(ans3.equals(SA3)) ){
                                stmt2.executeUpdate();
                                response.sendRedirect("Login.jsp");
                        }   // end if ans = sa
                    }   // end if newpass = conpass
                    else{
                        throw new Exception("Error: " );
                    }
                    conn.close();
                    stmt2.close();
            }
            catch (Exception ex) {
                    out.println("<h2 style='color: red;'>" + ex.getMessage() + "</h2>");
        }
                    

        }
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("       </form>\n");
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
