public class LoadTester {
    public static void main(String[] args)  {
        Resumes.getInstance();
        System.out.println("Loaded Resumes Without Errors.");
        Students.getInstance();    
    }
}
