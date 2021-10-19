import java.util.ArrayList;
import java.util.Scanner;

public class Experience {

    private String title;
    private ArrayList<String> description;
    private Scanner scanner;
    
    public Experience(String title) {
        this.title = title;
        this.description = new ArrayList<String>();
        scanner = new Scanner(System.in);

    }

    public void addDescription(String description) 
    {
        this.description.add(description);
    }

    public String toString() {
        return "";
    }
    
}
