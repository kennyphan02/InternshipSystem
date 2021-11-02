import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Extracts data from project JSON files and formats them as class instances for loading into ArrayLists
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class DataLoader extends DataConstants {

    /**
     * Reads in the student.JSON file and performs a series of operations to translate the data for each entry in the file into its own instance of the Student class, adding each instance to a master ArrayList
     * @return an ArrayList of Student instances, each containing the data found in an individual entry of student.JSON
     */
    public static ArrayList<Student> getStudents() {
        // Define this method's internal ArrayList of Student objects to be returned
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            // Open file with FileReader
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            // Parse the file and convert it to a JSONArray
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);

            // Start a for loop that runs over every entry in the JSONArray
            for(int i = 0; i < studentsJSON.size(); i++) {
                // Take the current entry in the JSONArray and cast it to an individual JSONObject
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
                // Get all the data from this JSONObject using the attribute access Strings defined in DataConstants.java
                UUID id = UUID.fromString((String)studentJSON.get(STUDENT_UUID));
                String user = (String)studentJSON.get(STUDENT_USER_NAME);
                String pass = (String)studentJSON.get(STUDENT_PASSWORD);
                String email = (String)studentJSON.get(STUDENT_EMAIL);
                String birthday = (String)studentJSON.get(STUDENT_BIRTHDAY);
                String country = (String)studentJSON.get(STUDENT_COUNTRY);
                UUID resumeID = UUID.fromString((String) studentJSON.get(STUDENT_RESUME));
                // For assigning the Resume attribute we call upon the Resumes singleton and run a UUID match
                Resumes resSingleton = Resumes.getInstance();
                Resume resume = resSingleton.getResume(resumeID);
                String college = (String)studentJSON.get(STUDENT_COLLEGE);
                JSONArray language = (JSONArray)studentJSON.get(STUDENT_LANGUAGES);
                ArrayList<String> languages = arrToListStr(language);
                JSONArray bookmarkArr = (JSONArray)studentJSON.get(STUDENT_BOOKMARKS);
                ArrayList<UUID> bookmarks = arrToListUUID(bookmarkArr);
                JSONArray reviewArr = (JSONArray)studentJSON.get(STUDENT_REVIEWS);
                ArrayList<UUID> reviews = arrToListUUID(reviewArr);
                // Construct new Student object with all these retrieved attributes and add it to this Method's ArrayList
                students.add(new Student(id, user, pass, email, birthday,
                    country, resume, college, languages, bookmarks, reviews));
            }
            // At the conclusion of the loop, return this method's ArrayList
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads in the org.JSON file and performs a series of operations to translate the data for each entry in the file into its own instance of the Organization class, adding each instance to a master ArrayList
     * @return an ArrayList of Organization instances, each containing the data found in an individual entry of org.JSON
     */
    public static ArrayList<Organization> getOrgs() {
        // Define this method's internal ArrayList of Organization objects to be returned
        ArrayList<Organization> orgs = new ArrayList<Organization>();
        try {
            // Open file with FileReader
            FileReader reader = new FileReader(ORG_FILE_NAME);
            // Parse the file and convert it to a JSONArray
            JSONArray orgsJSON = (JSONArray) new JSONParser().parse(reader);

            //Start a for loop that runs over every entry in the JSONArray
            for(int i = 0; i < orgsJSON.size(); i++) {
                // Take the current JSONArray index and cast it to a JSONObject
                JSONObject orgJSON = (JSONObject)orgsJSON.get(i);
                // Get all the data from this JSONObject using the attribute accessor Strings defined in DataConstants.java
                UUID id = UUID.fromString((String) orgJSON.get(ORG_UUID));
                String user = (String) orgJSON.get(ORG_USERNAME);
                String pass = (String) orgJSON.get(ORG_PASSWORD);
                String email = (String) orgJSON.get(ORG_EMAIL);
                String country = (String) orgJSON.get(ORG_COUNTRY);
                String orgName = (String) orgJSON.get(ORG_NAME);
                String phoneNum = (String) orgJSON.get(ORG_PHONE_NUM);
                String description = (String) orgJSON.get(ORG_DESCRIPTION);
                JSONArray internshipIDsarr = (JSONArray) orgJSON.get(ORG_INTERNSHIPS);
                ArrayList<UUID> internshipIDs = arrToListUUID(internshipIDsarr);
                // For assigning the Internship attribute we call the Internships singleton and run a UUID match
                Internships internshipsSingleton = Internships.getInstance();
                ArrayList<Internship> internships = new ArrayList<Internship>();
                for(int j = 0; j < internshipIDs.size(); j++) {
                    internships.add(internshipsSingleton.getInternship(internshipIDs.get(j)));
                }
                // Construct a new Organization object with all retrieved attributes and add it to this Method's ArrayList
                orgs.add(new Organization(id, user, pass, email, country, orgName, phoneNum, description, internships));
            }
            // Return the method's ArrayList at the conclusion of the processing loop
            return orgs;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads in the Resume.JSON file and performs a series of operations to translate the data for each entry in the file into its own instance of the Resume class, adding each instance to a master ArrayList
     * @return an ArrayList of Resume instances, each containing the data found in an individual entry of Resume.JSON
     */
    public static ArrayList<Resume> getResumes() {
        // Define this method's internal ArrayList of Resume objects to be returned
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        try {
            // Open the file with FileReader
            FileReader reader = new FileReader(RESUME_FILE_NAME);
            // Parse the file and convert it to a JSONArray
            JSONArray resumesJSON = (JSONArray) new JSONParser().parse(reader);

            // Start a for loop that runs over every entry in the JSONArray
            for(int i = 0; i < resumesJSON.size(); i++) {
                // Take the current index in the JSON Array and cast it to an individual JSONObject
                JSONObject resumeJSON = (JSONObject) resumesJSON.get(i);
                // Get all the data from this JSONObject using the attribute Strings defined in DataConstants.java
                UUID id = UUID.fromString((String) resumeJSON.get(RESUME_UUID));
                JSONArray skillsJSON = (JSONArray) resumeJSON.get(RESUME_SKILLS);
                ArrayList<String> skills = arrToListStr(skillsJSON);
                JSONArray experiences = (JSONArray) resumeJSON.get(RESUME_EXPERIENCE);
                ArrayList<Experience> experience = new ArrayList<Experience>();
                // Assigning Experience requires a nested processing loop of its own
                for(int j = 0; j < experiences.size(); j++) {
                    JSONObject experienceJSON = (JSONObject)experiences.get(j);
                    String title = (String)experienceJSON.get(EXP_TITLE);
                    String company = (String)experienceJSON.get(EXP_COMPANY);
                    String startDate = (String)experienceJSON.get(EXP_START_DATE);
                    String endDate = (String)experienceJSON.get(EXP_END_DATE);
                    JSONArray responsibilitiesArr = (JSONArray) experienceJSON.get(EXP_RESPONSIBILITIES);
                    ArrayList<String> responsibilities = arrToListStr(responsibilitiesArr);
                    experience.add(new Experience(title, company, startDate, endDate, responsibilities));
                }
                JSONObject educationJSON = (JSONObject) resumeJSON.get(RESUME_EDUCATION);
                String eduUni = (String)educationJSON.get(EDU_UNI);
                String eduDegree = (String)educationJSON.get(EDU_DEGREE);
                String eduGradDate = (String)educationJSON.get(EDU_GRAD_DATE);
                Education education = new Education(eduUni, eduDegree, eduGradDate);
                JSONArray languagesJSON = (JSONArray) resumeJSON.get(RESUME_LANGUAGES);
                ArrayList<String> language = arrToListStr(languagesJSON);
                // Construct a new Resume object with all retrieved attributes and add it to this method's ArrayList
                resumes.add(new Resume(id, skills, experience, education, language));
            }
            // Return this method's ArrayList at the conclusion of the loop
            return resumes;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads in the internship.JSON file and performs a series of operations to translate the data for each entry in the file into its own instance of the Internship class, adding each instance to a master ArrayList
     * @return an ArrayList of Internship instances, each containing the data found in an individual entry of internship.JSON
     */
    public static ArrayList<Internship> getInternships() {
        // Define this method's internal ArrayList of Internship objects to be returned
        ArrayList<Internship> internships = new ArrayList<Internship>();
        try {
            // Open the file with FileReader
            FileReader reader = new FileReader(INTERNSHIP_FILE_NAME);
            // Parse the file and convert it to a JSONArray
            JSONArray internshipsJSON = (JSONArray) new JSONParser().parse(reader);

            // Start a for loop that runs over every entry in the JSONArray
            for(int i = 0; i < internshipsJSON.size(); i++) {
                // Take the current index of the JSONArray and cast it to an individual JSONObject
                JSONObject internshipJSON = (JSONObject)internshipsJSON.get(i);
                // Get all the data from this JSONObject using the attribute access strings defined in DataConstants.java
                UUID id = UUID.fromString((String) internshipJSON.get(INTERNSHIP_UUID));
                String job = (String) internshipJSON.get(INTERNSHIP_JOB);
                String degree = (String) internshipJSON.get(INTERNSHIP_DEGREE);
                boolean fullTime = (boolean) internshipJSON.get(INTERNSHIP_FULL_TIME);
                boolean inPerson = (boolean) internshipJSON.get(INTERNSHIP_IN_PERSON);
                String pay = (String) internshipJSON.get(INTERNSHIP_PAY);
                int hours = ((Long) internshipJSON.get(INTERNSHIP_HOURS)).intValue();
                UUID orgID = UUID.fromString((String) internshipJSON.get(INTERNSHIP_ORG_ID));
                JSONArray skillsArr = (JSONArray) internshipJSON.get(INTERNSHIP_SKILLS);
                ArrayList<String> skills = arrToListStr(skillsArr);
                JSONArray reviewArr = (JSONArray) internshipJSON.get(INTERNSHIP_REVIEWS);
                ArrayList<UUID> reviewIDs = arrToListUUID(reviewArr);
                JSONArray applicantArr = (JSONArray) internshipJSON.get(INTERNSHIP_APPLICANTS);
                ArrayList<UUID> applicantIDs = arrToListUUID(applicantArr);
                // Construct a new Internship object with all the retrieved attributes and add it to this method's ArrayList
                internships.add(new Internship(id, job, degree, fullTime, inPerson, pay, hours, orgID, skills, reviewIDs, applicantIDs));
            }
            // Return this method's ArrayList at the conclusion of the loop
            return internships;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads in the studentReviews.JSON file and performs a series of operations to translate the data for each entry in the file into its own instance of the Review class, adding each instance to a master ArrayList
     * @return an ArrayList of Review instances, each containing the data found in an individual entry of studentReviews.JSON
     */
    public static ArrayList<Review> getStudentReviews() {
        // Define this method's internal ArrayList of Review objects to be returned
        ArrayList<Review> studentReviews = new ArrayList<Review>();
        try {
            // Open the file with FileReader
            FileReader reader = new FileReader(STUDENT_REVIEW_FILE_NAME);
            // Parse the file and convert it to a JSONArray
            JSONArray studentReviewsJSON = (JSONArray) new JSONParser().parse(reader);

            // Start a for loop that iterates over every entry in the JSONArray  
            for(int i = 0; i < studentReviewsJSON.size(); i++) {
                // For the current index of the JSONArray, cast it to a JSONObject
                JSONObject studentReviewJSON = (JSONObject)studentReviewsJSON.get(i);
                // Get the attributes of that object using the attribute access Strings defined in DataConstants.java
                UUID id = UUID.fromString((String) studentReviewJSON.get(REVIEW_UUID));
                String title = (String) studentReviewJSON.get(REVIEW_TITLE);
                String comment = (String) studentReviewJSON.get(REVIEW_COMMENT);
                int rating = ((Long) studentReviewJSON.get(REVIEW_RATING)).intValue();
                // Construct a new Review object using the obtained attributes and add it to this method's ArrayList
                studentReviews.add(new Review(id, title, comment, rating));
            }
            // Return this method's ArrayList at the conclusion of the loop
            return studentReviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads in the internshipReviews.JSON file and performs a series of operations to translate the data for each entry in the file into its own instance of the Review class, adding each instance to a master ArrayList
     * @return an ArrayList of Review instances, each containing the data found in an individual entry of internshipReview.JSON
     */
    public static ArrayList<Review> getInternshipReviews() {
        // Define this method's internal ArrayList of Review objects to be returned
        ArrayList<Review> internshipReviews = new ArrayList<Review>();
        try {
            // Open file with FileReader 
            FileReader reader = new FileReader(INTERNSHIP_REVIEW_FILE_NAME);
            // Parse the file and convert it to a JSONArray
            JSONArray internshipReviewsJSON = (JSONArray) new JSONParser().parse(reader);

            // Start a for loop that iterates over every entry in the JSONArray
            for(int i = 0; i < internshipReviewsJSON.size(); i++) {
                // For each index of the JSONArray, cast it to a JSONObject
                JSONObject internshipReviewJSON = (JSONObject)internshipReviewsJSON.get(i);
                // Get the attributes of that JSONObject using the access Strings defined in DataConstants.java
                UUID id = UUID.fromString((String) internshipReviewJSON.get(REVIEW_UUID));
                String title = (String) internshipReviewJSON.get(REVIEW_TITLE);
                String comment = (String) internshipReviewJSON.get(REVIEW_COMMENT);
                int rating = ((Long) internshipReviewJSON.get(REVIEW_RATING)).intValue();
                // Construct a new Review object with all retrieved attributes and add it to this method's ArrayList
                internshipReviews.add(new Review(id, title, comment, rating));
            }
            // Return this method's ArrayList at the conclusion of the loop
            return internshipReviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Converts a JSONArray object into an ArrayList of Strings
     * @param arr the JSONArray to be converted into an ArrayList<String>
     * @return an ArrayList with the contents of the passed JSONArray, cast as Strings
     */
    private static ArrayList<String> arrToListStr(JSONArray arr) {
        ArrayList<String> ret = new ArrayList<String>();
        for(int i = 0; i < arr.size(); i++) {
            ret.add(arr.get(i).toString());
        }
        return ret;
    }

    /**
     * Converts a JSONArray object into an ArrayList of UUID objects
     * @param arr the JSONArray to be converted into an ArrayList<UUID>
     * @return an ArrayList with the contents of the passed JSONArray, cast as UUID objects
     */
    private static ArrayList<UUID> arrToListUUID(JSONArray arr) {
        ArrayList<UUID> ret = new ArrayList<UUID>();
        for(int i = 0; i < arr.size(); i++) {
            UUID id = UUID.fromString(arr.get(i).toString());
            ret.add(id);
        }
        return ret;
    }
}
