import java.util.ArrayList;

public class Education {

    private String degree;
    private ArrayList<String> description;

    /**
     * Default constructor that initalizes the degree and description/
     * @param degree a String being initalized
     */
    public Education(String degree) {
        this.degree = degree;
        description = new ArrayList<String>();
    }

    public void addDescription(String description) {
        return;
    }

    public String toString() {
        return "";
    }

}
