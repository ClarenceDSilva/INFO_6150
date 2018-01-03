/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.CommunityAdminRole;
import Business.Role.GovernmentAdminRole;
import Business.Role.NGOAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class CommunityOrganization extends Organization{

    public CommunityOrganization() {
        super(Type.Community.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CommunityAdminRole());
         
        return roles;
    }
     
}
