import java.util.ArrayList;
import java.util.Scanner;

public class Education {

    private String degree;
    private ArrayList<String> description;
    private Scanner scanner;

    /**
     * Default constructor that initalizes the degree and description/
     * @param degree a String being initalized
     */
    public Education(String degree) {
        this.degree = degree;
        this.description = new ArrayList<String>();
        scanner = new Scanner(System.in);
    }
    public void addDescription(String description) {
        this.description.add(description);
    }
    
    public String toString() {
        return "";
    }

}
