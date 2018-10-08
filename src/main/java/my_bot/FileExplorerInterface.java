package my_bot;

import java.util.HashMap;

public interface FileExplorerInterface {
    HashMap<Integer, User> GetHashListOfUsers();
    void WriteUserInFile(int userID);
}
