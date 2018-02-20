public class CardGameTester {

  public static void main(String[] args) {

    Deck deck = new Deck();
    deck.shuffle();

    System.out.println("Original Deck:");
    System.out.println(deck);

    System.out.print("\nDealing ... ");
    System.out.println(deck.deal());

    System.out.println("\nModified Deck:");
    System.out.println(deck);

    /*
    System.out.println("\nAdding A Card:");
    deck.add(new Card("hearts", 4));
    System.out.println(deck);
    */

  }

}
