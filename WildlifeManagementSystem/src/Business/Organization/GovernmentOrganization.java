/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.GovernmentAdminRole;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class GovernmentOrganization extends Organization{

    public GovernmentOrganization() {
        super(Type.Government.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();      
         roles.add(new GovernmentAdminRole());        
        return roles;
    }
     
}
