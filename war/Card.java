public class Card {

  private String suit;
  private int value;

  public Card() {
    suit = "";
    value = 0;
  }

  public Card(String s, int v) {
    suit = s;
    value = v;
  }

  public String getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    return value + " of " + suit;
  }

}
