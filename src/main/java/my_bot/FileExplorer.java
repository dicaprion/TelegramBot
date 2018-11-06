package my_bot;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface FileExplorer {
    ArrayList<String> GetInformationFromFile() throws FileNotFoundException;
    void WriteInformationInFile();
}
