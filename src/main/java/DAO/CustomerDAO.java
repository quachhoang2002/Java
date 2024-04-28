/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CustomerDTO;
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
public class CustomerDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public CustomerDTO find(int id) {
        try {
            Connection conn = Database.GetConnection();
            stmt = conn.prepareStatement("SELECT * FROM customer WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                CustomerDTO c = new CustomerDTO();
                c.setID(rs.getInt("id"));
                c.setName(rs.getString("first_name"));
                c.setLastname(rs.getString("last_name"));
                c.setPhone(rs.getString("phone"));
                return c;
            }

        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }
        return null;
    }

    public List<CustomerDTO> findByName(String name) {
        List<CustomerDTO> customers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.GetConnection();
            stmt = conn.prepareStatement("SELECT * FROM customer WHERE first_name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                CustomerDTO c = new CustomerDTO();
                c.setID(rs.getInt("id"));
                c.setName(rs.getString("first_name"));
                c.setLastname(rs.getString("last_name"));
                c.setPhone(rs.getString("phone"));
                customers.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }
        return customers;
    }

    public boolean createCustomer(CustomerDTO customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();
            String sql = "INSERT INTO customer (first_name, last_name, phone) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getLastname());
            stmt.setString(3, customer.getPhone());

            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isSuccess;
    }

    public boolean updateCustomer(CustomerDTO customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();
            String sql = "UPDATE customer SET first_name = ?, last_name = ?, phone = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getLastname());
            stmt.setString(3, customer.getPhone());
            stmt.setInt(4, customer.getID());

            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isSuccess;
    }

    public boolean deleteCustomer(int customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();
            String sql = "DELETE FROM customer WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, customerId);

            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isSuccess;
    }
}
