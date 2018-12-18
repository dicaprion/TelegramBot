package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMessageQueueTest {

    @Test
    void getFirstInQueue() {
        SimpleMessageQueue queue = new SimpleMessageQueue();
        Assert.assertEquals(queue.GetFirstInQueue(), null);
    }

    @Test
    void getMessage() {
        SimpleMessageQueue queue = new SimpleMessageQueue();
        Assert.assertEquals(queue.GetMessage(), null);
    }
}