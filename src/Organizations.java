import java.util.ArrayList;
import java.util.UUID;

/**
 * Hold operations for instances of Organizations
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Organizations {

    private static Organizations organizations = null;
    private static ArrayList<Organization> organizationsList = new ArrayList<Organization>();

    //Calls on data loader to populate array list.
    private Organizations() {
        organizationsList = DataLoader.getOrgs();
    }

   /**
     *Checks if instance of organization.java exists. Returns instance if exists, contructs one otherwise.
     * @return instance of organization.java if it exists
     * @see Organization#Organization(UUID, String, String, String, String, String, String, String, ArrayList)
     */
    public static Organizations getInstance() {
        if(organizations == null) {
            organizations = new Organizations();
        }
        return organizations;
    }

    /**
     * Gets the list of organizations
     * @return the array of organizations
     */
    public ArrayList<Organization> getOrganizationsList() {
        return organizationsList;
    }

    /**
     * Gets an instance of organization from array list
     * @param target
     * @return selected organization
     */
    public Organization getOrganization(UUID target) {
        for (int i = 0; i < organizationsList.size(); i++) {
            if(organizationsList.get(i).getId() == target) {
                return organizationsList.get(i);
            }
        }
        return null;
    }

    //Adds an organization from JSON file into the array list.
    public void addOrganization(Organization o) {
        organizationsList.add(o);
    }

    //Removes an instance of organization from array list.
    public void removeOrganization(Organization o) {
        organizationsList.remove(o);
    }

    //Sends data from this singleton to DataWriter.
    public void logout() {
        DataWriter.saveOrganization();
    }
    
}
