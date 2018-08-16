<%-- 
    Document   : Login
    Created on : Oct 19, 2017, 9:54:24 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@include file="function.jspf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="ExCss.css">
    </head>
    <body>   
        <%
            if(request.getParameter("btnCreateAcc")!=null){
                response.sendRedirect("Registration.jsp");
        %>
                
           <% }
            if (request.getParameter("btnLogin") != null) {
                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                PreparedStatement stmt  = conn.prepareStatement(
                        "SELECT * FROM Login WHERE username = ? AND password = ?", 
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_READ_ONLY);
                
                String username = request.getParameter("txtUser").trim().toLowerCase();
                String password = request.getParameter("txtPass");    
                
                stmt.setString(1, username);
                stmt.setString(2, sha1(password));  
                               
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    session.setAttribute("userid", rs.getString("username"));
                    session.setMaxInactiveInterval(60*60*60);  
                    response.sendRedirect("homepage.jsp");
                }
                else { %>
                    <div class="loginpg">
                           <div class="form">
                              <form method="post" class="login-form">
                                <div class="logo"><img src="Logo.png" alt="logo" width="150" height="150" /></div>
                                <input type="text" name="txtUser" placeholder="username"/>
                                <input type="password" name="txtPass" placeholder="password"/>
                                <button name="btnLogin" type="submit">LOGIN</button>
                                <p class="message">Forgot your password? <a href="#">Reset password</a></p>
                                <p class="messageerror">Invalid password</p>
                              </form>
                            </div>
                      </div>
                <%
                }
                        
                rs.close();
                stmt.close();
                conn.close();
            }
            else
            {// user first landed on page            
        %>
        <div class="loginpg">
           <div class="form">
              <form method="post" class="login-form">
                <div class="logo"><img src="Logo.png" alt="logo" width="150" height="150" /></div>
                <input type="text" name="txtUser" placeholder="username"/>
                <input type="password" name="txtPass" placeholder="password"/>
                <button name="btnLogin" type="submit">LOGIN</button>
                <p class="message">Forgotten your password? <a href="ResetPass.jsp">Reset password</a></p>
                <br/>
                <button name="btnCreateAcc" type="submit">CREATE NEW ACCOUNT</button>
              </form>
            </div>
      </div>
        <%
        }
        %>
    </body>
</html>
