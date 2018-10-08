package my_bot;

public interface AnswerGeneratorInterface {
    void SetResource(ResourceInterface resource);
    String GetAnswer(String request);
}
