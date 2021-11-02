import java.util.ArrayList;
import java.util.UUID;

/**
 * Hold operations for instances of internship reviews
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class internshipReviews {

    private static internshipReviews internshipReviews = null;
    private static ArrayList<Review> internshipReviewsList = new ArrayList<Review>();

    //Calls on DataLoader to populate an ArrayList from internshipReviews.json
    private internshipReviews() {
        internshipReviewsList = DataLoader.getInternshipReviews();
    }

    /**
     * Checks for instance of internshipReviews. Returns instance if it exists;
     * otherwise, one will be constructed.
     * @return internshipReview if it exists
     */
    public static internshipReviews getInstance() {
        if(internshipReviews == null) {
            internshipReviews = new internshipReviews();
        }
        return internshipReviews;
    }

     /**
     * Gets the list of internship reviews.
     * @return the ArrayList of internship reviews
     */
    public ArrayList<Review> getinternshipReviewsList() {
        return internshipReviewsList;
    }

    /**
     * Gets an instance of internship review from ArrayList
     * @param target
     * @return the selected internship review
     */
    public Review getReview(UUID target) {
        for (int i = 0; i < internshipReviewsList.size(); i++) {
            if(internshipReviewsList.get(i).getId() == target) {
                return internshipReviewsList.get(i);
            }
        }
        return null;
    }

    //Adds an internship review from JSON into ArrayList.
    public void addReview(Review r) {
        internshipReviewsList.add(r);
    }

    //Removes an internship review from the ArrayList.
    public void removeReview(Review r) {
        internshipReviewsList.remove(r);
    }

    //Sends data from this singleton to DataWriter.
    public void logout() {
        DataWriter.saveInternshipReview();
    }
    
}