/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database;

/**
 *
 * @author ADMIN
 */
public class EmployeeDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public EmployeeDTO find(String id) {

        try {
            Connection conn = Database.GetConnection();
            stmt = conn.prepareStatement("SELECT * FROM employee WHERE id = ?");
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                EmployeeDTO e = new EmployeeDTO();
                e.setName(rs.getString("name"));
                System.out.println(e.getName());
                return e;
            }

        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }
        return null;
    }
}
