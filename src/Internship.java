import java.util.ArrayList;

public class Internship {

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