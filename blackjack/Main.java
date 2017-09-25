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
            System.out.print("Player " + i + "'s name: ");
            new Player(scan.nextLine(), false);
        }

        System.out.print("How many tokens should each person start with? ");
        int startingTokens = Integer.parseInt(scan.nextLine());
        for (Player player : Player.players) {
            player.setTokens(startingTokens);
        }
        System.out.print("\n");
        while (true) {
            for (Player player : Player.players) {
                if (player.isBusted() || player.isStanding()) continue;

                System.out.println("Player " + player.getNumber() + ": " + player.getPoints() + " Points | "
                    + player.getTokens() + " Tokens");
                if (player.getBet() == 0) {
                    System.out.print("How many tokens would you like to bet? ");
                    player.bet(Integer.parseInt(scan.nextLine()));
                }
                System.out.print("What would you like to do? (hit, stand): ");
                String response = scan.nextLine().toLowerCase();
                switch (response) {
                    case "hit":
                        Card.playCard(player);
                        break;
                    case "stand":
                        player.setStanding(true);
                        break;
                    default:
                        break;
                }

                System.out.print("\n");
            }
            for (Player player : Player.players) {
                if (!player.isStanding() && !player.isBusted()) Player.remainingPlayers.add(player);
            }

            if (Player.remainingPlayers.size() == 0) {
                ArrayList<Player> standing = new ArrayList<Player>();
                for (Player player : Player.players) {
                    if (player.isStanding()) {
                        if ((player.getPoints() > Player.dealer.getPoints()) || player.getPoints() == 21) {
                            System.out.println("Player " + player.getNumber() + " won " + player.getBet()*2 + " tokens!");
                            player.win();
                        }
                    }
                }
                for (Player player : standing) {

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
