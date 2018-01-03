/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Organization.Organization;

/**
 *
 * @author Rohit
 */
public class Employee {

    private String name;
    private Organization empOrganization;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public Organization getEmpOrganization() {
        return empOrganization;
    }

    public void setEmpOrganization(Organization empOrganization) {
        this.empOrganization = empOrganization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
