/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Aditya Kelkar
 */
public class Connect {

    private Connection conn;
    private ResultSet rs;
    private Statement st;

    public Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/wps", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData() {
        try {
            String query = "SELECT * FROM issues WHERE TicketCreated = 0";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet getDataById(int id) {
        try {
            String query = "SELECT * FROM issues WHERE TicketCreated = 0 AND IssueID = "+id;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Boolean updateIssue(int id) {
        try {
            String query = "UPDATE issues SET TicketCreated = 1 WHERE IssueId = "+id;
            st = conn.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getCount() {
        int count = 0;
        try {
            String query = "SELECT count(*) as RowCount FROM issues";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                count = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public Boolean addIssue(String subject, String issueDescription, String senderName, String priority) {
        try {
            String query = "INSERT INTO issues (SenderName, IssueSubject, IssueDescription, IssuePriority) VALUES ()";
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
