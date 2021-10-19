import java.util.ArrayList;
import java.util.Scanner;

public class Experience {

    private String title;
    private ArrayList<String> description;
    private Scanner scanner;
    
    /**
     * Default constructor that initalizes the degree and description. scanner is initalized for future usages.
     * @param title type string
     */
    public Experience(String title) {
        this.title = title;
        this.description = new ArrayList<String>();
        scanner = new Scanner(System.in);

    }

    /**
     * Adds a description to the arraylist of descriptions. The user may want to add multiple descriptions on the experience section of their resume. 
     * @param description type String
     */
    public void addDescription(String description) 
    {
        this.description.add(description);
    }

    /**
     * to be implemented
     */
    public String toString() {
        return "";
    }
    
}
