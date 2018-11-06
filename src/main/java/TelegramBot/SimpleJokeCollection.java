package TelegramBot;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class SimpleJokeCollection implements FileExplorer<String> {
    private File storage;
    private ArrayList<String> listJokes;
    private String fileName;
    private JokeParser parser;

    SimpleJokeCollection() {
        URL classesRootDir = getClass().getProtectionDomain().getCodeSource().getLocation();
        String fullPath = classesRootDir.getPath();
        fileName = fullPath.substring(0, fullPath.length() - 15) + "src\\main\\java\\TelegramBot\\jokeCollection";
        storage = new File(fileName);
        listJokes = ParseFile();
        parser = new SimpleJokeParser();
    }

    public String GetJokeByIndex(int index) throws FileNotFoundException {
        if (index >= listJokes.size()) {
            String newAnek = parser.GetNextJoke();
            if (newAnek == null)
                return "jokes is over";
            listJokes.add(newAnek);
            WriteInformationInFile(newAnek);
            return newAnek;
        }
        else
            return listJokes.get(index);
    }

    private ArrayList<String> ParseFile(){
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
