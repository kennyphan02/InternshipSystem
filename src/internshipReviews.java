import java.util.ArrayList;

public class internshipReviews {

    private static internshipReviews internshipReviews = null;
    private static ArrayList<Review> internshipReviewsList = new ArrayList<Review>();

    private internshipReviews() {
        internshipReviewsList = DataLoader.getInternshipReviews();
    }

    public static internshipReviews getInstance() {
        if(internshipReviews == null) {
            internshipReviews = new internshipReviews();
        }
        return internshipReviews;
    }

    public ArrayList<Review> getinternshipReviewsList() {
        return internshipReviewsList;
    }

    public Review getReview(int index) {
        return internshipReviewsList.get(index);
    }

    public void addReview(Review r) {
        internshipReviewsList.add(r);
    }

    public void removeReview(Review r) {
        internshipReviewsList.remove(r);
    }

    public void logout() {

    }
    
}