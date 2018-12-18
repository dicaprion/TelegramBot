package TelegramBot;

import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class SimpleMessageQueue implements RandomMessage {

    @Override
    public Message GetFirstInQueue() {
        if (queue.size() > 0)
            return queue.element();
        else
            return null;
    }

    @Override
    public Message GetMessage() {
        return queue.poll();
    }

    @Override
    public void AddMessage(Message message) {
        this.queue.offerLast(message);
    }
}
