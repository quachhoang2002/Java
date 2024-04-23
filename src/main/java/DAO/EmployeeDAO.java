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
import java.util.ArrayList;
import java.util.List;
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

    public List<EmployeeDTO> findByName(String name) {
        List<EmployeeDTO> employees = new ArrayList();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.GetConnection();
            // Prepare the SQL statement with a name filter
            stmt = conn.prepareStatement("SELECT * FROM employee WHERE first_name LIKE ?");
            // Set the name parameter in the query, adding wildcards for partial matching
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EmployeeDTO e = new EmployeeDTO();
                int id = rs.getInt("id");

                e.setID(id);
                e.setName(rs.getString("first_name"));
                e.setLastname(rs.getString("last_name"));
                e.setGender(rs.getInt("gender"));
                e.setPosition(rs.getInt("position"));
                employees.add(e);
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }
        return employees;
    }

    public boolean createEmployee(EmployeeDTO employee) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();
            // Prepare the SQL statement for inserting a new employee
            String sql = "INSERT INTO employee (first_name, last_name, gender, position) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set parameters based on the employee object passed
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastname());
            stmt.setInt(3, employee.getGender());
            stmt.setInt(4, employee.getPosition());

            // Execute the insert operation
            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isSuccess;
    }

    public boolean updateEmployee(EmployeeDTO employee) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();
            String sql = "UPDATE employee SET first_name = ?, last_name = ?, gender = ?, position = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastname());
            stmt.setInt(3, employee.getGender());
            stmt.setInt(4, employee.getPosition());
            stmt.setInt(5, employee.getID());  // Assuming there's an EmployeeId field in EmployeeDTO

            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isSuccess;
    }

    public boolean deleteEmployee(int employeeId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();  // Assumed method to get a DB connection
            String sql = "DELETE FROM employee WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, employeeId);

            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;  // Check if the row was actually deleted
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);  // Assumed method to close connections
        }

        return isSuccess;
    }

}
