package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleJokeParserTest {
    @Test
    void parser(){
        SimpleJokeParser jokeParser = new SimpleJokeParser();
        Assert.assertTrue(jokeParser.list.size() != 0);
    }

    @Test
    void getJoke(){
        SimpleJokeGetter jokeGetter = new SimpleJokeGetter();
        Assert.assertEquals(jokeGetter.list.get(0), jokeGetter.GetNextJoke());
    }
}