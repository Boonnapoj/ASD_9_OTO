<%-- 
    Document   : createRestaurant
    Created on : Sep 28, 2020, 12:20:11 PM
    Author     : diamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/demo.css">
        <title>Create Restaurant</title>
    </head>
    <body>
        <h1 class="reg_h1">Register Restaurant</h1>
         <form class="form" action="CreateRestaurantServlet" method="post">
            <table>
                <tr><td>Restaurant Name:</td><td><input type="text" placeholder="Enter Restaurant Name" name="Rname" required></td></tr>
                <tr><td>Restaurant Address:</td><td><input type="text" placeholder="Enter Restaurant Address" name="Raddress" required></td></tr>
                <tr><td>Restaurant Business Hour:</td><td><input type="text" placeholder="Enter Business Hour" name="RbusinessHour" required></td></tr>

                    <td><a class="button" href="index.jsp">Cancel</a>
                        <input class="button" type="submit" value="Sign Up">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
