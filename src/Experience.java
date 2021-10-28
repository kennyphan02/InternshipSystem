import java.util.ArrayList;

/**
 * Keeps track of information for user eeducation
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Experience {
    private String title;
    private String company;
    private String startDate;
    private String endDate;
    private ArrayList<String> responsibilities;

    //Hold values for each instance of experience.
    public Experience(String title, String company, String startDate, String endDate, ArrayList<String> responsibilities) {
        this.title = title;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.responsibilities = responsibilities;
    }

    //Returns all the descriptions for the instance of experience.
    public String toString() {
        return "Title: " + title + "\n" +  "Company: " + company + "\n" + "Start Date: " + startDate + "\n" + "End Date: " + endDate + "\n" + "Responsibilities: " + responsibilities.toString() + "\n";
    }
}
