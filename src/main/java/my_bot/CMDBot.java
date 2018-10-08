package my_bot;
import java.util.Scanner;

public class CMDBot implements Runnable {

    private AnswerGeneratorInterface solver;

    CMDBot(AnswerGeneratorInterface generator){
        this.solver = generator;
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
                    System.out.print(solver.GetAnswer(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
