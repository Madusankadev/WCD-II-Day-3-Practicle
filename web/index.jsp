<%-- 
    Document   : index
    Created on : Apr 3, 2025, 2:27:27 PM
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
        <h1>Login to the System</h1>
        <form action="loginServlet" method="POST">
            <label>Email: </label><br> 
            <input type="email" name="email"><br><br> 

            <label>Password</label><br> 
            <input type="password" name="password"> <br><br><br>
            
            <button type="submit">Login</button>

        </form>
    </body>
</html>
