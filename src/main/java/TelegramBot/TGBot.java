package TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TGBot extends TelegramLongPollingBot implements Runnable {

    private AnswerGenerator solver;
    private UsersBaseInterface base;

    public void run() {
        TelegramBotsApi botApi = new TelegramBotsApi();
        try {
            botApi.registerBot(new TGBot(this.solver, this.base));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    TGBot(AnswerGenerator generator, String fileName) {
        base = new UsersBase(fileName);
        this.solver = generator;
    }

    TGBot(AnswerGenerator generator, UsersBaseInterface uBase) {
        base = uBase;
        this.solver = generator;
    }

    private TelegramBot.Message rndMess(){
        try {
            TelegramBot.Message ms = solver.GetMesQueue().GetFirstInQueue();
            Calendar sendTime = Calendar.getInstance();
            sendTime.setTime(new Date());
            System.out.println(ms.sendTime.compareTo(sendTime));
            System.out.println(ms.sendTime.getTime());
            System.out.println(sendTime.getTime());
            if (ms.sendTime.compareTo(sendTime) <= 0){
                return solver.GetMesQueue().GetMessage();
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }

    public void onUpdateReceived(Update update){
        TelegramBot.Message ms = rndMess();
        if (ms != null){
            if (ms.chatId == -1)
                ms.chatId = base.
            sendMsg(ms.chatId, "message from unknown user \n" + ms.text);
        }
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            try {
                base.IsNewUser(message.getChatId().intValue());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            sendMsg(message.getChatId().intValue(), solver.GetAnswer(message.getText(), message.getChatId().intValue(), base));
        }
    }

    private void sendMsg(int chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        ArrayList<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstLine= new KeyboardRow();
        keyboardFirstLine.add("date");
        keyboardFirstLine.add("joke");
        KeyboardRow keyboardSecondLine = new KeyboardRow();
        keyboardSecondLine.add("help");
        keyboard.add(keyboardFirstLine);
        keyboard.add(keyboardSecondLine);
        replyKeyboardMarkup.setKeyboard(keyboard);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "UrFU Ft-202";
    }

    public String getBotToken() {
        return "616457548:AAEOiC4COqi8epMpNz9q-GhHx69hSPsiQFk";
    }
}
