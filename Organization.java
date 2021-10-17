import java.util.ArrayList;

public class Organization {
    private String user;
    private String pass;
    private String email;
    private String country;
    private String orgName;
    private ArrayList<Internship> internship; // internship class will have internshipreview 
    private ArrayList<Student> students;
    public Organization(String user, Srtring pass, String email, String country, String orgNames){
        this.user = user;
        this.pass = pass;
        this.emai = email;
        this.country = country;
        this.orgName = orgName;
        internship = new ArrayList<Internship>();
        students = new ArrayList<Student>();
    }
    public void addInternship(Internship internship){
        return;
    }
    public void removeInternship(Internship internship){
        return;
    }
    public void editInternship(Internship internship){
        return;
    }
    public ArrayList<Student> viewProfiles(){
        return students;
    }
    public Student searchStudent(ArrayList<Student> studentList){
        return studentList.get(0);
    }
    public void addStudent(Student student){
        return;
    }
    public void removeStudent(Student student){
        return;
    }
    public void addStudentReview(Student student, Review review){
        return;
    }
    public String toString(){
        
    }
}
