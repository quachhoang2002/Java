/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ImportDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database;

/**
 *
 * @author ADMIN
 */
public class ImportDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public boolean isValidProduct(int productId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValid = false;

        try {
            conn = Database.GetConnection();
            String sql = "SELECT COUNT(*) FROM product WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                isValid = count > 0; // Product ID is valid if count > 0 (product exists)
            }
        } catch (SQLException e) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isValid;
    }

    public boolean isValidManufacture(int manufactureId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValid = false;

        try {
            conn = Database.GetConnection();
            String sql = "SELECT COUNT(*) FROM manufacture WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, manufactureId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                isValid = count > 0; // Manufacture ID is valid if count > 0 (manufacture exists)
            }
        } catch (SQLException e) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isValid;
    }

    public boolean createImportOrder(ImportDTO importDTO) {

        boolean isSuccess = false;

        try {
            conn = Database.GetConnection();
            String sql = "INSERT INTO import (product_id, quantity, total_price, manufacture_id) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, importDTO.getProductId());
            stmt.setInt(2, importDTO.getQuantity());
            stmt.setDouble(3, importDTO.getTotalPrice());
            stmt.setInt(4, importDTO.getManufactureId());

            int affectedRows = stmt.executeUpdate();
            isSuccess = affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return isSuccess;
    }

    public List<ImportDTO> findImportsByProductName(String productName) {
        List<ImportDTO> imports = new ArrayList<>();

        try {
            conn = Database.GetConnection();
            // SQL query to retrieve imports by product name
            String sql = "SELECT i.id, i.product_id, i.quantity, i.total_price, i.manufacture_id,i.date, p.name as product_name, m.name as manufacture_name "
                    + "FROM import i "
                    + "JOIN product p ON i.product_id = p.id "
                    + "JOIN manufacture m ON i.manufacture_id = m.id "
                    + "WHERE p.name LIKE ?"
                    + "ORDER BY i.id DESC";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + productName + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ImportDTO importDTO = new ImportDTO();
                importDTO.setId(rs.getInt("id"));
                importDTO.setProductId(rs.getInt("product_id"));
                importDTO.setQuantity(rs.getInt("quantity"));
                importDTO.setTotalPrice(rs.getDouble("total_price"));
                importDTO.setManufactureId(rs.getInt("manufacture_id"));
                importDTO.setProdname(rs.getString("product_name")); // Set product name
                importDTO.setManuName(rs.getString("manufacture_name")); // Set manufacture name
                Timestamp timestamp = rs.getTimestamp("date");
                String dateStr = timestamp.toString(); // Adjust formatting as needed
                importDTO.setTime(dateStr);
                imports.add(importDTO);
            }
        } catch (SQLException e) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return imports;
    }
}
