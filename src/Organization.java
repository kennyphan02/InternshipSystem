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

    //prints out all of the student information for the organization to see.
    public String toString() {
        return "User: " + this.user + "\nPass: " + this.pass + "\nEmail: " + this.email + "\nCountry: " + this.country + "\nOrgName: " + this.orgName + "\nPhoneNum: " + this.phoneNum + "\nDescription: " + this.description + "\nInternships: " + internships;
    }

    /**
     * Gets the UUID for the organization.
     * @return The UUID for the organization.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the username of the organization.
     * @return The username of the organization.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets the password of the organization.
     * @return The password of the organization.
     */
    public String getPassword() {
        return pass;
    }

    /**
     * Gets the email of the organization.
     * @return The email of the organization.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the country of the organization. 
     * @return the country of the organization. 
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the Org name of the organization.
     * @return the org name. 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Gets the phone number of the organization.
     * @return the phone number of the organization.
     */
    public String getPhoneNumber() {
        return phoneNum;
    }

    /**
     * Gets the description of the organization.
     * @return the description.
     */
    public String getDesc() {
        return description;
    }

    /**
     * Gets the internships that the organization has.  
     * @return the internships. 
     */
    public ArrayList<Internship> getInternships() {
        return internships;
    }

}
