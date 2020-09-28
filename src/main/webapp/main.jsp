<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Main Page</title>
    </head>
    <body>
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
            <a class="button" href="EditServlet?email='<%=email%>'&password='<%=pass%>'&permission='<%=perm%>'">Account</a>
            <a class="button" href="order.jsp">Order Management</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>

        <p style="text-align: right; color: yellow; "> 
            <i>You are logged in as ${user.name} &lt; ${user.email} &gt; &lt; ${user.permission} &gt;</i>
        </p>
        <div>
         <%--  <% if (perm.equals("staff")) { %>
           <jsp:include page="catalogue_staff.jsp" flush="true" /> 
           <% } else { %>
                <jsp:include page="catalogue_customer.jsp" flush="true" />
           <% } %> 
         --%>
            
        </div>
        
       
    </body>
</html>
