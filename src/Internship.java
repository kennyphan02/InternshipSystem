import java.util.UUID;
import java.util.ArrayList;

public class Internship {

    private UUID id;
    private String job;
    private String degree;
    private boolean fullTime;
    private boolean inPerson;
    private String pay;
    private int hours;
    private UUID orgID;
    private ArrayList<String> skills;
    private ArrayList<UUID> reviewIDs;
    private ArrayList<UUID> applicantIDs;

    /**
     * Default constructor that initalizes the private variables in the Internship class.
     * @param job type String
     * @param degree type String
     * @param fullTime type boolean
     * @param inPerson type boolean
     * @param pay type String
     * @param hours type int
     * @param orgID type UUID
     * @param skills type ArrayList<String>
     */
    public Internship(String job, String degree, boolean fullTime, boolean inPerson, String pay, int hours, UUID orgID, ArrayList<String> skills) {
        this.id = UUID.randomUUID();
        this.job = job;
        this.degree = degree;
        this.fullTime = fullTime;
        this.inPerson = inPerson;
        this.pay = pay;
        this.hours = hours;
        this.orgID = orgID;
        this.skills = skills;
        this.reviewIDs = new ArrayList<UUID>();
        this.applicantIDs = new ArrayList<UUID>();
    }

    /**
     * Default constructor that initalizes the private variables in the Internship class. 
     * @param id type UUID
     * @param job type String
     * @param degree type String
     * @param fullTime type boolean
     * @param inPerson type boolean
     * @param pay type int
     * @param hours type int
     * @param orgID type UUID
     * @param skills type ArrayList<String>
     * @param reviewIDs type ArrayList<UUID>
     * @param applicantIDs type ArrayList<UUID>
     */
    public Internship(UUID id, String job, String degree, boolean fullTime,
        boolean inPerson, String pay, int hours, UUID orgID, ArrayList<String> skills, ArrayList<UUID> reviewIDs, ArrayList<UUID> applicantIDs) {
        this.id = id;
        this.job = job;
        this.degree = degree;
        this.fullTime = fullTime;
        this.inPerson = inPerson;
        this.pay = pay;
        this.hours = hours;
        this.orgID = orgID;
        this.skills = skills;
        this.reviewIDs = reviewIDs;
        this.applicantIDs = applicantIDs;
    }

    /**
     * gets the id of the student. 
     * @return the id of the student. 
     */
    public UUID getid() {
        return this.id;
    }

    /**
     * gets the job of the student. 
     * @return the job. 
     */
    public String getjob() {
        return this.job;
    }

    /**
     * gets the degree of the student. 
     * @return the degree. 
     */
    public String getdegree() {
        return this.degree;
    }

    /**
     * gets a boolean value of full time or not. 
     * @return true or false.
     */
    public boolean getfullTime() {
        return this.fullTime;
    }

    /**
     * gets a boolean value of in person or not. 
     * @return true or false.
     */
    public boolean getinPerson() {
        return this.inPerson;
    }

    /**
     * gets the pay of the internship.
     * @return the pay. 
     */
    public String getpay() {
        return this.pay;
    }

    /**
     * gets the hours. 
     * @return the hours. 
     */
    public int gethours() {
        return this.hours;
    }

    /**
     * gets the orgID.
     * @return the orgID.
     */
    public UUID getorgID() {
        return this.orgID;
    }

    /**
     * gets the skills of the students. 
     * @return the skills of the students. 
     */
    public ArrayList<String> getSkills() {
        return this.skills;
    }

    /**
     * gets the reviewIDs. 
     * @return the reviewIDs.
     */
    public ArrayList<UUID> getreviewIDs() {
        return this.reviewIDs;
    }

    /**
     * gets the applicants IDs.
     * @return the applicants IDs. 
     */
    public ArrayList<UUID> getapplicantIDs() {
        return this.applicantIDs;
    }

    /**
     * adds a review to the ArrayList. 
     * @param review the review that is being added. 
     * @return null. 
     */
    public ArrayList<UUID> addReview(Review review) {
        return null;
    }

    /**
     * prints out all of the data. 
     */
    public String toString() {
        if(this.fullTime && this.inPerson){
            return "Job:" + this.job + "\nDegree: " + this.degree + "\nFull time: yes " + "\nIn Person: yes" + "\nPay: " + this.pay + "\nHours: " + this.hours + "\nSkills: " + this.skills;  
        }
        else if(this.fullTime && !this.inPerson) {
            return "Job:" + this.job + "\nDegree: " + this.degree + "\nFull time: yes " + "\nIn Person: no" + "\nPay: " + this.pay + "\nHours: " + this.hours + "\nSkills: " + this.skills;  
        }
        else if(!this.fullTime && this.inPerson) {
            return "Job:" + this.job + "\nDegree: " + this.degree + "\nFull time: no " + "\nIn Person: yes" + "\nPay: " + this.pay + "\nHours: " + this.hours + "\nSkills: " + this.skills;  
        }
        else
        {
            return "Job:" + this.job + "\nDegree: " + this.degree + "\nFull time: no " + "\nIn Person: no" + "\nPay: " + this.pay + "\nHours: " + this.hours + "\nSkills: " + this.skills;
        }

    }
    
}