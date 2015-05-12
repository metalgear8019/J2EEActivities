<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:42 PM
    Author     : mets
--%>
<%@page import="com.example.listener.AppEventsListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="common/cachecontrol.jsp" />
<%
    if(session.getAttribute("username") != null)
    {
%>
<jsp:include page="common/header.jsp" />
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
        <p>Number of active users: <%= AppEventsListener.activeUsers %></p>
    </body>
</html>

<%
    }
    else
    {
        response.sendRedirect("");
    }
%>
