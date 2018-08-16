<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@include file="function.jspf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" type="text/css" href="ExCss.css">
    </head>
    <body>   
        
        <script type="text/javascript">
            
function Validate() {
        var password = document.getElementById("pass1").value;
        var confirmPassword = document.getElementById("pass2").value;
        if (password !== confirmPassword) {
            alert("Passwords Do Not Match.");
            return false;
        }
    }
            
            function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(pass1.value === pass2.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!";
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!";
    }
}  
        </script>
        
        <form method = "post" class="login-form">
            <% if (request.getParameter("btnVerify") == null && request.getParameter("btnConfirm") == null) { %>
                       
            <div class="loginpg">
                    <div class="form">
                       <form method="post" class="login-form">
                         <div class="logo"><img src="reset.png" alt="logo" width="150" height="150" /></div>
                         <p class="title">Reset Password</p>
                         <br/>
                         <input type="text" name="txtUser" placeholder="username" required/>
                         <input type="text" name="txtEmail" placeholder="email" required/>
                         <button name="btnVerify" type="submit">VERIFY</button> 
                       </form>
                     </div>
               </div>
            <% } else if (request.getParameter("btnConfirm") == null && request.getParameter("btnVerify") != null) { 

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
            
            %>
                <div class="loginpg">
                   <div class="form">
                           <div class="logo"><img src="reset.png" alt="logo" width="150" height="150" /></div>    

                               <input type="password" name="txtNewPass" id="pass1" placeholder="new password" required/>
                               <input type="password" name="txtConPass" id="pass2" onkeyup="checkPass(); return false;" placeholder="confirm password" required/>
                               <span id="confirmMessage" class="confirmMessage"></span>
                               <br/>
                               <br/>
                                   <input type="text" name="txtS1" placeholder="<%=questions[rs2.getInt("SQ1")]%>" disabled/>
                                   <input type="text"  name="txtA1" placeholder="answer 1" size="20" required>          

                                   <input type="text" name="txtS2" placeholder="<%=questions[rs2.getInt("SQ2")]%>" disabled/>
                                   <input type="text" name="txtA2" placeholder="answer 2" size="20" required>

                                   <input type="text" name="txtS3" placeholder="<%=questions[rs2.getInt("SQ3")]%>" disabled/>
                                   <input type="text" name="txtA3" placeholder="answer 3" size="20" required>

                                   <button name="btnConfirm" type="submit" onclick="return Validate()">CONFIRM</button>      
                                   
                                   
            <% 
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

                        %>
                    <%
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
                    

        }%>
            


       </form>
    </body>
</html>