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
    private ArrayList<Internship> internship; // internship class will have internshipreview 

    public Organization(String user, String pass, String email, String country, String orgName, String phoneNum, String description) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.country = country;
        this.orgName = orgName;
        this.phoneNum = phoneNum;
        this.description = description;
        internship = new ArrayList<Internship>();
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
