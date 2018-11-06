package TelegramBot;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface FileExplorer<T> {
    ArrayList<T> GetInformationFromFile();
    void WriteInformationInFile(T info) throws FileNotFoundException;
}
