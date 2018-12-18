package TelegramBot;

import java.util.ArrayDeque;

public interface RandomMessage {
    //ArrayDeque<Message> queue = new ArrayDeque<Message>();
    Message GetFirstInQueue();
    //Message GetMessage();
    void AddMessage(Message message);
}
