import java.util.ArrayList;
import java.util.UUID;

public class Students {

    private static Students students = null;
    private static ArrayList<Student> studentsList = new ArrayList<Student>();

    private Students() {
        studentsList = DataLoader.getStudents();
    }

    public static Students getInstance() {
        if(students == null) {
            students = new Students();
        }
        return students;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public Student getStudent(UUID target) {
        for (int i = 0; i < studentsList.size(); i++) {
            if(studentsList.get(i).getId() == target) {
                return studentsList.get(i);
            }
        }
        return null;
    }

    public void addStudent(Student s) {
        studentsList.add(s);
    }

    public void removeStudent(Student s) {
        studentsList.remove(s);
    }

    public void logout() {
        DataWriter.saveStudents();
    }
    
}
