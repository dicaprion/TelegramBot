package TelegramBot;

import org.telegram.telegrambots.ApiContextInitializer;

import java.io.FileNotFoundException;


public class EntryPoint {
    public static void main(String[] args) throws FileNotFoundException {
        RandomMessage q = new SimpleMessageQueue();
        SimpleJokeCollection jokeColl = new SimpleJokeCollection("https://www.anekdot.ru/random/anekdot/", "src\\main\\java\\TelegramBot\\jokeCollection");
        AnswerGenerator generator = new SimpleAnswerGenerator(new SimpleResource(), jokeColl, q);
        ApiContextInitializer.init();
        TGBot telegramBot = new TGBot(generator, "baseTG");
        CMDBot cmdBot = new CMDBot(generator, "baseCMD");
        JThread tgThread = new JThread("Telegram bot", telegramBot);
        JThread cmdThread = new JThread("Cmd bot", cmdBot);
    }
}
