import java.util.Scanner;

public class InternshipUI {
    private Scanner scanner;
    private InternshipSystem internshipSystem;

    InternshipUI()  {
        scanner = new Scanner(System.in);
        internshipSystem = new InternshipSystem();
    }

    public void run() {
        displayMainMenu();
        int userInput = internshipSystem.getUserInput();
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
        // internshipSystem.searchInternship();
    }

    private void login() {
        internshipSystem.login();
    }

    private void createAccount(){
        internshipSystem.createAccount();
    }
    public static void main(String[] args)  {
        InternshipUI driver = new InternshipUI();
        driver.run();
    }
}
