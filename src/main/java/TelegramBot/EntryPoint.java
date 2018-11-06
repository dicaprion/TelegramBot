package TelegramBot;

import org.telegram.telegrambots.ApiContextInitializer;

import java.io.FileNotFoundException;

public class EntryPoint {
    public static void main(String[] args) throws FileNotFoundException {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource());
        ApiContextInitializer.init();
        TGBot telegramBot = new TGBot(generator);
        CMDBot cmdBot = new CMDBot(generator);
        JThread tgThread = new JThread("Telegram bot", telegramBot);
        JThread cmdThread = new JThread("Cmd bot", cmdBot);
    }
}
