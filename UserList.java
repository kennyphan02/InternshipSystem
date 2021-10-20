public class UserList {
    private ArrayList<User> userList;
    private static UserList users;
    private UserList() {

    }
    public static UserList getInstance(){
        if(users == null){
            users = new UserList();
        }
        return users;
    }
}
