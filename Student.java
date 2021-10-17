public class Student {
    private String user;
    private String pass;
    private String email;
    private String birthday;
    private String country;
    private Resume resume;
    private String college;
    private String language;
    private ArrayList<Internship> bookmarks;
    private ArrayList<Review> studentReviews;
    public Student(String user, String pass, String email, String birthday, String country, Resume resume, String college, String language){
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.resume = resume;
        this.college = college;
        this.language = language;
        bookmarks = new ArrayList<Internship>();
        studentReviews = new ArrayList<studentReviews>();
    }
    public boolean passwordCondition(){
        return false;
    }
    public void bookmarkInternship(){
        return;
    }
    public void removeBookmark(){
        return;
    }
    public void displayBookmarks(){
        return;
    }
    public void addInternshipReview(Internship internship, int rate, String comment){
        return;
    }
    public void removeInternshipReview(Internship internship){
        return;
    }
    public void applyInternship(Internship internship){
        return;
    }
    public void createStudentProfile(){
        return;
    }
    public String toString(){
        return "";
    }
}
