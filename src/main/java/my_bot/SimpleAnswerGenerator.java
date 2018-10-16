package my_bot;

import java.util.ArrayList;
import java.util.Map;

public class SimpleAnswerGenerator implements AnswerGenerator {

    private Resource resource = new SimpleResource();

    SimpleAnswerGenerator(Resource resource){
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
