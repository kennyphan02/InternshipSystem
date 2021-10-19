import java.util.ArrayList;
import java.util.Scanner;

public class Education {

    private String degree;
    private ArrayList<String> description;
    private Scanner scanner;

    /**
     * Default constructor that initalizes the degree and description. scanner is initalized for future usages.
     * @param degree
     */
    public Education(String degree) {
        this.degree = degree;
        this.description = new ArrayList<String>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a description to the arraylist of descriptions. The user may want to add multiple descriptions on the education section of their resume. 
     * @param description 
     */
    public void addDescription(String description) {
        this.description.add(description);
    }

    public String toString() {
        return "";
    }

}
