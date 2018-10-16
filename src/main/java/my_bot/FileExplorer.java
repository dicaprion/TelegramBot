package my_bot;

import java.util.HashMap;

public interface FileExplorer {
    HashMap<Integer, User> GetHashListOfUsers();
    void WriteUserInFile(int userID);
}
