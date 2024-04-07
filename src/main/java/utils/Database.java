/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class Database {

    public static final String port = "3306";
    public static final String database = "mysql";
    public static final String user = "mysql";
    public static final String password = "mysql";

    public static Connection GetConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost:" + port + "/" + database + "?user=" + user + "&password=" + password;

        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Return the connection
        return DriverManager.getConnection(connectionUrl);
    }

    public static void CloseConnection(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Cann't close connection");
        }
    }

}
