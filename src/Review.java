import java.util.UUID;

public class Review {

    private UUID id;
    private String title;
    private String comment;
    private int rating;

    /**
     * Default constructor that initalizes the private variables of the Review class.
     * @param title type String
     * @param comment type String
     * @param rating type rating
     */
    public Review(String title, String comment, int rating) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.comment = comment;
        this.rating = rating;
    }

    /**
     * Default constructor that initalizes the private variables of the Review class.
     * @param id type UUID
     * @param title type String
     * @param comment type String
     * @param rating type int
     */
    public Review(UUID id, String title, String comment, int rating) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.rating = rating;
    }

    /**
     * prints out.
     */
    public String toString() {
        return "";
    }

    /**
     * gets the id.
     * @return the id of the student.
     */
    public UUID getId() {
        return id;
    }

    /**
     * gets the title of the review.
     * @return the title of the review. 
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets the comments of the reviews.
     * @return the comments of the reviews posted. 
     */
    public String getComment() {
        return comment;
    }

    /**
     * gets the rating posted. 
     * @return the rating that was posted. 
     */
    public int getRating() {
        return rating;
    }
}
