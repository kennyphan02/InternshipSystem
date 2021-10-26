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
        
        return studentDetails;
	}


}
