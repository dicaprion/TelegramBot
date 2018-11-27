package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleJokeFileExplorerTest {

    @Test
    void parseFile() {
        SimpleJokeFileExplorer JFE = new SimpleJokeFileExplorer("src\\main\\java\\TelegramBot\\jokeCollection");
        Assert.assertEquals(JFE.ParseFile().get(0), "\n В чем сходство между Виагрой и Диснейлэндом?\n" +
                " - Ждешь час ради двухминутного удовольствия.\n");
    }

    @Test
    void writeInformationInFile() throws FileNotFoundException {
        SimpleJokeFileExplorer JFE = new SimpleJokeFileExplorer("src\\main\\java\\TelegramBot\\test");
        JFE.CleanFile();
        JFE.WriteInformationInFile("hello world\n");
        Assert.assertEquals(JFE.ParseFile().get(0), "hello world\n");
    }
}