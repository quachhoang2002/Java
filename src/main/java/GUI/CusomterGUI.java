/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.EmployeeBus;
import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class CusomterGUI extends javax.swing.JPanel {

    private DefaultTableModel tableModel;

    /**
     * Creates new form ListEmployeePanel
     */
    public CusomterGUI() {
        initComponents();
        initUI();
        setupTableSelectionListener();
    }

    private void initUI() {
//        setLayout(new BorderLayout());

        // Initialize table model
        if (customer_table == null) {
            // Initialize table model
            tableModel = new DefaultTableModel(new Object[]{"ID", "Last Name", "First Name", "Phone"}, 0);
            customer_table = new JTable(tableModel);
        } else {
            // Update the existing table model
            tableModel = (DefaultTableModel) customer_table.getModel();
        }

        loadData("");
    }

    // Method to update the table model
    public void updateTable(List<CustomerDTO> customers) {
        tableModel.setRowCount(0); // Clear existing data

        // Populate the table model
        for (CustomerDTO customer : customers) {
            Object[] row = new Object[]{
                customer.getID(),
                customer.getName(),
                customer.getLastname(),
                customer.getPhone()
            };
            tableModel.addRow(row);
        }
    }

    private void loadData(String name) {
        CustomerDAO dao = new CustomerDAO();
        List<CustomerDTO> customers = dao.findByName(name);
        updateTable(customers);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lastname = new javax.swing.JTextField();
        lastname_lb = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname_lab = new javax.swing.JLabel();
        firstname_lb = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        search_txt = new javax.swing.JTextField();
        searchlb = new javax.swing.JLabel();
        search_btn = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        phone_txt = new javax.swing.JTextField();
        phone_lb = new javax.swing.JLabel();

        customer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma", "Ten", "Ho", "SDT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(customer_table);

        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });

        lastname_lb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastname_lb.setText("Quan Ly Khach Hang");

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });

        lastname_lab.setText("Ho");

        firstname_lb.setText("Ten");

        create.setText("Tao ");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        update.setText("Cap Nhat");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete_btn.setText("Xoa");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        searchlb.setText("Search");

        search_btn.setText("Tim Kiem");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        phone_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_txtActionPerformed(evt);
            }
        });

        phone_lb.setText("SDT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lastname_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(firstname_lb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 121, Short.MAX_VALUE)
                        .addComponent(searchlb)
                        .addGap(8, 8, 8)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(delete_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refresh))
                    .addComponent(search_btn))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(lastname_lb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(create)
                    .addComponent(phone_lb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lastname_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname_lab)
                    .addComponent(firstname_lb)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone_lb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(delete_btn)
                    .addComponent(refresh)
                    .addComponent(create))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchlb)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
        String name = firstname.getText().trim();
        String lastName = lastname.getText().trim();
        String phone = phone_txt.getText().trim();

        CustomerDTO customer = new CustomerDTO();
        customer.setName(name);
        customer.setLastname(lastName);
        customer.setPhone(phone);

        CustomerDAO dao = new CustomerDAO();
        if (dao.createCustomer(customer)) {
            JOptionPane.showMessageDialog(null, "Customer created successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to create customer.");
        }

        initUI(); // Refresh the UI
    }//GEN-LAST:event_createActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String name = firstname.getText().trim();
        String lastName = lastname.getText().trim();
        String phone = phone_txt.getText().trim();
        int selectedRow = customer_table.getSelectedRow();
        if (selectedRow != -1) {
            int customerId = (Integer) customer_table.getModel().getValueAt(selectedRow, 0);

            CustomerDTO customer = new CustomerDTO();
            customer.setID(customerId);
            customer.setName(name);
            customer.setLastname(lastName);
            customer.setPhone(phone);

            CustomerDAO dao = new CustomerDAO();
            if (dao.updateCustomer(customer)) {
                JOptionPane.showMessageDialog(null, "Customer updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update customer.");
            }

            initUI(); // Refresh the UI
        } else {
            JOptionPane.showMessageDialog(null, "Please select a customer to update.");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        int selectedRow = customer_table.getSelectedRow();
        if (selectedRow != -1) {
            int customerId = (Integer) customer_table.getModel().getValueAt(selectedRow, 0);

            CustomerDAO dao = new CustomerDAO();
            if (dao.deleteCustomer(customerId)) {
                JOptionPane.showMessageDialog(null, "Customer deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete customer.");
            }

            initUI(); // Refresh the UI
        } else {
            JOptionPane.showMessageDialog(null, "Please select a customer to delete.");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // TODO add your handling code here:
        String name = search_txt.getText().trim();
        loadData(name);
    }//GEN-LAST:event_search_btnActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        firstname.setText("");
        lastname.setText("");
        phone_txt.setText("");
    }//GEN-LAST:event_refreshActionPerformed

    private void phone_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_txtActionPerformed

    private void setupTableSelectionListener() {
        customer_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) { // Prevent double events
                    displaySelectedEmployeeData();
                }
            }
        });
    }

    private void displaySelectedEmployeeData() {
        int selectedRow = customer_table.getSelectedRow();
        if (selectedRow != -1) {
            int customerId = (Integer) customer_table.getModel().getValueAt(selectedRow, 0);
            String name = (String) customer_table.getModel().getValueAt(selectedRow, 1);
            String lastName = (String) customer_table.getModel().getValueAt(selectedRow, 2);
            String phone = (String) customer_table.getModel().getValueAt(selectedRow, 3);

            firstname.setText(name);
            lastname.setText(lastName);
            phone_txt.setText(phone);
        } else {
            firstname.setText("");
            lastname.setText("");
            phone_txt.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JTable customer_table;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel firstname_lb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lastname_lab;
    private javax.swing.JLabel lastname_lb;
    private javax.swing.JLabel phone_lb;
    private javax.swing.JTextField phone_txt;
    private javax.swing.JButton refresh;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_txt;
    private javax.swing.JLabel searchlb;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
