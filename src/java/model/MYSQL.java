
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class MYSQL {
    private static Connection con;
    
    private static String dbName = "wcd_2_day2_practicle";
    private static String port = "3306";
    private static String user = "root";
    private static String pswd = "";

    public static void createConnection() throws Exception {
        if (con == null) {
            System.out.println("start");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:"+ port +"/" + dbName  , user, pswd);
            System.out.println("connection sucess");
        }
    }

    public static ResultSet execute(String querry) throws Exception {
        createConnection();
        return con.createStatement().executeQuery(querry);
    }

    public static Integer executeIUD(String querry) throws Exception {
        createConnection();
        return con.createStatement().executeUpdate(querry);

    }

    
}