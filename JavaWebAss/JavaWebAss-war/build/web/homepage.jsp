<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MyClass.ShoppingCart,MyClass.Item" %>
<%@include file="function.jspf" %>
<!DOCTYPE html>

<%!    public String createFilterUI(String type, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("<br/>");
        //sb.append("<button name='").append(type).append("'>").append("&#10006;</button>");
        sb.append("<span>&#8226;").append(value).append("</span>");
        return sb.toString();
    }

    public String createFilterUI(String type, double value) {
        Double d = new Double(value);
        return createFilterUI(type, d.toString());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <link rel="stylesheet" type="text/css" href="homepage.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/javascript" src="autoBreadcrumbs.js"></script>
    </head>
    <body>

        <%            String logo = request.getParameter("btnLogo");
            if (logo != null) {
                response.sendRedirect("homepage.jsp");
            }

            String submit = request.getParameter("btnAdd2Cart");
            String pressdel = request.getParameter("del");
            if (submit != null) {
        %><jsp:directive.include file="authentication.jspf"/><%
                int qty = Integer.parseInt(request.getParameter("txtQty"));
                session.setAttribute("toa", qty);
                
                String pname = request.getParameter("pname");
                String pid = request.getParameter("pid");
                double price = Double.parseDouble(request.getParameter("price"));
                String i_name = request.getParameter("imgname");
                session.setAttribute("imgname", i_name);
                out.println(i_name);
                session.setAttribute("pname", pname);
                session.setAttribute("pid", pid);
                session.setAttribute("price", price);

                MyClass.ShoppingCart myCart = (MyClass.ShoppingCart) session.getAttribute("myCart");
                if (myCart == null) {
                    myCart = new ShoppingCart();
                }

                myCart.addItem(pid, pname, price, qty, i_name);
                session.setAttribute("myCart", myCart);
                session.setMaxInactiveInterval(60 * 10);
            }

            String filterSql = " WHERE ";
            int priceFilter = 0, sizeFilter = 0, colorFilter = 0, genderFilter = 0;
            int dlSize = 0;
            String nameFilter = "";
            if (request.getParameter("ddlPrice") != null) {
                priceFilter = Integer.parseInt(request.getParameter("ddlPrice"));
            }
            if (request.getParameter("ddlColor") != null) {
                colorFilter = Integer.parseInt(request.getParameter("ddlColor"));
            }
            if (request.getParameter("ddlSizeFilter") != null) {
                sizeFilter = Integer.parseInt(request.getParameter("ddlSizeFilter"));
            }
            if (request.getParameter("chkGender") != null) {
                genderFilter = Integer.parseInt(request.getParameter("chkGender"));
            }
            if (request.getParameter("ddlSize") != null) {
                dlSize = Integer.parseInt(request.getParameter("ddlSize"));
            }
        %>                

        <jsp:directive.include file="homepage_header.jspf"/>

        <div class="menu">
            <div class="boxFilter">
                Your Selection:
                <br/>
                <%                        
                    boolean isFilterOn = false;
                    if (priceFilter > 0) {
                        isFilterOn = true;
                        String value = "";
                        String lPrice = "0", hPrice = "10000";
                        switch (priceFilter) {
                            case 1:
                                value = "RM200 - 300";
                                lPrice = "200";
                                hPrice = "300";
                                break;
                            case 2:
                                value = "RM301 - 400";
                                lPrice = "301";
                                hPrice = "400";
                                break;
                            case 3:
                                value = "RM401 - 500";
                                lPrice = "401";
                                hPrice = "500";
                                break;
                            case 4:
                                value = "RM501 - 600";
                                lPrice = "501";
                                hPrice = "600";
                                break;
                            case 5:
                                value = "RM601 - 700";
                                lPrice = "601";
                                hPrice = "700";
                                break;
                            case 6:
                                value = "RM701 - 800";
                                lPrice = "701";
                                hPrice = "800";
                                break;
                            case 7:
                                value = "RM801 - 900";
                                lPrice = "801";
                                hPrice = "900";
                                break;
                        }
                        filterSql += " UNITPRICE BETWEEN " + lPrice + " AND " + hPrice;
                        if (!isFilterOn) {
                            filterSql += " AND ";
                        }
                        out.println(createFilterUI("priceRange", value));

                    }

                    if (colorFilter > 0) {
                        String value = "";

                        switch (colorFilter) {
                            case 1:
                                value = "Black";
                                break;
                            case 2:
                                value = "Blue";
                                break;
                            case 3:
                                value = "Grey";
                                break;
                            case 4:
                                value = "Pink";
                                break;
                            case 5:
                                value = "Red";
                                break;
                            case 6:
                                value = "White";
                                break;
                            case 7:
                                value = "Yellow";
                                break;
                        }

                        if (isFilterOn) {
                            filterSql += " AND ";
                        }

                        filterSql += "COLOR LIKE '" + value + "' ";
                        //isFilterOn = true;
                        out.println(createFilterUI("Color", value));
                    }

                    if (sizeFilter > 0) {

                        String value = "";
                        String size = "";
                        switch (sizeFilter) {
                            case 1:
                                value = "4";
                                size = "4";
                                break;
                            case 2:
                                value = "5";
                                size = "5";
                                break;
                            case 3:
                                value = "5.5";
                                size = "5_5";
                                break;
                            case 4:
                                value = "6";
                                size = "6";
                                break;
                            case 5:
                                value = "6.5";
                                size = "6_5";
                                break;
                            case 6:
                                value = "7";
                                size = "7";
                                break;
                            case 7:
                                value = "7.5";
                                size = "7_5";
                                break;
                            case 8:
                                value = "8";
                                size = "8";
                                break;
                            case 9:
                                value = "8.5";
                                size = "8_5";
                                break;
                            case 10:
                                value = "9";
                                size = "9";
                                break;
                            case 11:
                                value = "9.5";
                                size = "9_5";
                                break;
                            case 12:
                                value = "10";
                                size = "10";
                                break;
                            case 13:
                                value = "11";
                                size = "11";
                                break;
                            case 14:
                                value = "12";
                                size = "12";
                                break;
                            case 15:
                                value = "13";
                                size = "13";
                                break;
                            case 16:
                                value = "14";
                                size = "14";
                                break;

                        }

                        if (isFilterOn) {
                            filterSql += " AND ";
                        }

                        filterSql += "SIZE" + size + ">0";
                        //isFilterOn = true;
                        out.println(createFilterUI("Size", value));
                    }

                    if (genderFilter > 0) {
                        String value = "";
                        switch (genderFilter) {
                            case 1:
                                value = "Men";
                                break;
                            case 2:
                                value = "Women";
                                break;
                        }

                        if (isFilterOn) {
                            filterSql += " AND ";
                        }

                        filterSql += "PGENDER = '" + value + "' ";
                        //isFilterOn = true;
                        out.println(createFilterUI("Gender", value));
                    }

                    if (request.getParameter("btnSearch") != null) {
                        String value = request.getParameter("txtSearch");

                        if (isFilterOn) {
                            filterSql += " AND ";
                        }

                        //filterSql += "PRODUCTNAME LIKE '%"+ value +"%'";
                        filterSql += "LOWER(PRODUCTNAME) LIKE LOWER('%" + value + "%')";
                        out.println(createFilterUI("Search", value));
                    }
                    if (dlSize > 0) {
                            String value = "";
                            String size = "";
                            switch (dlSize) {
                                case 1:
                                    value = "4";
                                    size = "4";
                                    break;
                                case 2:
                                    value = "5";
                                    size = "5";
                                    break;
                                case 3:
                                    value = "5.5";
                                    size = "5_5";
                                    break;
                                case 4:
                                    value = "6";
                                    size = "6";
                                    break;
                                case 5:
                                    value = "6.5";
                                    size = "6_5";
                                    break;
                                case 6:
                                    value = "7";
                                    size = "7";
                                    break;
                                case 7:
                                    value = "7.5";
                                    size = "7_5";
                                    break;
                                case 8:
                                    value = "8";
                                    size = "8";
                                    break;
                                case 9:
                                    value = "8.5";
                                    size = "8_5";
                                    break;
                                case 10:
                                    value = "9";
                                    size = "9";
                                    break;
                                case 11:
                                    value = "9.5";
                                    size = "9_5";
                                    break;
                                case 12:
                                    value = "10";
                                    size = "10";
                                    break;
                                case 13:
                                    value = "11";
                                    size = "11";
                                    break;
                                case 14:
                                    value = "12";
                                    size = "12";
                                    break;
                                case 15:
                                    value = "13";
                                    size = "13";
                                    break;
                                case 16:
                                    value = "14";
                                    size = "14";
                                    break;
                            }
                            session.setAttribute("size", value);
                        }
                %>                
            </div>
            <div class="boxFilter">
                Size
                <select name="ddlSizeFilter" onchange='this.form.submit()'>
                    <option value="0">Select Size</option>
                    <option value="1" ${param.ddlSizeFilter == '1' ? 'selected' : ''} >4</option>
                    <option value="2" ${param.ddlSizeFilter == '2' ? 'selected' : ''}>5</option>
                    <option value="3" ${param.ddlSizeFilter == '3' ? 'selected' : ''}>5.5</option>
                    <option value="4" ${param.ddlSizeFilter == '4' ? 'selected' : ''}>6</option>
                    <option value="5" ${param.ddlSizeFilter == '5' ? 'selected' : ''}>6.5</option>
                    <option value="6" ${param.ddlSizeFilter == '6' ? 'selected' : ''}>7</option>
                    <option value="7" ${param.ddlSizeFilter == '7' ? 'selected' : ''}>7.5</option>
                    <option value="8" ${param.ddlSizeFilter == '8' ? 'selected' : ''}>8</option>
                    <option value="9" ${param.ddlSizeFilter == '9' ? 'selected' : ''}>8.5</option>
                    <option value="10" ${param.ddlSizeFilter == '10' ? 'selected' : ''}>9</option>
                    <option value="11" ${param.ddlSizeFilter == '11' ? 'selected' : ''}>9.5</option>
                    <option value="12" ${param.ddlSizeFilter == '12' ? 'selected' : ''}>10</option>
                    <option value="13" ${param.ddlSizeFilter == '13' ? 'selected' : ''}>11</option>
                    <option value="14" ${param.ddlSizeFilter == '14' ? 'selected' : ''}>12</option>
                    <option value="15" ${param.ddlSizeFilter == '15' ? 'selected' : ''}>13</option>
                    <option value="16" ${param.ddlSizeFilter == '16' ? 'selected' : ''}>14</option>
                </select>

            </div>
            <div class="boxFilter">
                Price - RM
                <select name="ddlPrice" onchange='this.form.submit()'>
                    <option value="0">Select Price</option>
                    <option value="1" ${param.ddlPrice == '1' ? 'selected' : ''}>200 - 300</option>
                    <option value="2" ${param.ddlPrice == '2' ? 'selected' : ''}>301 - 400</option>
                    <option value="3" ${param.ddlPrice == '3' ? 'selected' : ''}>401 - 500</option>
                    <option value="4" ${param.ddlPrice == '4' ? 'selected' : ''}>501 - 600</option>
                    <option value="5" ${param.ddlPrice == '5' ? 'selected' : ''}>601 - 700</option>
                    <option value="6" ${param.ddlPrice == '6' ? 'selected' : ''}>701 - 800</option>
                    <option value="7" ${param.ddlPrice == '7' ? 'selected' : ''}>801 - 900</option>
                </select>
            </div>
            <div class="boxFilter">
                Color:
                <select name="ddlColor" onchange='this.form.submit()'>
                    <option value="0" >Select Color</option>
                    <option value="1" ${param.ddlColor == '1' ? 'selected' : ''}>Black</option>
                    <option value="2" ${param.ddlColor == '2' ? 'selected' : ''}>Blue</option>
                    <option value="3" ${param.ddlColor == '3' ? 'selected' : ''}>Grey</option>
                    <option value="4" ${param.ddlColor == '4' ? 'selected' : ''}>Pink</option>
                    <option value="5" ${param.ddlColor == '5' ? 'selected' : ''}>Red</option>
                    <option value="6" ${param.ddlColor == '6' ? 'selected' : ''}>White</option>
                    <option value="7" ${param.ddlColor == '7' ? 'selected' : ''}>Yellow</option>
                </select>
            </div>
            <div class="boxFilter">
                Gender
                <br/>
                <input type="radio" name="chkGender" onchange='this.form.submit()' value="1"${param.chkGender == '1' ? 'checked' : ''}>Men
                <br/>
                <input type="radio" name="chkGender" onchange='this.form.submit()' value="2"${param.chkGender == '2' ? 'checked' : ''}>Women
            </div>
        </div>
    </form>
    <%           
        try {
            Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
            String sql = "SELECT * FROM PRODUCT";
            sql += isFilterOn ? filterSql : "";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String pid = rs.getString("ProductID");
                String pname = rs.getString("ProductName");
                String pdesc = rs.getString("Description");
                double price = rs.getDouble("Unitprice");
                String img_name = rs.getString("ImgName");
    %>

    <form method="post" action="homepage.jsp">        
        <div class="main">
            <div class="products">
                <div class="productItem">
                    <div class="image"><img src="img/<%=img_name%>" alt="<%= pname%>" width="200" height="200"/></div>
                    <!--                            <div class="productColor"></div>-->
                    <div class="productName"><%= pname%></div>
                    <div class="productPrice"><%= String.format("RM%.2f", price)%></div>
                    <div class="quantity">Quantity: <input type="text" name="txtQty" size="5" /></div>


                    <div class="ddlSize">Size:
                        <select name="ddlSize">
                                <option value="1">4</option>
                                <option value="2">5</option>
                                <option value="3">5.5</option>
                                <option value="4">6</option>
                                <option value="5">6.5</option>
                                <option value="6">7</option>
                                <option value="7">7.5</option>
                                <option value="8">8</option>
                                <option value="9">8.5</option>
                                <option value="10">9</option>
                                <option value="11">9.5</option>
                                <option value="12">10</option>
                                <option value="13">11</option>
                                <option value="14">12</option>
                                <option value="15">13</option>
                                <option value="16">14</option>
                            </select>
                    </div>
                    <div class="add2cartbtn"><button class="btn" name="btnAdd2Cart" type="submit">Add to Cart</button></div>
                    <input type="hidden" name="pid" value="<%= pid%>"/>
                    <input type="hidden" name="pname" value="<%= pname%>"/>
                    <input type="hidden" name="price" value="<%= price%>"/>                
                    <input type="hidden" name="imgname" value="<%= img_name%>"/>    
                    </form>    
                </div>
            </div>
        </div>
    </div>

    <% }
    %>

    <%
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception ex) {%>
    <div class="error">Error: <%= ex.getMessage()%></div>

    <% }
    %>        

</body>
</html>
