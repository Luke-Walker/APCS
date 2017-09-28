package blackjack;

import java.lang.*;
import java.util.*;

public class Main {

    private static boolean round = true;

    public static void main(String[] args) {
        if (args.length == 0) return;
		if (Integer.parseInt(args[0]) <= 0) return;

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
        round = true;
        while (true) {
            for (Player player : Player.players) {
                if (player.isBusted() || player.isStanding()) continue;

                System.out.println(player.getName() + ": "  + player.getPoints() + " Points | "
                    + player.getTokens() + " Tokens | " + player.getBet() + " Bet");
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
                if (!player.isStanding() && !player.isBusted()) {
                    Player.remainingPlayers.add(player);
                } else {
                    Player.remainingPlayers.remove(player);
                }
            }

            if (Player.remainingPlayers.size() == 0) {
                ArrayList<Player> standing = new ArrayList<Player>();
                ArrayList<Player> winners = new ArrayList<Player>();
                for (Player player : Player.players) {
                    if (player.isStanding()) {
                        if (winners.size() == 0) {
                            winners.add(player);
                            continue;
                        }
                        if (player.getPoints() > winners.get(0).getPoints()) {
                            winners.clear();
                            winners.add(player);
                        } else if (player.getPoints() == 21) {
                            if (winners.get(0).getPoints() != 21) {
                                winners.clear();
                            }
                            winners.add(player);
                        }
                    }
                }
                for (Player player : winners) {
                    System.out.println(player.getName() + " won " + player.getBet()*2 + " tokens!\n\n");
                    player.win();
                    round = false;
                }
            }
            if (!round) newRound();
        }
    }

    private static void newRound() {
        for (Player player : Player.players) {
            player.resetPoints();
            player.resetBet();
            player.setStanding(false);
            player.setBusted(false);
        }
        ArrayList<Card> used = new ArrayList<Card>();
        for (Card card : Card.usedCards) used.add(card);
        for (Card card : used) {
            Card.usedCards.remove(card);
            Card.cards.add(card);
        }
        round = true;
    }
}
