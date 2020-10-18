<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Main Page</title>
    </head>
    <body onload="startTime()">
        <h1>Order Takeaway Online</h1>
        <%
            User user = (User) session.getAttribute("user");
            String email = user.getEmail();
            String pass = user.getPassword();
            String perm = user.getPermission();
        %>

        <h2>User Dashboard</h2>
        <hr>
        <div class="main_btn">
            <a class="button" href="edit.jsp">Edit Account</a>
            <a class="button" href="order.jsp">Order Management</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>

        <p style="text-align: right; color: yellow; "> 
            <i>You are logged in as ${user.name} &lt; ${user.email} &gt; &lt; ${user.permission} &gt;</i>
        </p>
        <div>


            <form action="ReadRestaurantServlet" method="post">
                <table>
                    <tr><td>Search Condition</td></tr>
                    <tr><td>Restaurant Name:</td><td><input type="text" placeholder="Search by Name" name="Rname"></td></tr>
                    <tr><input class="button" type="submit" value="Search"></tr>
                </table>
            </form> 

            <% if (perm.equals("customer")) { %>
            <jsp:include page="catalogue_customer.jsp" flush="true" />
            <% } else { %>
            <jsp:include page="catalogue_staff.jsp" flush="true" /> 
            <% }%> 


        </div>


    </body>
</html>
