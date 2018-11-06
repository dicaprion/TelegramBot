package TelegramBot;

import java.io.FileNotFoundException;

public interface UsersBaseInterface {
    void AddNewUser(int userID) throws FileNotFoundException;
    Boolean isContains(int userID);
    void IsNewUser(int message) throws FileNotFoundException;
    User GetUserById(int userId);
}

