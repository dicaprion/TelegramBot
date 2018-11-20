package TelegramBot;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class SimpleJokeFileExplorer implements FileExplorer<String> {
    private String fileName;

    SimpleJokeFileExplorer(String filePath) {
        URL classesRootDir = getClass().getProtectionDomain().getCodeSource().getLocation();
        String fullPath = classesRootDir.getPath();
        fileName = fullPath.substring(0, fullPath.length() - 15) + filePath;
    }

    public ArrayList<String> ParseFile(){
        ArrayList<String> result = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String temp = "";
            while ((strLine = br.readLine()) != null) {
                if (strLine.equals("~")) {
                    result.add(temp);
                    temp = "";
                }
                else
                    temp += strLine + "\n";
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<String> GetInformationFromFile() {
        return ParseFile();
    }

    @Override
    public void WriteInformationInFile(String info) throws FileNotFoundException {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(info + "~");
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
