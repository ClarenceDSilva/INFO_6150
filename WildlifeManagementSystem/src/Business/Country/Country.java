/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import Business.Enterprise.EnterpriseDirectory;
import Business.Continent.Continent;
import Business.State.State;
import Business.State.StateList;
import java.util.ArrayList;

/**
 *
 * @author Aditya Kelkar
 */
public class Country {

    private String countryName;
    private Continent continent;
   // private StateList stateList;
       private EnterpriseDirectory enterpriseDirectory;

//    public StateList getStateList() {
//        return stateList;
//    }
//
//    public void setStateList(StateList stateList) {
//        this.stateList = stateList;
//    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent network) {
        this.continent = network;
    }

    @Override
    public String toString() {
        return countryName;
    }
    
    
     public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
}
