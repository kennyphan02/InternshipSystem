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
        return id;
    }
    public String getjob() {
        return job;
    }
    public String getdegree() {
        return degree;
    }
    public boolean getfullTime() {
        return fullTime;
    }
    public boolean getinPerson() {
        return inPerson;
    }
    public int getpay() {
        return pay;
    }
    public int gethours() {
        return hours;
    }
    public Organization getorganization() {
        return organization;
    }
    public Experience getexperience() {
        return experience;
    }
    public ArrayList<Review> getreviews() {
        return reviews;
    }
    public ArrayList<Student> getapplicants() {
        return applicants;
    }

    public ArrayList<Review> addReview(Review review) {
        return null;
    }
    public String toString() {
        return "";
    }
    
}