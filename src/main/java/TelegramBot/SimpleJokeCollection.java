package TelegramBot;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class SimpleJokeCollection {
    private File storage;
    private ArrayList<String> listJokes;
    private String fileName;
    private JokeGetter getter;
    private SimpleJokeFileExplorer jokeBase;

    SimpleJokeCollection(String jokeUrl, String filePath) {
        jokeBase = new SimpleJokeFileExplorer(filePath);
        listJokes = jokeBase.ParseFile();
        getter = new SimpleJokeGetter(jokeUrl);
    }

    public String GetJokeByIndex(int index) throws FileNotFoundException {
        if (index >= listJokes.size()) {
            String newAnek = getter.GetNextJoke();
            if (newAnek == null)
                return "jokes is over";
            listJokes.add(newAnek);
            jokeBase.WriteInformationInFile(newAnek);
            return newAnek;
        } else
            return listJokes.get(index);
    }
}
