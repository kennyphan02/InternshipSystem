import java.util.UUID;
import java.util.ArrayList;

public class Organization extends User{

    private UUID id;
    private String user;
    private String pass;
    private String email;
    private String country;
    private String orgName;
    private String phoneNum;
    private String description;
    private ArrayList<Internship> internships; // internship class will have internshipreview 

    public Organization(String user, String pass, String email, String country, String orgName, String phoneNum, String description) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.country = country;
        this.orgName = orgName;
        this.phoneNum = phoneNum;
        this.description = description;
        internships = new ArrayList<Internship>();
    }
    public Organization(UUID id, String user, String pass, String email,
        String country, String orgName, String phoneNum, String description, ArrayList<Internship> internships) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.country = country;
        this.orgName = orgName;
        this.phoneNum = phoneNum;
        this.description = description;
        this.internships = internships;
    }

    public void addInternship(Internship internship) {
        return;
    }

    public void removeInternship(Internship internship) {
        return;
    }

    public void editInternship(Internship internship) {
        return;
    }

    public String toString() {
        return "";
    }

}
