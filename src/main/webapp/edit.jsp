
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
        <div><span class="time" id="time" ></span></div>
            <%
                User user = (User) session.getAttribute("user");
                String update = (String)session.getAttribute("update");
            %>

        <h1 class="edit_h1">Edit User Information <span class="message"> <%= (update != null ? update : "updated")%> </span></h1>
        <div class="main_btn">
            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        <form class="form" action="EditServlet" method="post">
            <table>

                <tr><td>Email:</td><td><input type="text"  name="email" value="${user.email}" readonly="true"></td></tr>
                <tr><td>Full Name:</td><td><input type="text"  name="name" value="${user.name}"></td></tr>
                <tr><td>Password:</td><td><input type="password"  name="password" value="${user.password}"></td></tr>
          
                    <td>
<!--                        <input type="hidden" name="update" value="Update was successful" >-->
                        <input class="button" type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </form>
              



    </body>
</html>
