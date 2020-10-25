<%-- 
    Document   : updateRestarant
    Created on : Sep 28, 2020, 12:14:23 PM
    Author     : diamo
--%>

<%@page import="uts.asd.model.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Restaurant</title>
         <link rel="stylesheet" href="css/demo.css">
    </head>
    <body>
        <%
            String name = (String) request.getParameter("RName");
            String address = (String) request.getParameter("address");
            String bussinessHour = (String) request.getParameter("bussinessHour");
            String update = (String) request.getParameter("Rupdate");
            if (update == null) 
            {
                update = "yes";
            }
            if (!update.equals("yes")) { %>
        <h1 class="edit_h1">Edit Restaurant Information</h1>
        <div class="main_btn">
            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        <form class="form">
            <table>
                <tr><td>Restaurant Name:</td><td><%=name%></td></tr>
                <tr><td>Address:</td><td><%=address%></td></tr>
                <tr><td>Business Hour:</td><td><%=businessHour%></td></tr>
                <td>
                    <input type="hidden" name="Rupdate" value="yes">
                    <a class="button" href="updateRestaurnat.jsp" type="submit">Update</a>
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
        <form class="form" action="UpdateRestaurantServlet" method="post">
            <table>
                <tr><td>Restaurant Name:</td><td><input type="text"  name="RName" value="<%=name%>" readonly="true"></td></tr>
                <tr><td>Address:</td><td><input type="text" value="<%=address%>" name="newRAddress"  required ></td></tr>
                <tr><td>Business Hour:</td><td><input type="text" value="<%=businessHour%>" name="newRBusinessHour" required></td></tr>
                <td>
                    <input type="hidden" name="Rupdate" value="no">
                    <input class="button" type="submit" value="Update">
                </td>
                </tr>
            </table>
        </form>
        <% }%>
    </body>
</html>
