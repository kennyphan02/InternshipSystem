import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
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
}
