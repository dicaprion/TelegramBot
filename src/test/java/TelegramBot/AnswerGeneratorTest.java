package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

class AnswerGeneratorTest {

    @Test
    void hiTest() {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        generator.GetAnswer("hi", 1, null);
        String helpString = "Hi, What do you want? I am busy, but I think, I can find one minute for you\n" +
                "If you want to know what date is it, write /date\n" + "If you want to get a joke, write /joke\n";
        Assert.assertEquals(generator.GetAnswer("hi", 1, null), helpString);
    }

    @Test
    void dateTest() {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        Assert.assertEquals(generator.GetAnswer("date", 1, null),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
    }

    @Test
    void unknowRequestTest() {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        Assert.assertEquals(generator.GetAnswer("tert", 1, null), "khmm, I don't know, what should I say\n");
    }
}