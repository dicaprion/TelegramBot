package my_bot;

import java.util.HashMap;

public class UsersBase implements UsersBaseInterface {

    private UserFileExplorer explorer = new SimpleFileExplorer();
    private HashMap<Integer, User> allUsers = new HashMap<Integer, User>();

    public void AddNewUser(int userID){
        if (allUsers.keySet().contains(userID))
            return;
        allUsers.put(userID, new User(userID));
        explorer.WriteUserInFile(userID);
    }

    public Boolean isContains(int userID){
        if (allUsers.keySet().contains(userID))
            return true;
        return false;
    }

    UsersBase(){
        allUsers = explorer.GetHashListOfUsers();
    }

    UsersBase(String fileName){
        this.explorer = new SimpleFileExplorer(fileName);
        allUsers = explorer.GetHashListOfUsers();
    }
}
