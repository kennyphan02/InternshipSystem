
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
    private String experience;
    private Internship internship;

    public Internship(String job, String degree, String partTime, String fullTime, 
        String remote, String inPerson, int pay, int hours, Organization organization, 
        String Experience, Internship internship) {
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
            this.internship = internship;
        }

    public String toString() {
        return "";
    }
    
}
