import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class InternshipSystem {
    private Internships internships;
    private Scanner scanner;
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String country;
    private String firstName;
    private String lastName;
    private String profession;
    private String college;
    private String organization;
    private String phoneNum;
    private String description;
    private ArrayList<String> language;
    private Experience experience;
    private Education education;
    private Resume resume;

    public InternshipSystem(){
        // internshipList = InternshipList.getInstance();
        // userList = UserList.getInstance();
        scanner = new Scanner(System.in);
        experience = new Experience();
        education = new Education();
        language = new ArrayList<String>();
    }
    
    public void login(){
        clearConsole();
        displayInternshipLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
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
        profession = scanner.nextLine();
        System.out.println("Email: " + email);
        System.out.println("");
        createExperiences();
        createEducation();
        resume = new Resume(firstName, lastName, profession, email, experience, education, language);
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
            experience.addTitle(title);
            System.out.print("Input description: ");
            String description = scanner.nextLine();
            experience.addDescription(description);
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
            education.addDegree(degree);
            System.out.print("Input description: ");
            String description = scanner.nextLine();
            education.addDescription(description);
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

    public boolean writeResume(Student student, Resume resume) {
        String fileName = student.getUser()+"Resume.txt";
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: "+file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(student.getUser()+"\n"+student.getEmail()+"\n"+resume.geteducation()+"\n"+resume.getexperience());
            for(int i=0; i<resume.getSkills().size(); i++) {
                writer.write(resume.getSkills().get(i));
            }
            for(int i=0; i<resume.getlanguage().size(); i++) {
                writer.write(resume.getlanguage().get(i));
            }
            for(int i=0; i<resume.getSkills().size(); i++) {
                writer.write(resume.getexperience().get(i).toString());
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
 
}
