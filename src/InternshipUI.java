import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InternshipUI {
    private Scanner scanner;
    private InternshipSystem internshipSystem;
    private int studentUser;
    private int organizationUser;
    private int studentInput;
    private int organizationInput;
    private int guestInput;
    private int guestUser;

    
    InternshipUI()  {
        scanner = new Scanner(System.in);
        internshipSystem = new InternshipSystem();
        studentUser = 0;
        organizationUser = 0;
        guestUser = 1;
    }

    /**
     * Runs the main UI system and waits for user to input a certain number. The program will
     * first print the main menu and then wait for the user to input any inputs. If the input 
     * matches the numbers the system would then call the next method and move on. If the number
     * does not match a output the system will print out an error message. 
     */
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
                } else{
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
                inputStudentOptions();
            }
            if(organizationUser == 1){
                clearConsole();
                displayOrganizationMenu();
                inputOrganizationOptions();
            }
        }
    }
    
    /**
     * Prints out main menu for the user to see what number to input. 
     */
    private void displayMainMenu()  {
        System.out.println("--------Internship System--------");
        System.out.println("Input a number based off the choices below");
        System.out.println("1. Search Internship\n");
        System.out.println("2. Login\n");
        System.out.println("3. Create an Account\n");
        System.out.println("4. Quit\n");
    }

    /**
     * Prints out student menu for the user to see what number to input. 
     */
    private void displayStudentMenu(){
        System.out.println("--------Internship System--------");
        System.out.println("Input a number based off the choices below");
        System.out.println("1. Search Internship");
        System.out.println("2. Add resume");
        System.out.println("3. Print resume");
        System.out.println("4. View my student reviews");
        System.out.println("5. Edit student profile");
        System.out.println("6. Pending Internships");
        System.out.println("7. Logout");
        // System.out.println("Input 8 to display student's resume");
    }

    /**
     * Prints out organization menu for the organization to see what number to input. 
     */
    private void displayOrganizationMenu(){
        System.out.println("--------Internship System--------");
        System.out.println("Input a number based off the choices below");
        System.out.println("1. Search Internship");
        System.out.println("2. View My Internship");
        System.out.println("3. View my student reviews");
        System.out.println("4. View my organization reviews");
        System.out.println("5. Edit organization profile");
        System.out.println("6. Logout");
    }

    /**
     * Takes the student input and calls the method. 
     */
    private void inputStudentOptions(){
        studentInput = internshipSystem.getUserInput();
        if(studentInput == 1){
            searchInternship();
        }
        else if(studentInput == 2){
            addResume();
        }
        else if(studentInput == 3){
            printResume();

        } 
        else if(studentInput == 7){
            logOff();
        }
        else if(studentInput == 5){
            internshipSystem.editStudentProfile();
        }

        //debugging
        if(studentInput == 8){
            System.out.println(internshipSystem.getResume());
            System.exit(0);
        }
    }
    private void inputOrganizationOptions(){
        organizationInput = internshipSystem.getUserInput();
        if(organizationInput == 2){
            viewMyInternship();
        }
        if(organizationInput == 6){
            logOff();
        }
    }
    private void addResume(){
        clearConsole();
        internshipSystem.addResume();

    
    }
    private void viewMyInternship(){
        internshipSystem.viewMyInternship();
    }
    private void printResume(){
        clearConsole();
        internshipSystem.printResume();
    }
    private void logOff(){
        try {
            System.out.println("\nLogging off...");
            TimeUnit.MILLISECONDS.sleep(300); 
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        studentUser = 0;
        organizationUser = 0;
        guestUser = 1;
        clearConsole();
    }

    /**
     * Clears the console. 
     */
    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Calls the searchInternship method. 
     */
    private void searchInternship(){
        internshipSystem.searchInternship();
    }

    /**
     * Login method that takes in the users username and password. It then checks to see if 
     * the username and password matches and prints out the next menu. 
     */
    private void login() {
        clearConsole();
        System.out.println("--------Internship System--------");
        System.out.print("Input user: ");
        String username = scanner.nextLine();
        System.out.print("Input pass: ");
        String password = scanner.nextLine();
        if(internshipSystem.login(username, password)){
            if(internshipSystem.getStudent() != null){
                guestUser = 0;
                studentUser = 1;
            }
            if(internshipSystem.getOrganization() != null){
                guestUser = 0;
                organizationUser = 1;
            }
            try {
                System.out.println("\nLogging in...");
                TimeUnit.MILLISECONDS.sleep(1000); 
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        else
        {
            System.out.println("Invalid Username/Password!");
        }

        
        
    }

    /**
     * Method that creates an account for a student or organization. It takes the user input 
     * and calls in the next method to create a student or organization account. 
     */
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
            organizationUser = 1;
            guestUser = 0;
            internshipSystem.createOrganizationAccount();
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
