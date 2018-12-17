package TelegramBot;

public interface RandomMessage {
    Message GetFirstInQueue();
    Message GetMessage();
    void AddMessage(Message message);
}
