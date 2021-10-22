import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InternshipUI {
    private Scanner scanner;
    private InternshipSystem internshipSystem;
    private int studentMenu;
    private int organizationMenu;
    private int studentInput;

    InternshipUI()  {
        scanner = new Scanner(System.in);
        internshipSystem = new InternshipSystem();
        studentMenu = 0;
        organizationMenu = 0;
    }

    public void run() {
        while(true){
            if(studentMenu == 0 && organizationMenu == 0){
                displayMainMenu();
            }
            int guestInput = internshipSystem.getUserInput();
            if(guestInput == 1){
                // searchInternship();
            } else if(guestInput == 2){
                login();
            } else if(guestInput == 3){
                createAccount();
                studentMenu = 1;
            } else if(guestInput == 4) {
                break;
            } else {
                try {
                    System.out.println("\nInvalid Option...");
                    TimeUnit.MILLISECONDS.sleep(1000); 
                } catch (Exception e) {
                    System.out.println("Error");
                }
                clearConsole();

            }
            if(studentMenu == 1){
                guestInput = 0;
                clearConsole();
                displayStudentMenu();
                inputUserOptions();
            }
        }
    }
    
    private void displayMainMenu()  {
        System.out.println("--------Internship System--------");
        System.out.println("\nInput a number based off the choices below");
        System.out.println("1. Search Internship\n");
        System.out.println("2. Login\n");
        System.out.println("3. Create an Account\n");
        System.out.println("4. Quit\n");
    }

    private void displayStudentMenu(){
        System.out.println("--------Internship System--------");
        System.out.println("Input a number based off the choices below");
        System.out.println("1. Search Internship");
        System.out.println("2. View bookmarks for internships");
        System.out.println("3. View my student reviews");
        System.out.println("4. Edit student profile");
        System.out.println("5. Pending Internships");
        System.out.println("6. Logout");
        System.out.println("Input 8 to display student's resume");
    }
    private void inputUserOptions(){
        studentInput = internshipSystem.getUserInput();
        if(studentInput == 6){
            logOff();
        }
        if(studentInput == 8){
            System.out.println(internshipSystem.getResume());
            System.exit(0);
        }

    }

    private void logOff(){
        try {
            System.out.println("\nLogging off...");
            TimeUnit.MILLISECONDS.sleep(1000); 
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        studentMenu = 0;
        organizationMenu = 0;
        clearConsole();
    }

    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void searchInternship(){
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
