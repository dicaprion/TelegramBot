package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleJokeCollectionTest {

    @Test
    void f() throws FileNotFoundException {
        SimpleJokeCollection jokeCollection = new SimpleJokeCollection("https://www.anekdot.ru/random/anekdot/", "src\\main\\java\\TelegramBot\\jokeCollection");
        Assert.assertEquals(jokeCollection.listJokes.get(2), jokeCollection.GetJokeByIndex(2));
    }

}