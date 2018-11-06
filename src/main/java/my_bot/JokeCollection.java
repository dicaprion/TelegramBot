package my_bot;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class JokeCollection implements FileExplorer {
    public org.jsoup.select.Elements htmlParser() {
        String stringHTML = new HTMLLoader().GetHTMLString("https://www.anekdot.ru/random/anekdot/");
        Document html = Jsoup.parse(stringHTML);
        org.jsoup.select.Elements htmlByClass = html.getElementsByClass("text");

        return htmlByClass;
    }

    public void WriteInformationInFile(){
        org.jsoup.select.Elements info = htmlParser();
        File anekdots = new File("anekdots.txt");
        try(FileWriter writer = new FileWriter(anekdots, false))
        {
            while (info.size() != 0){
                String line = info.first().toString();
                String resultString = line.replace("<div class=\"text\">", "");
                String resultString1 = resultString.replace("</div>", "");
                String resultString2 = resultString1.replace("<br>", "\n");
                writer.write(resultString2);
                writer.write("\n-------\n");
                info.remove(0);
        }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> GetInformationFromFile(){
        try(FileReader reader = new FileReader("anekdots.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }
}
