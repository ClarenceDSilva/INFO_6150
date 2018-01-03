/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.UIManager.*;
import Business.*;
import Business.EcoSystem;
import Business.ConfigureASystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Continent.Continent;
import Business.Country.Country;
import Business.Database.Connect;
import Business.Organization.Organization;
import Business.State.State;
import Business.UserAccount.UserAccount;
import UserInterface.OrgAdminRole.MapFrame;
import UserInterface.SystemAdminWorkAreaJPanel.SystenAdminCreateTicketJPanel;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.pushingpixels.substance.api.skin.*;

/**
 *
 * @author Aditya Kelkar
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public static int initial_count = 0;
    public static IssueList issueList;
    public static String loggedUser = null;
    private Timer timerLB;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean phNumValidate(String phoneNumber) {
        String regex = "^\\+?[0-9. ()-]{10,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    public static boolean emailValidate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public MainJFrame() {
        initComponents();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());
                } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                }
            }
        });
        system = dB4OUtil.retrieveSystem();
        Loader l = new Loader(system);
        SwingWorker work = l.createWorker();
        work.execute();
        issueList = new IssueList();

        issueAlert.setVisible(false);
        Connect con = new Connect();
        Runnable runnabledelayedTask = new Runnable() {
            @Override
            public void run() {
                Issue issue = new Issue();
                int count = con.getCount();
                if (initial_count == 0 || (initial_count != 0 && initial_count != count)) {
                    // First Iteration or additional values inserted into database
                    issueList.getIssueList().clear();
                    ResultSet rs = con.getData();
                    if (rs != null) {
                        try {
                            while (rs.next()) {
                                int id = rs.getInt("IssueID");
                                String senderName = rs.getString("SenderName");
                                String senderEmail = rs.getString("SenderEmail");
                                String issueDescription = rs.getString("IssueDescription");
                                String issueSubject = rs.getString("IssueSubject");
                                String issuePriority = rs.getString("IssuePriority");
                                String lat = rs.getString("lat");
                                String lon = rs.getString("lon");

                                issue = issueList.addIssue();
                                issue.setIssueID(String.valueOf(id));
                                issue.setIssueDescription(issueDescription);
                                issue.setIssuePriority(issuePriority);
                                issue.setIssueTitle(issueSubject);
                                issue.setLatutude(lat);
                                issue.setLongitude(lon);
                                issue.setSenderName(senderName);
                                issue.setSenderEmail(senderEmail);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    initial_count = count;
                    if (loggedUser != null) {
                        issueAlert.setVisible(true);
                        issueAlert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        timerLB = new Timer(1000, new LbBlink(issueAlert));
                        timerLB.start();
                    }
                }
            }
        };

        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(4);
        /**
         * @param runnabledelayedTask -- Task to be performed
         * @param Initial execution delay (Start the execution after 1 second)
         * @param Time delay between two calls (Call the next execution after 3
         * second)
         * @param Unit to be used while performing the actions. In this case,
         * seconds
         */
        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask, 1, 1, TimeUnit.SECONDS);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainSplitPane = new javax.swing.JSplitPane();
        controlPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        issueAlert = new javax.swing.JLabel();
        warningSign = new javax.swing.JLabel();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlPanel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        controlPanel.setMinimumSize(new java.awt.Dimension(230, 230));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("User Name");

        userNameJTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        passwordField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Password");

        loginJButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        logoutJButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        issueAlert.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        issueAlert.setText("ISSUE ALERT!!!");
        issueAlert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueAlertMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warningSign, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNameJTextField)
                    .addComponent(passwordField)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(loginJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                            .addComponent(issueAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginJButton)
                .addGap(18, 18, 18)
                .addComponent(logoutJButton)
                .addGap(68, 68, 68)
                .addComponent(warningSign, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(issueAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );

        MainSplitPane.setLeftComponent(controlPanel);

        container.setLayout(new java.awt.CardLayout());
        MainSplitPane.setRightComponent(container);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainSplitPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);

        ArrayList<Continent> continentList;
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Continent continent;
        Country country;
        State state;
        Enterprise enterprise;

        //Step1: Check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        if (userAccount == null) {
            for (int i = 0; i < system.getContinentList().size(); i++) {
                continent = system.getContinentList().get(i);
                if (userAccount == null) {
                    for (int j = 0; j < continent.getCountryDirectory().getCountryList().size(); j++) {
                        country = continent.getCountryDirectory().getCountryList().get(j);
                        for (int m = 0; m < country.getEnterpriseDirectory().getEnterpriseList().size(); m++) {
                            enterprise = country.getEnterpriseDirectory().getEnterpriseList().get(m);
                            userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount == null) {
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                                    if (userAccount != null) {
                                        inEnterprise = enterprise;
                                        inOrganization = organization;
                                        break;
                                    }
                                }
                            } else {
                                inEnterprise = enterprise;
                                break;
                            }
                            if (inOrganization != null) {
                                break;
                            }
                        }
                        if (inEnterprise != null) {
                            break;
                        }
                    }
                }
            }

        }
        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        } else {
            if (String.valueOf(userAccount.getRole()).equals("SystemAdminRole")) {
                loggedUser = userAccount.getUsername();
            } else {
                System.out.println("BLAH HERE");
            }
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system));
            layout.next(container);
        }
        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        loggedUser = null;
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void issueAlertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueAlertMouseClicked
        // TODO add your handling code here:
        timerLB.start();
        issueAlert.setVisible(false);
        MapFrame mf = new MapFrame();
    }//GEN-LAST:event_issueAlertMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    class LbBlink implements ActionListener {

        private javax.swing.JLabel label;
        private java.awt.Color cor1 = java.awt.Color.red;
        private java.awt.Color cor2 = java.awt.Color.black;
        private int count;

        public LbBlink(javax.swing.JLabel label) {
            this.label = label;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (count % 2 == 0) {
                label.setForeground(cor1);
            } else {
                label.setForeground(cor2);
            }
            count++;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane MainSplitPane;
    private javax.swing.JPanel container;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel issueAlert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginJButton;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JLabel warningSign;
    // End of variables declaration//GEN-END:variables
}
