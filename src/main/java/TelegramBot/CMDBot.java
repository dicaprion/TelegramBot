package TelegramBot;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CMDBot implements Runnable {
    private UsersBaseInterface base = new UsersBase();
    private AnswerGenerator solver;

    CMDBot(AnswerGenerator generator) throws FileNotFoundException {
        this.solver = generator;
        base.AddNewUser(1);
        System.out.print(solver.GetAnswer("start", 1, base));
    }

    public void run(){
        try {
            Scanner in = new Scanner(System.in);
            while (true) {
                String line = in.nextLine();
                if (line.equalsIgnoreCase("end")) {
                    System.out.print("See you later, goodbye.\n");
                    break;
                } else {
                    System.out.print(solver.GetAnswer(line, 1, base));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
