import java.util.UUID;
import java.util.ArrayList;

public class Resume {

    private UUID id;
    private ArrayList<String> skills;
    private ArrayList<Experience> experience;
    private Education education;
    private ArrayList<String> language;

    /**
     * Default constructor that initalizes the private variables in the Resume class.
     * @param skills type ArrayList<String>
     * @param experience type ArrayList<Experience>
     * @param education type education
     * @param language type ArrayList<String>
     */
    public Resume(ArrayList<String> skills, ArrayList<Experience> experience, Education education, ArrayList<String> language) {
        this.id = UUID.randomUUID();
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.language = language;
    }

    /**
     * Default constructor that initalizes the private variables in the Resume class.
     * @param id type UUID
     * @param skills type ArrayList<String>
     * @param experience type ArrayList<Experience>
     * @param education type education
     * @param language type ArrayList<String>
     */
    public Resume(UUID id, ArrayList<String>skills, ArrayList<Experience> experience, Education education, ArrayList<String> language) {
        this.id = id;
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.language = language;
    }

    /**
     * gets the students ID.
     * @return returns the students id.
     */
    public UUID getid() {
        return id;
    }

    /**
     * gets the experience from ArrayList.
     * @return students experience
     */
    public ArrayList<Experience> getexperience() {
        return experience;
    }

    /**
     * gets the education from ArrayList.
     * @return students education. 
     */
    public Education geteducation() {
        return education;
    }

    /**
     * gets the language from ArrayList.
     * @return students language.
     */
    public ArrayList<String> getlanguage() {
        return language;
    }

    /**
     * gets the students skills from ArrayList.
     * @return students skills.
     */
    public ArrayList<String> getSkills() {
        return skills;
    }

    /**
     * Prints out.
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
