import java.util.Scanner;

public class InternshipSystem {
    private InternshipList internshipList;
    private UserList userList;
    private Scanner scanner;

    public InternshipSystem(){
        // internshipList = InternshipList.getInstance();
        // userList = UserList.getInstance();
        scanner = new Scanner(System.in);
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
            String username = scanner.nextLine();
            System.out.print("Input password: ");
            String password = scanner.nextLine();
            System.out.print("Input email: ");
            String email = scanner.nextLine();
            System.out.print("Input birthday: ");
            String birthday = scanner.nextLine();
            System.out.print("Input country: ");
            String country = scanner.nextLine();
            System.out.println("");
            System.out.println("Create your student profile that will be displayed to organizations: ");
            System.out.println("");
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Email: " + email);
            System.out.println("Birthday: " + birthday);
            System.out.println("Country: " + country);
            System.out.print("College: ");
            String college = scanner.nextLine();
            System.out.println("");
            System.out.println("Add the following details to your resume:");
            System.out.println("");
            System.out.println("First Name: " + firstName);
            System.out.println("Last name: " + lastName);
            System.out.print("Profession: ");
            String profession = scanner.nextLine();
            System.out.println("Email: " + email);
            System.out.println("");
            System.out.println("Input experience. Enter 1 to stop adding experiences");
            boolean count = true;
            while(count){

            
            }



            
        }
    }

    public int getUserInput(){
        String input = scanner.nextLine();
        int userInput = Integer.parseInt(input);
        return userInput;
    }







    
}
