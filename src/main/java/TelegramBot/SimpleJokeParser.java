package TelegramBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;


public class SimpleJokeParser {

    ArrayList<String> list = new ArrayList<>();

    public org.jsoup.select.Elements htmlParser(String url) {
        String stringHTML = new HTMLLoader().GetHTMLString(url);
        Document html = Jsoup.parse(stringHTML);
        org.jsoup.select.Elements htmlByClass = html.getElementsByClass("text");
        return htmlByClass;
    }

    SimpleJokeParser(String url) {
        org.jsoup.select.Elements info = htmlParser(url);
        while (info.size() != 0) {
            String line = info.first().toString();
            String dirtyLine = line.replace("<div class=\"text\">", "");
            String dirtyResult = dirtyLine.replace("</div>", "");
            String resultJoke = dirtyResult.replace("<br>","");
            list.add(resultJoke);
            info.remove(0);
        }
    }
}