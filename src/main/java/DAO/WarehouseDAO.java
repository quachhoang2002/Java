/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.WarehouseDTO;
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
public class WarehouseDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<WarehouseDTO> findByName(String name) {
        List<WarehouseDTO> stocks = new ArrayList<>();

        try {
            conn = Database.GetConnection();
            String query = "SELECT w.id, w.product_id, w.quantity, p.name AS product_name FROM warehouse w "
                    + "JOIN product p ON w.product_id = p.id "
                    + "WHERE p.name LIKE ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                WarehouseDTO warehouseDTO = new WarehouseDTO(id, productId, productName, quantity);
                stocks.add(warehouseDTO);
            }

            return stocks;
        } catch (SQLException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Database.CloseConnection(conn, stmt);
        }
        return null;
    }

    public boolean createOrUpdateWarehouse(int productId, int quantity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.GetConnection();

            // Check if the product exists in the warehouse
            stmt = conn.prepareStatement("SELECT * FROM warehouse WHERE product_id = ?");
            stmt.setInt(1, productId);
            rs = stmt.executeQuery();
            System.out.println(productId);
            if (rs.next()) {
                System.out.println("aaaaa");

                // Product exists, update the quantity
                int warehouseId = rs.getInt("id");
                quantity = rs.getInt("quantity") + quantity;
                return updateWarehouseQuantity(warehouseId, quantity);
            } else {
                System.out.println("bbbbbb");

                // Product doesn't exist, create a new warehouse entry
                return createWarehouse(productId, quantity);
            }
        } catch (SQLException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            Database.CloseConnection(conn, stmt);
        }
    }

    private boolean createWarehouse(int productId, int quantity) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Database.GetConnection();
            stmt = conn.prepareStatement("INSERT INTO warehouse (product_id, quantity) VALUES (?, ?)");
            stmt.setInt(1, productId);
            stmt.setInt(2, quantity);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            Database.CloseConnection(conn, stmt);
        }
    }

    private boolean updateWarehouseQuantity(int warehouseId, int newQuantity) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Database.GetConnection();
            stmt = conn.prepareStatement("UPDATE warehouse SET quantity = ? WHERE id = ?");
            stmt.setInt(1, newQuantity);
            stmt.setInt(2, warehouseId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            Database.CloseConnection(conn, stmt);
        }
    }
}
