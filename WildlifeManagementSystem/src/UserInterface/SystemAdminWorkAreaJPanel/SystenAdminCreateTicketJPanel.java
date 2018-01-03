/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkAreaJPanel;

import Business.ConfigureASystem;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Continent.Continent;
import Business.Country.Country;
import Business.Database.Connect;
import Business.Organization.Organization;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TicketWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Rohit
 */
public class SystenAdminCreateTicketJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private ArrayList<Continent> continentList;
    private ArrayList<Enterprise> enterpriseList;
    private ArrayList<Organization> organizationList;
    private Continent continent;
    private Country country;
    private State state;
    private Enterprise enterprise;
    private Organization organization;
    private Connect conn;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public SystenAdminCreateTicketJPanel(JPanel userProcessContainer, EcoSystem system, ArrayList<Continent> continentList, ArrayList<Enterprise> enterpriseList, ArrayList<Organization> organizationList, Continent continent, Country country, State state, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.continentList = continentList;
        this.organizationList = organizationList;
        populateContinentComboBox();
        conn = new Connect();
        issueTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        populateIssueTable();
    }

    public void populateIssueTable() {
        DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
        model.setRowCount(0);
        ResultSet rs = conn.getData();
        if (rs != null) {
            try {
                while (rs.next()) {
                    int id = rs.getInt("IssueID");
                    String issueDescription = rs.getString("IssueDescription");
                    String issueSubject = rs.getString("IssueSubject");
                    String issuePriority = rs.getString("IssuePriority");
                    Object[] row = new Object[4];
                    row[0] = id;
                    row[1] = issueSubject;
                    row[2] = issueDescription;
                    row[3] = issuePriority;
                    model.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void populateContinentComboBox() {
        continentDrop.removeAllItems();
        for (Continent network : system.getContinentList()) {
            continentDrop.addItem(network);
        }
    }

    private void populateCountryComboBox(Continent continent) {
        countryDrop.removeAllItems();
        for (Country country : continent.getCountryDirectory().getCountryList()) {
            countryDrop.addItem(country);
        }
    }

    public void populateOrganizationEmpComboBox(Enterprise e) {
        organizationEmpJComboBox.removeAllItems();
        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
            organizationEmpJComboBox.addItem(organization);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        continentDrop = new javax.swing.JComboBox();
        countryDrop = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        enterpriseDrop = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagetxt = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        prioritytxt = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        subjecttxt = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();
        submit1 = new javax.swing.JButton();

        backJButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Continent");

        continentDrop.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        continentDrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        continentDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continentDropActionPerformed(evt);
            }
        });

        countryDrop.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        countryDrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        countryDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryDropActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setText("Country");

        enterpriseDrop.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        enterpriseDrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseDropActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setText("Enterprise");

        organizationEmpJComboBox.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setText("Organization");

        messagetxt.setColumns(20);
        messagetxt.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        messagetxt.setRows(5);
        jScrollPane1.setViewportView(messagetxt);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("Subject");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("Message");

        prioritytxt.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        prioritytxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High", "Medium", "Low" }));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel8.setText("Priority");

        subjecttxt.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        subjecttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjecttxtActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Outstanding Issues", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 20))); // NOI18N

        issueTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Issue Subject", "Issue Description", "Issue Priority"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(issueTable);
        if (issueTable.getColumnModel().getColumnCount() > 0) {
            issueTable.getColumnModel().getColumn(1).setResizable(false);
            issueTable.getColumnModel().getColumn(2).setResizable(false);
            issueTable.getColumnModel().getColumn(3).setResizable(false);
        }

        submit1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        submit1.setText("<< CREATE TICKET");
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(submit1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submit1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subjecttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prioritytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(submit)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(72, 72, 72)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(enterpriseDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(continentDrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(countryDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(59, 59, 59)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continentDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subjecttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(prioritytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addComponent(submit)
                .addContainerGap(361, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        ViewAllReportsJPanel manageEnterpriseJPanel = new ViewAllReportsJPanel(userProcessContainer, system, continentList, enterpriseList, organizationList, continent, country, state, enterprise, organization);
        userProcessContainer.add("ManageAutoGeneratedTicketsJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void continentDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continentDropActionPerformed

        Continent network = (Continent) continentDrop.getSelectedItem();
        if (network != null) {
            populateCountryComboBox(network);
        }
    }//GEN-LAST:event_continentDropActionPerformed

    private void countryDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryDropActionPerformed
        // TODO add your handling code here:
        Country c = (Country) countryDrop.getSelectedItem();
        if (c != null) {
            //  populateStateComboBox(c);
            populateEnterpriseComboBox(c);
        }
    }//GEN-LAST:event_countryDropActionPerformed

    private void populateEnterpriseComboBox(Country c) {
        enterpriseDrop.removeAllItems();
        for (Enterprise enterprise : c.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseDrop.addItem(enterprise);
        }

    }

    private void subjecttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjecttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjecttxtActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        String subject = subjecttxt.getText();
        String message = messagetxt.getText();
        String priority = prioritytxt.getSelectedItem().toString();
        Organization org = (Organization) organizationEmpJComboBox.getSelectedItem();
        TicketWorkRequest request = new TicketWorkRequest();
        UserAccount ua = new UserAccount();
        ua.setEmailID("wildlifemanagementsystem@gmail.com");
        ua.setUsername("SysAdmin");
        request.setMessage(message);
        request.setSender(ua);
        request.setStatus("Open");
        request.setSubject(subject);
        request.setTicketPriority(priority);
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            ua.getWorkQueue().getWorkRequestList().add(request);
        }

    }//GEN-LAST:event_submitActionPerformed

    private void enterpriseDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseDropActionPerformed
        // TODO add your handling code here:
        Enterprise e = (Enterprise) enterpriseDrop.getSelectedItem();
        if (e != null) {
            //  populateStateComboBox(c);
            populateOrganizationEmpComboBox(e);
        }
    }//GEN-LAST:event_enterpriseDropActionPerformed

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = issueTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an issue!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (selectedRow >= 0) {
            int m = (Integer) issueTable.getValueAt(selectedRow, 0);
            ResultSet rs = conn.getDataById(m);
            if (conn.updateIssue(m)) {
                try {
                    int finalIndexVal = 0;
                    while (rs.next()) {
                        String issueSubject = rs.getString("IssueSubject");
                        String issueDescription = rs.getString("IssueDescription");
                        String issuePriority = rs.getString("IssuePriority");
                        subjecttxt.setText(issueSubject);
                        messagetxt.setText(issueDescription);
                        if (issuePriority.equalsIgnoreCase("low")) {
                            finalIndexVal = 0;
                        } else if (issuePriority.equalsIgnoreCase("medium")) {
                            finalIndexVal = 1;
                        } else {
                            finalIndexVal = 2;
                        }
                        prioritytxt.setSelectedIndex(finalIndexVal);
                        submit1.setEnabled(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            populateIssueTable();
        }
    }//GEN-LAST:event_submit1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox continentDrop;
    private javax.swing.JComboBox countryDrop;
    private javax.swing.JComboBox enterpriseDrop;
    private javax.swing.JTable issueTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messagetxt;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox<String> prioritytxt;
    private javax.swing.JTextField subjecttxt;
    private javax.swing.JButton submit;
    private javax.swing.JButton submit1;
    // End of variables declaration//GEN-END:variables
}
