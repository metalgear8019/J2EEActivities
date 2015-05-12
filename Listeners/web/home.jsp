<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:42 PM
    Author     : mets
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>Hello <%= session.getAttribute("username") %>!</h1>
        <div>
            <a href="user.jsp?action=add">Add User</a>
        </div>
        <table>
            <thead>
                <th>Username</th>
                <th>Password</th>
                <th colspan="2">Action</th>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><a href="UserController?action=edit&userid=<c:out value="${user.userid}"/>">Edit</a></td>
                        <td><a href="UserController?action=delete&userid=<c:out value="${user.userid}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>Number of tries: <%= session.getAttribute("counter") %></p>
    </body>
</html>

<%
    }
    else
    {
        response.sendRedirect("");
    }
%>
