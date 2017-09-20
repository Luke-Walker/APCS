package blackjack;

import java.lang.*;

public class Card {

    public static ArrayList<Card> cards = new ArrayList<Card>();
    public static ArrayList<Card> usedCards = new ArrayList<Card>();

    private String suit;
    private int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;

        cards.add(this);
    }

    public static void initCards() {
        for (int i = 0; i < 13; i++) {
            new Card("hearts", i);
            new Card("diamonds", i);
            new Card("clubs", i);
            new Card("spades", i);
        }
    }

    public void playCard(Player player) {
        Random rand = new Random();
        Card card = cards.get(rand.nextInt(cards.size()));

        cards.remove(card);
        usedCards.add(card);

        player.addPoints(card.getValue());
    }

    public int getValue() {
        return value;
    }
}
