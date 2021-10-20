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
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

    }







    
}
