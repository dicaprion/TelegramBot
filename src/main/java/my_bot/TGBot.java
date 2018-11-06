package my_bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TGBot extends TelegramLongPollingBot implements Runnable {

    private AnswerGenerator solver;
    private UsersBaseInterface base = new UsersBase();

    public void run() {
        TelegramBotsApi botApi = new TelegramBotsApi();
        try {
            botApi.registerBot(new TGBot(this.solver));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    TGBot(AnswerGenerator generator) {
        this.solver = generator;
    }

    public void onUpdateReceived(Update update){
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            sendMsg(message, solver.GetAnswer(message.getText()));
        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        if (!base.isContains(message.getChatId().intValue())) {
            base.AddNewUser(message.getChatId().intValue());
            //text = text + "\n But first tell me how can i name you?\n ";
        }
        //System.out.print(message.getChatId().intValue() + "\n");
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
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
