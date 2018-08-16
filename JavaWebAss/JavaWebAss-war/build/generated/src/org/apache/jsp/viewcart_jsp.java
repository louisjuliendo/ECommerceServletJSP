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

public final class viewcart_jsp extends org.apache.jasper.runtime.HttpJspBase
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



                public String createTableRow(String img_name, String name, int qty, double price) {
                    StringBuilder sb = new StringBuilder();
                    String imghtml = String.format("<img src='img/%s' alt ='%s' width='100 height='100' />", img_name, name);
                    sb.append("<td style='text-align:center;'>").append(imghtml).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(name).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(qty).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(String.format("RM%.2f", price)).append("</td>");
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            table { \n");
      out.write("                width: 600px; \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"post\" action=\"viewcart.jsp\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                String pressdel = request.getParameter("del");
                MyClass.ShoppingCart myCart = (MyClass.ShoppingCart) session.getAttribute("myCart");
                if (myCart != null) {
                    out.println("<table border='1' width='400px'>");
                    out.println("<thead><tr><th>Image</th><th>Items</th><th>Quantity</th><th>Price (RM)</th><th>Action</th></tr></thead>");
                    for (int i = 0; i < myCart.size(); i++) {
                        Item items = myCart.getItem(i);
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("               \n");
      out.write("                ");

                    String updateQty = request.getParameter("btnUpdQty");
                    int qty = items.getQuantity();
                    if(updateQty!= null){
                        qty = items.getQuantity();
                        qty++;
                    }
                
      out.write("\n");
      out.write("                ");

                    out.println(createTableRow(items.getImageName(),items.getName(), qty, items.getUnitPrice()));
                
      out.write("\n");
      out.write("                 \n");
      out.write("                 <td style=\"text-align:center;\">\n");
      out.write("                     <button type=\"submit\" value=\"0\" onclick=\"buttonClick()\" >Update Qty</button>\n");
      out.write("                     <button name=");
      out.print(i);
      out.write(" type=\"submit\" value=\"0\" >Delete</button>\n");
      out.write("                    \n");
      out.write("                 </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                    out.println("<tr><td colspan='4'>Total</td><td>RM" + String.format("%.2f", myCart.calculateTotalPrice()) + "</td></tr>");
                    out.println("</table>");

                    if (pressdel != null) {
                        Item items = (Item) myCart.getItem(Integer.parseInt(pressdel));
                        myCart.removeItem(items.getID());
                        session.setAttribute("total", myCart.calculateTotalPrice());
                        session.setAttribute("tod", pressdel);
                        response.sendRedirect("viewcart.jsp");
                    }
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("   \n");
      out.write("        ");

            String purchase = request.getParameter("btnPurchase");
            if(purchase != null){
                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO HISTORYORD (OrderID) VALUES(?)");
                PreparedStatement stmt2 = conn.prepareStatement("SELECT ORDERID FROM CORDER WHERE HISTORYORD.ORDERID = CORDER.ORDERID");
                stmt.setInt(1,2);
                int i = stmt.executeUpdate();
                response.sendRedirect("success.jsp");
            }
        
      out.write("\n");
      out.write("        <button name=\"btnPurchase\">Purchase</button>\n");
      out.write("         </form>\n");
      out.write("</body>\n");
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
