/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name){
        Enterprise enterprise = null;        
//        if (type == Enterprise.EnterpriseType.Government){
//           enterprise = new GovernmentEnterprise(name);
//           enterpriseList.add(enterprise);
//        }
//        if (type == Enterprise.EnterpriseType.NGO){
//            enterprise = new NGOEnterprise(name);
//            enterpriseList.add(enterprise);
//       }
//          if (type == Enterprise.EnterpriseType.Community){
//           enterprise = new CommunityEnterprise(name);
//          enterpriseList.add(enterprise);
//        }
         // if (type == Enterprise.EnterpriseType.State){
           enterprise = new StateEnterprise(name);
          enterpriseList.add(enterprise);
       // }
        return enterprise;
    }
    
}
