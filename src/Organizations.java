import java.util.ArrayList;
import java.util.UUID;

public class Organizations {

    private static Organizations organizations = null;
    private static ArrayList<Organization> organizationsList = new ArrayList<Organization>();

    private Organizations() {
        organizationsList = DataLoader.getOrgs();
    }

    public static Organizations getInstance() {
        if(organizations == null) {
            organizations = new Organizations();
        }
        return organizations;
    }

    public ArrayList<Organization> getOrganizationsList() {
        return organizationsList;
    }

    public Organization getOrganization(UUID target) {
        for (int i = 0; i < organizationsList.size(); i++) {
            if(organizationsList.get(i).getId() == target) {
                return organizationsList.get(i);
            }
        }
        return null;
    }

    public void addOrganization(Organization o) {
        organizationsList.add(o);
    }

    public void removeOrganization(Organization o) {
        organizationsList.remove(o);
    }

    public void logout() {

    }
    
}
