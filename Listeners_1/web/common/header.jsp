<%-- 
    Document   : header
    Created on : May 12, 2015, 4:37:49 PM
    Author     : mets
--%>

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
        <h1>Hello <%= session.getAttribute("username") %>!</h1>