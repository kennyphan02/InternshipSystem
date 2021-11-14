import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InternshipSystemTest {
    private InternshipSystem internshipSystem = new InternshipSystem();
    private Organizations organizations = Organizations.getInstance();
    private Students students = Students.getInstance();


    @BeforeEach
    public void setup(){
        Organizations.getInstance().getOrganizationsList().clear();
        Students.getInstance().getStudentsList().clear();
        DataWriter.saveOrganization();
        DataWriter.saveStudents();
    }

    @AfterEach
    public void tearDown(){
        Organizations.getInstance().getOrganizationsList().clear();
        Students.getInstance().getStudentsList().clear();
        DataWriter.saveOrganization();
        DataWriter.saveStudents();
    }

    @Test
    public void testCreateValidStudentAccount(){
        ArrayList<String> skills = new ArrayList<String>();
        ArrayList<String> language = new ArrayList<String>();
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        skills.add("Java");
        skills.add("Python");
        ArrayList<String> responsibilities = new ArrayList<String>();
        responsibilities.add("Created a Python program");
        responsibilities.add("Built java program");
        Experience experience = new Experience("Computer Programmer", "techsters", "Aug 2019", "Oct 2020", responsibilities);
        experiences.add(experience);
        Education education = new Education("UofSC","Computer Science","5/12/2021");
        language.add("English");
        language.add("Russian");
        Resume resume = new Resume(skills, experiences, education, language);
        internshipSystem.createStudentAccount("tech123", "abc123", "bob@gmail.com", "6/18/2002", "USA", resume, "UofSC", language);

        internshipSystem.login("tech123", "abc123");
        Student currentStudent = internshipSystem.getStudentUser();
        assertEquals("tech123", currentStudent.getUser());
    }

    @Test
    public void testCreateValidOrganizationAccount(){
        internshipSystem.createOrganizationAccount("HBOMax123", "samsungtv123", "hbo@gmail.com", "USA", "HBOMax", "821-341-1921", "tv stuff");
        internshipSystem.login("HBOMax123", "samsungtv123");
        Organization currentOrganization = internshipSystem.getOrganizationUser();
        assertEquals("HBOMax123", currentOrganization.getUser());
    }

    @Test
    public void testCheckDuplicateUserName(){
        ArrayList<String> skills = new ArrayList<String>();
        ArrayList<String> language = new ArrayList<String>();
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        skills.add("Java");
        skills.add("Python");
        ArrayList<String> responsibilities = new ArrayList<String>();
        responsibilities.add("Created a Python program");
        responsibilities.add("Built java program");
        Experience experience = new Experience("Computer Programmer", "techsters", "Aug 2019", "Oct 2020", responsibilities);
        experiences.add(experience);
        Education education = new Education("UofSC","Computer Science","5/12/2021");
        language.add("English");
        language.add("Russian");
        Resume resume = new Resume(skills, experiences, education, language);
        internshipSystem.createStudentAccount("tech123", "abc123", "bob@gmail.com", "6/18/2002", "USA", resume, "UofSC", language);
        boolean duplicateUserAccount = internshipSystem.createStudentAccount("tech123", "tere1123", "poo@gmail.com", "9/12/1994", "USA", resume, "UofSC", language);
        assertFalse(duplicateUserAccount);
    }

    @Test
    public void testCreateEmptyUserName(){
        ArrayList<String> skills = new ArrayList<String>();
        ArrayList<String> language = new ArrayList<String>();
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        skills.add("Java");
        skills.add("Python");
        ArrayList<String> responsibilities = new ArrayList<String>();
        responsibilities.add("Created a Python program");
        responsibilities.add("Built java program");
        Experience experience = new Experience("Computer Programmer", "techsters", "Aug 2019", "Oct 2020", responsibilities);
        experiences.add(experience);
        Education education = new Education("UofSC","Computer Science","5/12/2021");
        language.add("English");
        language.add("Russian");
        Resume resume = new Resume(skills, experiences, education, language);
        boolean invalidUser = internshipSystem.createStudentAccount("", "abc123", "bob@gmail.com", "6/18/2002", "USA", resume, "UofSC", language);
        assertFalse(invalidUser);
    }

    @Test
    public void testcreateEmptyAccount(){
        boolean invalidUser = internshipSystem.createStudentAccount("", "", "", "", "", null, "", null);
        assertFalse(invalidUser);
    }

    @Test
    public void testValidLogin(){
        ArrayList<String> skills = new ArrayList<String>();
        ArrayList<String> language = new ArrayList<String>();
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        skills.add("Java");
        skills.add("Python");
        ArrayList<String> responsibilities = new ArrayList<String>();
        responsibilities.add("Created a Python program");
        responsibilities.add("Built java program");
        Experience experience = new Experience("Computer Programmer", "techsters", "Aug 2019", "Oct 2020", responsibilities);
        experiences.add(experience);
        Education education = new Education("UofSC","Computer Science","5/12/2021");
        language.add("English");
        language.add("Russian");
        Resume resume = new Resume(skills, experiences, education, language);
        internshipSystem.createStudentAccount("tech123", "abc123", "bob@gmail.com", "6/18/2002", "USA", resume, "UofSC", language);

        boolean validLogin = internshipSystem.login("tech123", "abc123");
        assertTrue(validLogin);
    }

    @Test
    public void testInvalidLogin(){
        ArrayList<String> skills = new ArrayList<String>();
        ArrayList<String> language = new ArrayList<String>();
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        skills.add("Java");
        skills.add("Python");
        ArrayList<String> responsibilities = new ArrayList<String>();
        responsibilities.add("Created a Python program");
        responsibilities.add("Built java program");
        Experience experience = new Experience("Computer Programmer", "techsters", "Aug 2019", "Oct 2020", responsibilities);
        experiences.add(experience);
        Education education = new Education("UofSC","Computer Science","5/12/2021");
        language.add("English");
        language.add("Russian");
        Resume resume = new Resume(skills, experiences, education, language);
        internshipSystem.createStudentAccount("tech123", "abc123", "bob@gmail.com", "6/18/2002", "USA", resume, "UofSC", language);

        boolean validLogin = internshipSystem.login("tech123", "abcdsgfdh123");
        assertFalse(validLogin);

    }
}
