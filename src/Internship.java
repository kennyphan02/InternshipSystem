import java.util.UUID;
import java.util.ArrayList;

public class Internship {

    private UUID id;
    private String job;
    private String degree;
    private String partTime;
    private String fullTime;
    private String remote;
    private String inPerson;
    private int pay;
    private int hours;
    private Organization organization;
    private Experience experience;
    private Internship internship;
    private ArrayList<Review> review;
    private ArrayList<Student> applicants;

    public Internship() {
            this.job = job;
            this.degree = degree;
            this.partTime = partTime;
            this.fullTime = fullTime;
            this.remote = remote;
            this.inPerson = inPerson;
            this.pay = pay;
            this.hours = hours;
            this.organization = organization;
            this.experience = experience;
            this.applicants = applicants;
        }
    public Internship compareFilters(Internship internship) {
        return internship;
    }
    public String toString() {
        return "";
    }
    public ArrayList<Review> addReview(Review review) {
        return null;
    }
    
}