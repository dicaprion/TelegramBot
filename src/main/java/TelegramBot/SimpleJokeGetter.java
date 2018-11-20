package TelegramBot;


import java.util.ArrayList;


public class SimpleJokeGetter implements JokeGetter{

    ArrayList<String> list = new SimpleJokeParser("https://www.anekdot.ru/random/anekdot/").list;

    @Override
    public String GetNextJoke() {
        if (list.size() == 0)
            return null;
        String result = list.get(0);
        list.remove(0);
        return result;
    }
}
