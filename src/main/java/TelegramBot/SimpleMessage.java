package TelegramBot;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class SimpleMessage implements Message {
    private String text = "";
    private Calendar sendTime;
    private int chatId;

    public SimpleMessage CreateMessage(String request){
        try {
            String[] lines = request.split("\n");
            boolean flag = true;
            boolean flag1 = true;
            boolean first = true;
            for (String line : lines) {
                if (first){
                    first = false;
                    continue;
                }
                if (line.equals("----")) {
                    flag = false;
                    continue;
                }
                if (flag)
                    text += line;
                else if (flag1) {
                    sendTime = Calendar.getInstance();
                    sendTime.setTime(new Date());
                    sendTime.add(Calendar.MINUTE, Integer.parseInt(line));
                    flag1 = false;
                } else
                    chatId = Integer.parseInt(line);
            }
            if (flag1){
                sendTime = Calendar.getInstance();
                sendTime.setTime(new Date());
                chatId = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public String toString(){
        return "Message with text : " + text + "  delay(minutes) " + sendTime.toString() + " to ChatID  " + chatId;
    }

    @Override
    public String getMessageText() {
        return text;
    }

    @Override
    public Integer getChatId() {
        return chatId;
    }

    @Override
    public Calendar getSendTime() {
        return sendTime;
    }

    @Override
    public void setMessageText(String s) {
        text = s;
    }

    @Override
    public void setChatId(int s) {
        chatId = s;
    }

    @Override
    public void setSendTime(Calendar s) {
        sendTime = s;
    }
}
