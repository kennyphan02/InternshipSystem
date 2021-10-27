import java.util.UUID;
import java.util.ArrayList;

public class Resume {

    private UUID id;
    private ArrayList<String> skills;
    private ArrayList<Experience> experience;
    private Education education;
    private ArrayList<String> language;

    public Resume(ArrayList<String> skills, ArrayList<Experience> experience, Education education, ArrayList<String> language) {
        this.id = UUID.randomUUID();
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.language = language;
    }
    public Resume(UUID id, ArrayList<String>skills, ArrayList<Experience> experience, Education education, ArrayList<String> language) {
        this.id = id;
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.language = language;
    }
    public UUID getid() {
        return id;
    }
    public ArrayList<Experience> getexperience() {
        return experience;
    }
    public Education geteducation() {
        return education;
    }
    public ArrayList<String> getlanguage() {
        return language;
    }
    public ArrayList<String> getSkills() {
        return skills;
    }

    /**
     * To be changed
     */
    public String toString() {
        String ret = "ID: " + id + "\n" + "Skills: " + skills.toString() + "\n" + "\n" + "Experience: " + "\n";
        for(int i = 0; i < experience.size(); i++) {
            ret += experience.get(i).toString() + "\n";
        }
        ret += "Education: " + "\n" + education.toString() + "\n" + "Language(s): " + language.toString() + "\n";
        return ret;
    }
    
}
