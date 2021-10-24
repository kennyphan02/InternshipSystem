import java.util.ArrayList;

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

    public Resume getResume(int index) {
        return resumesList.get(index);
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
