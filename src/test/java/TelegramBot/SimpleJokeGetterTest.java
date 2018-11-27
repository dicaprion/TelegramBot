package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleJokeGetterTest {

    @Test
    void getJoke(){
        SimpleJokeGetter jokeGetter = new SimpleJokeGetter("https://www.anekdot.ru/random/anekdot/");
        Assert.assertEquals(jokeGetter.list.get(0), jokeGetter.GetNextJoke());
    }
}