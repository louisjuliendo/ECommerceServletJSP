package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MyClass.ShoppingCart;
import MyClass.Item;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    public String createFilterUI(String type, String value) {
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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/function.jspf");
    _jspx_dependants.add("/authentication.jspf");
    _jspx_dependants.add("/homepage_header.jspf");
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Homepage</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"homepage.css\">\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script type=\"text/javascript\" src=\"autoBreadcrumbs.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
            String logo = request.getParameter("btnLogo");
            if (logo != null) {
                response.sendRedirect("homepage.jsp");
            }

            String submit = request.getParameter("btnAdd2Cart");
            String pressdel = request.getParameter("del");
            if (submit != null) {
        

    String userid = (String) session.getAttribute("userid");
    if (userid == null) response.sendRedirect("Login.jsp");


                int qty = Integer.parseInt(request.getParameter("txtQty"));
                session.setAttribute("toa", qty);
                String pname = request.getParameter("pname");
                String pid = request.getParameter("pid");
                double price = Double.parseDouble(request.getParameter("price"));
                String img_name = request.getParameter("imgname");
                session.setAttribute("pname", pname);
                session.setAttribute("pid", pid);
                session.setAttribute("price", price);

                MyClass.ShoppingCart myCart = (MyClass.ShoppingCart) session.getAttribute("myCart");
                if (myCart == null) {
                    myCart = new ShoppingCart();
                }

                myCart.addItem(pid, pname, price, qty, img_name);
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
        
      out.write("                \n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"welcome\"><h1>Welcome to EX Shopify</h1></div>\n");
      out.write("        <form method=\"post\">\n");
      out.write("            <div class=\"topnav\" id=\"myTopnav\">\n");
      out.write("                <!--<a class=\"active\" href=\"#home\">EX Shopify</a>-->\n");
      out.write("                <a class=\"active\" href=\"homepage.jsp\"><img class=\"logo\" src=\"Logo.png\" alt=\"logo\" width=\"110\" height=\"110\" /></a>\n");
      out.write("\n");
      out.write("                <span class=\"floatRight\">\n");
      out.write("                    ");
                        String userid = (String) session.getAttribute("userid");
                        if (userid == null) {
                            out.println("<a href='Registration.jsp'>Create Account</a>");
                            out.println("<a href='Login.jsp'>Login</a>");
                        } else {
                            out.println("<a href='viewcart.jsp'>View Cart</a>");
                            out.println("<a href='purchaseHistory.jsp'>Purchase History</a>");
                            out.println("<button class='logout' name='logout' type='submit'>Logout</button>");
                        }
                    
      out.write("\n");
      out.write("                    ");

                        String logout = request.getParameter("logout");
                        if (logout != null) {
                            session.invalidate();
                            response.sendRedirect("Login.jsp");
                        }
                    
      out.write("\n");
      out.write("                </span>\n");
      out.write("\n");
      out.write("                <!--                <div class=\"searchSpace\">\n");
      out.write("                                    <input type=\"text\" name=\"txtSearch\" placeholder=\"find your shoes\" size=\"20\"/>\n");
      out.write("                                    <button type=\"submit\" name=\"btnSearch\">Search</button>\n");
      out.write("                                </div>-->\n");
      out.write("                <div class=\"box\">\n");
      out.write("                    <div class=\"container-4\">\n");
      out.write("                        <input type=\"search\" name=\"txtSearch\" id=\"search\" placeholder=\"Search...\" />\n");
      out.write("                        <button class=\"icon\" name=\"btnSearch\"><i class=\"fa fa-search\" ></i></button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    breadcrumbs();\n");
      out.write("                </script>\n");
      out.write("            </div>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <div class=\"boxFilter\">\n");
      out.write("                Your Selection:\n");
      out.write("                <br/>\n");
      out.write("                ");
                        
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
                
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"boxFilter\">\n");
      out.write("                Size\n");
      out.write("                <select name=\"ddlSizeFilter\" onchange='this.form.submit()'>\n");
      out.write("                    <option value=\"0\">Select Size</option>\n");
      out.write("                    <option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '1' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" >4</option>\n");
      out.write("                    <option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '2' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">5</option>\n");
      out.write("                    <option value=\"3\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '3' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">5.5</option>\n");
      out.write("                    <option value=\"4\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '4' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">6</option>\n");
      out.write("                    <option value=\"5\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '5' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">6.5</option>\n");
      out.write("                    <option value=\"6\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '6' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">7</option>\n");
      out.write("                    <option value=\"7\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '7' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">7.5</option>\n");
      out.write("                    <option value=\"8\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '8' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">8</option>\n");
      out.write("                    <option value=\"9\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '9' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">8.5</option>\n");
      out.write("                    <option value=\"10\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '10' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">9</option>\n");
      out.write("                    <option value=\"11\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '11' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">9.5</option>\n");
      out.write("                    <option value=\"12\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '12' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">10</option>\n");
      out.write("                    <option value=\"13\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '13' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">11</option>\n");
      out.write("                    <option value=\"14\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '14' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">12</option>\n");
      out.write("                    <option value=\"15\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '15' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">13</option>\n");
      out.write("                    <option value=\"16\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlSizeFilter == '16' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">14</option>\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"boxFilter\">\n");
      out.write("                Price - RM\n");
      out.write("                <select name=\"ddlPrice\" onchange='this.form.submit()'>\n");
      out.write("                    <option value=\"0\">Select Price</option>\n");
      out.write("                    <option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '1' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">200 - 300</option>\n");
      out.write("                    <option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '2' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">301 - 400</option>\n");
      out.write("                    <option value=\"3\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '3' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">401 - 500</option>\n");
      out.write("                    <option value=\"4\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '4' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">501 - 600</option>\n");
      out.write("                    <option value=\"5\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '5' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">601 - 700</option>\n");
      out.write("                    <option value=\"6\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '6' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">701 - 800</option>\n");
      out.write("                    <option value=\"7\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlPrice == '7' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">801 - 900</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"boxFilter\">\n");
      out.write("                Color:\n");
      out.write("                <select name=\"ddlColor\" onchange='this.form.submit()'>\n");
      out.write("                    <option value=\"0\" >Select Color</option>\n");
      out.write("                    <option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '1' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Black</option>\n");
      out.write("                    <option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '2' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Blue</option>\n");
      out.write("                    <option value=\"3\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '3' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Grey</option>\n");
      out.write("                    <option value=\"4\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '4' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Pink</option>\n");
      out.write("                    <option value=\"5\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '5' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Red</option>\n");
      out.write("                    <option value=\"6\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '6' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">White</option>\n");
      out.write("                    <option value=\"7\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.ddlColor == '7' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Yellow</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"boxFilter\">\n");
      out.write("                Gender\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"radio\" name=\"chkGender\" onchange='this.form.submit()' value=\"1\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.chkGender == '1' ? 'checked' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Men\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"radio\" name=\"chkGender\" onchange='this.form.submit()' value=\"2\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.chkGender == '2' ? 'checked' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Women\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("    ");
           
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
    
      out.write("\n");
      out.write("\n");
      out.write("    <form method=\"post\" action=\"homepage.jsp\">        \n");
      out.write("        <div class=\"main\">\n");
      out.write("            <div class=\"products\">\n");
      out.write("                <div class=\"productItem\">\n");
      out.write("                    <div class=\"image\"><img src=\"img/");
      out.print(img_name);
      out.write("\" alt=\"");
      out.print( pname);
      out.write("\" width=\"200\" height=\"200\"/></div>\n");
      out.write("                    <!--                            <div class=\"productColor\"></div>-->\n");
      out.write("                    <div class=\"productName\">");
      out.print( pname);
      out.write("</div>\n");
      out.write("                    <div class=\"productPrice\">");
      out.print( String.format("RM%.2f", price));
      out.write("</div>\n");
      out.write("                    <div class=\"quantity\">Quantity: <input type=\"text\" name=\"txtQty\" size=\"5\" /></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"ddlSize\">Size:\n");
      out.write("                        <select name=\"ddlSize\">\n");
      out.write("                                <option value=\"1\">4</option>\n");
      out.write("                                <option value=\"2\">5</option>\n");
      out.write("                                <option value=\"3\">5.5</option>\n");
      out.write("                                <option value=\"4\">6</option>\n");
      out.write("                                <option value=\"5\">6.5</option>\n");
      out.write("                                <option value=\"6\">7</option>\n");
      out.write("                                <option value=\"7\">7.5</option>\n");
      out.write("                                <option value=\"8\">8</option>\n");
      out.write("                                <option value=\"9\">8.5</option>\n");
      out.write("                                <option value=\"10\">9</option>\n");
      out.write("                                <option value=\"11\">9.5</option>\n");
      out.write("                                <option value=\"12\">10</option>\n");
      out.write("                                <option value=\"13\">11</option>\n");
      out.write("                                <option value=\"14\">12</option>\n");
      out.write("                                <option value=\"15\">13</option>\n");
      out.write("                                <option value=\"16\">14</option>\n");
      out.write("                            </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"add2cartbtn\"><button class=\"btn\" name=\"btnAdd2Cart\" type=\"submit\">Add to Cart</button></div>\n");
      out.write("                    <input type=\"hidden\" name=\"pid\" value=\"");
      out.print( pid);
      out.write("\"/>\n");
      out.write("                    <input type=\"hidden\" name=\"pname\" value=\"");
      out.print( pname);
      out.write("\"/>\n");
      out.write("                    <input type=\"hidden\" name=\"price\" value=\"");
      out.print( price);
      out.write("\"/>                \n");
      out.write("                    <input type=\"hidden\" name=\"imgname\" value=\"");
      out.print( img_name);
      out.write("\"/>    \n");
      out.write("                    </form>    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
 }
    
      out.write("\n");
      out.write("\n");
      out.write("    ");

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception ex) {
      out.write("\n");
      out.write("    <div class=\"error\">Error: ");
      out.print( ex.getMessage());
      out.write("</div>\n");
      out.write("\n");
      out.write("    ");
 }
    
      out.write("        \n");
      out.write("\n");
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
