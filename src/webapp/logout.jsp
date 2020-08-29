<%-- 
    Document   : logout
    Created on : 28/04/2020, 3:52:46 PM
    Author     : peter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Logout Page</title>
    </head>
    <body>
        <p class="logout">You have logged out Click <a href="index.jsp">Here</a> to go th the home page.</p>
        <% session.invalidate(); %>
    </body>
</html>
