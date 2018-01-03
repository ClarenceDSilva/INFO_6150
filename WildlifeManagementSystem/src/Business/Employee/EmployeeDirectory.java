/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name, Organization empOrg) {
        Employee employee = new Employee();
        employeeList.add(employee);
        employee.setName(name);
        if (empOrg != null) {
            employee.setEmpOrganization(empOrg);
        }
        return employee;
    }
}
