<%-- 
    Document   : updateRestarant
    Created on : Sep 28, 2020, 12:14:23 PM
    Author     : diamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/demo.css">
        <title>Update Restaurant</title>
    </head>
    <body>
        <%
            String name = request.getParameter("RName");
            String address = request.getParameter("Address");
            String businessHour = request.getParameter("BusinessHour");
        %>

        <h1 class="edit_h1">Update Restaurant Information</h1>
        <div class="main_btn">
            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        <form class="form" action="UpdateRestaurantServlet" method="post" enctype="application/x-www-form-urlencoded">
            <table>
                <td><input type="hidden"  name="RName" value="<%=name%>" ></td>
                <tr><td>Restaurant Name:</td><td><%=name%></td></tr>
                <tr><td>Address:</td><td><input type="text" name="newAddress"  value="<%=address%>"  required ></td></tr>
                <tr><td>Business Hour:</td><td><input type="text" name="newBusinessHour" value="<%=businessHour%>" required></td></tr>
                <td>
                    <input class="button" type="submit" value="Update">
                </td>
                </tr>
            </table>
        </form>

    </body>
</html>
