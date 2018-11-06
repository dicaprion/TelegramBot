package TelegramBot;

public interface AnswerGenerator {
    String GetAnswer(String request, int userId, UsersBaseInterface base);
}
