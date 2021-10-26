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

    /**
     * Default constructor that initilizes the private variables in Orginization class. 
     * @param user type String
     * @param pass type String 
     * @param email type String 
     * @param country type String 
     * @param orgName type String 
     * @param phoneNum type String 
     * @param description type String
     */

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

    /**
     * 
     * @param id type String
     * @param user type String
     * @param pass type String
     * @param email type String
     * @param country type String
     * @param orgName type String
     * @param phoneNum type String
     * @param description type String
     * @param internships type ArrayList<Internship>
     */
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

    /**
     * Adds an internship. 
     * @param internship the internship that is being added.
     */
    public void addInternship(Internship internship) {
        return;
    }

    /**
     * Removes an internship.
     * @param internship the internship that is being removed. 
     */
    public void removeInternship(Internship internship) {
        return;
    }

    /**
     * Edits an internship. 
     * @param internship the internship that is being edited. 
     */
    public void editInternship(Internship internship) {
        return;
    }

    /**
     * prints out. 
     */
    public String toString() {
        return "";
    }

    /**
     * Gets the UUID for the student.
     * @return The UUID for the student.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the username of the student.
     * @return The username of the student.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets the password of the student.
     * @return The password of the student.
     */
    public String getPassword() {
        return pass;
    }

    /**
     * Gets the email of the student.
     * @return The email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the country of the student. 
     * @return the country of the student. 
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the Org name of the student.
     * @return the org name. 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Gets the phone number of the student.
     * @return the phone number of the student.
     */
    public String getPhoneNumber() {
        return phoneNum;
    }

    /**
     * Gets the description of the student. 
     * @return the description.
     */
    public String getDesc() {
        return description;
    }

    /**
     * Gets the internships that the student has. 
     * @return the internships. 
     */
    public ArrayList<Internship> getInternships() {
        return internships;
    }

}
