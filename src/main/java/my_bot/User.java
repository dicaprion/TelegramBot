package my_bot;

public class User {

    final private int userID;
    private String location;
    private String name;

    User(int chatId){
        userID = chatId;
    }

    User(int chatId, String location){
        userID = chatId;
        this.location = location;
    }

    public int GetUserID(){
        return userID;
    }

    public String GetLocation(){
        return location;
    }

    public void SetLocation(String location){
        this.location = location;
    }

    public String GetName(){
        return name;
    }

    public void SetName(String name){
        this.name = name;
    }
}
