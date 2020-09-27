<%-- 
    Document   : mLab
    Created on : Sep 28, 2020, 2:07:01 AM
    Author     : diamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>mLab Login</title>
    </head>
    <body>
        <div>
            <form action="ConnServlet" method="post">
                <p>mLab Admin Login: </p>
                <div>
                <input placeholder ="Admin ID" name="adminemail" required="true">
                </div>
                <div>
                    <input type="password" name="adminpassword" placeholder="Password" required="true">
                </div>
                <div>
                    <input type="submit" value="Connect" class="button">
                </div>
            </form>
        </div>
    </body>
</html>
