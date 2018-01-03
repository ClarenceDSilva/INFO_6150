/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import UserInterface.OrgAdminRole.OrgAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Rohit
 */
public class GovernmentAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new OrgAdminWorkAreaJPanel(userProcessContainer, enterprise,organization,business,account);
    }

    
    
}
