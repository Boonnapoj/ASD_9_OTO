<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Profile Page</title>
    </head>
    <body>
        <h1 class="pro_h1">User Profile</h1>
        <%
            User user = (User) session.getAttribute("user");
         %>
         <table id="profile_table">
            <thead>
                <th>Email</th>
                <th>Full Name</th>
                <th>Password</th>
            </thead>
            <tbody>
            <tr>
                <td>${user.email}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
            </tr>
            </tbody>
        </table>
    </body>
</html>
