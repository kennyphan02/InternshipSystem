import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InternshipUI {
    private Scanner scanner;
    private InternshipSystem internshipSystem;
    private int studentUser;
    private int organizationUser;
    private int studentInput;
    private int guestInput;
    private int guestUser;

    InternshipUI()  {
        scanner = new Scanner(System.in);
        internshipSystem = new InternshipSystem();
        studentUser = 0;
        organizationUser = 0;
        guestUser = 1;
    }

    public void run() {
        while(true){
            if(studentUser == 0 && organizationUser == 0){
                displayMainMenu();
            }
            if(guestUser == 1){
                guestInput = internshipSystem.getUserInput();
                if(guestInput == 1){
                    // searchInternship();
                } else if(guestInput == 2){
                    login();
                } else if(guestInput == 3){
                    createAccount();
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
            }
            if(studentUser == 1){
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
        // System.out.println("Input 8 to display student's resume");
    }
    private void inputUserOptions(){
        studentInput = internshipSystem.getUserInput();
        if(studentInput == 6){
            logOff();
        }
        else if(studentInput == 4){
            internshipSystem.editStudentProfile();
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
        studentUser = 0;
        organizationUser = 0;
        guestUser = 1;
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
        clearConsole();
        System.out.println("--------Internship System--------");
        System.out.println("Are you a student or an organization? Input 1 for student or 2 for organization:  ");
        int input = internshipSystem.getUserInput();
        if(input == 1){
            studentUser = 1;
            guestUser = 0;
            internshipSystem.createStudentAccount();
        }
        else if(input == 2){

        }
        else{
            try {
                System.out.println("\nInvalid input...");
                TimeUnit.MILLISECONDS.sleep(1000); 
                clearConsole();
                createAccount();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
    public static void main(String[] args)  {
        InternshipUI driver = new InternshipUI();
        driver.run();
    }
}
