<%-- 
    Document   : viewUsers
    Created on : Apr 3, 2025, 5:00:35 PM
    Author     : Madusanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:setDataSource 
            driver="com.mysql.cj.jdbc.Driver" 
            url="jdbc:mysql://localhost:3306/wcd_2_day2_practicle?useSSL=false" 
            user="root" password="" 
            var="db" 
            scope="request"
            />

        <s:query dataSource="${requestScope.db}" sql="SELECT * FROM `user`" var="res" 
                 scope="request"/>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Registered</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="u" items="${requestScope.res.rows}">

                    <tr>
                        <td>${u.id}</td>
                        <td>${u.name}</td>
                        <td>${u.email}</td>                       
                       
                        <td>${request.d}</td>
                      
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <style>
            table, tr, td, th {
                border: 1px solid gray;
                border-style: solid;
                border-collapse: collapse;
                text-align: center;
                font-family: sans-serif;
                font-size: 14px;
            }
            
            th {
                padding: 20px;
                    font-weight: 600;
                    color: #282828;
                    background: hypot;
            }

            td {
                width: 400px;
                padding: 15px ;
            }
        </style>
    </body>
</html>
