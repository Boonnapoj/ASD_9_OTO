<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Home Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <div class="home_page">

            <div class="home_content">
                <h1 class="index_h1">Home Page</h1>
                <a class="button" href="register.jsp">Register</a>
                <a class="button" href="login.jsp">Login</a>
                <a class="button" href="mLab.jsp">mLab</a>

%>
            </div>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
