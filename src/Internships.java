import java.util.ArrayList;
import java.util.UUID;

/**
 * Hold operations for instances of internship
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Internships {

    private static Internships internships = null;
    private static ArrayList<Internship> internshipsList = new ArrayList<Internship>();

    //Calls on DataLoader to populate the ArrayList
    private Internships() {
        internshipsList = DataLoader.getInternships();
    }

    /**
     * Checks for instance of internship. Returns instance if it exists;
     * otherwise, one will be constructed.
     * @return internship if it exists
     */
    public static Internships getInstance() {
        if(internships == null) {
            internships = new Internships();
        }
        return internships;
    }

    /**
     * Gets the list of internships
     * @return the ArrayList of internships
     */
    public ArrayList<Internship> getInternshipsList() {
        return internshipsList;
    }

    /**
     * Gets an instance of internship from array list.
     * @param target
     * @return selected internship
     */
    public Internship getInternship(UUID target) {
        for (int i = 0; i < internshipsList.size(); i++) {
            if(internshipsList.get(i).getid().equals(target)) {
                return internshipsList.get(i);
            }
        }
        return null;
    }

    //Adds an internship from the JSON file into ArrayList.
    public void addInternship(Internship i) {
        internshipsList.add(i);
    }

    //Removes an internship from the ArrayList
    public void removeInternship(Internship i) {
        internshipsList.remove(i);
    }

    //Sends data from this singleton to DataWriter
    public void logout() {
        DataWriter.saveInternship();
    }
    
}