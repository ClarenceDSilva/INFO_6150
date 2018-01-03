/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class StateEnterprise extends Enterprise {

    public StateEnterprise(String name) {
        super(name, EnterpriseType.State);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
