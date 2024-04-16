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

}
