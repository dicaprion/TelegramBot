package my_bot;

import java.util.ArrayList;
import java.util.Map;

public class AnswerGenerator implements AnswerGeneratorInterface {

    private ResourceInterface resource = new Resource();

    AnswerGenerator(ResourceInterface resource){
        this.resource = resource;
    }

    @Override
    public String GetAnswer(String request){
        for (Map.Entry<String, ArrayList<String>> entry : resource.Variants.entrySet()){
            if (entry.getValue().contains(request.toLowerCase())){
                return entry.getKey();
            }
        }
        return "khmm, I don't know, what should I say\n";
    }
}
