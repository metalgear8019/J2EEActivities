<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:42 PM
    Author     : mets
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="common/cachecontrol.jsp" />
<%
    if(session.getAttribute("username") != null)
    {
%>
<jsp:include page="common/header.jsp" />
        Add a user below:<br>
        <form method="POST" action="UserController">
            <input type="hidden" name="userid" value="">
            Username: <input type="text" name="username" value=""><br>
            Password: <input type="password" name="password" value=""><br>
            <input type="submit" value="">
        </form>
    </body>
</html>

<%
    }
    else
    {
        response.sendRedirect("");
    }
%>
