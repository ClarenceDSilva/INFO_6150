package Business;



import Business.Continent.Continent;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private static ArrayList<Continent> continentList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
          
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        continentList = new ArrayList<>();
    }

    public ArrayList<Continent> getContinentList() {
        return continentList;
    }

    public Continent createAndAddContinent() {
        Continent continent = new Continent();
        continentList.add(continent);
        return continent;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        return true;
    }

    
    
    
    
}