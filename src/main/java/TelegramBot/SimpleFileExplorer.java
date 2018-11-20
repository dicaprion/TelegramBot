package TelegramBot;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleFileExplorer implements FileExplorer<User> {

    private String fileName;

    public String GetFileName(){
        return fileName;
    }

    public void SetFileName(String fileName){
        this.fileName = fileName;
    }

    SimpleFileExplorer(){
        URL classesRootDir = getClass().getProtectionDomain().getCodeSource().getLocation();
        String fullPath = classesRootDir.getPath();
        fileName = fullPath.substring(0, fullPath.length() - 15) + "src\\main\\java\\TelegramBot\\baseTG";
    }

    SimpleFileExplorer(String name){
        URL classesRootDir = getClass().getProtectionDomain().getCodeSource().getLocation();
        String fullPath = classesRootDir.getPath();
        fileName = fullPath.substring(0, fullPath.length() - 15) + "src\\main\\java\\TelegramBot\\" + name;
    }

    @Override
    public ArrayList<User> GetInformationFromFile() {
        ArrayList<User> result = new ArrayList<User>();
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                User user = getUserFromLine(strLine);
                if (user == null)
                    continue;
                result.add(user);
                //System.out.println(strLine);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void WriteInformationInFile(User user) throws FileNotFoundException {
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("userID: " + user.GetUserID() + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getLastItem(Iterable dict){
        final Iterator itr = dict.iterator();
        User lastElement = (User) itr.next();
        while(itr.hasNext()) {
            lastElement = (User) itr.next();
        }
        return lastElement;
    }

    private User getUserFromLine(String text) {
        String[] parts = text.split(" ");
        int id = 0;
        try {
            id = Integer.parseInt(parts[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new User(id);
    }
}
