import java.lang.*;
import java.util.*;

public class NumberGuess {

  public static int points = 0;

  public static void main(String[] args) {
    if (args.length < 2) {
      return;
    }

    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int num, guess;
    boolean guessed = false;
    while (true) {
      num = rand.nextInt(max-min+1) + min;
      guessed = false;
      while (!guessed) {
        guess = Integer.parseInt(scan.nextLine());
        if (guess == num) {
          points += 10;
          System.out.println("You guessed the number correctly!");
          guessed = true;
        } else if (guess > num) {
          points -= 1;
          System.out.println("Your guess was too high!");
        } else if (guess < num) {
          points -= 1;
          System.out.println("Your guess was too low!");
        }
      }
    }
  }
}
