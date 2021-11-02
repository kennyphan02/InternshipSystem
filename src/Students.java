import java.util.ArrayList;
import java.util.UUID;

/**
 * Hold operations for instances of Students
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Students {

    private static Students students = null;
    private static ArrayList<Student> studentsList = new ArrayList<Student>();

    //Calls on data loader to populate array list.
    private Students() {
        studentsList = DataLoader.getStudents();
    }

    /**
     *Checks if instance of student.java exists. Returns instance if exists, contructs one otherwise.
     * @return instance of student.java if it exists
     * @see Students#Students()
     */
    public static Students getInstance() {
        if(students == null) {
            students = new Students();
        }
        return students;
    }

    /**
     * Gets the list of students
     * @return the array of students
     */
    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    /**
     * Gets an instance of student from array list
     * @param target
     * @return selected student
     */
    public Student getStudent(UUID target) {
        for (int i = 0; i < studentsList.size(); i++) {
            if(studentsList.get(i).getId() == target) {
                return studentsList.get(i);
            }
        }
        return null;
    }

    //Adds a student from the JSON file into the array list.
    public void addStudent(Student s) {
        studentsList.add(s);
    }

    //Removes an instance of a student from array list.
    public void removeStudent(Student s) {
        studentsList.remove(s);
    }

    //Sends data from student singleton to DataWriter.
    public void logout() {
        DataWriter.saveStudents();
    }
    
}
