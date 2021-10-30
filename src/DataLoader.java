import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Hold operations for instances of Students
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class DataLoader extends DataConstants {

    //Loads data from JSON file into array list
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
                UUID id = UUID.fromString((String)studentJSON.get(STUDENT_UUID));
                String user = (String)studentJSON.get(STUDENT_USER_NAME);
                String pass = (String)studentJSON.get(STUDENT_PASSWORD);
                String email = (String)studentJSON.get(STUDENT_EMAIL);
                String birthday = (String)studentJSON.get(STUDENT_BIRTHDAY);
                String country = (String)studentJSON.get(STUDENT_COUNTRY);
                UUID resumeID = UUID.fromString((String) studentJSON.get(STUDENT_RESUME));
                Resumes resSingleton = Resumes.getInstance();
                Resume resume = resSingleton.getResume(resumeID);
                String college = (String)studentJSON.get(STUDENT_COLLEGE);
                JSONArray language = (JSONArray)studentJSON.get(STUDENT_LANGUAGES);
                ArrayList<String> languages = arrToListStr(language);
                JSONArray bookmarkArr = (JSONArray)studentJSON.get(STUDENT_BOOKMARKS);
                ArrayList<UUID> bookmarks = arrToListUUID(bookmarkArr);
                JSONArray reviewArr = (JSONArray)studentJSON.get(STUDENT_REVIEWS);
                ArrayList<UUID> reviews = arrToListUUID(reviewArr);
                //Add new object to Singleton
                students.add(new Student(id, user, pass, email, birthday,
                    country, resume, college, languages, bookmarks, reviews));
            }
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Loads data from JSON file into array list
    public static ArrayList<Organization> getOrgs() {
        ArrayList<Organization> orgs = new ArrayList<Organization>();
        try {
            FileReader reader = new FileReader(ORG_FILE_NAME);
            
            JSONArray orgsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < orgsJSON.size(); i++) {
                JSONObject orgJSON = (JSONObject)orgsJSON.get(i);
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
                Internships internshipsSingleton = Internships.getInstance();
                ArrayList<Internship> internships = new ArrayList<Internship>();
                for(int j = 0; j < internshipIDs.size(); j++) {
                    internships.add(internshipsSingleton.getInternship(internshipIDs.get(j)));
                }

                orgs.add(new Organization(id, user, pass, email, country, orgName, phoneNum, description, internships));
            }
            return orgs;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Loads data from JSON file into array list
    public static ArrayList<Resume> getResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        try {
            FileReader reader = new FileReader(RESUME_FILE_NAME);
            
            JSONArray resumesJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < resumesJSON.size(); i++) {
                JSONObject resumeJSON = (JSONObject) resumesJSON.get(i);
                UUID id = UUID.fromString((String) resumeJSON.get(RESUME_UUID));
                JSONArray skillsJSON = (JSONArray) resumeJSON.get(RESUME_SKILLS);
                ArrayList<String> skills = arrToListStr(skillsJSON);
                JSONArray experiences = (JSONArray) resumeJSON.get(RESUME_EXPERIENCE);
                ArrayList<Experience> experience = new ArrayList<Experience>();
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
                
                resumes.add(new Resume(id, skills, experience, education, language));
            }
            return resumes;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Loads data from JSON file into array list
    public static ArrayList<Internship> getInternships() {
        ArrayList<Internship> internships = new ArrayList<Internship>();
        try {
            FileReader reader = new FileReader(INTERNSHIP_FILE_NAME);
            
            JSONArray internshipsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < internshipsJSON.size(); i++) {
                JSONObject internshipJSON = (JSONObject)internshipsJSON.get(i);
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

                internships.add(new Internship(id, job, degree, fullTime, inPerson, pay, hours, orgID, skills, reviewIDs, applicantIDs));
            }
            return internships;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Loads data from JSON file into array list
    public static ArrayList<Review> getStudentReviews() {
        ArrayList<Review> studentReviews = new ArrayList<Review>();
        try {
            FileReader reader = new FileReader(STUDENT_REVIEW_FILE_NAME);
            
            JSONArray studentReviewsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < studentReviewsJSON.size(); i++) {
                JSONObject studentReviewJSON = (JSONObject)studentReviewsJSON.get(i);
                UUID id = UUID.fromString((String) studentReviewJSON.get(REVIEW_UUID));
                String title = (String) studentReviewJSON.get(REVIEW_TITLE);
                String comment = (String) studentReviewJSON.get(REVIEW_COMMENT);
                int rating = ((Long) studentReviewJSON.get(REVIEW_RATING)).intValue();

                studentReviews.add(new Review(id, title, comment, rating));
            }
            return studentReviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Loads data from JSON file into array list
    public static ArrayList<Review> getInternshipReviews() {
        ArrayList<Review> internshipReviews = new ArrayList<Review>();
        try {
            FileReader reader = new FileReader(INTERNSHIP_REVIEW_FILE_NAME);
            
            JSONArray internshipReviewsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < internshipReviewsJSON.size(); i++) {
                JSONObject internshipReviewJSON = (JSONObject)internshipReviewsJSON.get(i);
                UUID id = UUID.fromString((String) internshipReviewJSON.get(REVIEW_UUID));
                String title = (String) internshipReviewJSON.get(REVIEW_TITLE);
                String comment = (String) internshipReviewJSON.get(REVIEW_COMMENT);
                int rating = ((Long) internshipReviewJSON.get(REVIEW_RATING)).intValue();

                internshipReviews.add(new Review(id, title, comment, rating));
            }
            return internshipReviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Takes in String type JSONArray objects into ArrayLists
    private static ArrayList<String> arrToListStr(JSONArray arr) {
        ArrayList<String> ret = new ArrayList<String>();
        for(int i = 0; i < arr.size(); i++) {
            ret.add(arr.get(i).toString());
        }
        return ret;
    }

    //Takes in UUID type JSONArray objects into ArrayLists
    private static ArrayList<UUID> arrToListUUID(JSONArray arr) {
        ArrayList<UUID> ret = new ArrayList<UUID>();
        for(int i = 0; i < arr.size(); i++) {
            UUID id = UUID.fromString(arr.get(i).toString());
            ret.add(id);
        }
        return ret;
    }
}
