/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class WarehouseDTO {

    private int id;
    private int productId;
    private String productName;
    private int quantity;

    // Constructor
    public WarehouseDTO(int id, int productId,String productName ,int quantity) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public String getProductName(){
        return productName;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String name){
        this.productName = name;
    }
    
    // toString method for printing
    @Override
    public String toString() {
        return "StockDTO{"
                + "id=" + id
                + ", productId=" + productId
                + ", quantity=" + quantity
                + '}';
    }
}
