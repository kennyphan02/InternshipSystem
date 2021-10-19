import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    //Need loaders for Student, Org, Resume, Internship, studentReviews, and internshipReviews
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> users = new ArrayList<Student>();
        return users;
    }

    public static ArrayList<Org> getOrgs() {
        ArrayList<Org> orgs = new ArrayList<Org>();
        return orgs;
    }

    public static ArrayList<Resume> getResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        return resumes;
    }

    public static ArrayList<Internship> getInternships() {
        ArrayList<Internship> internships = new ArrayList<Internship>();
        return internships;
    }

    public static ArrayList<studentReview> getStudentReviews() {
        ArrayList<studentReview> studentReviews = new ArrayList<studentReview>();
        return studentReviews;
    }

    public static ArrayList<internshipReview> getInternshipReviews() {
        ArrayList<internshipReview> internshipReviews = new ArrayList<internshipReviews>();
        return internshipReviews;
    }

}
