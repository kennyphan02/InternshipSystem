import java.util.ArrayList;

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

    public Student getStudent(int index) {
        return studentsList.get(index);
    }

    public void addStudent(Student s) {
        studentsList.add(s);
    }

    public void removeStudent(Student s) {
        studentsList.remove(s);
    }

    public void logout() {

    }
    
}
