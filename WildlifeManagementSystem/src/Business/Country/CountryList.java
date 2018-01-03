/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import Business.Enterprise.EnterpriseDirectory;
import Business.State.StateList;
import java.util.ArrayList;

/**
 *
 * @author Aditya Kelkar
 */
public class CountryList {
    private ArrayList<Country> countryList;
    
    public CountryList() {
        countryList = new ArrayList<>();
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }
    
    public Country addcountry() {
        Country sub = new Country();
        EnterpriseDirectory enterpriseDirectory = new EnterpriseDirectory();
        sub.setEnterpriseDirectory(enterpriseDirectory);
        countryList.add(sub);
        return sub;
    }
}
