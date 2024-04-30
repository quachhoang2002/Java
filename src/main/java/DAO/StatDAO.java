/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.MonthYearSale;
import DTO.StatDTO;
import DTO.StatMonthSaleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database;

/**
 *
 * @author ADMIN
 */
public class StatDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public StatDTO getStats() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        StatDTO statDTO = new StatDTO();

        try {
            conn = Database.GetConnection();
            String sql = "SELECT "
                    + "(SELECT COUNT(*) FROM product) AS total_products, "
                    + "(SELECT SUM(total_price) FROM `order`) AS total_sales, "
                    + "(SELECT COUNT(*) FROM customer) AS total_customers, "
                    + "(SELECT COUNT(*) FROM employee) AS total_employees";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Set the statistics in StatDTO object
            if (rs.next()) {
                statDTO.setTotalProducts(rs.getInt("total_products"));
                statDTO.setTotalSales(rs.getDouble("total_sales"));
                statDTO.setTotalCustomers(rs.getInt("total_customers"));
                statDTO.setTotalEmployees(rs.getInt("total_employees"));
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions here
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return statDTO;
    }

    public StatMonthSaleDTO getSalesByMonthAndYear() throws SQLException {
        List<MonthYearSale> monthYearSales = new ArrayList<>();

        // Execute query to retrieve sales data for each month and year
        String sql = "SELECT YEAR(created_at) AS year, MONTH(created_at) AS month, SUM(total_price) AS total_sales "
                + "FROM `order` "
                + "GROUP BY YEAR(created_at), MONTH(created_at)";
        try {
            Connection conn = Database.GetConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Process the result set to populate monthYearSales list
            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                double totalSales = rs.getDouble("total_sales");
                monthYearSales.add(new MonthYearSale(year, month, totalSales));
            }
        } catch (SQLException e) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.CloseConnection(conn, stmt);
        }

        return new StatMonthSaleDTO(monthYearSales);
    }
}
