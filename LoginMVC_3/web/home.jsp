<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:42 PM
    Author     : mets
--%>

<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);

    if(session.getAttribute("username") != null)
    {
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <div>
            <a href="home.jsp">Home</a> |  <a href="profile.jsp">Profile</a> | <a href="LogoutServlet">Logout</a>
        </div>
        <h1>Hello <%=session.getAttribute("username")%>!</h1>
    </body>
</html>

<%
    }
    else
    {
        response.sendRedirect("");
    }
%>
