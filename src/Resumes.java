import java.util.ArrayList;
import java.util.UUID;

/**
 * Hold operations for instances of resume
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Resumes {

    private static Resumes resumes = null;
    private static ArrayList<Resume> resumesList = new ArrayList<Resume>();

    //Calls on DataLoader to populate the ArrayList from JSON file.
    private Resumes() {
        resumesList = DataLoader.getResumes();
    }

     /**
     * Checks for instance of resume. Returns instance if it exists;
     * otherwise, one will be constructed.
     * @return resume if it exists
     */
    public static Resumes getInstance() {
        if(resumes == null) {
            resumes = new Resumes();
        }
        return resumes;
    }

    /**
     * Gets a list of resumes.
     * @return the ArrayList of resumes
     */
    public ArrayList<Resume> getResumesList() {
        return resumesList;
    }

    /**
     * Gets an instance of resume from the ArrayList.
     * @param target
     * @return the selected resume
     */
    public Resume getResume(UUID target) {
        for (int i = 0; i < resumesList.size(); i++) {
            if(resumesList.get(i).getid() == target) {
                return resumesList.get(i);
            }
        }
        return null;
    }

    //Adds a resume from the JSON file into the ArrayList.
    public void addResume(Resume r) {
        resumesList.add(r);
    }

    //Removes an instance of resume from the ArrayList
    public void removeResume(Resume r) {
        resumesList.remove(r);
    }

    //Sends data from resume singleton to DataWriter.
    public void logout() {
        DataWriter.saveResume();
    }
    
}
