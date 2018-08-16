<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MyClass.ShoppingCart"%>
<%@page import="MyClass.Item"%>
<%@include file="function.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase History</title>
        <link rel="stylesheet" type="text/css" href="purchaseHistory.css"/>
        <script type="text/javascript" src="autoBreadcrumbs.js"></script>
    </head>
    <body>
        <form method="post" action="purchaseHistory.jsp">
            <jsp:directive.include file="purcHistory_header.jspf"/>
        <%!
            public String createTableRow(int orderID, String productName, String image, int qty, double price) {
                    StringBuilder sb = new StringBuilder();
                    String imghtml = String.format("<img src='img/%s' alt ='%s' width='100 height='100' />", image, productName);
                    sb.append("<tr>");
                    sb.append("<td style='text-align:center;'>").append(orderID).append("</td>");
                    sb.append("<td style='text-align:center;width:200px'>").append(productName).append("</td>");
                    sb.append("<td style='text-align:center;width:200px'>").append(imghtml).append("</td>");               
                    sb.append("<td style='text-align:center;width:200px'>").append(qty).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(String.format("RM%.2f", price)).append("</td>");
                    sb.append("</tr>");
                    return sb.toString();
                }
        %>
        
        <%
                    try {
                    String userid = (String)session.getAttribute("userid");
                    Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                    String sql = "SELECT PRODUCT.PRODUCTID,PRODUCT.PRODUCTNAME,(PRODUCT.UNITPRICE * CORDER.QTY) AS TOTALPRICE, PRODUCT.IMGNAME, CORDER.ORDERID, CORDER.QTY "
                            + "FROM PRODUCT "
                            + "INNER JOIN CORDER "
                            + "ON PRODUCT.PRODUCTID=CORDER.PRODUCTID "
                            + "WHERE CORDER.CUSTOMERID=(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME = '"+ userid +"')";

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);%>
        
            <table cellspacing='0'>
                <thead>
                    <th>Order ID</th>
                    <th>Product Name</th>
                    <th>Image</th>
                    <th>Quantity</th>
                    <th>Total Price</th>      
                </thead>
                
                <% 
                    while (rs.next()) { 
                       int orderID  = rs.getInt("ORDERID");
                       String productName = rs.getString("PRODUCTNAME");
                       String image = rs.getString("IMGNAME");
                       int quantity = rs.getInt("QTY");
                       int totalPrice = rs.getInt("TOTALPRICE"); 

                       out.println(createTableRow(orderID, productName, image, quantity, totalPrice));        
                    }     
                %>
            </table>
                <% 
                        rs.close();
                        stmt.close();
                        conn.close();
                    }
                 catch (Exception ex) { %>
                        <div class="error">Error: <%= ex.getMessage() %></div>
                <% 
                }
                %>
                </form>
    </body>
</html>
