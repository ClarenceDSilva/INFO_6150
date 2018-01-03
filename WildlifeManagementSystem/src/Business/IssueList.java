/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Aditya Kelkar
 */
public class IssueList {
    private static ArrayList<Issue> issueList;
    
    public IssueList() {
        issueList = new ArrayList<>();
    }

    public ArrayList<Issue> getIssueList() {
        return issueList;
    }

    public Issue addIssue() {
        Issue issue = new Issue();
        issueList.add(issue);
        return issue;
    }
    
    
}
