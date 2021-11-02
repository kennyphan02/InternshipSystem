import java.util.ArrayList;
import java.util.UUID;

/**
 * Hold operations for instances of Students
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class studentReviews {

    private static studentReviews studentReviews = null;
    private static ArrayList<Review> studentReviewsList = new ArrayList<Review>();

    //Calls on DataLoader to populate ArrayList from JSON file.
    private studentReviews() {
        studentReviewsList = DataLoader.getStudentReviews();
    }

    /**
     * Checks for instance of studentReviews. Returns instance if it exists;
     * otherwise, one will be constructed.
     * @return studentReview if it exists
     */
    public static studentReviews getInstance() {
        if(studentReviews == null) {
            studentReviews = new studentReviews();
        }
        return studentReviews;
    }

    /**
     * Gets the list of student reviews.
     * @return the ArrayList of student reviews
     */
    public ArrayList<Review> getstudentReviewsList() {
        return studentReviewsList;
    }

    /**
     * Gets an instance of review from array list.
     * @param target
     * @return selected review
     */
    public Review getReview(UUID target) {
        for (int i = 0; i < studentReviewsList.size(); i++) {
            if(studentReviewsList.get(i).getId() == target) {
                return studentReviewsList.get(i);
            }
        }
        return null;
    }

    //Adds a review from the JSON file into the array list.
    public void addReview(Review r) {
        studentReviewsList.add(r);
    }

    //Removes an instance of review from the array list.
    public void removeReview(Review r) {
        studentReviewsList.remove(r);
    }

    //Sends data from review singleton to DataWriter.
    public void logout() {
        DataWriter.saveStudentReview();
    }
    
}