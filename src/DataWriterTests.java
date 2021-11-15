/**
 * @author Danai Angelidis
 * Suite of tests for DataWriter.java in the InternshipSystem project.
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTests {

	private Students students = Students.getInstance();
	private ArrayList<Student> studentList = students.getStudentsList();
	
	@BeforeEach
	public void studentsSetup() {
		Students.getInstance().getStudentsList().clear();
		DataWriter.saveStudents();
	}
	
	@AfterEach
	public void studentTearDown() {
		Students.getInstance().getStudentsList().clear();
		DataWriter.saveStudents();
	}
	
	
	@Test
	void testWritingZeroStudents() {
		studentList = DataLoader.getStudents();
		assertEquals(0, studentList.size());
	}

	@Test
	void testWritingOneStudent() {
        Education ed = new Education("uni", "degree", "gradDate");
        ArrayList<String> lang = new ArrayList<String>();
        lang.add("language");
        ArrayList<String> ski= new ArrayList<String>();
        ski.add("experience");
        ArrayList<String> resp = new ArrayList<String>();
        resp.add("responsibilities");
        Experience exp = new Experience("title", "company", "startDate", "endDate", resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
        Resume res = new Resume(ski, exps, ed, lang);
		studentList.add(new Student("asmith", "smith", "asmith@email.com", "02/21/21", "USA", res , "USC", lang));
		DataWriter.saveStudents();
		assertEquals("asmith", DataLoader.getStudents().get(0).getUser());
	}
	
	@Test
	void testWritingFiveStudents() {
		Education ed = new Education("uni", "degree", "gradDate");
        ArrayList<String> lang = new ArrayList<String>();
        lang.add("language");
        ArrayList<String> ski= new ArrayList<String>();
        ski.add("experience");
        ArrayList<String> resp = new ArrayList<String>();
        resp.add("responsibilities");
        Experience exp = new Experience("title", "company", "startDate", "endDate", resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
        Resume res = new Resume(ski, exps, ed, lang);
		studentList.add(new Student("asmith", "smith", "asmith@email.com", "02/21/21", "USA", res , "USC", lang));
        studentList.add(new Student("bsmith", "smith", "asmith@email.com", "02/21/21", "USA", res , "USC", lang));
        studentList.add(new Student("csmith", "smith", "asmith@email.com", "02/21/21", "USA", res , "USC", lang));
        studentList.add(new Student("dsmith", "smith", "asmith@email.com", "02/21/21", "USA", res , "USC", lang));
        studentList.add(new Student("esmith", "smith", "asmith@email.com", "02/21/21", "USA", res , "USC", lang));
		DataWriter.saveStudents();
		assertEquals("esmith", DataLoader.getStudents().get(4).getUser());
	}
	
	@Test
	void testWritingEmptyStudent() {
        Education ed = new Education(" ", " ", " ");
        ArrayList<String> lang = new ArrayList<String>();
        lang.add(" ");
        ArrayList<String> ski= new ArrayList<String>();
        ski.add(" ");
        ArrayList<String> resp = new ArrayList<String>();
        resp.add(" ");
        Experience exp = new Experience(" ", " ", " ", " ", resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
        Resume res = new Resume(ski, exps, ed, lang);
		studentList.add(new Student(" ", " ", " ", " ", " ", res, " ", lang));
		DataWriter.saveStudents();
		assertEquals("", DataLoader.getStudents().get(0).getUser());
	}
	
	@Test
	void testWritingNullStudent() {
		Education ed = new Education(null, null, null);
        ArrayList<String> lang = new ArrayList<String>();
        lang.add(null);
        ArrayList<String> ski= new ArrayList<String>();
        ski.add(null);
        ArrayList<String> resp = new ArrayList<String>();
        resp.add(null);
        Experience exp = new Experience(null, null, null, null, resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
        Resume res = new Resume(ski, exps, ed, lang);
		studentList.add(new Student(null, null, null, null, null, res, null, lang));
		DataWriter.saveStudents();
		assertEquals(null, DataLoader.getStudents().get(0).getUser());
	}

    private Organizations organizations = Organizations.getInstance();
    private ArrayList<Organization> oList = organizations.getOrganizationsList();

    @BeforeEach
	public void orgSetup() {
		Organizations.getInstance().getOrganizationsList().clear();
		DataWriter.saveOrganization();
	}
	
	@AfterEach
	public void orgTearDown() {
		Organizations.getInstance().getOrganizationsList().clear();
		DataWriter.saveOrganization();
	}
	
	
	@Test
	void testWritingZeroOrgs() {
		oList = DataLoader.getOrgs();
		assertEquals(0, oList.size());
	}

	@Test
	void testWritingOneOrg() {
		oList.add(new Organization("asmith", "smith", "asmith@email.com", "USA", "SmithTM", "123-456-7890", "desc"));
		DataWriter.saveOrganization();
		assertEquals("asmith", DataLoader.getOrgs().get(0).getUser());
	}
	
	@Test
	void testWritingFiveOrgs() {
        oList.add(new Organization("asmith", "smith", "asmith@email.com", "USA", "SmithTM", "123-456-7890", "desc"));
        oList.add(new Organization("bsmith", "smith", "asmith@email.com", "USA", "SmithTM", "123-456-7890", "desc"));
        oList.add(new Organization("csmith", "smith", "asmith@email.com", "USA", "SmithTM", "123-456-7890", "desc"));
        oList.add(new Organization("dsmith", "smith", "asmith@email.com", "USA", "SmithTM", "123-456-7890", "desc"));
        oList.add(new Organization("esmith", "smith", "asmith@email.com", "USA", "SmithTM", "123-456-7890", "desc"));
		DataWriter.saveOrganization();
		assertEquals("esmith", DataLoader.getOrgs().get(4).getUser());
	}
	
	@Test
	void testWritingEmptyOrg() {
        oList.add(new Organization(" ", " ", " ", " ", " ", " ", " "));
		DataWriter.saveOrganization();
		assertEquals("", DataLoader.getOrgs().get(0).getUser());
	}
	
	@Test
	void testWritingNullOrg() {
		oList.add(new Organization(null, null, null, null, null, null, null));
		DataWriter.saveOrganization();
		assertEquals(null, DataLoader.getOrgs().get(0).getUser());
	}

    private Internships internships = Internships.getInstance();
    private ArrayList<Internship> iList = internships.getInternshipsList();

    @BeforeEach
	public void internshipSetup() {
		Internships.getInstance().getInternshipsList().clear();
		DataWriter.saveInternship();
	}
	
	@AfterEach
	public void internshipTearDown() {
		Internships.getInstance().getInternshipsList().clear();
		DataWriter.saveInternship();
	}

	
	@Test
	void testWritingZeroInternships() {
		iList = DataLoader.getInternships();
		assertEquals(0, iList.size());
	}

	@Test
	void testWritingOneInternship() {
        ArrayList<String> skills = new ArrayList<String>();
        skills.add("skills");
		UUID id = UUID.fromString("eeeb20f3-5f07-4837-b42b-ec8124a1e7c9");
		iList.add(new Internship("ajob", "degree", true, true, "$10", 7, id, skills));
		DataWriter.saveInternship();
		assertEquals("ajob", DataLoader.getInternships().get(0).getjob());
	}
	
	@Test
	void testWritingFiveInternships() {
        ArrayList<String> skills = new ArrayList<String>();
        skills.add("skills");
		UUID id = UUID.fromString("eeeb20f3-5f07-4837-b42b-ec8124a1e7c9");
		iList.add(new Internship("ajob", "degree", true, true, "$10", 7, id, skills));
		iList.add(new Internship("bjob", "degree", true, true, "$10", 7, id, skills));
		iList.add(new Internship("cjob", "degree", true, true, "$10", 7, id, skills));
		iList.add(new Internship("djob", "degree", true, true, "$10", 7, id, skills));
		iList.add(new Internship("ejob", "degree", true, true, "$10", 7, id, skills));
		DataWriter.saveInternship();
		assertEquals("ejob", DataLoader.getInternships().get(4).getjob());
	}
	
	@Test
	void testWritingEmptyIntership() {
		ArrayList<String> skills = new ArrayList<String>();
        skills.add(" ");
		UUID id = UUID.fromString(" ");
		iList.add(new Internship(" ", " ", true, true, " ", 0, id, skills));
		DataWriter.saveInternship();
		assertEquals("", DataLoader.getInternships().get(0).getjob());
	}
	
	@Test
	void testWritingNullInternship() {
		ArrayList<String> skills = new ArrayList<String>();
        skills.add(null);
		UUID id = UUID.fromString(null);
		iList.add(new Internship(null, null, true, true, null, 0, id, skills));
		DataWriter.saveInternship();
		assertEquals(null, DataLoader.getInternships().get(0).getjob());
	}
	

    private Resumes resumes = Resumes.getInstance();
    private ArrayList<Resume> resumeList = resumes.getResumesList();

    @BeforeEach
	public void resumeSetup() {
		Resumes.getInstance().getResumesList().clear();
		DataWriter.saveResume();
	}
	
	@AfterEach
	public void resumeTearDown() {
		Resumes.getInstance().getResumesList().clear();
		DataWriter.saveResume();
	}

	
	@Test
	void testWritingZeroResumes() {
		resumeList = DataLoader.getResumes();
		assertEquals(0, resumeList.size());
	}

	@Test
	void testWritingOneResume() {
		Education ed = new Education("uni", "degree", "gradDate");
        ArrayList<String> lang = new ArrayList<String>();
        lang.add("language");
        ArrayList<String> ski= new ArrayList<String>();
        ski.add("experience");
        ArrayList<String> resp = new ArrayList<String>();
        resp.add("responsibilities");
        Experience exp = new Experience("atitle", "company", "startDate", "endDate", resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
		resumeList.add(new Resume(ski, exps, ed, lang));
		DataWriter.saveResume();
		assertEquals(lang, DataLoader.getResumes().get(0).getlanguage());
	}
	
	@Test
	void testWritingFiveResumes() {
        Education ed = new Education("uni", "degree", "gradDate");
        ArrayList<String> lang1 = new ArrayList<String>();
        lang1.add("language1");
		ArrayList<String> lang2 = new ArrayList<String>();
        lang2.add("language2");
		ArrayList<String> lang3 = new ArrayList<String>();
        lang1.add("language3");
		ArrayList<String> lang4 = new ArrayList<String>();
        lang1.add("language4");
		ArrayList<String> lang5 = new ArrayList<String>();
        lang1.add("language5");
        ArrayList<String> ski= new ArrayList<String>();
        ski.add("experience");
        ArrayList<String> resp = new ArrayList<String>();
        resp.add("responsibilities");
        Experience exp = new Experience("atitle", "company", "startDate", "endDate", resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
		resumeList.add(new Resume(ski, exps, ed, lang1));
		resumeList.add(new Resume(ski, exps, ed, lang2));
		resumeList.add(new Resume(ski, exps, ed, lang3));
		resumeList.add(new Resume(ski, exps, ed, lang4));
		resumeList.add(new Resume(ski, exps, ed, lang5));
		DataWriter.saveResume();
		assertEquals(lang5, DataLoader.getResumes().get(4).getlanguage());
	}
	
	@Test
	void testWritingEmptyResume() {
		Education ed = new Education(" ", " ", " ");
        ArrayList<String> lang = new ArrayList<String>();
        lang.add(" ");
        ArrayList<String> ski= new ArrayList<String>();
        ski.add(" ");
        ArrayList<String> resp = new ArrayList<String>();
        resp.add(" ");
        Experience exp = new Experience(" ", " ", " ", " ", resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
        Resume res = new Resume(ski, exps, ed, lang);
		studentList.add(new Student(" ", " ", " ", " ", " ", res, " ", lang));
		DataWriter.saveStudents();
		assertEquals(lang, DataLoader.getResumes().get(0).getlanguage());
	}
	
	@Test
	void testWritingNullResume() {
		Education ed = new Education(null, null, null);
        ArrayList<String> lang = new ArrayList<String>();
        lang.add(null);
        ArrayList<String> ski= new ArrayList<String>();
        ski.add(null);
        ArrayList<String> resp = new ArrayList<String>();
        resp.add(null);
        Experience exp = new Experience(null, null, null, null, resp);
        ArrayList<Experience> exps = new ArrayList<Experience>();
        exps.add(exp);
        Resume res = new Resume(ski, exps, ed, lang);
		studentList.add(new Student(null, null, null, null, null, res, null, lang));
		DataWriter.saveStudents();
		assertEquals(lang, DataLoader.getResumes().get(0).getlanguage());
	}


	private internshipReviews iReviews = internshipReviews.getInstance();
    private ArrayList<Review> iReviewList = iReviews.getinternshipReviewsList();

    @BeforeEach
	public void iReviewSetup() {
		internshipReviews.getInstance().getinternshipReviewsList().clear();
		DataWriter.saveInternshipReview();
	}
	
	@AfterEach
	public void iReviewTearDown() {
		internshipReviews.getInstance().getinternshipReviewsList().clear();
		DataWriter.saveInternshipReview();
	}

	
	@Test
	void testWritingZeroiReviews() {
		iReviewList = DataLoader.getInternshipReviews();
		assertEquals(0, iReviewList.size());
	}

	@Test
	void testWritingOneIReview() {
		iReviewList.add(new Review("atitle", "comment", 2));
		DataWriter.saveInternshipReview();
		assertEquals("atitle", DataLoader.getInternshipReviews().get(0).getTitle());
	}
	
	@Test
	void testWritingFiveIReviews() {
        iReviewList.add(new Review("atitle", "comment", 2));
		iReviewList.add(new Review("btitle", "comment", 2));
		iReviewList.add(new Review("ctitle", "comment", 2));
		iReviewList.add(new Review("dtitle", "comment", 2));
		iReviewList.add(new Review("etitle", "comment", 2));
		DataWriter.saveInternshipReview();
		assertEquals("etitle", DataLoader.getInternshipReviews().get(4).getTitle());
	}
	
	@Test
	void testWritingEmptyIReview() {
		iReviewList.add(new Review(" ", " ", 0));
		DataWriter.saveInternshipReview();
		assertEquals("", DataLoader.getInternshipReviews().get(0).getTitle());
	}
	
	@Test
	void testWritingNullIReview() {
		iReviewList.add(new Review(null, null, 0));
		DataWriter.saveInternshipReview();
		assertEquals( null, DataLoader.getInternshipReviews().get(0).getTitle());
	}


	private studentReviews sReviews = studentReviews.getInstance();
    private ArrayList<Review> sReviewList = sReviews.getstudentReviewsList();

    @BeforeEach
	public void sReviewSetup() {
		studentReviews.getInstance().getstudentReviewsList().clear();
		DataWriter.saveStudentReview();
	}
	
	@AfterEach
	public void sReviewTearDown() {
		studentReviews.getInstance().getstudentReviewsList().clear();
		DataWriter.saveStudentReview();
	}

	
	@Test
	void testWritingZeroSReviews() {
		sReviewList = DataLoader.getStudentReviews();
		assertEquals(0, sReviewList.size());
	}

	@Test
	void testWritingOneSReview() {
		sReviewList.add(new Review("atitle", "comment", 2));
		DataWriter.saveStudentReview();
		assertEquals("atitle", DataLoader.getStudentReviews().get(0).getTitle());
	}
	
	@Test
	void testWritingFiveSReviews() {
        sReviewList.add(new Review("atitle", "comment", 2));
		sReviewList.add(new Review("btitle", "comment", 2));
		sReviewList.add(new Review("ctitle", "comment", 2));
		sReviewList.add(new Review("dtitle", "comment", 2));
		sReviewList.add(new Review("etitle", "comment", 2));
		DataWriter.saveStudentReview();
		assertEquals("etitle", DataLoader.getStudentReviews().get(4).getTitle());
	}
	
	@Test
	void testWritingEmptySReview() {
		sReviewList.add(new Review(" ", " ", 0));
		DataWriter.saveStudentReview();
		assertEquals("", DataLoader.getStudentReviews().get(0).getTitle());
	}
	
	@Test
	void testWritingNullSReview() {
		sReviewList.add(new Review(null, null, 0));
		DataWriter.saveStudentReview();
		assertEquals( null, DataLoader.getStudentReviews().get(0).getTitle());
	}

}