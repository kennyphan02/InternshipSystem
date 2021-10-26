import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    //Need loaders for Student, Org, Resume, Internship, studentReviews, and internshipReviews
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
                UUID id = UUID.fromString((String)studentJSON.get(STUDENT_UUID));
                String user = (String)studentJSON.get(STUDENT_USER_NAME);
                String pass = (String)studentJSON.get(STUDENT_PASSWORD);
                String email = (String)studentJSON.get(STUDENT_EMAIL);
                String birthday = (String)studentJSON.get(STUDENT_BIRTHDAY);
                String country = (String)studentJSON.get(STUDENT_COUNTRY);
                Resumes resSingleton = Resumes.getInstance();
                Resume resume = resSingleton.getResume(id);
                String college = (String)studentJSON.get(STUDENT_COLLEGE);
                String[] language = (String[])studentJSON.get(STUDENT_LANGUAGES);
                ArrayList<String> languages = new ArrayList<String>(Arrays.asList(language));
                UUID[] bookmarkArr = (UUID[])studentJSON.get(STUDENT_BOOKMARKS);
                ArrayList<UUID> bookmarks = new ArrayList<UUID>(Arrays.asList(bookmarkArr));
                UUID[] reviewArr = (UUID[])studentJSON.get(STUDENT_REVIEWS);
                ArrayList<UUID> reviews = new ArrayList<UUID>(Arrays.asList(reviewArr));
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

    public static ArrayList<Organization> getOrgs() {
        ArrayList<Organization> orgs = new ArrayList<Organization>();
        try {
            FileReader reader = new FileReader(ORG_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray orgsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < orgsJSON.size(); i++) {
                JSONObject orgJSON = (JSONObject)orgsJSON.get(i);

                //Add new object to Singleton
            }
            return orgs;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Resume> getResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        try {
            FileReader reader = new FileReader(RESUME_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray resumesJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < resumesJSON.size(); i++) {
                JSONObject resumeJSON = (JSONObject) resumesJSON.get(i);
                UUID id = UUID.fromString((String) resumeJSON.get(RESUME_UUID));
                ArrayList<String> skills = parseFromArr(resumeJSON.skills);
                JSONArray experiences = (JSONArray) resumeJSON.get(RESUME_EXPERIENCE);
                ArrayList<Experience> experience = new ArrayList<Experience>();
                for(int j = 0; j < experiences.size(); j++) {
                    JSONObject experienceJSON = (JSONObject)experiences.get(j);
                    String title = (String)experienceJSON.get(EXP_TITLE);
                    String company = (String)experienceJSON.get(EXP_COMPANY);
                    String startDate = (String)experienceJSON.get(EXP_START_DATE);
                    String endDate = (String)experienceJSON.get(EXP_END_DATE);
                    String[] responsibilitiesArr = (String[]) experienceJSON.get(EXP_RESPONSIBILITIES);
                    ArrayList<String> responsibilities = new ArrayList<String>(Arrays.asList(responsibilitiesArr));
                    experience.add(new Experience(title, company, startDate, endDate, responsibilities));
                }
                JSONObject educationJSON = (JSONObject) resumeJSON.get(RESUME_EDUCATION);
                String eduUni = (String)educationJSON.get(EDU_UNI);
                String eduDegree = (String)educationJSON.get(EDU_DEGREE);
                String eduGradDate = (String)educationJSON.get(EDU_GRAD_DATE);
                Education education = new Education(eduUni, eduDegree, eduGradDate);
                String[] langArr = (String[]) resumeJSON.get(RESUME_LANGUAGES);
                ArrayList<String> language = new ArrayList<String>(Arrays.asList(langArr));
                
                resumes.add(new Resume(skills, experience, education, language));
            }
            return resumes;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Internship> getInternships() {
        ArrayList<Internship> internships = new ArrayList<Internship>();
        try {
            FileReader reader = new FileReader(INTERNSHIP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray internshipsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < internshipsJSON.size(); i++) {
                JSONObject internshipJSON = (JSONObject)internshipsJSON.get(i);

                //Add new object to Singleton
            }
            return internships;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Review> getStudentReviews() {
        ArrayList<Review> studentReviews = new ArrayList<Review>();
        try {
            FileReader reader = new FileReader(STUDENT_REVIEW_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentReviewsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < studentReviewsJSON.size(); i++) {
                JSONObject studentReviewJSON = (JSONObject)studentReviewsJSON.get(i);

                //Add new object to Singleton
            }
            return studentReviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Review> getInternshipReviews() {
        ArrayList<Review> internshipReviews = new ArrayList<Review>();
        try {
            FileReader reader = new FileReader(INTERNSHIP_REVIEW_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray internshipReviewsJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i < internshipReviewsJSON.size(); i++) {
                JSONObject internshipReviewJSON = (JSONObject)internshipReviewsJSON.get(i);

                //Add new object to Singleton
            }
            return internshipReviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<String> parseFromArr(JSONObject jObj){
        ArrayList<String> ret = new ArrayList<String>();
        for(int i = 0; i < jArr.size(); i++) {
            ret.add(jArr[i]
/        }
    }
}
