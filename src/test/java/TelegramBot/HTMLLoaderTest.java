package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTMLLoaderTest {
    @Test
    void LoadException(){
        HTMLLoader loader = new HTMLLoader();
        String result = loader.GetHTMLString("htts://ru.wikipedia.org");
        Assert.assertEquals(result, "");
    }
}