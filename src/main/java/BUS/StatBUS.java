/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.StatDAO;
import DTO.StatDTO;
import DTO.StatMonthSaleDTO;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class StatBUS {

    private StatDAO statDAO;

    public StatBUS() {
        this.statDAO = new StatDAO();
    }

    public StatDTO getStats() {
        try {
            // Call the DAO method to retrieve statistics
            return statDAO.getStats();
        } catch (SQLException e) {
            // Handle any SQL exceptions here
            e.printStackTrace();
            return null; // or throw an exception as per your application's error handling strategy
        }
    }

    public StatMonthSaleDTO getSalesByMonthAndYear() {
        try {
            return statDAO.getSalesByMonthAndYear();
        } catch (SQLException e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            e.printStackTrace();
            return null; // Or throw a custom exception
        }
    }
}
