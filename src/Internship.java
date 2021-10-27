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
    public UUID getid() {
        return this.id;
    }
    public String getjob() {
        return this.job;
    }
    public String getdegree() {
        return this.degree;
    }
    public boolean getfullTime() {
        return this.fullTime;
    }
    public boolean getinPerson() {
        return this.inPerson;
    }
    public String getpay() {
        return this.pay;
    }
    public int gethours() {
        return this.hours;
    }
    public UUID getorgID() {
        return this.orgID;
    }
    public ArrayList<String> getSkills() {
        return this.skills;
    }
    public ArrayList<UUID> getreviewIDs() {
        return this.reviewIDs;
    }
    public ArrayList<UUID> getapplicantIDs() {
        return this.applicantIDs;
    }

    public ArrayList<UUID> addReview(Review review) {
        return null;
    }
    public String toString() {
        if(this.fullTime && this.inPerson){
            return this.job + "|" + this.degree + "|" + "Full Time" + "|" + "In Person" + "|" + this.pay + "|" + this.hours + "|" + this.skills + "|";  
        }
        else if(this.fullTime && !this.inPerson) {
            return this.job + "|" + this.degree + "|" + "Full Time" + "|" + "Remote" + "|" + this.pay + "|" + this.hours + "|" + this.skills + "|"; 
        }
        else if(!this.fullTime && this.inPerson) {
            return this.job + "|" + this.degree + "|" + "Part time" + "|" + "In Person" + "|" + this.pay + "|" + this.hours + "|" + this.skills + "|"; 
        }
        else
        {
            return this.job + "|" + this.degree + "|" + "Part time" + "|" + "Remote" + "|" + this.pay + "|" + this.hours + "|" + this.skills + "|";
        }

    }
    
}