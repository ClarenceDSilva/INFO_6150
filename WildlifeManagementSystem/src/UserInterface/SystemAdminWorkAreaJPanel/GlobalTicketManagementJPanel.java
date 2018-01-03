/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkAreaJPanel;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Continent.Continent;
import Business.Country.Country;
import Business.Organization.Organization;
import Business.State.State;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Rohit
 */
public class GlobalTicketManagementJPanel extends javax.swing.JPanel {

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

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public GlobalTicketManagementJPanel(JPanel userProcessContainer, EcoSystem system, ArrayList<Continent> continentList, ArrayList<Enterprise> enterpriseList, ArrayList<Organization> organizationList, Continent continent, Country country, State state, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.continentList = continentList;
        this.organizationList = organizationList;
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
        manageNetworkJButton2 = new javax.swing.JButton();
        manageNetworkJButton3 = new javax.swing.JButton();

        backJButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        manageNetworkJButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        manageNetworkJButton2.setText("Manage Global Ticket List");
        manageNetworkJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButton2ActionPerformed(evt);
            }
        });

        manageNetworkJButton3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        manageNetworkJButton3.setText("Create Ticket");
        manageNetworkJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(manageNetworkJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(364, 364, 364)
                            .addComponent(manageNetworkJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(94, 94, 94)
                .addComponent(manageNetworkJButton2)
                .addGap(18, 18, 18)
                .addComponent(manageNetworkJButton3)
                .addContainerGap(442, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        SystemAdminWorkAreaJPanel manageEnterpriseJPanel = new SystemAdminWorkAreaJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageAutoGeneratedTicketsJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void manageNetworkJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButton2ActionPerformed
        // TODO add your handling code here:
        ManageReportsJPanel manageEnterpriseJPanel = new ManageReportsJPanel(userProcessContainer, system, continentList, enterpriseList, organizationList, continent, country, state, enterprise, organization);
        userProcessContainer.add("ManageAutoGeneratedTicketsJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButton2ActionPerformed

    private void manageNetworkJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButton3ActionPerformed
        // TODO add your handling code here:

        SystenAdminCreateTicketJPanel manageEnterpriseJPanel = new SystenAdminCreateTicketJPanel(userProcessContainer, system, continentList, enterpriseList, organizationList, continent, country, state, enterprise, organization);
        userProcessContainer.add("ManageAutoGeneratedTicketsJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton manageNetworkJButton2;
    private javax.swing.JButton manageNetworkJButton3;
    // End of variables declaration//GEN-END:variables
}
