import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Hold operations for instances of Students
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class DataWriter extends DataConstants {
    
    // 
    public static void saveStudents() {
		Students students = Students.getInstance();
		ArrayList<Student> studentList = students.getStudentsList();
		JSONArray jsonStudents = new JSONArray();
		
		for(int i=0; i< studentList.size(); i++) {
			jsonStudents.add(getStudentJSON(studentList.get(i)));

		}
		
        try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
 
            file.write(jsonStudents.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getStudentJSON(Student student) {
		JSONObject studentDetails = new JSONObject();
		studentDetails.put(STUDENT_UUID, student.getId().toString());
		studentDetails.put(STUDENT_USER_NAME, student.getUser());
		studentDetails.put(STUDENT_BIRTHDAY, student.getBirthday());
        studentDetails.put(STUDENT_PASSWORD, student.getPassword());
        studentDetails.put(STUDENT_EMAIL, student.getEmail());
        studentDetails.put(STUDENT_BIRTHDAY, student.getBirthday());
        studentDetails.put(STUDENT_COUNTRY, student.getCountry());
        studentDetails.put(STUDENT_RESUME, student.getResume());
        studentDetails.put(STUDENT_COLLEGE, student.getCollege());
        studentDetails.put(STUDENT_LANGUAGES, student.getLanguage());
        studentDetails.put(STUDENT_BOOKMARKS, student.getBookmarks());
        studentDetails.put(STUDENT_REVIEWS, student.getReview());
        
        return studentDetails;
	}

    /**
     * 
     */

    public static void saveOrganization() {
		Organizations organizations = Organizations.getInstance();
		ArrayList<Organization> orgList = organizations.getOrganizationsList();
		JSONArray jsonOrganizations = new JSONArray();
		
		for(int i=0; i< orgList.size(); i++) {
			jsonOrganizations.add(getOrganizationJSON(orgList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(ORG_FILE_NAME)) {
 
            file.write(jsonOrganizations.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getOrganizationJSON(Organization organization) {
		JSONObject orgDetails = new JSONObject();
		orgDetails.put(ORG_UUID, organization.getId().toString());
		orgDetails.put(ORG_USERNAME, organization.getUser());
        orgDetails.put(ORG_PASSWORD, organization.getPassword());
        orgDetails.put(ORG_EMAIL, organization.getEmail());
        orgDetails.put(ORG_COUNTRY, organization.getCountry());
        orgDetails.put(ORG_NAME, organization.getOrgName());
        orgDetails.put(ORG_PHONE_NUM, organization.getPhoneNumber());
        orgDetails.put(ORG_DESCRIPTION, organization.getDesc());
        orgDetails.put(ORG_INTERNSHIPS, organization.getInternships());
        
        return orgDetails;
	}

    /**
     * 
     */
    
    public static void saveInternship() {
		Internships internships = Internships.getInstance();
		ArrayList<Internship> internshipList = internships.getInternshipsList();
		JSONArray jsonInternships = new JSONArray();
		
		for(int i=0; i< internshipList.size(); i++) {
			jsonInternships.add(getInternshipJSON(internshipList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(INTERNSHIP_FILE_NAME)) {
 
            file.write(jsonInternships.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getInternshipJSON(Internship internship) {
		JSONObject internshipDetails = new JSONObject();
		internshipDetails.put(INTERNSHIP_UUID, internship.getid().toString());
		internshipDetails.put(INTERNSHIP_JOB, internship.getjob());
        internshipDetails.put(INTERNSHIP_DEGREE, internship.getdegree());
        internshipDetails.put(INTERNSHIP_FULL_TIME, internship.getfullTime());
        internshipDetails.put(INTERNSHIP_IN_PERSON, internship.getinPerson());
        internshipDetails.put(INTERNSHIP_PAY, internship.getpay());
        internshipDetails.put(INTERNSHIP_HOURS, internship.gethours());
        internshipDetails.put(INTERNSHIP_ORG_ID, internship.getorgID().toString());
        internshipDetails.put(INTERNSHIP_SKILLS, internship.getSkills());
        ArrayList<String> reviewIdStr = UUIDArrtoStrArr(internship.getreviewIDs());
        internshipDetails.put(INTERNSHIP_REVIEWS, reviewIdStr);
        ArrayList<String> applicantIdStr = UUIDArrtoStrArr(internship.getapplicantIDs());
        internshipDetails.put(INTERNSHIP_APPLICANTS, applicantIdStr);
        
        return internshipDetails;
	}

    /**
     * 
     */
    
    public static void saveResume() {
		Resumes resumes = Resumes.getInstance();
		ArrayList<Resume> resumeList = resumes.getResumesList();
		JSONArray jsonResumes = new JSONArray();
		
		for(int i=0; i< resumeList.size(); i++) {
			jsonResumes.add(getResumeJSON(resumeList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(RESUME_FILE_NAME)) {
 
            file.write(jsonResumes.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getResumeJSON(Resume resume) {
		JSONObject resumeDetails = new JSONObject();
		resumeDetails.put(RESUME_UUID, resume.getid().toString());
        resumeDetails.put(RESUME_SKILLS, resume.getSkills());
        resumeDetails.put(RESUME_EDUCATION, resume.geteducation());
        resumeDetails.put(RESUME_EXPERIENCE, resume.getexperience());
        resumeDetails.put(RESUME_LANGUAGES, resume.getlanguage());
        
        return resumeDetails;
	}

    /**
     * 
     */

    public static void saveInternshipReview() {
		internshipReviews iReviews = internshipReviews.getInstance();
		ArrayList<Review> iReviewList = iReviews.getinternshipReviewsList();
		JSONArray jsonIReviews = new JSONArray();
		
		for(int i=0; i< iReviewList.size(); i++) {
			jsonIReviews.add(getInternshipReviewJSON(iReviewList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(INTERNSHIP_REVIEW_FILE_NAME)) {
 
            file.write(jsonIReviews.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getInternshipReviewJSON(Review review) {
		JSONObject iReviewDetails = new JSONObject();
		iReviewDetails.put(REVIEW_UUID, review.getId().toString());
		iReviewDetails.put(REVIEW_TITLE, review.getTitle());
        iReviewDetails.put(REVIEW_RATING, review.getRating());
        iReviewDetails.put(REVIEW_COMMENT, review.getComment());
        
        return iReviewDetails;
	}
    
    /**
     * 
     */

    public static void saveStudentReview() {
		studentReviews sReviews = studentReviews.getInstance();
		ArrayList<Review> sReviewList = sReviews.getstudentReviewsList();
		JSONArray jsonSReviews = new JSONArray();
		
		for(int i=0; i< sReviewList.size(); i++) {
			jsonSReviews.add(getStudentReviewJSON(sReviewList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(STUDENT_REVIEW_FILE_NAME)) {
 
            file.write(jsonSReviews.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getStudentReviewJSON(Review review) {
		JSONObject sReviewDetails = new JSONObject();
		sReviewDetails.put(REVIEW_UUID, review.getId().toString());
		sReviewDetails.put(REVIEW_TITLE, review.getTitle());
        sReviewDetails.put(REVIEW_RATING, review.getRating());
        sReviewDetails.put(REVIEW_COMMENT, review.getComment());
        
        return sReviewDetails;
	}
    
    private static ArrayList<String> UUIDArrtoStrArr(ArrayList<UUID> arr) {
        ArrayList<String> ret = new ArrayList<String>();
        for(int i = 0; i < arr.size(); i++) {
            ret.add(arr.get(i).toString());
        }
        return ret;
    }
}