package my_bot;

import java.io.*;
import java.net.URL;
import java.util.HashMap;

public class SimpleFileExplorer implements UserFileExplorer {

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
        String path = fullPath.substring(0, fullPath.length() - 15) + "src\\main\\java\\my_bot\\base";
        fileName = path;
    }

    SimpleFileExplorer(String name){
        fileName = name;
    }

    @Override
    public HashMap<Integer, User> GetHashListOfUsers() {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                User user = getUserFromLine(strLine);
                if (user == null)
                    continue;
                result.put(user.GetUserID(), user);
                //System.out.println(strLine);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
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

    public void WriteUserInFile(int userID) {
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("userID: " + userID + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
