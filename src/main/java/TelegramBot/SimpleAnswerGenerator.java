package TelegramBot;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class SimpleAnswerGenerator implements AnswerGenerator {

    private Resource resource;
    private SimpleJokeCollection jokeCollection;
    private RandomMessage randomMessageQueue;

    public RandomMessage GetMesQueue(){
        return randomMessageQueue;
    }

    SimpleAnswerGenerator(Resource resource, String jokeUrl, String filePathJoke){
        this.resource = resource;
        jokeCollection = new SimpleJokeCollection(jokeUrl, filePathJoke);
        randomMessageQueue = new SimpleMessageQueue();
    }

    @Override
    public String GetAnswer(String request, int userId, UsersBaseInterface base) {
        ArrayList<String> dateVariants = new ArrayList<String>();
        dateVariants.addAll(Arrays.asList("/date", "/time", "date", "time", "what time is it?"));
        if (dateVariants.contains(request))
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n";
        String[] lines = request.split("\n");
        if (lines[0].equals("/send random")){
            Message message = new Message();
            message = message.CreateMessage(request);
            if (message != null) {
                randomMessageQueue.AddMessage(message);
                System.out.println(message.toString());
                return "Success";
            } else {
                return "Fail";
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : resource.Variants.entrySet()) {
            if (entry.getValue().contains(request.toLowerCase())) {
                return entry.getKey();
            }
        }
        ArrayList<String> jokeVariants = new ArrayList<String>();
        jokeVariants.addAll(Arrays.asList("/joke", "joke", "tell me joke"));
        if (jokeVariants.contains(request.toLowerCase())) {
            User currentUser = base.GetUserById(userId);
            String joke = null;
            try {
                joke = jokeCollection.GetJokeByIndex(currentUser.GetInsexOfJoke());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            currentUser.AddIndexOfJoke();
            return joke;
        }
        return "khmm, I don't know, what should I say\n";
    }
}
