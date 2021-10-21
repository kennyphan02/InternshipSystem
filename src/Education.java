import java.util.ArrayList;
import java.util.Scanner;

public class Education {

    private ArrayList<String> degrees;
    private ArrayList<String> descriptions;
    private Scanner scanner;

    /**
     * Default constructor that initalizes the degree and description. scanner is initalized for future usages.
     * @param degree type string
     */
    public Education() {
        this.degrees = new ArrayList<String>();
        this.descriptions = new ArrayList<String>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a description to the arraylist of descriptions. The user may want to add multiple descriptions on the education section of their resume. 
     * @param description type String
     */
    public void addDescription(String description) {
        this.descriptions.add(description);
    }

    public void addDegree(String degree) {
        this.degrees.add(degree);
    }

    /**
     * To be implemented
     */
    public String toString() {
        return "";
    }

    public ArrayList<String> getDegrees() {
        return degrees;
    }

    public ArrayList<String> getDesc() {
        return descriptions;
    }

}
