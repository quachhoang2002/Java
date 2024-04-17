/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.EmployeeDAO;
import DTO.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import utils.Database;

/**
 *
 * @author ADMIN
 */
public class EmployeeBus {

    EmployeeDAO dao = new EmployeeDAO();

    public EmployeeDTO getEmployee(String id) {
        EmployeeDTO e = dao.find(id);
        return e;
    }

    /**
     *
     * @param name
     * @return
     */
    public List<EmployeeDTO> findByName(String name) {
        List<EmployeeDTO> employees = dao.findByName(name);
        return employees;
    }

    public boolean createEmployee(EmployeeDTO employee) {
        // Validate the employee object
        if (employee == null) {
            throw new IllegalArgumentException("Employee object cannot be null");
        }
        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        if (employee.getLastname() == null || employee.getLastname().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee lastname cannot be null or empty");
        }
        // Additional validations can be added here (e.g., valid gender, position)

        // Call DAO to create the employee
        boolean isSuccess = dao.createEmployee(employee);

        // Additional business logic or post-processing can be done here if needed
        return isSuccess;
    }

}
