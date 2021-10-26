import java.util.ArrayList;
import java.util.UUID;

public class studentReviews {

    private static studentReviews studentReviews = null;
    private static ArrayList<Review> studentReviewsList = new ArrayList<Review>();

    private studentReviews() {
        studentReviewsList = DataLoader.getStudentReviews();
    }

    public static studentReviews getInstance() {
        if(studentReviews == null) {
            studentReviews = new studentReviews();
        }
        return studentReviews;
    }

    public ArrayList<Review> getstudentReviewsList() {
        return studentReviewsList;
    }

    public Review getReview(UUID target) {
        for (int i = 0; i < studentReviewsList.size(); i++) {
            if(studentReviewsList.get(i).getId() == target) {
                return studentReviewsList.get(i);
            }
        }
        return null;
    }

    public void addReview(Review r) {
        studentReviewsList.add(r);
    }

    public void removeReview(Review r) {
        studentReviewsList.remove(r);
    }

    public void logout() {

    }
    
}