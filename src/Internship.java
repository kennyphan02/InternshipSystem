import java.util.UUID;
import java.util.ArrayList;

public class Internship {

    private UUID id;
    private String job;
    private String degree;
    private boolean fullTime;
    private boolean inPerson;
    private int pay;
    private int hours;
    private Organization organization;
    private Experience experience;
    private ArrayList<Review> reviews;
    private ArrayList<Student> applicants;

    public Internship(String job, String degree, boolean fullTime, boolean inPerson, int pay, int hours, Experience experience) {
        this.id = UUID.randomUUID();
        this.job = job;
        this.degree = degree;
        this.fullTime = fullTime;
        this.inPerson = inPerson;
        this.pay = pay;
        this.hours = hours;
        this.experience = experience;
        this.reviews = new ArrayList<Review>();
        this.applicants = new ArrayList<Student>();
    }
    public Internship(UUID id, String job, String degree, boolean fullTime,
        boolean inPerson, int pay, int hours, Experience experience, ArrayList<Review> reviews, ArrayList<Student> applicants) {
        this.id = id;
        this.job = job;
        this.degree = degree;
        this.fullTime = fullTime;
        this.inPerson = inPerson;
        this.pay = pay;
        this.hours = hours;
        this.experience = experience;
        this.reviews = reviews;
        this.applicants = applicants;
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
    public int getpay() {
        return this.pay;
    }
    public int gethours() {
        return this.hours;
    }
    public Organization getorganization() {
        return this.organization;
    }
    public Experience getexperience() {
        return this.experience;
    }
    public ArrayList<Review> getreviews() {
        return this.reviews;
    }
    public ArrayList<Student> getapplicants() {
        return this.applicants;
    }

    public ArrayList<Review> addReview(Review review) {
        return null;
    }
    public String toString() {
        if(this.fullTime && this.inPerson){
            return this.job + "|" + this.degree + "|" + "Full Time" + "|" + "In Person" + "|" + this.pay + "|" + this.hours + "|" + this.experience + "|";  
        }
        else if(this.fullTime && !this.inPerson) {
            return this.job + "|" + this.degree + "|" + "Full Time" + "|" + "Remote" + "|" + this.pay + "|" + this.hours + "|" + this.experience + "|"; 
        }
        else if(!this.fullTime && this.inPerson) {
            return this.job + "|" + this.degree + "|" + "Part time" + "|" + "In Person" + "|" + this.pay + "|" + this.hours + "|" + this.experience + "|"; 
        }
        else
        {
            return this.job + "|" + this.degree + "|" + "Part time" + "|" + "Remote" + "|" + this.pay + "|" + this.hours + "|" + this.experience + "|";
        }

    }
    
}