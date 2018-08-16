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

public final class purchaseHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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



            public String createTableRow(int orderID, String productName, String image, int qty, double price) {
                    StringBuilder sb = new StringBuilder();
                    String imghtml = String.format("<img src='img/%s' alt ='%s' width='100 height='100' />", image, productName);
                    sb.append("<tr>");
                    sb.append("<td style='text-align:center;'>").append(orderID).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(productName).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(imghtml).append("</td>");               
                    sb.append("<td style='text-align:center;'>").append(qty).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(String.format("RM%.2f", price)).append("</td>");
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
      out.write("\n");
      out.write('\n');
      out.write('\n');

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String dbLoc  = "jdbc:derby://localhost:1527/ABC";
    String dbUser = "john";
    String dbPwd  = "john";
    

      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Purchase History</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            table{border: 1px solid black; border-collapse: collapse;text-align: center;width: 45%}\n");
      out.write("            td,tr{border: 1px solid black;}\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"mystyle.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

                    try {
                    String userid = (String)session.getAttribute("userid");
                    Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                    String sql = "SELECT PRODUCT.PRODUCTID,PRODUCT.PRODUCTNAME,(PRODUCT.UNITPRICE * CORDER.QTY) AS TOTALPRICE, PRODUCT.IMGNAME, CORDER.ORDERID, CORDER.QTY "
                            + "FROM PRODUCT "
                            + "INNER JOIN CORDER "
                            + "ON PRODUCT.PRODUCTID=CORDER.PRODUCTID "
                            + "WHERE CORDER.CUSTOMERID=(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME = '"+ userid +"')";

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
      out.write("\n");
      out.write("        \n");
      out.write("            <h1>Purchase History</h1>\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <th>Order ID</th>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Total Price</th>      \n");
      out.write("                </thead>\n");
      out.write("                \n");
      out.write("                ");
 
                    while (rs.next()) { 
                       int orderID  = rs.getInt("ORDERID");
                       String productName = rs.getString("PRODUCTNAME");
                       String image = rs.getString("IMGNAME");
                       int quantity = rs.getInt("QTY");
                       int totalPrice = rs.getInt("TOTALPRICE"); 

                       out.println(createTableRow(orderID, productName, image, quantity, totalPrice));        
                    }     
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("                ");
 
                    
                    
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
