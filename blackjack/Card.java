package blackjack;

import java.lang.*;
import java.util.*;

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
        for (int i = 1; i <= 13; i++) {
            new Card("hearts", i);
            new Card("diamonds", i);
            new Card("clubs", i);
            new Card("spades", i);
        }
    }

    public static void playCard(Player player) {
        Random rand = new Random();
        Card card = cards.get(rand.nextInt(cards.size()));

        cards.remove(card);
        usedCards.add(card);

        player.addPoints(card.getValue());
        System.out.println(player.getName() + " hit a "
            + card.getValue() + " of " + card.getSuit());
        if (player.getPoints() > 21) {
            System.out.println("They busted with a score of " + player.getPoints() + ".");
            player.setBusted(true);
        } else if (player.getPoints() == 21) {
            System.out.println("Blackjack!");
            player.setStanding(true);
        } else {
            System.out.println(player.getName() + "'s value is now " + player.getPoints() + ".");
        }
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
