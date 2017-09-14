import java.lang.*;
import java.util.*;

public class NameGuess {

  private static final ArrayList<String> names = new ArrayList<String>();

  private static int points = 0;

  public static void main(String[] args) {
    init();

    while (true) {
      String name = names.get(new Random().nextInt(names.size()));
      String[] split = name.split(" ");
      String first = split[0];
      String last = split[1];

      Scanner scan = new Scanner(System.in);

      boolean guessed = false;
      while (!guessed) {
        System.out.println(first.substring(0,2) + " | " + last.substring(0,3));
        String input = scan.nextLine();
        if (input.toLowerCase().equals("e")) {
          System.exit(0);
        }
        if (input.equals(name)) {
          points += 10;
          guessed = true;
          System.out.println("You got it right!");
        } else {
          points -= 1;
          System.out.println("You got it wrong.");
        }

        System.out.println("You have " + points + " points.");
      }
    }
  }

  private static void init() {
    names.add("Donald Trump");
    names.add("Hillary Clinton");
    names.add("Bernie Sanders");
    names.add("Ted Cruz");
    names.add("Ben Carson");
    names.add("Kim Kardashian");
    names.add("Nicki Minaj");
  }
}
