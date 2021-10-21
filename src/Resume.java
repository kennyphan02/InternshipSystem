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

    public String toString() {
        return "";
    }
    
}
