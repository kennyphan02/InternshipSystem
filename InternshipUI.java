import java.util.Scanner;

public class InternshipUI {
    private String[] mainMenuOptions = {"Search Internship","Login","Create an Account"};
    private Scanner scanner;
    private Internship internship;

    InternshipUI()  {
        scanner = new Scanner(System.in);
        internship = new Internship();
    }
    public void run() {
        Scanner keyboard = new Scanner(System.in);
        int option = keyboard.nextInt();
        boolean undecided = true;
        while (undecided)   {
            if (option == 1)    {
                undecided = false;
                searchInternship();
            } else if (option == 2) {
                undecided = false;
                login();
            } else if (option == 3) {
                undecided = false;
                createAcc();
            } else  {
                System.out.println("Error: incorrect input");
                }
        }
    }
    /**
     * Code based on library example
     */
    private void displayMainMenu()  {
        System.out.println("--------Internship System--------");
        System.out.println("\nInput a number based off the choices below");
        for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
    }

    private void searchInternship()   {

    }

    private void login() {
        
    }

    private void createAcc()    {

    }

    public static void main(String[] args)  {
        InternshipUI main = new InternshipUI();
        main.run();
    }
}
