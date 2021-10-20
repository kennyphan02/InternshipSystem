import java.util.Scanner;

public class InternshipSystem {
    private InternshipList internshipList;
    private UserList userList;
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
    private Experience experience;
    private Resume resume;


    public InternshipSystem(){
        // internshipList = InternshipList.getInstance();
        // userList = UserList.getInstance();
        scanner = new Scanner(System.in);
        experience = new Experience();
    }
    
    public void login(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("--------Internship System--------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    }

    public void createAccount(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("--------Internship System--------");
        System.out.println("Are you a student or an organization? Input 1 for student or 2 for organization:  ");
        int userInput = getUserInput();
        if(userInput == 1){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--------Internship System--------");
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
            System.out.println("");
            createStudentProfile();
            createResume();    
        }
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
    }

    private void createExperiences(){
        System.out.println("Input experience. Enter \"quit\" before adding an experience to quit");
        System.out.println("");
        boolean count = true; 
        while(count){
            System.out.print("Input title:  ");
            String title = scanner.nextLine();
            experience.addTitle(title);
            System.out.print("Input description:");
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

    }

    public int getUserInput(){
        String input = scanner.nextLine();
        int userInput = Integer.parseInt(input);
        return userInput;
    }







    
}
