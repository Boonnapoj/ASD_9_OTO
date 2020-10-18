<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Account Page</title>
    </head>
    <body onload="startTime()">
        <%
            User user = (User) session.getAttribute("user");
            String nameErr = (String) session.getAttribute("nameErr");
            String passErr = (String) session.getAttribute("passErr");
            String update = (String) request.getParameter("update");
            if (update == null) 
            {
                update = "no";
            }
            if (!update.equals("yes")) { %>
        <h1 class="edit_h1">Edit User Information</h1>
        <div class="main_btn">
            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        <form class="form">
            <table>
                <tr><td>Email:</td><td>${user.getEmail()}</td></tr>
                <tr><td>Full Name:</td><td>${user.getName()}</td></tr>
                <tr><td>Password:</td><td>${user.getPassword()}</td></tr>
                <td>
                    <input type="hidden" name="update" value="yes">
                    <a class="button" href="edit.jsp" type="submit">Edit</a>
                </td>
                </tr>
            </table>
        </form>
        <% } else {%>
        <h1 class="edit_h1">Edit User Information</h1>
        <div class="main_btn">
            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        <form class="form" action="EditServlet" method="post">
            <table>
                <tr><td>Email:</td><td><input type="text"  name="email" value="${user.getEmail()}" readonly="true"></td></tr>
                <tr><td>Full Name:</td><td><input type="text" placeholder="<%=(passErr != null ? passErr : "Enter password")%>"  name="newName" required ></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="newPassword" required></td></tr>
                <td>
                    <input type="hidden" name="update" value="no">
                    <input class="button" type="submit" value="Update">
                </td>
                </tr>
            </table>
        </form>
        <% }%>
    </body>
</html>
