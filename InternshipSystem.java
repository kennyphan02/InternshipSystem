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
    }

    public int getUserInput(){
        String input = scanner.nextLine();
        int userInput = Integer.parseInt(input);
        return userInput;
    }







    
}
