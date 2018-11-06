package TelegramBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;


public class SimpleJokeParser implements JokeParser {

    ArrayList<String> list = new ArrayList<>();

    public org.jsoup.select.Elements htmlParser() {
        String stringHTML = new HTMLLoader().GetHTMLString("https://www.anekdot.ru/random/anekdot/");
        Document html = Jsoup.parse(stringHTML);
        org.jsoup.select.Elements htmlByClass = html.getElementsByClass("text");
        return htmlByClass;
    }

    SimpleJokeParser() {
        org.jsoup.select.Elements info = htmlParser();
        while (info.size() != 0) {
            String line = info.first().toString();
            String dirtyLine = line.replace("<div class=\"text\">", "");
            String dirtyResult = dirtyLine.replace("</div>", "");
            String resultJoke = dirtyResult.replace("<br>","");
            list.add(resultJoke);
            info.remove(0);
        }
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