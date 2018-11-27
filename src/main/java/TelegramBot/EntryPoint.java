package TelegramBot;

import org.telegram.telegrambots.ApiContextInitializer;

import java.io.FileNotFoundException;


public class EntryPoint {
    public static void main(String[] args) throws FileNotFoundException {
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource(), "https://www.anekdot.ru/random/anekdot/", "src\\main\\java\\TelegramBot\\jokeCollection");
        ApiContextInitializer.init();
        TGBot telegramBot = new TGBot(generator, "baseTG");
        CMDBot cmdBot = new CMDBot(generator, "baseCMD");
        JThread tgThread = new JThread("Telegram bot", telegramBot);
        JThread cmdThread = new JThread("Cmd bot", cmdBot);
    }
}
