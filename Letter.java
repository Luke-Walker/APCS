import java.util.*;

public class Letter {

  public static void main(String[] args) {
    if (args.length != 1) {
        System.out.println("Invalid argument.");
        return;
    }

    System.out.println("1. Length");
    System.out.println("2. Get letter");
    System.out.println("3. To Upper Case");
    System.out.println("4. To Lower Case");
    System.out.println("5. Contains");
    System.out.println("6. Substring");
    System.out.println("7. EXIT");

    String word = args[0];
    Scanner scan = new Scanner(System.in);
    int choice = Integer.parseInt(scan.nextLine());

    switch (choice) {
      case 1:
        System.out.println(word.length());
        break;
      case 2:
        System.out.println("What place is the letter in? ");
        int place = Integer.parseInt(scan.nextLine());
        System.out.println(word.charAt(place));
        break;
      case 3:
        System.out.println(word.toUpperCase());
        break;
      case 4:
        System.out.println(word.toLowerCase());
        break;
      case 5:
        System.out.println("Word: ");
        String s = scan.nextLine();
        System.out.println(word.contains(s));
        break;
      case 6:
        System.out.println("Place to substring: ");
        int input = Integer.parseInt(scan.nextLine());
        System.out.println(word.substring(input));
        break;
      case 7:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice.");
        break;
    }
  }
}
