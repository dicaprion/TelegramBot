package TelegramBot;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Message {
    String text = "";
    Calendar sendTime;
    int chatId;

    Message CreateMessage(String request){
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
            if (flag){
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
}
