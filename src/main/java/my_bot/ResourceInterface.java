package my_bot;

import java.util.ArrayList;
import java.util.HashMap;

public interface ResourceInterface {
    HashMap<String, ArrayList<String>> Variants = new HashMap<String, ArrayList<String>>();
    void Fill();
}
