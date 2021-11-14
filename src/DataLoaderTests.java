/**
 * @author Jacob Suhs
 * Suite of tests for DataLoader.java in the InternshipSystem project.
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

class DataLoaderTests {
    
    @Test
    public void testGetStudents() {
        ArrayList<Student> studentsList = DataLoader.getStudents();
        assertEquals(4, studentsList.size());
    }

    @Test
    public void testStudentData() {
        ArrayList<Student> studentsList = DataLoader.getStudents();
        UUID[] studentIDs = {UUID.fromString("590fdc16-3626-49f8-a855-baccd3aba799"),UUID.fromString("aeca4c82-e986-4f04-a08a-34328fd8d5d1"),UUID.fromString("2e8bc9a2-2a69-498d-b12a-28b4df5343c4"),UUID.fromString("9e2a6a20-0ed4-4e21-bfcd-0db2c302eee4")};
        for (int i = 0; i < studentIDs.length; i++) {
            assertEquals(studentIDs[i], studentsList.get(i).getId());
        }
    }

    @Test
    public void testGetOrgs() {
        ArrayList<Organization> orgsList = DataLoader.getOrgs();
        assertEquals(2, orgsList.size());
    }

    @Test
    public void testOrgData() {
        ArrayList<Organization> orgsList = DataLoader.getOrgs();
        UUID[] orgIDs = {UUID.fromString("806c9221-a08e-400a-8d9d-8e1ba03a6be5"),UUID.fromString("b7a87285-44b9-4ac3-b6b0-0e616feb96fd")};
        for (int i = 0; i < orgIDs.length; i++) {
            assertEquals(orgIDs[i], orgsList.get(i).getId());
        }
    }

    @Test
    public void testGetResumes() {
        ArrayList<Resume> resList = DataLoader.getResumes();
        assertEquals(4, resList.size());
    }

    @Test
    public void testResumeData() {
        ArrayList<Resume> resList = DataLoader.getResumes();
        UUID[] resumeIDs = {UUID.fromString("58612df9-ffaa-4715-b245-14d3bc04b7b5"),UUID.fromString("555bfbed-16d3-4bcd-bc6a-13fc9f7c7871"),UUID.fromString("55f46117-a90a-482c-9ef4-eac482ed89be"),UUID.fromString("98700033-2f9d-41a8-a4b7-9df6c45f53f5")};
        for (int i = 0; i < resumeIDs.length; i++) {
            assertEquals(resumeIDs[i], resList.get(i).getid());
        }
    }

    @Test
    public void testGetInternships() {
        ArrayList<Internship> intList = DataLoader.getInternships();
        assertEquals(3, intList.size());
    }

    @Test
    public void testInternshipData() {
        ArrayList<Internship> intList = DataLoader.getInternships();
        UUID[] internshipIDs = {UUID.fromString("3d523283-a353-41ae-b702-488cfb6917d5"),UUID.fromString("a33421b9-e82a-465c-8aa5-a85b8de7db24"),UUID.fromString("230d04f2-389b-484b-bb64-db73b08b398a")};
        for (int i = 0; i < internshipIDs.length; i++) {
            assertEquals(internshipIDs[i], intList.get(i).getid());
        }
    }

    @Test
    public void testGetStudentReviews() {
        ArrayList<Review> revList = DataLoader.getStudentReviews();
        assertEquals(5, revList.size());
    }

    @Test
    public void testStudentReviewsData() {
        ArrayList<Review> revList = DataLoader.getStudentReviews();
        UUID[] revIDs = {UUID.fromString("e413a400-4cf4-48ab-baaf-b2cf77535b87"),UUID.fromString("4aceebbe-e353-43de-9b79-7b6cf44ab63e"),UUID.fromString("54f1c5a4-fd44-409f-83a4-dd086ec1f608"),UUID.fromString("2fb1e662-44b4-4961-bf66-c1e2ced104dd"),UUID.fromString("54167f8e-2246-40fb-b5ae-7f52aa0fc89f")};
        for (int i = 0; i < revIDs.length; i++) {
            assertEquals(revIDs[i], revList.get(i).getId());
        }
    }

    @Test
    public void testInternshipReviews() {
        ArrayList<Review> revList = DataLoader.getInternshipReviews();
        assertEquals(3, revList.size());
    }

    @Test
    public void testInternshipReviewsData() {
        ArrayList<Review> revList = DataLoader.getInternshipReviews();
        UUID[] revIDs = {UUID.fromString("46a4ef90-a7ed-4281-8154-99ffb426fd98"),UUID.fromString("d7ccec7d-d47f-479d-b445-d27ccbc03a42"),UUID.fromString("2ddc2e1f-795f-45c4-9202-8ba6a28c8082")};
        for (int i = 0; i < revIDs.length; i++) {
            assertEquals(revIDs[i], revList.get(i).getId());
        }
    }
}