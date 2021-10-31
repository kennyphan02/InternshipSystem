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
    private ArrayList<UUID> bookmarkIDs;
    private ArrayList<UUID> reviewIDs;

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
     * @param language type ArrayList<String>
     */
    public Student(String user, String pass, String email, String birthday, String country, Resume resume, String college, ArrayList<String> language) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.resume = resume;
        this.college = college;
        this.language = language;
    }

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
     * @param language type ArrayList<String>
     */
    public Student(UUID id, String user, String pass, String email, String birthday, 
            String country, Resume resume, String college, ArrayList<String> language, ArrayList<UUID> bookmarks, ArrayList<UUID> reviews) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.resume = resume;
        this.college = college;
        this.language = language;
        this.bookmarkIDs = bookmarks;
        this.reviewIDs = reviews;
    }


    /**
     * Gets the UUID for the student.
     * @return The UUID for the student.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the username of the student.
     * @return The username of the student.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets the password of the student.
     * @return The password of the student.
     */
    public String getPassword() {
        return pass;
    }
    
    /**
     * Gets the email of the student.
     * @return The email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the birth date of the student.
     * @return The birth date of the student.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Gets the country of origin of the student.
     * @return The country of origin of the student.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the resume of the student.
     * @return The resume of the student.
     */
    public Resume getResume() {
        return resume;
    }

    /**
     * Gets the college that the student attends.
     * @return The college that the students attends.
     */
    public String getCollege() {
        return college;
    }

    /**
     * Gets the languages the student speaks.
     * @return The languages the student speaks.
     */
    public ArrayList<String> getLanguage() {
        return language;
    }

    /**
     * Gets the internships the student has bookmarked.
     * @return The internships the student has bookmarked.
     */
    public ArrayList<UUID> getBookmarks() {
        return bookmarkIDs;
    }

    /**
     * Gets the reviews of the student left by employers.
     * @return The reviews of the student left by employers.
     */
    public ArrayList<UUID> getReview() {
        return reviewIDs;
    }

    public String toString() {
        return "User Name: " + user + "\n" + "Password: " + pass + "\n" + "Email: " + email + "\n" + "Birthday: " + birthday + "\n"
            + "Country: " + country + "\n" + "College: " + college + "\n" + "Languages: " + language.toString() + "\n" + "Bookmarked Internships: " + bookmarkIDs.size() + "\n" + "Reviews: " + reviewIDs.size();
    }
}
