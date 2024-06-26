/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 */
public class CustomerDTO {
    private int id;
    private String lastname;
    private String name; // Assuming this is the actual name, not gender. You might want a separate field for gender.
    private String phone;
    
    public int getID() {
        return id;
    }

    // Setter for identify
    public void setID(int id) {
        this.id = id;
    }
    
    // Getter for identify
    // Getter for lastname
    public String getLastname() {
        return lastname;
    }

    // Setter for lastname
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for position
    public String getPhone() {
        return phone;
    }

    // Setter for position
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

