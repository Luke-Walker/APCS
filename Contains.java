public class Contains {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Needs 2 arguments.");
      return;
    }

    String word = args[0];
    String letter = args[1];

    System.out.println(word.contains(letter));
  }
}
