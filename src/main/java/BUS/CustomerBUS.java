/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CustomerDAO;
import DTO.CustomerDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CustomerBUS {

    CustomerDAO dao = new CustomerDAO();

    public CustomerDTO getCustomer(int id) {
        CustomerDTO c = dao.find(id);
        return c;
    }

    /**
     * Finds customers by name.
     * 
     * @param name The name to search for.
     * @return A list of matching CustomerDTO objects.
     */
    public List<CustomerDTO> findByName(String name) {
        List<CustomerDTO> customers = dao.findByName(name);
        return customers;
    }

    public boolean createCustomer(CustomerDTO customer) {
        // Validate the customer object
        if (customer == null) {
            throw new IllegalArgumentException("Customer object cannot be null");
        }
        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        if (customer.getLastname() == null || customer.getLastname().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer lastname cannot be null or empty");
        }
        if (customer.getPhone() == null || customer.getPhone().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer phone cannot be null or empty");
        }

        // Call DAO to create the customer
        boolean isSuccess = dao.createCustomer(customer);

        // Additional business logic or post-processing can be done here if needed
        return isSuccess;
    }

    public boolean updateCustomer(CustomerDTO customer) {
        // Validate the customer object
        if (customer == null) {
            throw new IllegalArgumentException("Customer object cannot be null");
        }
        if (customer.getID() <= 0) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        if (customer.getLastname() == null || customer.getLastname().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer lastname cannot be null or empty");
        }
        if (customer.getPhone() == null || customer.getPhone().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer phone cannot be null or empty");
        }

        // Call DAO to update the customer
        boolean isSuccess = dao.updateCustomer(customer);

        // Additional business logic or post-processing can be done here if needed
        return isSuccess;
    }

    public boolean deleteCustomer(int customerId) {
        // Here you could add any business validations
        if (customerId <= 0) {
            throw new IllegalArgumentException("Invalid Customer ID");
        }

        // Call the DAO to delete the customer
        boolean isDeleted = dao.deleteCustomer(customerId);

        // You can add additional post-deletion logic if needed
        return isDeleted;
    }
}
