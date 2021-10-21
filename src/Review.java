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
    public Review(UUID id, String title, String comment, int rating) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.rating = rating;
    }

    public String toString() {
        return "";
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
