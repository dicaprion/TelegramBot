package my_bot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

class AnswerGeneratorTest {

    @Test
    void hiTest() {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        generator.GetAnswer("hi");
        String helpString = "Hi, What do you want? I am busy, but I think, I can find one minute for you\n" +
                "If you want know? what date is it? write \"/date\"\n";
        Assert.assertEquals(generator.GetAnswer("hi"), helpString);
    }

    @Test
    void dateTest() {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        Assert.assertEquals(generator.GetAnswer("date"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
    }

    @Test
    void unknowRequestTest() {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        Assert.assertEquals(generator.GetAnswer("tert"), "khmm, I don't know, what should I say\n");
    }
}