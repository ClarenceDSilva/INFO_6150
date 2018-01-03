/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.State;

import Business.Country.Country;
import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Aditya Kelkar
 */
public class State {

    private String statename;
    private Country country;
    private EnterpriseDirectory enterpriseDirectory;
    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country subNetwork) {
        this.country = subNetwork;
    }

     public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    @Override
    public String toString() {
        return statename;
    }
    
    
}
