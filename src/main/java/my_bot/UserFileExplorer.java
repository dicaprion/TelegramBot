package my_bot;

import java.util.HashMap;

public interface UserFileExplorer {
    HashMap<Integer, User> GetHashListOfUsers();
    void WriteUserInFile(int userID);
}
