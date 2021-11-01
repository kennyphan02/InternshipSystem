import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InternshipSystem {
    private Internships internships;
    private Students students;
    private Organizations organizations;
    private Resumes resumes;
    private Scanner scanner;
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String country;
    private String firstName;
    private String lastName;
    private String college;
    private String organization;
    private String phoneNum;
    private String description;
    private ArrayList<String> language;
    private Experience experience;
    private Education education;
    private Resume resume;
    private Student studentUser;
    private Organization organizationUser;


    public InternshipSystem(){
        // userList = UserList.getInstance();
        internships = Internships.getInstance();
        organizations = Organizations.getInstance();
        students = Students.getInstance();
        resumes = Resumes.getInstance();
        scanner = new Scanner(System.in);
        // experience = new Experience();
        // education = new Education();
        language = new ArrayList<String>();
    }

    public Student getStudent(){
        return studentUser;
    }
    public Organization getOrganization(){
        return organizationUser;
    }

    public boolean login(String username, String password){
        for(Student student : students.getStudentsList()) {
            if(student.getUser().equals(username) && student.getPassword().equals(password)){
                studentUser = students.getStudent(student.getId());
                return true;
            }
        }
        for(Organization organization : organizations.getOrganizationsList()) {
            if(organization.getUser().equals(username) && organization.getPassword().equals(password)){
                organizationUser = organizations.getOrganization(organization.getId());
                return true;
            }
        }

        return false;
    }
    public void debug(){
        System.out.println(organizationUser);
        String debug = scanner.nextLine();
    }

    public void addResume(){
        displayInternshipLine();
        System.out.println("Add the following details to your resume: ");
        System.out.println("Input q to stop at any time");
        System.out.println("Skills:");
        ArrayList<String> skills = new ArrayList<String>();
        while(true){
            String skill = scanner.nextLine();
            if(skill.equals("q")){
                break;
            }
            else
            {
                skills.add(skill);
            }
        }
        System.out.println("");
        System.out.println("Input education:\n");
        System.out.print("College: ");
        college = scanner.nextLine();
        System.out.print("Degree: ");
        String degree = scanner.nextLine();
        System.out.print("Expected Graduation Date: ");
        String gradDate = scanner.nextLine();
        Education ed = new Education(college,degree,gradDate);

        System.out.print("Input languages that you can speak. Press q at any time to quit\n");
        ArrayList<String> languages = new ArrayList<String>();
        while(true){
            String language = scanner.nextLine();
            if(language.equals("q")){
                break;
            }
            else
            {
                languages.add(language);
            }
        }

        ArrayList<Experience> experiences = new ArrayList<Experience>();

        System.out.println("\nInput experience:\n");
        while(true){
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("      Company: ");
            String company = scanner.nextLine();
            System.out.print("      Start date: ");
            String startDate = scanner.nextLine();
            System.out.print("      End date: ");
            String endDate = scanner.nextLine();

            ArrayList<String> descriptions = new ArrayList<String>();
            System.out.println("\nInput descriptions for experiences. Press q at any time to quit\n");
            while(true){
                String description = scanner.nextLine();
                if(description.equals("q")){
                    break;
                }
                else
                {
                    descriptions.add(description);
                }
            }
            Experience exp = new Experience(title, company, startDate, endDate, descriptions);
            experiences.add(exp);
            System.out.println("\n Add more experiences? input y to continue or n to stop\n");
            String userCondition = scanner.nextLine();
            if(userCondition.equals("y"))
            {
                continue;
            }
            if(userCondition.equals("n")){
                break;
            }
    }
        resume = new Resume(skills, experiences, ed, languages);
        resumes.addResume(resume);
    }

    public void printResume(){
        displayInternshipLine();
        try {
            System.out.println("\nPrinting resume to text file...");
            TimeUnit.MILLISECONDS.sleep(3000); 
            FileWriter file = new FileWriter(studentUser.getUser() + "Resume.txt");
            PrintWriter output = new PrintWriter(file);
            output.println(resume.toString());
            output.close();
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }


    public void searchInternship(){
        System.out.println("Search by Filter. Input number next to filter to change it:\n");
        System.out.println("1. Job: ");
        System.out.println("2. Degree: ");
        System.out.println("3. Full time or In Person: ");
        System.out.println("4. Pay: ");
        System.out.println("5. Hours: ");
        System.out.println("6. Skills: ");
        int filter = getUserInput();
        if(filter == 6){
            ArrayList<String> skills = new ArrayList<String>();
            System.out.println("\n Input skills. Press q to stop at any point: \n");
            while(true){
                String skill = scanner.nextLine();
                if(skill.equals("q")){
                    break;
                }
                else
                {
                    skills.add(skill);
                }
            }
            System.out.println("\n Job Postings that contain " + skills);
            ArrayList<Internship> filteredInternships = new ArrayList<Internship>();
            System.out.println("\n********************\n");
            int counter = 0;

            for(Internship internship : internships.getInternshipsList()){
                for(int i = 0; i < internship.getSkills().size(); i++){
                    if(internship.getSkills().get(i).equals(skills.get(counter))){
                        filteredInternships.add(internships.getInternship(internship.getid()));
                    }
                }   
            }

            for(int i= 0; i < filteredInternships.size(); i++){
                System.out.println(i+1 + ".");
                System.out.println(filteredInternships.get(i));
                System.out.println("\n");
            }
            


            System.out.println("Input number next to the job listing to apply: ");
            int number = getUserInput();
            filteredInternships.get(number-1).addID(studentUser.getId());
            internships.logout();
            }
    }

    public void viewMyInternship(){
        
        if(organizationUser != null){
            // 1st for loop (loops through each internship)
            for(int i = 0; i < organizationUser.getInternships().size(); i++) {
                Student applicant;
                System.out.println(i+1 + ".");
                System.out.println(organizationUser.getInternships().get(i));
                System.out.println("Applicants: ");
                // 2nd for loop iterates through every user id
                for(int j = 0; j < organizationUser.getInternships().get(i).getapplicantIDs().size(); j++){
                    // enhanced for loop that iterates through every student in the studentlist. checks each student's id
                    // and compares it to the id of those in the applicants.
                    for(Student student: students.getStudentsList()){
                        // System.out.println("Student id: " + student.getId());
                        // System.out.println("Applicant id: " + organizationUser.getInternships().get(i).getapplicantIDs().get(j));
                        if(student.getId().equals(organizationUser.getInternships().get(i).getapplicantIDs().get(j))){
                            applicant = students.getStudent(student.getId());
                            System.out.println(applicant.getUser());
                        }
                    }
                }
                System.out.println("\n");
            }
            String debug = scanner.nextLine();


        }

    }


    
    public void createStudentAccount(){
            clearConsole();
            displayInternshipLine();
            System.out.print("Input username: ");
            username = scanner.nextLine();
            System.out.print("Input password: ");
            password = scanner.nextLine();
            System.out.print("Input email: ");
            email = scanner.nextLine();
            System.out.print("Input birthday: ");
            birthday = scanner.nextLine();
            System.out.print("Input country: ");
            country = scanner.nextLine();
            createLanguages();
            System.out.println("");
            createStudentProfile();
            createResume();  
           Student student = new Student(username, password, email, birthday, country, resume, college, language);

    }
    public void createOrganizationAccount(){
        clearConsole();
        displayInternshipLine();
        System.out.print("Input username: ");
        username = scanner.nextLine();
        System.out.print("Input password: ");
        password = scanner.nextLine();
        System.out.print("Input email: ");
        email = scanner.nextLine();
        System.out.print("Input country: ");
        country = scanner.nextLine();
        System.out.print("Organization name: ");
        organization = scanner.nextLine();
        System.out.println("");
        createOrganizationProfile();
        Organization org = new Organization(username, password, email, country, organization, phoneNum, description);
    }

    private void createOrganizationProfile(){
        System.out.println("Create your organization profile that will be displayed to organizations: ");
        System.out.println("");
        System.out.println("Organization's name: " + organization);
        System.out.println("Email: " + email);
        System.out.print("Phone: ");
        phoneNum = scanner.nextLine();
        System.out.print("Description: ");
        description = scanner.nextLine();
    }

    public void editStudentProfile(){
        clearConsole();
        while(true){
            clearConsole();
            displayInternshipLine();
            System.out.println("1. First Name: " + firstName);
            System.out.println("2. Last Name: " + lastName);
            System.out.println("3. Email: " + email);
            System.out.println("4. Birthday: " + birthday);
            System.out.println("5. Country: " + country);
            System.out.println("6. College: " + college);
            System.out.println("7. Quit");
            System.out.println("\nInput a number to edit the number's field. press 7 to quit");
            int getUserInput = getUserInput();
            // A switch statement would be more optimal below but I forgot how they work exactly -Kenny
            if(getUserInput == 1){
                clearConsole();
                displayInternshipLine();
                System.out.print("First name: ");
                firstName = scanner.nextLine();
            }
            else if(getUserInput == 2){
                clearConsole();
                displayInternshipLine();
                System.out.print("Last name: ");
                lastName = scanner.nextLine();
            }
            else if(getUserInput == 3){
                clearConsole();
                displayInternshipLine();
                System.out.print("Email: ");
                email = scanner.nextLine();
            }
            else if(getUserInput == 4){
                clearConsole();
                displayInternshipLine();
                System.out.print("Birthday: ");
                birthday = scanner.nextLine();
            }
            else if(getUserInput == 5){
                clearConsole();
                displayInternshipLine();
                System.out.print("Country: ");
                country = scanner.nextLine();
            }
            else if(getUserInput == 6){
                clearConsole();
                displayInternshipLine();
                System.out.print("College: ");
                college = scanner.nextLine();
            }
            else if(getUserInput == 7){
                break;
            }
            else{
                try {
                    System.out.println("\nInvalid Option...");
                    TimeUnit.MILLISECONDS.sleep(1000); 
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        }
    }

    public Resume getResume(){
        return resume;
    }

    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void displayInternshipLine(){
        System.out.println("--------Internship System--------");
    }

    private void createStudentProfile(){
        System.out.println("Create your student profile that will be displayed to organizations: ");
        System.out.println("");
        System.out.print("First name: ");
        firstName = scanner.nextLine();
        System.out.print("Last name: ");
        lastName = scanner.nextLine();
        System.out.println("Email: " + email);
        System.out.println("Birthday: " + birthday);
        System.out.println("Country: " + country);
        System.out.print("College: ");
        college = scanner.nextLine();
        System.out.println("");
    }


    private void createResume(){
        System.out.println("Add the following details to your resume:");
        System.out.println("");
        System.out.println("First Name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.print("Profession: ");
        // profession = scanner.nextLine();
        System.out.println("Email: " + email);
        System.out.println("");
        createExperiences();
        createEducation();
        // resume = new Resume(firstName, lastName, profession, email, experience, education, language);
    }

    private void createLanguages(){
        System.out.println("Input languages that you speak. Enter \"quit\" before adding an languages to quit");
        System.out.println("");
        boolean count = true;
        while(count){
            System.out.print("Input language: ");
            String languageUserInput = scanner.nextLine();
            language.add(languageUserInput);
            System.out.print("Input quit? type quit to quit or no to keep inputting languages: ");
            String quit = scanner.nextLine();
            if(quit.equals("quit")){
                count = false;
            } else if(quit.equals("no")){
                continue;
            }
        }
    }

    private void createExperiences(){
        System.out.println("Input experience. Enter \"quit\" before adding an experience to quit");
        System.out.println("");
        boolean count = true; 
        while(count){
            System.out.print("Input title:  ");
            String title = scanner.nextLine();
            // experience.addTitle(title);
            System.out.print("Input description: ");
            String description = scanner.nextLine();
            // experience.addDescription(description);
            System.out.print("Input quit? type quit to quit or no to keep inputting experiences: ");
            String quit = scanner.nextLine();
            if(quit.equals("quit")){
                count = false;
            } else if(quit.equals("no")){
                continue;
            }
        }
    }

    private void createEducation(){
        System.out.println("");
        System.out.println("Input education. Enter \"quit\" before adding an education to quit");
        System.out.println("");
        boolean count = true;
        while(count){
            System.out.print("Input degree:  ");
            String degree = scanner.nextLine();
            // education.addDegree(degree);
            System.out.print("Input description: ");
            String description = scanner.nextLine();
            // education.addDescription(description);
            System.out.print("Input quit? type quit to quit or no to ke ep inputting education: ");
            String quit = scanner.nextLine();
            if(quit.equals("quit")){
                count = false;
            } else if(quit.equals("no")){
                continue;
            }
        }
    }

    public int getUserInput(){
        String input = scanner.nextLine();
        int userInput = Integer.parseInt(input);
        return userInput;
    }






    
}
