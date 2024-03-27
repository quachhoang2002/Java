/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class Database {

    public static Connection ConnectDB() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost:3306/myDatabase?user=myUsername&password=myPassword";

        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Return the connection
        return DriverManager.getConnection(connectionUrl);
    }
}
