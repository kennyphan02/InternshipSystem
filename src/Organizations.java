import java.util.ArrayList;

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

    public Organization getOrganization(int index) {
        return organizationsList.get(index);
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
