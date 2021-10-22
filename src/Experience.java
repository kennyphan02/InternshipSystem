import java.util.ArrayList;
import java.util.Scanner;

public class Experience {

    private ArrayList<String> titles;
    private ArrayList<String> descriptions;
    private Scanner scanner;
    
    /**
     * Default constructor that initalizes the degree and description. scanner is initalized for future usages.
     * @param title type string
     */
    public Experience() {
        this.titles = new ArrayList<String>();
        this.descriptions = new ArrayList<String>();
        scanner = new Scanner(System.in);

    }

    /**
     * Adds a description to the arraylist of descriptions. The user may want to add multiple descriptions on the experience section of their resume. 
     * @param description type String
     */
    public void addDescription(String description) 
    {
        this.descriptions.add(description);
    }

    public void addTitle(String title) 
    {
        this.titles.add(title);
    }


    /**
     * to be implemented
     */
    public String toString() {
        String list = "";
        for(int i = 0; i < this.titles.size(); i++){
            list += "       Title: " + this.titles.get(i) + "\n         Description: " + this.descriptions.get(i) + "\n\n***************\n";
        }
        return " " + list;
    }
    
    public ArrayList<String> gettitles() {
        return titles;
    }
    public ArrayList<String> getdescriptions() {
        return descriptions;
    }
    public Scanner getscanner() {
        return scanner;
    }
}
