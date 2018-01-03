/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.NGOAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class NGOOrganization extends Organization{

    public NGOOrganization() {
        super(Type.NGO.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
     
         roles.add(new NGOAdminRole());
        return roles;
    }
     
}
