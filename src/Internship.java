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
    public ArrayList<Review> addReview(Review review) {
        return null;
    }
    public String toString() {
        return "";
    }
    
}