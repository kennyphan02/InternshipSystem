import java.util.ArrayList;
import java.util.Scanner;

/**
 * Keeps track of information for user eeducation
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Experience {

    private ArrayList<String> titles;
    private ArrayList<String> descriptions;
    
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
     * Adds a description to the arraylist of descriptions. The user shall add multiple descriptions as needed. 
     * @param description type String
     */
    public void addDescription(String description) 
    {
        this.descriptions.add(description);
    }

    /**
     * Adds a title to an arraylist of titles. The user shall add multiple titles as needed.
     */
    public void addTitle(String title) 
    {
        this.titles.add(title);
    }


    /**
     * Returns all titles and descriptions for the user.
     * to be implemented
     */
    public String toString() {
        String list = "";
        for(int i = 0; i < this.titles.size(); i++){
            list += "       Title: " + this.titles.get(i) + "\n         Description: " + this.descriptions.get(i) + "\n\n***************\n";
        }
        return " " + list;
    }
    
    /**
     * Get the titles for the user.
     * @return titles
     */
    public ArrayList<String> gettitles() {
        return titles;
    }

    /**
     * Get the descriptions for the user.
     * @return descriptions
     */
    public ArrayList<String> getdescriptions() {
        return descriptions;
    }
}
