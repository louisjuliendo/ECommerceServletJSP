<%@page import="java.sql.*"%>
<%@page import="MyClass.ShoppingCart"%>
<%@page import="MyClass.Item"%>
<%@include file="function.jspf"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="checkout.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/javascript" src="autoBreadcrumbs.js"></script>
    </head>
    <body>
        <form method="post">
        <%!
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
        %>
        <%
            String checkHist = request.getParameter("btnCheckHistory");
            String checkCont = request.getParameter("btnContinue");
            if(checkHist != null){
                response.sendRedirect("purchaseHistory.jsp");
            }
            if(checkCont != null){
                response.sendRedirect("homepage.jsp");
            }
                    try {
                    String userids = (String)session.getAttribute("userid");
                    String pname = (String)session.getAttribute("pname");
                    Integer qty = (Integer)session.getAttribute("toa");
                    //Double totalPrice = (Double)session.getAttribute("total");
                    MyClass.ShoppingCart myCart = (MyClass.ShoppingCart) session.getAttribute("myCart");
                    double totalPrice =0;
                    for (int i = 0; i < myCart.size(); i++) {
                        Item items = myCart.getItem(i);
                        totalPrice = items.getUnitPrice()*items.getQuantity();
                    }
                    
                    String sizes = (String)session.getAttribute("size");
                    String img = (String) session.getAttribute("i_name");
                    
                    Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                    String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMERID=(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME = '"+ userids +"')";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
        
        %>
        <h1>Order Details</h1>
            <table cellspacing='0'>
                <thead>
                    <th>Product Name</th>
                    <th>Size</th>
                    <th>Unit Price</th>
                    <th>Image</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                </thead>
                
                <% 
                    out.println(createTableRow(sizes, pname, img, qty, totalPrice));              
                %>
              
            </table>
                
            <h1>Your order is complete. The details are shown below.</h1>
                
            <table>
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Postcode</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Country</th>
                </thead>
                <% 
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
                        
                %>
                    
            </table>
<!--            <button name="btnCheckHistory">Check History</button>
            <button name="btnContinue">Continue Shopping</button>-->
            <div class="centerize">
                <button class="btnCheckHistory" type="submit">
                    <i class="fa fa-history" aria-hidden="true"></i>
                    Check History
                </button>
                <button class="btnContinue" type="submit">
                    <i class="fa fa-home" aria-hidden="true"></i
                    Continue Shopping
                </button>
            </div>
                <%      
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
                 catch (Exception ex) { %>
                        <div class="error">Error: <%= ex.getMessage() %></div>
                <% 
                }
                %>
        </form>
    </body>
</html>
