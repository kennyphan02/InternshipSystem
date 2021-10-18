import java.util.Scanner;

public class InternshipUI {
    private Scanner scanner;
    private Internship internship;

    InternshipUI()  {
        scanner = new Scanner(System.in);
    }

    public void run() {
        displayMainMenu();
        int userInput = getUserInput();
        if(userInput == 1){

        } else if(userInput == 2){
            login();

        } else if(userInput == 3){
            createAccount();
        } else {
            
        }
    }
    
    private void displayMainMenu()  {
        System.out.println("--------Internship System--------");
        System.out.println("\nInput a number based off the choices below");
        System.out.println("1. Search Internship\n");
        System.out.println("2. Login\n");
        System.out.println("3. Create an Account\n");
    }

    private void searchInternship()   {
        
    }

    private void login() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("--------Internship System--------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

    }

    private void createAccount(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("--------Internship System--------");
        System.out.println("Are you a student or an organization? Input 1 for student or 2 for organization:  ");
        int userInput = getUserInput();


    }

    private int getUserInput(){
        String input = scanner.nextLine();
        int userInput = Integer.parseInt(input);
        return userInput;
    }

    public static void main(String[] args)  {
        InternshipUI driver = new InternshipUI();
        driver.run();
    }
}
