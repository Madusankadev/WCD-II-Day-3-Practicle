<%-- 
    Document   : addUser
    Created on : Apr 3, 2025, 3:57:44 PM
    Author     : Madusanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add User to the System</h1>
        <form method="POST" action="addUserServlet">
            Name: <input type="text" name="name"><br><Br>
            Email <input type="email" name="email"><br><Br>
            Password <input type="password" name="password"><br><Br>
            <button type="submit">Add User</button>
        </form>
        <a href="viewUsers.jsp">View Users</a>
    </body>
</html>
