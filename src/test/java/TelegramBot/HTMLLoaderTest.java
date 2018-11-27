package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTMLLoaderTest {
    @Test
    void LoadException(){
        HTMLLoader loader = new HTMLLoader("htts://ru.wikipedia.org");
        String result = loader.GetHTMLString();
        Assert.assertEquals(result, "");
    }
}