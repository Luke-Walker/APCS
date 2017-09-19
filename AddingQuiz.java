import java.lang.*;
import java.util.*;

public class AddingQuiz {

  public static int correct = 0;

  public static void main(String[] args) {
    if (args.length != 1) return;

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    for (int i = Integer.parseInt(args[0]); i > 0; i--) {
      int first, second, answer;

      first = rand.nextInt(100);
      second = rand.nextInt(100);
      answer = first+second;

      System.out.println(first + "+" + second + "=");

      if (Integer.parseInt(scan.nextLine()) == answer) {
        correct++;
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect!");
      }
    }
    System.out.println("\nYou got " + correct + "/" + args[0] + " correct!");
  }
}
