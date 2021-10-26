import java.util.ArrayList;
import java.util.UUID;

public class Internships {

    private static Internships internships = null;
    private static ArrayList<Internship> internshipsList = new ArrayList<Internship>();

    private Internships() {
        internshipsList = DataLoader.getInternships();
    }

    public static Internships getInstance() {
        if(internships == null) {
            internships = new Internships();
        }
        return internships;
    }

    public ArrayList<Internship> getInternshipsList() {
        return internshipsList;
    }

    public Internship getInternship(UUID target) {
        for (int i = 0; i < internshipsList.size(); i++) {
            if(internshipsList.get(i).getid() == target) {
                return internshipsList.get(i);
            }
        }
        return null;
    }

    public void addInternship(Internship i) {
        internshipsList.add(i);
    }

    public void removeInternship(Internship i) {
        internshipsList.remove(i);
    }

    public void logout() {

    }
    
}