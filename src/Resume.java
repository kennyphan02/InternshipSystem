import java.util.UUID;
import java.util.ArrayList;

public class Resume {

    private UUID id;
    private String firstName;
    private String lastName;
    private String profession;
    private String email;
    private Experience experience;
    private Education education;
    private ArrayList<String> language;

    public Resume(String firstName, String lastName, String profession, 
            String email, Experience experience, Education education, ArrayList<String> language) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.email = email;
        this.experience = experience;
        this.education = education;
        this.language = language;
    }
    public Resume(UUID id, String firstName, String lastName, String profession, 
            String email, Experience experience, Education education, ArrayList<String> language) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.email = email;
        this.experience = experience;
        this.education = education;
        this.language = language;
    }
    public UUID getid() {
        return id;
    }
    public String getfirstName() {
        return firstName;
    } 
    public String getlastName() {
        return lastName;
    }
    public String getprofession() {
        return profession;
    }
    public String getemail() {
        return email;
    }
    public Experience getexperience() {
        return experience;
    }
    public Education geteducation() {
        return education;
    }
    public ArrayList<String> getlanguage() {
        return language;
    }

    /**
     * To be changed
     */
    public String toString() {
        return "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nProfession: " + this.profession + "\nEmail: " + 
            this.email + "\nExperience: " + this.experience + "\nEducation: " + this.education + "\nLanguage: " + this.language;
    }
    
}
