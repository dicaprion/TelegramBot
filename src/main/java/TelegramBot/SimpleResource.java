package TelegramBot;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleResource implements Resource {

    SimpleResource(){
        ArrayList<String> helpVariants = new ArrayList<String>();
        helpVariants.addAll(Arrays.asList("help", "start", "help me", "let's start", "hi", "hello", "let's go", "go", "/start", "/help", "/go"));
        String helpString = "Hi, What do you want? I am busy, but I think, I can find one minute for you\n" +
                "If you want to know what date is it, write /date\n" + "If you want to get a joke, write /joke\n" + "If you want to send a message to a random user, write /send_message + ---- + time to wait\n";
        this.Variants.put(helpString, helpVariants);
    }
}
