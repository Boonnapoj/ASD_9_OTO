<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Account Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String nameErr = (String) session.getAttribute("nameErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
        <h1 class="edit_h1">Edit User Information</h1>
        <div class="main_btn">
            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        <form class="form" action="EditServlet" method="post">
            <table>
                <tr><td>Email:</td><td><input type="text"  name="email" value="${user.getEmail()}" readonly="true"></td></tr>
                <tr><td>Full Name:</td><td><input type="text" placeholder="<%= user.getName()%>" name="newName" ></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="<%= user.getPassword()%>" name="newPassword" ></td></tr>
                <td>
                    <!--  <input type="hidden" name="update" value="Update was successful" >-->
                    <input class="button" type="submit" value="Update">
                </td>
                </tr>
            </table>
        </form>
    </body>
</html>
