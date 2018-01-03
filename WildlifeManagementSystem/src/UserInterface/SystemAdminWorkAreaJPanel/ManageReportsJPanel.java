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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Rohit
 */
public class ManageReportsJPanel extends javax.swing.JPanel {

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
    int count = 1;
    
    String stateName;
    int stateCount = 0;
    int col = 1;
    DefaultTableModel model;
    Map<String, Integer> stateDetails = new HashMap<String, Integer>();
    Map<String, Integer> statesForCombo = new HashMap<String, Integer>();

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    private void searchTable(String search) {
        model = (DefaultTableModel) workRequestJTable.getModel();
        TableRowSorter<DefaultTableModel> filter = new TableRowSorter<DefaultTableModel>(model);
        workRequestJTable.setRowSorter(filter);

        if (search.trim().length() == 0) { // or if (text.isEmpty())
            filter.setRowFilter(null);
        } else {
            filter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
        }
    }

    public ManageReportsJPanel(JPanel userProcessContainer, EcoSystem system, ArrayList<Continent> continentList, ArrayList<Enterprise> enterpriseList, ArrayList<Organization> organizationList, Continent continent, Country country, State state, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.continentList = continentList;
        this.organizationList = organizationList;
        this.enterpriseList = enterpriseList;
        workRequestJTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));

        populateTable();
        populateStateComboBox();

    }

    public void populateStateComboBox() {
        System.out.println("Method executing");
        comboState.removeAllItems();

        Iterator it = statesForCombo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            stateName = pair.getKey().toString();
            comboState.addItem(stateName);
        }
    }

    public void populateTable() {
    int countOpen = 0;
    int countPending =0;
    int countCompleted = 0;
        model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for (int i = 0; i < system.getContinentList().size(); i++) {
            continent = continentList.get(i);
            for (int j = 0; j < continent.getCountryDirectory().getCountryList().size(); j++) {
                country = continent.getCountryDirectory().getCountryList().get(j);
                for (int k = 0; k < country.getEnterpriseDirectory().getEnterpriseList().size(); k++) {
                    enterprise = country.getEnterpriseDirectory().getEnterpriseList().get(k);
                    for (int l = 0; l < enterprise.getOrganizationDirectory().getOrganizationList().size(); l++) {
                        organization = enterprise.getOrganizationDirectory().getOrganizationList().get(l);
                        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                            Object[] row = new Object[6];
                            row[0] = request;
                            row[1] = enterprise.getName();

                            if (!(stateDetails.containsKey(enterprise.getName()))) {
                                stateDetails.put(enterprise.getName(), 1);
                            } else {
                                stateDetails.put(enterprise.getName(), stateDetails.get(enterprise.getName()) + 1);
                            }

                            //Code to populate the search combobox
                            statesForCombo.put("Search by state", 0);
                            if (!(statesForCombo.containsKey(enterprise.getName()))) {
                                statesForCombo.put(enterprise.getName(), count);
                            }

//                            Iterator it = stateDetails.entrySet().iterator();
//                            while (it.hasNext()) {
//                                Map.Entry pair = (Map.Entry) it.next();
//                                stateName = pair.getKey().toString();
//                                stateCount = (Integer) pair.getValue();
//                                System.out.println(stateName + " ======= $" + stateCount);
//                                //pieDataset.setValue(stateName, stateCount);
//                            }

                            row[2] = request.getTicketPriority();
                            row[3] = request.getStatus();
                            if (request.getStatus().equals("Open")) {
                                countOpen++;
                            } else if (request.getStatus().equals("Pending")) {
                                countPending++;
                            } else if (request.getStatus().equals("Completed")) {
                                countCompleted++;
                            }
                            lblCompletedCount.setText(Integer.toString(countCompleted));
                            lblPendingCount.setText(Integer.toString(countPending));
                            lblOpenCount.setText(Integer.toString(countOpen));

                            row[4] = request.getRequestDate();
                            row[5] = request.getResolveDate();
                            //System.out.println(comboDate);
                            Calendar c=Calendar.getInstance();
                            if (comboDate.getSelectedItem().toString().equalsIgnoreCase("Search Tickets")) {
                                model.addRow(row);
                            }
                            if (comboDate.getSelectedItem().toString().equalsIgnoreCase("Today")) {
                              c.setTime(request.getRequestDate());
                            c.add(Calendar.DATE,1);
                             if(c.getTime().compareTo(new Date())>0){
                                     model.addRow(row);
                                }
                            }
                            if (comboDate.getSelectedItem().toString().equalsIgnoreCase("Last 30 days")) {
                                 c.setTime(request.getRequestDate());
                            c.add(Calendar.DATE,30);
                             if(c.getTime().compareTo(new Date())>0){
                                     model.addRow(row);
                                }
                            }
                            if (comboDate.getSelectedItem().toString().equalsIgnoreCase("Last 7 days")) {
                                 c.setTime(request.getRequestDate());
                            c.add(Calendar.DATE,7);
                             if(c.getTime().compareTo(new Date())>0){
                                     model.addRow(row);
                                }
                               
                            }

                        }
                    }
                }
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        comboState = new javax.swing.JComboBox<>();
        comboDate = new javax.swing.JComboBox<>();
        btnGraph = new javax.swing.JButton();
        lblCompleted = new javax.swing.JLabel();
        lblCompletedCount = new javax.swing.JLabel();
        lblPending = new javax.swing.JLabel();
        lblPendingCount = new javax.swing.JLabel();
        lblOpen = new javax.swing.JLabel();
        lblOpenCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnStateGraph = new javax.swing.JButton();

        backJButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "State", "Priority", "Status", "Request Date", "Resolve Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        refreshJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        comboState.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        comboState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by state" }));
        comboState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStateItemStateChanged(evt);
            }
        });

        comboDate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        comboDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search Tickets", "Today", "Last 30 days", "Last 7 days" }));
        comboDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDateItemStateChanged(evt);
            }
        });
        comboDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDateActionPerformed(evt);
            }
        });

        btnGraph.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGraph.setText("Graph Mode");
        btnGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphActionPerformed(evt);
            }
        });

        lblCompleted.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCompleted.setText("Completed:");

        lblCompletedCount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCompletedCount.setText("Nada");

        lblPending.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPending.setText("Pending:");

        lblPendingCount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPendingCount.setText("Nada");

        lblOpen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblOpen.setText("Open:");

        lblOpenCount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblOpenCount.setText("Nada");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Ticket Tracker");

        btnStateGraph.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnStateGraph.setText("State Graph");
        btnStateGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStateGraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(refreshJButton)
                        .addGap(140, 140, 140)
                        .addComponent(btnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnStateGraph))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269)
                        .addComponent(comboDate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 346, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(418, 418, 418)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompleted, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPending)
                            .addComponent(lblOpen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompletedCount)
                            .addComponent(lblPendingCount)
                            .addComponent(lblOpenCount)))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompleted)
                    .addComponent(lblCompletedCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPending)
                    .addComponent(lblPendingCount))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpen)
                    .addComponent(lblOpenCount))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboState, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDate))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshJButton)
                    .addComponent(btnGraph)
                    .addComponent(btnStateGraph))
                .addGap(320, 320, 320))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        ViewAllReportsJPanel manageEnterpriseJPanel = new ViewAllReportsJPanel(userProcessContainer, system, continentList, enterpriseList, organizationList, continent, country, state, enterprise, organization);
        userProcessContainer.add("ManageAutoGeneratedTicketsJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
         populateStateComboBox();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void comboStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStateItemStateChanged
        if (null != comboState.getSelectedItem()) {
            String item = comboState.getSelectedItem().toString();
            if (item.equals("Search by state")) {
                searchTable("");
               
            } else {
                 searchTable(item);
            }
        }
    }//GEN-LAST:event_comboStateItemStateChanged

    private void comboDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDateItemStateChanged

    }//GEN-LAST:event_comboDateItemStateChanged

    private void btnGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphActionPerformed
    int countOpen = lblOpenCount.getText().equals("Nada")?0:Integer.parseInt(lblOpenCount.getText());
    int countPending =lblPendingCount.getText().equals("Nada")?0:Integer.parseInt(lblPendingCount.getText());
    int countCompleted = lblCompletedCount.getText().equals("Nada")?0:Integer.parseInt(lblCompletedCount.getText());
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue(lblOpen.getText(), countOpen);
        pieDataset.setValue(lblPending.getText(), countPending);
        pieDataset.setValue(lblCompleted.getText(), countCompleted);

        JFreeChart chart = ChartFactory.createPieChart3D("Ticket Status Statistics", pieDataset);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(600, 750);
    }//GEN-LAST:event_btnGraphActionPerformed

    private void btnStateGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStateGraphActionPerformed
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        Iterator it = stateDetails.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            stateName = pair.getKey().toString();
            stateCount = (Integer) pair.getValue();
            System.out.println(stateName + " ============GRAPH MODE=============== $" + stateCount);
            pieDataset.setValue(stateName, stateCount);
        }
        JFreeChart chart = ChartFactory.createPieChart3D("Tickets generated per state", pieDataset);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(600, 750);
    }//GEN-LAST:event_btnStateGraphActionPerformed

    private void comboDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDateActionPerformed
        // TODO add your handling code here:
populateTable();

    }//GEN-LAST:event_comboDateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnGraph;
    private javax.swing.JButton btnStateGraph;
    private javax.swing.JComboBox<String> comboDate;
    private javax.swing.JComboBox<String> comboState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompleted;
    private javax.swing.JLabel lblCompletedCount;
    private javax.swing.JLabel lblOpen;
    private javax.swing.JLabel lblOpenCount;
    private javax.swing.JLabel lblPending;
    private javax.swing.JLabel lblPendingCount;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
