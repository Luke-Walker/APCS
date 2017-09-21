package blackjack;

import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) return;

        Card.initCards();

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            System.out.println("Player " + i + "'s name: ");
            new Player(scan.nextLine(), false);
        }

        System.out.println("How many tokens should each person start with? ");
        int startingTokens = Integer.parseInt(scan.nextLine());
        for (Player player : Player.players) {
            player.setTokens(startingTokens);
        }

        while (true) {
            for (Player player : Player.players) {
                if (player.getBet() == 0) {
                    System.out.print("How many tokens would you like to bet? ");
                    player.bet(Integer.parseInt(scan.nextLine()));
                }

                if (player.isBusted() || player.isStanding()) continue;

                System.out.println("Player " + player.getNumber() + ": " + player.getPoints() + " Points | "
                    + player.getTokens() + " Tokens");
                System.out.println("What would you like to do? (hit, stand)");
                String[] response = scan.nextLine().toLowerCase().split(" ");
                switch (response[0]) {
                    case "hit":
                        Card.playCard(player);
                        break;
                    case "stand":
                        player.setStanding(true);
                        break;
                    default:
                        break;
                }

                if (!player.isStanding()) {
                    if (player.getPoints() > 21) {
                        player.setBusted(true);
                    }
                }
            }
        }
    }

    private static void newRound() {
        for (Player player : Player.players) {
            player.resetPoints();
            player.setStanding(false);
        }
        for (Card card : Card.usedCards) {
            Card.usedCards.remove(card);
            Card.cards.add(card);
        }
    }
}
