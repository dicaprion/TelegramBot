package TelegramBot;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;


public class SimpleJokeGetter implements JokeGetter{
    ArrayList<String> list;
    private String url;

    SimpleJokeGetter(String newUrl){
        url = newUrl;
        list = new SimpleJokeParser(url).list;
        //"https://www.anekdot.ru/random/anekdot/"
    }

    @Override
    public String GetNextJoke() {
        if (list.size() == 0)
            return null;
        String result = list.get(0);
        list.remove(0);
        return result;
    }
}
