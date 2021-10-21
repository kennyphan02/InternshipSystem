import java.util.Scanner;

public class InternshipUI {
    private Scanner scanner;
    private InternshipSystem internshipSystem;
    private int studentMenu;
    private int organizationMenu;

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
            int userInput = internshipSystem.getUserInput();
            if(userInput == 1){
                // searchInternship();
            } else if(userInput == 2){
                login();
            } else if(userInput == 3){
                createAccount();
                studentMenu = 1;
            } else {
                System.out.println("Invalid Option");
            }
            if(studentMenu == 1){
                System.out.print("\033[H\033[2J");
                System.out.flush();
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
    }

    private void displayStudentMenu(){
        System.out.println("--------Internship System--------");
        System.out.println("Input a number based off the choices below");
        System.out.println("1. Search Internship");
        System.out.println("2. View bookmarks for internships");
        System.out.println("3. View my internship reviews");
        System.out.println("4. View my student reviews");
        System.out.println("5. Edit student profile");
        System.out.println("6. Pending Internships");
        System.out.println("7. Logout");
    }
    private void inputUserOptions(){
        
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
