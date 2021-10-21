import java.util.UUID;
import java.util.ArrayList;

public class Student extends User {

    private UUID id;
    private String user;
    private String pass;
    private String email;
    private String birthday;
    private String country;
    private Resume resume;
    private String college;
    private ArrayList<String> language;
    private ArrayList<Internship> bookmarks;
    private ArrayList<Review> reviews;

    /** 
     * Default constructor that initalizes the private variables in the Student class. Bookmarks are initalized to an arraylist of internships.
     * StudentReviews are initalized to an arraylist of review.
     * @param user type String
     * @param pass type String
     * @param email type String
     * @param birthday type String
     * @param country type String
     * @param resume type Resume
     * @param college type String
     * @param language type String
     */
    public Student(String user, String pass, String email, String birthday, 
            String country, Resume resume, String college, ArrayList<String> language) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.resume = resume;
        this.college = college;
        this.language = language;
        bookmarks = new ArrayList<Internship>();
        reviews = new ArrayList<Review>();
    }
    public Student(UUID id, String user, String pass, String email, String birthday, 
            String country, Resume resume, String college, ArrayList<String> language, ArrayList<Internship> bookmarks, ArrayList<Review> reviews) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.resume = resume;
        this.college = college;
        this.language = language;
        this.bookmarks = bookmarks;
        this.reviews = reviews;
    }

    public boolean passwordCondition() {
        return false;
    }

    public void bookmarkInternship() {
        return;
    }

    public void removeBookmark() {
        return;
    }

    public void displayBookmarks() {
        return;
    }

    public void addInternshipReview(Internship internship, int rate, String comment) {
        return;
    }

    public void removeInternshipReview(Internship internship) {
        return;
    }

    public void applyInternship(Internship internship) {
        return;
    }

    public void createStudentProfile() {
        return;
    }

    public String toString() {
        return "";
    }

    public UUID getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return pass;
    }
    
    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCountry() {
        return country;
    }

    public Resume getResume() {
        return resume;
    }

    public String getCollege() {
        return college;
    }

    public ArrayList<String> getLanguage() {
        return language;
    }

    public ArrayList<Internship> getBookmarks() {
        return bookmarks;
    }

    public ArrayList<Review> getReview() {
        return reviews;
    }
}
