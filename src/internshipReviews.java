import java.util.ArrayList;
import java.util.UUID;

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

    public Review getReview(UUID target) {
        for (int i = 0; i < internshipReviewsList.size(); i++) {
            if(internshipReviewsList.get(i).getId() == target) {
                return internshipReviewsList.get(i);
            }
        }
        return null;
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