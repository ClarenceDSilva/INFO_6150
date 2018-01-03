/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.ConfigureASystem;
import Business.Continent.Continent;
import Business.Country.Country;
import Business.Employee.Employee;
import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.State.State;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohit
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
      
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return true;
        }
        return false;
    }

   
    
    public UserAccount createUserAccount(String username, String password, String email, String phoneNo, String phoneCarrier, Employee employee, Role role,EcoSystem system) {
        boolean found=false;
         boolean found2=false;
         Continent continent;
        Country country;     
        Enterprise enterprise;
        UserAccount userAccount=null;
        if(!system.getUserAccountDirectory().checkIfUsernameIsUnique(username)){
        for (int i = 0; i < system.getContinentList().size(); i++) {
                continent = system.getContinentList().get(i);              
                    for (int j = 0; j < continent.getCountryDirectory().getCountryList().size(); j++) {
                        country = continent.getCountryDirectory().getCountryList().get(j);
                        for (int m = 0; m < country.getEnterpriseDirectory().getEnterpriseList().size(); m++) {
                            enterprise = country.getEnterpriseDirectory().getEnterpriseList().get(m);
                            found = enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(username);
                             if (found == true) {
                             found2=true;
                             }
                            if (found2 == false) {
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    found = organization.getUserAccountDirectory().checkIfUsernameIsUnique(username);
                                    if (found == true) {
                             found2=true;
                             }
                                  
                                }}}}}}
        else
        {
             found2 = true;
        }
        
        if(found2 == false)
        {
        
         userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccount.setEmailID(email);
        userAccount.setPhoneNumber(phoneNo);
        userAccount.setPhoneCarrier(phoneCarrier);
        userAccountList.add(userAccount);
        if(!employee.getName().equalsIgnoreCase("SYSTEM"))
        {
        ConfigureASystem ca = new ConfigureASystem();
       ca.sendEmail(email,"", "Account has been created successfully.", "User Acccount: "+ username+" has been created.");
        ca.sendEmail(phoneNo,phoneCarrier,  "Account has been created successfully.", "User Acccount: "+ username+" has been created.");
        }
        }
        else
        {
             if(!employee.getName().equalsIgnoreCase("SYSTEM"))
        {
             JOptionPane.showMessageDialog(null, "Username already present!");
        }
        }
        return userAccount;
    }
}


