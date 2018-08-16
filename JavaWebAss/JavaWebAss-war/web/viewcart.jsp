<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MyClass.ShoppingCart"%>
<%@page import="MyClass.Item"%>
<%@include file="function.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <link rel="stylesheet" type="text/css" href="viewcart.css">
          <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/javascript" src="autoBreadcrumbs.js"></script>
    </head>
    <body>
        <form method="post" action="viewcart.jsp">
            <jsp:directive.include file="viewcart_header.jspf"/>
            <%!                
                public String createTableRow(String img_name, String name, int qty, double price) {
                    StringBuilder sb = new StringBuilder();
                    String imghtml = String.format("<img src='img/%s' alt ='%s' width='100 height='100' />", img_name, name);
                    sb.append("<td style='text-align:center;'>").append(imghtml).append("</td>");
                    sb.append("<td style='text-align:center;width:200px'>").append(name).append("</td>");
                    sb.append("<td style='text-align:center;'>").append(qty).append("</td>");
                    sb.append("<td style='text-align:center; width:120px;'>").append(String.format("RM%.2f", price)).append("</td>");
                    return sb.toString();
                }
            %>

            <%                
                String pressdel = request.getParameter("del");
                MyClass.ShoppingCart myCart = (MyClass.ShoppingCart) session.getAttribute("myCart");
                if (myCart != null) {
                    out.println("<table cellspacing='0'>");
                    out.println("<thead><tr><th>Image</th><th>Items</th><th>Description</th><th>Quantity</th><th>Price (RM)</th><th class='action'>Action</th></tr></thead>");
                    String updateQty = request.getParameter("btnUpdQty");
                    String delete = request.getParameter("btnDel");
                    String minus = request.getParameter("btnMin");
                    for (int i = 0; i < myCart.size(); i++) {
                        Item items = myCart.getItem(i);
            %>
            <tr>
                <%
                    int qty = items.getQuantity();
                    if(updateQty!= null){
                        Item items2 = (Item) myCart.getItem(Integer.parseInt(updateQty));
                        myCart.addItem(items2.getID(),items2.getName(),items2.getUnitPrice(),1,items2.getImageName());
                        session.setAttribute("total", myCart.calculateTotalPrice());
                        session.setAttribute("toa", qty+1);
                        response.sendRedirect("viewcart.jsp");                
                    }
                    
                    if(delete!= null){
                        Item items2 = (Item) myCart.getItem(Integer.parseInt(delete));
                        myCart.removeItem(items2.getID());
                        session.setAttribute("total", myCart.calculateTotalPrice());
                        session.setAttribute("tod", delete);
                        response.sendRedirect("viewcart.jsp");                
                    }
                    
                   if (minus!=null){
                        Item items2 = (Item) myCart.getItem(Integer.parseInt(minus));
                        int num2 = items2.getQuantity();
                        int num;
                        myCart.addItem(items2.getID(),items2.getName(),items2.getUnitPrice(),num=num2-1,items2.getImageName()); 
                        
                        if (num>0){
                        session.setAttribute("total", myCart.calculateTotalPrice());
                        session.setAttribute("toa", num);
                        items2.setQuantity(num);}
                        response.sendRedirect("viewcart.jsp");  
                        
                    }
                    
                    
//                    if (pressdel != null) {
//                        Item items3 = (Item) myCart.getItem(Integer.parseInt(pressdel));
//                        myCart.removeItem(items3.getID());
//                        session.setAttribute("total", myCart.calculateTotalPrice());
//                        session.setAttribute("tod", pressdel);
//                        response.sendRedirect("viewcart.jsp");
//                    }
                    
                %>
                <%                    
                    out.println(createTableRow(items.getImageName(), items.getName(), qty, items.getUnitPrice()));
                %>

                <td style="text-align:center;">
                    <button name="btnUpdQty" type="submit" value="0" >Add Qty</button>
                    <button name="btnMin" type="submit" value="0" >Minus Qty</button>
                    <button name="btnDel" type="submit" value="0" >Delete</button>        
                </td>
            </tr>
            <%
                    }
                    out.println("<tr><td colspan='5'>Total</td><td class='total'>RM" + String.format("%.2f", myCart.calculateTotalPrice()) + "</td></tr>");
                    out.println("</table>");

                    if (pressdel != null) {
                        Item items = (Item) myCart.getItem(Integer.parseInt(delete));
                        myCart.removeItem(items.getID());
                        session.setAttribute("total", myCart.calculateTotalPrice());
                        session.setAttribute("tod", delete);
                        response.sendRedirect("viewcart.jsp");
                    }
                }
            %>

            <%
                String purchase = request.getParameter("btnPurchase");
                String userids = (String)session.getAttribute("userid");
                String pname = (String)session.getAttribute("pname");
                Integer qty = (Integer)session.getAttribute("toa");
                String imgname = (String)session.getAttribute("imgname");
                
                if(purchase != null){
                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                String sql = "INSERT INTO CORDER (PRODUCTID,QTY,CUSTOMERID)"
                        + "VALUES((SELECT PRODUCTID FROM PRODUCT WHERE IMGNAME = '" 
                        + imgname +"'),"+qty+","
                        + "(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME = '"+ 
                        userids +"'))";
                //out.println(sql);
               // String sql = "INSERT INTO CORDER (PRODUCTID,QTY,CUSTOMERID)VALUES((SELECT PRODUCTID FROM PRODUCT WHERE IMGNAME = '" + pname +"'),"+qty+",(SELECT CUSTOMERID FROM LOGIN WHERE USERNAME = '"+ userids +"'))";
                Statement stmt=conn.createStatement();
                stmt.executeUpdate(sql);
                response.sendRedirect("CheckOut.jsp");
                
          
                
            }
            %>
            <button name="btnPurchase">Purchase</button>
        </form>
    </body>
</html>