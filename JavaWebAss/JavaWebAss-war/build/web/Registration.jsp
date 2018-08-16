<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@include file="function.jspf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" type="text/css" href="ExCss.css">
    </head>
    <%!//        public String AutoNo(){
//            int random = (int)(Math.random() * 999 + 1);
//            StringBuilder sb =new StringBuilder();
//            sb.append("C0");
//            sb.append(String.valueOf(random));
//            return sb.toString();
//        }     
%>
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
                var pass1 = document.getElementById('pass1');
                var pass2 = document.getElementById('pass2');
                var message = document.getElementById('confirmMessage');
                var goodColor = "#66cc66";
                var badColor = "#ff6666";
                if (pass1.value === pass2.value) {
                    pass2.style.backgroundColor = goodColor;
                    message.style.color = goodColor;
                    message.innerHTML = "Passwords Match!";
                } else {
                    pass2.style.backgroundColor = badColor;
                    message.style.color = badColor;
                    message.innerHTML = "Passwords Do Not Match!";
                }
            }
        </script>
        <%            if (request.getParameter("btnSubmit") != null) {
                String user = request.getParameter("txtUser");
                String pass = request.getParameter("txtPass");
                String conPass = request.getParameter("txtConPass");
                String fname = request.getParameter("txtFname");
                String lname = request.getParameter("txtLname");
                String email = request.getParameter("txtEmail");
                String gender = request.getParameter("ddlGender");
                String telephone = request.getParameter("txtTelephone");
                String street = request.getParameter("txtStreet");
                String postcode = request.getParameter("txtPostcode");
                String city = request.getParameter("txtCity");
                String state = request.getParameter("txtState");
                String country = request.getParameter("txtCountry");
                int Q1 = Integer.parseInt(request.getParameter("ddlsq1"));
                String A1 = request.getParameter("txtSq1");
                int Q2 = Integer.parseInt(request.getParameter("ddlsq2"));
                String A2 = request.getParameter("txtSq2");
                int Q3 = Integer.parseInt(request.getParameter("ddlsq3"));
                String A3 = request.getParameter("txtSq3");

                Connection conn = DriverManager.getConnection(dbLoc, dbUser, dbPwd);
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO LOGIN VALUES (?,?,(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='" + fname + "'AND LASTNAME='" + lname + "' ))",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                PreparedStatement stmt2 = conn.prepareStatement(
                        "INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, EMAIL, GENDER, PHONENUMBER, ADDRESS, POSTCODE, CITY, STATE, COUNTRY) VALUES (?,?,?,?,?,?,?,?,?,?)",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                PreparedStatement stmt3 = conn.prepareStatement(
                        "INSERT INTO SECURITY (CUSTOMERID, SQ1, SQ2, SQ3, SA1, SA2, SA3) VALUES ((SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='" + fname + "'AND LASTNAME='" + lname + "' ),?,?,?,?,?,?)",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                stmt.setString(1, user);
                stmt.setString(2, sha1(pass));

                stmt2.setString(1, fname);
                stmt2.setString(2, lname);
                stmt2.setString(3, email);
                stmt2.setString(4, gender);
                stmt2.setString(5, telephone);
                stmt2.setString(6, street);
                stmt2.setString(7, postcode);
                stmt2.setString(8, city);
                stmt2.setString(9, state);
                stmt2.setString(10, country);

                stmt3.setInt(1, Q1);
                stmt3.setInt(2, Q2);
                stmt3.setInt(3, Q3);
                stmt3.setString(4, A1);
                stmt3.setString(5, A2);
                stmt3.setString(6, A3);

                stmt2.executeUpdate();   //customer             
                stmt.executeUpdate();   //login
                stmt3.executeUpdate(); //sq1

                response.sendRedirect("Login.jsp");

        %>

        <!--                <%//                else { %>
                            <div class="loginpg">
                                   <div class="form">
                                      <form method="post" class="login-form">
                                        <div class="logo"><img src="Logo.png" alt="logo" width="150" height="150" /></div>
                                        <input type="text" name="txtUser" placeholder="username" required/>
                                        <input type="password" name="txtPass" placeholder="password" required/>
                                        <input type="password" name="txtConPass" placeholder="confirm password" required/>
                                        <input type="text" name="txtFname" placeholder="first name" required/>
                                        <input type="text" name="txtLname" placeholder="last name" required/>
                                        <input type="text" name="txtEmail" placeholder="email" required/>
                                        <select name="ddlGender" required >
                                            <option value="">I am...</option>
                                            <option value="Female">Female</option>
                                            <option value="Male">Male</option>
                                            <option value="Other">Other</option>
                                            <option value="Decline">Rather not say</option>
                                         </select>
                                        <input type="tel" name="txtTelephone" placeholder="telephone" maxlength="11" required/>
                                        <input type="text" name="txtStreet" placeholder="address" required/>
                                        <input type="text" name="txtPostcode" placeholder="postcode" maxlength="5" required/>
                                        <input type="text" name="txtCity" placeholder="city" required/>
                                        <input type="text" name="txtState" placeholder="state" required/>
                                        <input type="text" name="txtCountry" placeholder="country" required/>
                                        <select name="ddlSq1" size="1" required>
                                            <option value="">Select Security Question 1</option>
                                            <option value="1">What was your childhood nickname?</option>
                                            <option value="2">In what city or town did your mother and father meet?</option>
                                            <option value="3">What is your favorite team?</option>
                                            <option value="4">What was your favorite sport in high school?</option>
                                            <option value="5">What is the first name of the boy or girl that you first kissed?</option>
                                        </select>
                                        <input type="text" name="txtSq1" placeholder="answer 1" size="20" required/>
                                        <select name="ddlSq2" size="1" required>
                                            <option value="">Select Security Question 2</option>
                                               <option value="6">What is the name of your favorite childhood friend?</option>
                                               <option value="7">What is the middle name of your oldest child?</option>
                                               <option value="8">What is your favorite movie?</option>
                                               <option value="9">In what town was your first job?</option>
                                               <option value="10">What was the last name of your third grade teacher?</option>
                                           </select>
                                        <input type="text" name="txtSq2" placeholder="answer 2" size="20" required/>
                                        <select name="ddlSq3" size="1" required>
                                            <option value="">Select Security Question 3</option>
                                            <option value="11">What was your favorite food as a child?</option>
                                            <option value="12">What was the make and model of your first car?</option>
                                            <option value="13">Who is your childhood sports hero?</option>
                                            <option value="14">What school did you attend for sixth grade?</option>
                                            <option value="15">What was the name of the company where you had your first job?</option>
                                        </select>
                                        <input type="text" name="txtSq3" placeholder="answer 3" size="20" required/>                                             
                                        <p>By creating an account, you agree to our <a href="#">Terms & Privacy</a>.</p>                               
                                        <button name="btnSubmit" type="submit">Sign Up</button>
                                        <button name="btnReset" type="reset">Reset</button>
                                        <p class="message">Forgot your password? <a href="#">Reset password</a></p>
                                        <p class="messageerror">Invalid password</p>
                                      </form>
                                    </div>
                              </div>-->
        <%
            stmt.close();
            stmt2.close();
            stmt3.close();
            conn.close();
        } else {// user first landed on page            
        %>
        <div class="loginpg">
            <div class="form">
                <form method="post" class="login-form">
                    <div class="logo"><img src="createacc.png" alt="logo" width="150" height="150" /></div>
                    <p class="title">Create your new account</p>
                    <br/>
                    <input type="text" name="txtUser" placeholder="username" required/>
                    <input type="password" id="pass1" name="txtPass" placeholder="password" required/>
                    <input type="password" id="pass2" name="txtConPass" onkeyup="checkPass(); return false;" placeholder="confirm password" required/>
                    <span id="confirmMessage" class="confirmMessage"></span>
                    <br/>
                    <br/>
                    <input type="text" name="txtFname" placeholder="first name" required/>
                    <input type="text" name="txtLname" placeholder="last name" required/>
                    <input type="text" name="txtEmail" placeholder="email" required/>
                    <select name="ddlGender" required >
                        <option value="">I am...</option>
                        <option value="FEMALE">Female</option>
                        <option value="MALE">Male</option>
                        <option value="OTHER">Other</option>
                        <option value="DECLINE">Rather not say</option>
                    </select>
                    <input type="tel" name="txtTelephone" placeholder="telephone" maxlength="11" required/>
                    <input type="text" name="txtStreet" placeholder="address" required/>
                    <input type="text" name="txtPostcode" placeholder="postcode" maxlength="5" required/>
                    <input type="text" name="txtCity" placeholder="city" required/>
                    <input type="text" name="txtState" placeholder="state" required/>
                    <input type="text" name="txtCountry" placeholder="country" required/>
                    <br/>
                    <br/>
                    <br/>
                    <select name="ddlsq1" size="1" required>
                        <option value="">Select Security Question 1</option>
                        <option value="1">What was your childhood nickname?</option>
                        <option value="2">In what city or town did your mother and father meet?</option>
                        <option value="3">What is your favorite team?</option>
                        <option value="4">What was your favorite sport in high school?</option>
                        <option value="5">What is the first name of the boy or girl that you first kissed?</option>
                    </select>
                    <input type="text" name="txtSq1" placeholder="answer 1" size="20" required/>
                    <select name="ddlsq2" size="1" required>
                        <option value="">Select Security Question 2</option>
                        <option value="6">What is the name of your favorite childhood friend?</option>
                        <option value="7">What is the middle name of your oldest child?</option>
                        <option value="8">What is your favorite movie?</option>
                        <option value="9">In what town was your first job?</option>
                        <option value="10">What was the last name of your third grade teacher?</option>
                    </select>
                    <input type="text" name="txtSq2" placeholder="answer 2" size="20" required/>
                    <select name="ddlsq3" size="1" required>
                        <option value="">Select Security Question 3</option>
                        <option value="11">What was your favorite food as a child?</option>
                        <option value="12">What was the make and model of your first car?</option>
                        <option value="13">Who is your childhood sports hero?</option>
                        <option value="14">What school did you attend for sixth grade?</option>
                        <option value="15">What was the name of the company where you had your first job?</option>
                    </select>
                    <input type="text" name="txtSq3" placeholder="answer 3" size="20" required/>                                           
                    <p class="message">By creating an account, you agree to our <a href="#">Terms & Privacy</a>.</p>    
                    &nbsp;
                    <button name="btnSubmit" type="submit" onclick="return Validate();">SIGN UP</button>
                    <button name="btnReset" type="reset">RESET</button>
                </form>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>