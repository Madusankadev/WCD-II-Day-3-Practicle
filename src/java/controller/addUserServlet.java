/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Madusanka
 */
@WebServlet(name = "addUserServlet", urlPatterns = {"/addUserServlet"})
public class addUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcd_2_day2_practicle?useSSL=false", "root", "");
            con.createStatement().executeUpdate("INSERT INTO `user` (`name`, `email`, `password`, `registerdAt`) VALUES ('"+ name +"','"+ email +"', '"+ password +"', '"+ sdf.format(c.getTime()) +"')");
                        
            response.setContentType("text/html");
            response.getWriter().write("<a href='addUser.jsp'>Add more Users</a>");
        } catch (Exception e) {
            response.getWriter().write(e.toString());
        }
    }

   
}
