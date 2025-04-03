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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MYSQL;

/**
 *
 * @author Madusanka
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcd_2_day2_practicle?useSSL=false", "root", "");
            ResultSet res = con.createStatement().executeQuery("SELECT * FROM `user` WHERE `email` = '" + email + "' AND `password` = '" + password + "'");
            
            if (res.next()) {
                if (res.getString("name").equals("admin")) {
                    response.sendRedirect("addUser.jsp");
                } else {
                    response.sendRedirect("dashboard.jsp");
                }
            } else {
                response.getWriter().write("Invalid");
            }
            
        } catch (Exception e) {
            response.getWriter().write(e.toString());
        }

//        try {
//            ResultSet r = MYSQL.execute("SELECT * FROM `user` WHERE `email` = '" + email + "' AND `password` = '" + password + "'");
//
//            if (r.next()) {
//                response.getWriter().write("admin found");
//            } else {
//                response.getWriter().write("Not found");
//            }
//        } catch (Exception e) {
//            System.out.println("err");
//        }
    }
    
}
