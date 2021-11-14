/**
 * @author Jacob Suhs
 * Suite of tests for the data Singletons of the InternshipSystem project.
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * IMPORTANT NOTE: tests for the addX() and removeX() in each Singleton are not here, as they are expected to be tested by the tests
 * Danai will write for testing DataWriter's various methods.
 * Even then, these tests may not be added to DataWriter's test suite because they are extremely time-consuming
 * and difficult to implement for the evaluation of an extremely simplistic line of code since it involves the
 * creation of an entirely new dummy object and the filling of all its attributes.
 */
class SingletonTests {
    /** All of these methods test both the getInstance method and the private constructor that calls DataLoader for every singleton.
     * Each test validates that the Singleton initalizes itself correctly, and that its internal ArrayList comes back with
     * the same number of items in it as retrieved by the DataLoader.
     */
    @Test
    public void testInternshipsInstance() {
        assertNotEquals(null, Internships.getInstance());
        assertEquals(DataLoader.getInternships().size(), Internships.getInstance().getInternshipsList().size());
    }

    @Test
    public void testOrganizationsInstance() {
        assertNotEquals(null, Organizations.getInstance());
        assertEquals(DataLoader.getOrgs().size(), Organizations.getInstance().getOrganizationsList().size());
    }

    @Test
    public void testResumesInstance() {
        assertNotEquals(null, Resumes.getInstance());
        assertEquals(DataLoader.getResumes().size(), Resumes.getInstance().getResumesList().size());
    }

    @Test
    public void testStudentsInstance() {
        assertNotEquals(null, Students.getInstance());
        assertEquals(DataLoader.getStudents().size(), Students.getInstance().getStudentsList().size());
    }

    @Test
    public void testStudentReviewsInstance() {
        assertNotEquals(null, studentReviews.getInstance());
        assertEquals(DataLoader.getStudentReviews().size(), studentReviews.getInstance().getstudentReviewsList().size());
    }

    @Test
    public void testInternshipReviewsInstance() {
        assertNotEquals(null, internshipReviews.getInstance());
        assertEquals(DataLoader.getInternshipReviews().size(), internshipReviews.getInstance().getinternshipReviewsList().size());
    }

    // Though the methods below are named "getX", they are actually coded as list-search-for-target methods, which is why I wrote two series of tests for it.

    // Making sure it works for VALID UUIDs
    @Test
    public void testUUIDSearch() {
        // Establish independent variables so we don't double-call getInstance() for our tests and waste memory/increase test times
        Internships internships = Internships.getInstance();
        Organizations organizations = Organizations.getInstance();
        Resumes resumes = Resumes.getInstance();
        Students students = Students.getInstance();
        studentReviews studentreviews = studentReviews.getInstance();
        internshipReviews internshipreviews = internshipReviews.getInstance();

        // Get the UUID of the first item in each Singleton's list
        UUID internshipID = internships.getInternshipsList().get(0).getid();
        UUID orgID = organizations.getOrganizationsList().get(0).getId();
        UUID resID = resumes.getResumesList().get(0).getid();
        UUID studentID = students.getStudentsList().get(0).getId();
        UUID sRevID = studentreviews.getstudentReviewsList().get(0).getId();
        UUID iRevID = internshipreviews.getinternshipReviewsList().get(0).getId();

        // Now run the UUID search and make sure the method returns an object with said UUID
        assertEquals(internshipID, internships.getInternship(internshipID).getid());
        assertEquals(orgID, organizations.getOrganization(orgID).getId());
        assertEquals(resID, resumes.getResume(resID).getid());
        assertEquals(studentID, students.getStudent(studentID).getId());
        assertEquals(sRevID, studentreviews.getReview(sRevID).getId());
        assertEquals(iRevID, internshipreviews.getReview(iRevID).getId());
    }

    // Making sure it returns null if you feed it a bogus UUID and the search doesn't have any hits
    // If this test suddenly fails, go buy a lottery ticket.
    @Test
    public void invalidUUIDSearchReturnsNull() {
        UUID invalUuid = UUID.randomUUID();
        assertEquals(null, Internships.getInstance().getInternship(invalUuid));
        assertEquals(null, Organizations.getInstance().getOrganization(invalUuid));
        assertEquals(null, Resumes.getInstance().getResume(invalUuid));
        assertEquals(null, Students.getInstance().getStudent(invalUuid));
        assertEquals(null, studentReviews.getInstance().getReview(invalUuid));
        assertEquals(null, internshipReviews.getInstance().getReview(invalUuid));
    }
}
