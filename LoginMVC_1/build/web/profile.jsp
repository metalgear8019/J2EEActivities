<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:42 PM
    Author     : mets
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div>
            <a href="home.jsp">Home</a> |  <a href="profile.jsp">Profile</a>
        </div>
        <h1>Hello <%=session.getAttribute("username")%>!</h1>
    </body>
</html>
