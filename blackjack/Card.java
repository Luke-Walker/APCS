package blackjack;

import java.lang.*;

public class Card {

    public static ArrayList<Card> cards = new ArrayList<Card>();

    private int value;

    public Card(int value) {
        this.value = value;

        cards.add(this);
    }

    public static void initCards() {

    }

    public int getValue() {
        return value;
    }
}
