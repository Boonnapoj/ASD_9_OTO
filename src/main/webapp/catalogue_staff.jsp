<%-- 
    Document   : Catalogue
    Created on : Sep 21, 2020, 1:22:19 PM
    Author     : diamo
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue/<title>
                <link rel="stylesheet" href="css/demo.css">
                <title>device management Page</title>
                </head>
                <body>
                    <h1>Catalogue</h1>
                    <%
                        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) session.getAttribute("restaurants");
                    %>
                    <table>
                        <thead>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Business Hour</th>
                        <th>Check food</th>
                        </thead>
                        <tbody>
                            <% for (Restaurant restaurant : restaurants) {%>
                            <tr>
                                <td><%=restaurant.getName()%></td>
                                <td><%=restaurant.getAddress()%></td>
                                <td><%=restaurant.getBusinessHour()%></td>
                                <td> 
                                    <a href="updateRestaurant.jsp?name=<%=restaurant.getName()%>
                                       &address=<%=restaurant.getAddress()%>&businessHour=<%=restaurant.getBusinessHour()%>">Update</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="DeleteRestaurantServlet?id=<%=restaurant.getName()%>">Delete</a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                    <div>
                        <a class="button" href="createRestaurant.jsp">Register Restaurant</a>
                    </div>
                </body>
                </html>
