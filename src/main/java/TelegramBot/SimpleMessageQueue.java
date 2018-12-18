package TelegramBot;

import java.util.*;

public class SimpleMessageQueue implements RandomMessage {
    ArrayDeque<Message> queue = new ArrayDeque<Message>();

    @Override
    public synchronized Message GetFirstInQueue() {
        Calendar sendTime = Calendar.getInstance();
        sendTime.setTime(new Date());
        if (queue.size() > 0 && queue.getFirst().getSendTime().compareTo(sendTime) <= 0)
            return queue.poll();
        else
            return null;
    }

    //@Override
    //public synchronized Message GetMessage() {
        //return queue.poll();
    //}

    @Override
    public synchronized void AddMessage(Message message) {
        this.queue.offerLast(message);
    }
}
