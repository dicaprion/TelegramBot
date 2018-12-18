package TelegramBot;

import java.util.Calendar;

public interface Message {
    SimpleMessage CreateMessage(String request);
    String toString();
    String getMessageText();
    Integer getChatId();
    Calendar getSendTime();
    void setMessageText(String s);
    void setChatId(int s);
    void setSendTime(Calendar s);
}
