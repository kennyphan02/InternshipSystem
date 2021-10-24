import java.util.ArrayList;

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

    public Internship getInternship(int index) {
        return internshipsList.get(index);
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