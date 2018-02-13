import java.util.*;

public class Deck {

  Card[] cards;

  /* Initializes all standard Cards in a 52 card Deck */
  public Deck() {
      cards = new Card[52];

      int index = 0;
      for (int i = 1; i <= 13; i++) {
          cards[index] = new Card("hearts", i);
          index++;
          cards[index] = new Card("diamonds", i);
          index++;
          cards[index] = new Card("clubs", i);
          index++;
          cards[index] = new Card("spades", i);
          index++;
      }
  }

  /* Randomize the Cards in the Deck */
  public void shuffle() {
      Random rand = new Random();
      Card[] temp = new Card[52];

      for (int i = 0; i < temp.length; i++) {
          int index = rand.nextInt(cards.length);
          while (cards[index] == null) {
              index = rand.nextInt(cards.length);
          }
          temp[i] = cards[index];
          cards[index] = null;
      }
      cards = temp;
  }

  /* Deals the first or last card off the Deck */
  public Card deal() {
      int index = 0;
      while (cards[index] == null) {
          index++;
      }

      Card card = cards[index];
      cards[index] = null;

      return card;
  }

  /* Returns a String of all Cards in the Deck */
  public String toString() {
      String str = "";
      for (Card card : cards) {
          if (card != null) {
              str += card.getSuit() + ": " + card.getValue() + "\n";
          }
      }
      return str;
  }
}
