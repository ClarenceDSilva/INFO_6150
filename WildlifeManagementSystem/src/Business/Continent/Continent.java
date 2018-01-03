/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Continent;

import Business.Country.Country;
import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Country.CountryList;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class Continent {

    private String name;
    private CountryList countryDirectory;

    public CountryList getCountryDirectory() {
        return countryDirectory;
    }

    public void setCountryDirectory(CountryList countryList) {
        this.countryDirectory = countryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }    

}
