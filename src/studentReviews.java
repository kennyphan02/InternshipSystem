import java.util.ArrayList;

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

    public Review getReview(int index) {
        return studentReviewsList.get(index);
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