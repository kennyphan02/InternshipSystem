import java.util.ArrayList;
import java.util.UUID;

public class Resumes {

    private static Resumes resumes = null;
    private static ArrayList<Resume> resumesList = new ArrayList<Resume>();

    private Resumes() {
        resumesList = DataLoader.getResumes();
    }

    public static Resumes getInstance() {
        if(resumes == null) {
            resumes = new Resumes();
        }
        return resumes;
    }

    public ArrayList<Resume> getResumesList() {
        return resumesList;
    }

    public Resume getResume(UUID target) {
        for (int i = 0; i < resumesList.size(); i++) {
            if(resumesList.get(i).getid() == target) {
                return resumesList.get(i);
            }
        }
        return null;
    }

    public void addResume(Resume r) {
        resumesList.add(r);
    }

    public void removeResume(Resume r) {
        resumesList.remove(r);
    }

    public void logout() {

    }
    
}
