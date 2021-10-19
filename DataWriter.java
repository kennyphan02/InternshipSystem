import java.io.FileWriter;
import java.util.ArrayList;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        User users = users.getInstance();
        ArrayList<User> userList = users.getUsers();

        for(int i=0; i<userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }
    }
}
