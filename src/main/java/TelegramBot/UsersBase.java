package TelegramBot;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersBase implements UsersBaseInterface {

    private SimpleFileExplorer explorer = new SimpleFileExplorer();
    private Map<Integer, User> allUsers = new HashMap<Integer, User>();

    public void AddNewUser(int userID) throws FileNotFoundException {
        if (allUsers.keySet().contains(userID))
            return;
        User newUser = new User(userID);
        allUsers.put(userID, newUser);
        explorer.WriteInformationInFile(newUser);
    }

    public Boolean isContains(int userID){
        if (allUsers.keySet().contains(userID))
            return true;
        return false;
    }

    public User GetUserById(int id){
        for (Map.Entry<Integer, User> entry : allUsers.entrySet()) {
            if (id == entry.getKey())
                return entry.getValue();
        }
        return null;
    }

    public void IsNewUser(int id) throws FileNotFoundException {
        if (!isContains(id)) {
            AddNewUser(id);
        }
    }

    UsersBase(){
        allUsers = makeHashMap(explorer.GetInformationFromFile());
    }

    private HashMap<Integer, User> makeHashMap(ArrayList<User> info) {
        HashMap<Integer, User> res = new HashMap<Integer, User>();
        for (int i = 0; i < info.size(); i++) {
            User currentUser = info.get(i);
            res.put(currentUser.GetUserID(), currentUser);
        }
        return res;
    }

    UsersBase(String fileName){
        this.explorer = new SimpleFileExplorer(fileName);
        allUsers = makeHashMap(explorer.GetInformationFromFile());
    }
}
