/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Continent.Continent;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Rohit
 */
public abstract class Enterprise extends Organization {

    private Continent network;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
    }

    public Continent getNetwork() {
        return network;
    }

    public void setNetwork(Continent network) {
        this.network = network;
    }

    public enum EnterpriseType {
        //Government("Government"), NGO("NGO"), Community("Community"),
        State("State");
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
 
        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

}
