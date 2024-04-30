/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class ImportDTO {

    private int id;
    private int productId;
    private int quantity;
    private String prodName;
    private String manuName;
    private double totalPrice;
    private int manufactureId;
    private String time;

    public ImportDTO() {
        // Default constructor
    }

    public ImportDTO(int productId, int quantity, double totalPrice, int manufactureId) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.manufactureId = manufactureId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(int manufactureId) {
        this.manufactureId = manufactureId;
    }

    public String getProdname() {
        return prodName;
    }

    public void setProdname(String name) {
        this.prodName = name;
    }

    public String getManuName() {
        return this.manuName;
    }

    public void setManuName(String name) {
        this.manuName = name;
    }

    public void setTime(String t) {
        this.time = t;
    }

    public String getTime() {
        return this.time;
    }

}
