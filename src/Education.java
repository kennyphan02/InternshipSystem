/**
 * Keeps track of information for user eeducation
 * @author Maru-Chan: KennyPhan, JacobSuhs, DanaiAngelidis, DanielNguyen, ThomasVu
 */
public class Education {
    private String uni;
    private String degree;
    private String gradDate;

    //Hold instance values for each instance of Education.
    public Education (String uni, String degree, String gradDate) {
        this.uni = uni;
        this.degree = degree;
        this.gradDate = gradDate;
    }

    /**
     * Returns all instance values
     * @return instance values for education
     */
    public String toString() {
        return "University: " + uni + "\n" + "Degree: " + degree + "\n" + "Grad Date: " + gradDate + "\n";
    }
}
