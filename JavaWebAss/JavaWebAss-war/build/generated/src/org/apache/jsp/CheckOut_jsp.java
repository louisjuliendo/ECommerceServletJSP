package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import MyClass.ShoppingCart;
import MyClass.Item;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CheckOut_jsp extends org.apache.jasper.runtime.HttpJspBase
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



            public String createTableRow(String size, String productName, String image, int qty, double price) {
                    StringBuilder sb = new StringBuilder();
                    String imghtml = String.format("<img src='img/%s' alt ='%s' width='100 height='100' />", image, productName);
                    sb.append("<tr>");
                    sb.append("<td style='text-align:center;'>").append(productName).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(size).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(imghtml).append("</td>");               
                    sb.append("<td style='text-align:center;'>").append(qty).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(String.format("RM%.2f", price)).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(String.format("RM%.2f", price*qty)).append("</td>");
                    sb.append("</tr>");
                    return sb.toString();
                }

            public String createTableRow2(String fname, String lname, String email, String phone, String gender, String address, String postcode, String city, String state, String country) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<tr>");
                    sb.append("<td style='text-align:center;'>").append(fname).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(lname).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(email).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(phone).append("</td>");               
                    sb.append("<td style='text-align:center;'>").append(gender).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(address).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(postcode).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(city).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(state).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(country).append("</td>");
                    sb.append("</tr>");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"post\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

                    try {
                        
                    String userid = (String)session.getAttribute("userid");
                    String pname = (String)session.getAttribute("pname");
                    Integer qty = (Integer)session.getAttribute("txtQty");
                    //Double totalPrice = (Double)session.getAttribute("total");
                    MyClass.ShoppingCart myCart = (MyClass.ShoppingCart) session.getAttribute("myCart");
                    double totalPrice =0;
                    for (int i = 0; i < myCart.size(); i++) {
                        Item items = myCart.getItem(i);
                        totalPrice = items.getUnitPrice()*items.getQuantity();
                    }
                    
                    String size = (String)session.getAttribute("size");
                    String img = (String) session.getAttribute("img_name");
                    
                    Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                    String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMERID=(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME = '"+ userid +"')";

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
        
        
      out.write("\n");
      out.write("             \n");
      out.write("        <h1>");
      out.print(userid);
      out.write("</h1>\n");
      out.write("        <h1>");
      out.print(pname);
      out.write("</h1>\n");
      out.write("        <h1>");
      out.print(qty);
      out.write("</h1>\n");
      out.write("        <h1>");
      out.print(totalPrice);
      out.write("</h1>\n");
      out.write("        <h1>");
      out.print(size);
      out.write("</h1>\n");
      out.write("        <h1>");
      out.print(img);
      out.write("</h1>\n");
      out.write("                    \n");
      out.write("        <h1>Order Details</h1>\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Size</th>\n");
      out.write("                    <th>Unit Price</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Total Price</th>\n");
      out.write("                </thead>\n");
      out.write("                \n");
      out.write("                ");
 
                    out.println(createTableRow(size, pname, img, qty, totalPrice));              
                
      out.write("\n");
      out.write("              \n");
      out.write("            </table>\n");
      out.write("                \n");
      out.write("            <h1>Your order is complete. The details are shown below.</h1>\n");
      out.write("                \n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <th>First Name</th>\n");
      out.write("                    <th>Last Name</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>Phone Number</th>\n");
      out.write("                    <th>Gender</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>Postcode</th>\n");
      out.write("                    <th>City</th>\n");
      out.write("                    <th>State</th>\n");
      out.write("                    <th>Country</th>\n");
      out.write("                </thead>\n");
      out.write("                ");
 
                    while (rs.next()) { 
                       String fname = rs.getString("FIRSTNAME");
                       String lname = rs.getString("LASTNAME");
                       String email = rs.getString("EMAIL");
                       String phone = rs.getString("PHONENUMBER");
                       String gender = rs.getString("GENDER"); 
                       String address = rs.getString("ADDRESS"); 
                       String postcode = rs.getString("POSTCODE"); 
                       String city = rs.getString("CITY"); 
                       String state  = rs.getString("STATE"); 
                       String country = rs.getString("COUNTRY"); 
                        
                       out.println(createTableRow2(fname, lname, email, phone, gender, address, postcode, city, state, country));
                    } 
                        
                
      out.write("\n");
      out.write("                    \n");
      out.write("            </table>\n");
      out.write("            <button name=\"btnCheckHistory\">Check History</button>\n");
      out.write("            <button name=\"btnContinue\">Continue Shopping</button>\n");
      out.write("                ");
      
                    if (request.getParameter("btnCheckHistory")!=null){
                        response.sendRedirect("purchaseHistory.jsp");
                    }
                    if (request.getParameter("btnContinue")!=null){
                        response.sendRedirect("homepage.jsp");
                    }
                        rs.close();
                        stmt.close();
                        conn.close();
                    }
                 catch (Exception ex) { 
      out.write("\n");
      out.write("                        <div class=\"error\">Error: ");
      out.print( ex.getMessage() );
      out.write("</div>\n");
      out.write("                ");
 
                }
                
      out.write("\n");
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
