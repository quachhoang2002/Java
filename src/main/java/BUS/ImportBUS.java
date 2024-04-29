/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ImportDAO;
import DAO.WarehouseDAO;
import DTO.ImportDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ImportBUS {

    private ImportDAO importDAO;
    private WarehouseDAO warehouseDAO;

    public ImportBUS() {
        this.importDAO = new ImportDAO();
        this.warehouseDAO = new WarehouseDAO();
    }

    // Method to create a new import order
    public boolean createImportOrder(ImportDTO importDTO) {
        if (!importDAO.isValidProduct(importDTO.getProductId())) {
            throw new IllegalArgumentException("Invalid product id ");
        }

        // Check if manufacture ID is valid
        if (!importDAO.isValidManufacture(importDTO.getManufactureId())) {
            throw new IllegalArgumentException("Invalid manufacture id ");
        }

        if (importDTO.getQuantity() < 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        if (importDTO.getTotalPrice() < 0) {
            throw new IllegalArgumentException("Invalid total price");
        }
        boolean importSuccess = importDAO.createImportOrder(importDTO);

        // If the import order was successful, update the warehouse quantity
        if (importSuccess) {
            int productId = importDTO.getProductId();
            int importedQuantity = importDTO.getQuantity();
            boolean updateSuccess = warehouseDAO.createOrUpdateWarehouse(productId, importedQuantity);
            if (!updateSuccess) {
                // If warehouse update fails, you might want to handle this case appropriately
                // For example, you could log an error or throw an exception
                // Here, I'm just printing a message to the console
                System.out.println("Failed to update warehouse quantity after import.");
            }
        }

        return importSuccess;
    }

// Method to find import orders by product name
    public List<ImportDTO> findImportsByProductName(String productName) {
        return importDAO.findImportsByProductName(productName);
    }
}
