/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.EmployeeDAO;
import DTO.EmployeeDTO;

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
}
