import java.util.ArrayList;

/**
 * Keeps track of information for user eeducation
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Education {

    private ArrayList<String> degrees;
    private ArrayList<String> descriptions;

    /**
     * Default constructor that initalizes the degree and description. scanner is initalized for future usage.
     * @param degree type string
     */
    public Education() {
        this.degrees = new ArrayList<String>();
        this.descriptions = new ArrayList<String>();
    }

    /**
     * Adds a description to the arraylist of descriptions. The user shall add multiple descriptions as needed. 
     * @param description type String
     */
    public void addDescription(String description) {
        this.descriptions.add(description);
    }

    /**
     * Adds a degree to the arraylist of degrees. User shall add multiple degrees as needed.
     * @param degree type String
     */
    public void addDegree(String degree) {
        this.degrees.add(degree);
    }

    /**
     * Returns all degrees and descriptions for user.
     * To be implemented
     */
    public String toString() {
        String list = "";
        for(int i = 0; i < this.degrees.size(); i++){
            list += "       Degree: " + this.degrees.get(i) + "\n       Description: " + this.descriptions.get(i) + "\n\n***************\n";
        }
        return "\n" + list;
    }

    /**
     * Get the degrees for the user.
     * @return degrees 
     */
    public ArrayList<String> getDegrees() {
        return degrees;
    }

    /**
     * Get the descriptions for the user.
     * @return descriptions of education
     */
    public ArrayList<String> getDesc() {
        return descriptions;
    }

}
