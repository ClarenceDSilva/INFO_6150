/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Community.getValue())) {
            organization = new CommunityOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.NGO.getValue())) {
            organization = new NGOOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.Government.getValue())) {
            organization = new GovernmentOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
