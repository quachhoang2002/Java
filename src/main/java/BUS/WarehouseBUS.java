/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.WarehouseDAO;
import DTO.WarehouseDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class WarehouseBUS {
        private WarehouseDAO warehouseDAO;

    /**
     * Constructs the WarehouseBUS and initializes the WarehouseDAO.
     */
    public WarehouseBUS() {
        this.warehouseDAO = new WarehouseDAO();
    }

    /**
     * Finds stock items by product name.
     * @param productName The name of the product to search for.
     * @return A list of StockDTOs matching the product name.
     */
    public List<WarehouseDTO> findByName(String productName) {
        return warehouseDAO.findByName(productName);
    }

}
