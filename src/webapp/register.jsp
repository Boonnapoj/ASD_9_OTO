<%-- 
    Document   : register
    Created on : 07/04/2020, 2:48:47 PM
    Author     : peter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Register Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time" ></span></div>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
        %>
        
        <h1 class="reg_h1">Sign Up<span class="message"> <%= (existErr != null ? existErr : "")%></span></h1>
         <form class="form" action="RegisterServlet" method="post">
            <table>
                <tr><td>Email:</td><td><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email" required></td></tr>
                <tr><td>Full Name:</td><td><input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter full name")%>" name="name" required></td></tr>

                <tr><td>Password:</td><td><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password" required></td></tr>

                    <td><a class="button" href="index.jsp">Cancel</a>
                        <input class="button" type="submit" value="Sign Up">
                    </td>
                </tr>
            </table>
        </form>
    </body>
   
</html>
